/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.dataaccess.repository;

import java.util.Date;
import java.util.List;

import nl.bzk.brp.dataaccess.selectie.RelatieSelectieFilterOud;
import nl.bzk.brp.model.gedeeld.SoortBetrokkenheid;
import nl.bzk.brp.model.gedeeld.SoortRelatie;
import nl.bzk.brp.model.logisch.Relatie;
import nl.bzk.brp.model.operationeel.kern.PersistentActie;
import nl.bzk.brp.model.operationeel.kern.PersistentPersoon;
import nl.bzk.brp.model.operationeel.kern.PersistentRelatie;
import org.springframework.stereotype.Repository;


/** Repository voor de {@link nl.bzk.brp.model.operationeel.kern.PersistentRelatie} class. */
@Repository
public interface RelatieRepository {


    /**
     * Haal op een lijst van persoonId's die een huwelijk of registeerd partnerschap hebben met de primaryId.
     * Let op, dat de lijst bevat ook de persoon zelf.
     *
     * @param persoonId de hoofdpersoon
     * @return de relaties
     */
    List<Long> haalopPartners(Long persoonId);

    /**
     * Haal op een lijst van persoonId's die een huwelijk relatie hebben met de primaryId.
     * Let op, dat de lijst bevat ook de persoon zelf.
     *
     * @param persoonId de hoofdpersoon
     * @return de relaties
     */
    List<Long> haalopEchtgenoten(Long persoonId);

    /**
     * Haal op een lijst van persoonId's die een huwelijk relatie hebben met de primaryId op een bepaald peilDatum.
     * Let op, dat de lijst bevat ook de persoon zelf.
     *
     * @param primaryId de hoofdpersoon
     * @param peilDatum de peildatum
     * @return de relaties
     */
    List<Long> haalopEchtgenoten(final Long primaryId, final Integer peilDatum);

    /**
     * Haal op een lijst van persoonId's die kind relatie hebben met de persoonId.
     *
     * @param persoonId de hoofdpersoon
     * @return de relaties
     */
    List<Long> haalopKinderen(Long persoonId);


    /**
     * Haal op een lijst van persoonId's die ouder relatie hebben met de persoonId.
     *
     * @param persoonId de hoofdpersoon
     * @return de relaties
     */
    List<Long> haalopOuders(Long persoonId);

    /**
     * Haal op een lijst van persoonId's die onderdeel maakt van de familie van de persoonId.
     * De SoortRelatie die gebruikt wordt is: FAMILIERECHTELIJKE_BETREKKING.
     * Let op dat de persoon zelf ook een onderdeel is van de lijst.
     *
     * @param persoonId de hoofdpersoon
     * @return de relaties
     */
    List<Long> haalopFamilie(Long persoonId);

    /**
     * Een gnerieke methode om de relaties mbt. de persoon op te halen. Aan de hand van de waarden in de filter
     * kan men bepaalde relatie type / betrekking type etc. uit selecteren.
     *
     * @param persoonId de hoofdpersoon
     * @param filter de filter
     * @return de relaties
     */
    List<Long> haalopRelatiesVanPersoon(final Long persoonId, final RelatieSelectieFilterOud filter);

    /**
     * Opslaan nieuwe relatie ten behoeve van eerste inschrijving. Deze methode slaat de relatie op, inclusief de
     * betrokkenheden, maar cascadeert niet door naar de betrokkene. Deze methode gaat er dan ook van uit dat alle
     * betrokkene reeds zijn gepersisteerd en dus inclusief primaire sleutel (ID) in de {@link Relatie} instantie
     * aanwezig zijn.
     *
     * @param relatie de relatie die opgeslagen dient te worden.
     * @param datumAanvangGeldigheid Datum waarop inschrijving ingaat.
     * @param tijdstipRegistratie tijdstip waarop de registratie plaatsvindt.
     * @return de id van de opgeslagen relatie.
     */
    PersistentRelatie opslaanNieuweRelatie(final Relatie relatie, final Integer datumAanvangGeldigheid,
        final Date tijdstipRegistratie);

    /**
     * Vind relaties van de opgegeven soorten waarin zowel persoon1 als persoon2 betrokkenen zijn.
     * @param persoon1 Persoon 1.
     * @param persoon2 Persoon 2.
     * @param soortBetrokkenheid De rol die persoon 1 en 2 hebben.
     * @param peilDatum De datum waarop de relaties en betrokkenheden actueel zijn, dus niet beeindigd.
     * @param soorten Soorten relaties die gezocht worden.
     * @return Lijst van relaties.
     */
    List<PersistentRelatie> vindSoortRelatiesMetPersonenInRol(final PersistentPersoon persoon1,
                                                              final PersistentPersoon persoon2,
                                                              final SoortBetrokkenheid soortBetrokkenheid,
                                                              final Integer peilDatum,
                                                              final SoortRelatie... soorten);

    /**
     * Werkt de historie van een relatie bij op basis van de opgegeven waarden en de soort van de relatie. Voor een
     * familierechtelijke betrekking dient er op de relatie geen historie bijgehouden te worden, maar op de
     * betrokkenheden van de ouders wel. Voor huwelijk en geregistreerd partnerschap dient er wel ook op de relatie
     * historie bijgehouden te worden.
     *
     * @param nieuweRelatie de nieuwe (operationeel model) relatie.
     * @param actie De actie die leidt tot de aanpassingen in de C/D-Laag.
     * @param datumAanvang de datum van aanvang.
     */
    void werkHistorieBij(final PersistentRelatie nieuweRelatie,
                         final PersistentActie actie, final Integer datumAanvang);
}
