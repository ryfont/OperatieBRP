/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.binding.bijhouding;

import java.util.Arrays;
import java.util.Date;

import nl.bzk.brp.binding.AbstractBindingUitIntegratieTest;
import nl.bzk.brp.business.dto.bijhouding.BijhoudingResultaat;
import nl.bzk.brp.model.algemeen.stamgegeven.ber.SoortBericht;
import nl.bzk.brp.model.algemeen.stamgegeven.ber.SoortMelding;
import nl.bzk.brp.model.validatie.Melding;
import nl.bzk.brp.model.validatie.MeldingCode;
import nl.bzk.brp.web.AntwoordBerichtFactory;
import nl.bzk.brp.web.AntwoordBerichtFactoryImpl;
import nl.bzk.brp.web.bijhouding.VerhuizingAntwoordBericht;
import org.jibx.runtime.JiBXException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/** Unit test class voor de binding van de {@link nl.bzk.brp.web.bijhouding.VerhuizingAntwoordBericht} class. */
@Ignore
public class VerhuizingAntwoordBerichtBindingTest extends AbstractBindingUitIntegratieTest<VerhuizingAntwoordBericht> {

    private static final String RESULTAAT_NODE_NAAM = "migratie_Verhuizing_BijhoudingResponse";

    private AntwoordBerichtFactory antwoordBerichtFactory;

    @Before
    public void init() {
        antwoordBerichtFactory = new AntwoordBerichtFactoryImpl();
    }

    @Override
    public Class<VerhuizingAntwoordBericht> getBindingClass() {
        return VerhuizingAntwoordBericht.class;
    }

    @Test
    public void testBindingMetGoedResultaatEnGeenMeldingen() throws JiBXException {
        BijhoudingResultaat resultaat = new BijhoudingResultaat(null);
        resultaat.setTijdstipRegistratie(new Date());
        VerhuizingAntwoordBericht antwoord =
                (VerhuizingAntwoordBericht) antwoordBerichtFactory.bouwAntwoordBericht(
                        bouwIngaandBericht(SoortBericht.M_I_G_REGISTREER_VERHUIZING_B), resultaat);
        String xml = marshalObject(antwoord);
        Assert.assertNotNull(xml);

        xml = vervangDynamischeWaardeVoorDummyWaarde(xml, "tijdstipRegistratie", "20120325143506789");
        Assert.assertEquals(getBerichtResultaatTemplate(RESULTAAT_NODE_NAAM, "G", null, null, null,
            "20120325143506789", true), xml);
        valideerTegenSchema(xml);
    }

    @Test
    public void testBindingMetGoedResultaatEnEenMelding() throws JiBXException {
        Melding[] meldingen = {
            new Melding(SoortMelding.INFORMATIE, MeldingCode.ALG0001, "Test omschrijving")
        };

        BijhoudingResultaat resultaat = new BijhoudingResultaat(Arrays.asList(meldingen));
        resultaat.setTijdstipRegistratie(new Date());

        VerhuizingAntwoordBericht antwoord =
                (VerhuizingAntwoordBericht) antwoordBerichtFactory.bouwAntwoordBericht(
                        bouwIngaandBericht(SoortBericht.M_I_G_REGISTREER_VERHUIZING_B), resultaat);
        String xml = marshalObject(antwoord);
        Assert.assertNotNull(xml);

        xml = vervangDynamischeWaardeVoorDummyWaarde(xml, "tijdstipRegistratie", "20120325143506789");
        Assert.assertEquals(getBerichtResultaatTemplate(RESULTAAT_NODE_NAAM, "G", "I", meldingen, null,
            "20120325143506789", true), xml);
        valideerTegenSchema(xml);
    }

    @Test
    public void testBindingMetFoutResultaatEnMeerdereMeldingen() throws JiBXException {
        Melding[] meldingen = {
            new Melding(SoortMelding.FOUT, MeldingCode.ALG0001, "Fout opgetreden"),
            new Melding(SoortMelding.DEBLOKKEERBAAR, MeldingCode.ALG0001, "Nog een fout opgetreden")
        };

        BijhoudingResultaat resultaat = new BijhoudingResultaat(Arrays.asList(meldingen));
        resultaat.markeerVerwerkingAlsFoutief();

        VerhuizingAntwoordBericht antwoord =
                (VerhuizingAntwoordBericht) antwoordBerichtFactory.bouwAntwoordBericht(
                        bouwIngaandBericht(SoortBericht.M_I_G_REGISTREER_VERHUIZING_B), resultaat);
        String xml = marshalObject(antwoord);
        Assert.assertNotNull(xml);

        xml = vervangDynamischeWaardeVoorDummyWaarde(xml, "tijdstipRegistratie", "20120325143506789");
        Assert.assertEquals(getBerichtResultaatTemplate(RESULTAAT_NODE_NAAM, "F", "F", meldingen, null,
            null, false), xml);
        valideerTegenSchema(xml);
    }

    @Override
    public String getSchemaBestand() {
        return "/xsd/BRP_Migratie_Berichten.xsd";
    }
}
