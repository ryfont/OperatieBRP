/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.dataaccess.repository;

import java.util.Date;

import nl.bzk.brp.model.attribuuttype.Burgerservicenummer;
import nl.bzk.brp.model.attribuuttype.Datum;
import nl.bzk.brp.model.objecttype.logisch.PersoonAdres;
import nl.bzk.brp.model.objecttype.operationeel.PersoonAdresModel;


/**
 * Repository voor de {@link nl.bzk.brp.model.objecttype.operationeel.PersoonAdresModel} class.
 */
public interface PersoonAdresMdlRepository {

    /**
     * Slaat het opgegeven nieuwe adres op en overschrijft daarmee een eventueel bestaand huidig adres, afhankelijk
     * van opgegeven geldigheids data. <br/>
     * <br/>
     * Deze methode houdt rekening met historie en voert, indien nodig, ook de benodigde wijzigingen door in de
     * historische data.
     *
     * @param persoonAdres het adres dat opgeslagen dient te worden.
     * @param datumAanvangGeldigheid Datum dat het nieuwe adres ingaat.
     * @param datumEindeGeldigheid Datum einde geldigheid van het adres.
     * @param tijdstipRegistratie tijdstip waarop de registratie plaatsvindt.
     * @return Opgeslagen PersoonAdres.
     */
    PersoonAdresModel opslaanNieuwPersoonAdres(final PersoonAdresModel persoonAdres,
            final Datum datumAanvangGeldigheid, final Datum datumEindeGeldigheid, final Date tijdstipRegistratie);

    /**
     * Controleert in de BRP database of er iemand momenteel ingeschreven staat op een adres.
     *
     * @param persoonAdres Het adres dat gecontroleerd wordt.
     * @return true indien er iemand ingeschreven staat anders false.
     */
    boolean isIemandIngeschrevenOpAdres(final PersoonAdres persoonAdres);

    /**
     * Zoekt het huidige adres op van een persoon.
     *
     * @param bsn bsn van de persoon waar het omgaat.
     * @return Het huidige adres van de persoon.
     */
    PersoonAdresModel vindHuidigWoonAdresVoorPersoon(final Burgerservicenummer bsn);

}
