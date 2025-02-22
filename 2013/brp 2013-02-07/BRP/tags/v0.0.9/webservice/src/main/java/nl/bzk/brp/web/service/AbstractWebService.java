/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.web.service;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.xml.ws.WebServiceContext;

import nl.bzk.brp.business.dto.BRPBericht;
import nl.bzk.brp.business.dto.BerichtContext;
import nl.bzk.brp.business.dto.BerichtResultaat;
import nl.bzk.brp.business.dto.BerichtenIds;
import nl.bzk.brp.business.service.AuthenticatieService;
import nl.bzk.brp.business.service.BerichtVerwerker;
import nl.bzk.brp.model.operationeel.aut.PersistentAuthenticatieMiddel;
import nl.bzk.brp.model.validatie.Melding;
import nl.bzk.brp.model.validatie.MeldingCode;
import nl.bzk.brp.model.validatie.SoortMelding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstracte class die standaard methodes biedt die gebruikt worden door de verschillende service implementaties voor
 * generieke zaken als authenticatie, bericht context vulling etc.
 *
 * @param <T> Het type bericht dat door deze webservice wordt afgehandeld.
 */
public abstract class AbstractWebService<T extends BRPBericht> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractWebService.class);

    @Inject
    private AuthenticatieService authenticatieService;

    @Resource
    private WebServiceContext wsContext;

    /**
     * Voert het bericht uit door eerst het authenticatiemiddel te controleren, de context te initialiseren en dan
     * de business laag aan te roepen voor de werkelijke verwerking.
     *
     * @param berichtVerwerker de berichtverwerker die het bericht dient te verwerken.
     * @param bericht het bericht dat verwerkt dient te worden.
     * @return het uiteindelijke resultaat van de verwerking.
     */
    protected BerichtResultaat voerBerichtUit(final BerichtVerwerker berichtVerwerker, final T bericht) {
        BerichtResultaat resultaat;
        PersistentAuthenticatieMiddel authenticatieMiddel;
        BerichtenIds berichtenIds = null;

        try {
            berichtenIds = WebserviceUtil.haalBerichtenIdsOp();
            authenticatieMiddel = checkAuthenticatieMiddel(bericht, berichtenIds);

            if (isGeauthenticeerd(authenticatieMiddel)) {
                BerichtContext context = bouwBerichtContext(berichtenIds, authenticatieMiddel);
                resultaat = berichtVerwerker.verwerkBericht(bericht, context);
            } else {
                LOG.info("Authenticatie Fout: Partij niet geauthenticeerd in bericht {}",
                    berichtenIds.getIngaandBerichtId());
                resultaat = bouwBerichtResultaatMetMelding(MeldingCode.AUTH0001, null);
            }
        } catch (Throwable t) {
            String berichtId = "<<onbekend>>";
            if (berichtenIds != null) {
                berichtId = berichtenIds.getIngaandBerichtId().toString();
            }
            LOG.error(String.format("Onbekende fout opgetreden in bericht %s", berichtId), t);
            resultaat = bouwBerichtResultaatMetMelding(MeldingCode.ALG0001,
                "Er is een onbekende fout opgetreden in de verwerking. Probeer later nogmaals");
        }

        return resultaat;
    }

    /**
     * Controleert of de aanroep correct is geauthenticeerd door te controleren of er een geldig authenticatieMiddel
     * is gevonden.
     *
     * @param authenticatieMiddel het authenticatie middel dat is gevonden en dat gecontroleerd dient te worden.
     * @return of de authenticatie correct is verlopen.
     */
    protected boolean isGeauthenticeerd(final PersistentAuthenticatieMiddel authenticatieMiddel) {
        return (authenticatieMiddel != null);
    }

    /**
     * Bouwt een {@link BerichtContext} instantie met daarin onder andere de opgegeven berichten ids en het opgegeven
     * authenticatiemiddel. Tevens zal de partij in de context worden gezet.
     *
     * @param berichtenIds de ids van het in- en uitgaande bericht behorende bij deze berichtverwerking.
     * @param authenticatieMiddel het authenticatiemiddel waarmee de partij zich heeft geauthenticeerd.
     * @return een geinitialiseerde berichten context met daarin de berichtenids, het authenticatiemiddel en de partij.
     */
    protected BerichtContext bouwBerichtContext(final BerichtenIds berichtenIds,
        final PersistentAuthenticatieMiddel authenticatieMiddel)
    {
        return new BerichtContext(berichtenIds, authenticatieMiddel.getId(), authenticatieMiddel.getPartij());
    }

    /**
     * Bouwt een standaard {@link BerichtResultaat} dat geretourneerd kan worden en voegt daar een enkele melding aan
     * toe met de opgegeven {@link nl.bzk.brp.model.validatie.MeldingCode} en omschrijving. Indien de omschrijving
     * <code>null</code> is, zal de standaard omschrijving behorende bij de MeldingCode worden gebruikt als
     * omschrijving.
     *
     * @param meldingCode de code van de melding die aangeeft wat voor probleem er eventueel is geconstateerd.
     * @param omschrijving de omschrijving van de melding die meer informatie geeft over hetgeen is opgetreden.
     * @return een te retourneren bericht resultaat met een enkele melding.
     */
    protected BerichtResultaat bouwBerichtResultaatMetMelding(final MeldingCode meldingCode,
        final String omschrijving)
    {
        Melding melding = new Melding(SoortMelding.FOUT_ONOVERRULEBAAR, meldingCode);
        if (omschrijving != null) {
            melding.setOmschrijving(omschrijving);
        }
        BerichtResultaat resultaat = new BerichtResultaat(Arrays.asList(melding));
        resultaat.markeerVerwerkingAlsFoutief();
        return resultaat;
    }

    /**
     * Haalt het unieke authenticatiemiddel op voor het opgegeven bericht op basis van het certificaat en de partij
     * welke uit het bericht en de bijbehorende context worden gehaald. Indien er geen uniek authenticatiemiddel kan
     * worden gevonden voor de opgegeven partij en het uit de context gehaalde certificaat, dan zal deze methode
     * <code>null</code> retourneren, wat dus betekent dat de partij niet geauthenticeerd is. Indien er wel een uniek
     * authenticatiemiddel kan worden gevonden, dan zal deze worden geretourneerd.
     *
     * @param bericht Het bericht.
     * @param berichtenIds de ids van het ingaande en het uitgaande bericht.
     * @return het voor het bericht geldende authenticatiemiddel of <code>null</code> indien er geen uniek
     *         authenticatiemiddel kon worden gevonden.
     */
    protected PersistentAuthenticatieMiddel checkAuthenticatieMiddel(final T bericht, final BerichtenIds berichtenIds) {
        final X509Certificate certificaat = WebserviceUtil.haalClientCertificaatOp(wsContext);
        final Integer partijId = bericht.getPartijId();

        PersistentAuthenticatieMiddel resultaat;
        if (certificaat != null && partijId != null) {
            List<PersistentAuthenticatieMiddel> authenticatieMiddelen =
                authenticatieService.haalAuthenticatieMiddelenOp(partijId, certificaat);
            if (authenticatieMiddelen.size() == 1) {
                resultaat = authenticatieMiddelen.get(0);
            } else {
                LOG.debug("Authenticatie fout: Partij {} niet geauthenticeerd voor bericht {}", partijId,
                    berichtenIds.getIngaandBerichtId());
                resultaat = null;
                if (authenticatieMiddelen.size() > 1) {
                    LOG.warn(
                        "Misconfiguratie: Partij {} beschikt over niet uniek authenticatiemiddel voor certificaat {}.",
                        partijId, certificaat.getSerialNumber());
                }
            }
        } else {
            LOG.warn("Authenticatie fout: geen partij en/of geen certificaat aanwezig in bericht {}",
                berichtenIds.getIngaandBerichtId());
            resultaat = null;
        }
        return resultaat;
    }

}
