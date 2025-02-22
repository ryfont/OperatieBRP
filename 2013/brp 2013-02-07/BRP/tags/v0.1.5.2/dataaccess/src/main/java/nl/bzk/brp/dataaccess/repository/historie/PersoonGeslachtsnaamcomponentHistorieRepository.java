/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.dataaccess.repository.historie;

import nl.bzk.brp.model.operationeel.kern.PersistentActie;
import nl.bzk.brp.model.operationeel.kern.PersistentPersoonGeslachtsnaamcomponent;


/**
 * Repository om de historie op te slaan van PersoonVoornaam.
 *
 */
public interface PersoonGeslachtsnaamcomponentHistorieRepository {

    /**
     * Slaat de historie gegevens op voor PersoonGeslachtsnaamcomponent. Deze methode bevat de nodige logica om de
     * C-laag en de D-laag
     * te bewerken.
     *
     * @param geslachtsnaamcomponent Geslachtsnaamcomponent van de A-laag
     * @param actie De actie die geleid heeft tot de aanpassingen in de C/D-Laag.
     * @param datumAanvangGeldigheid datum van aanvang geldigheid
     * @param datumEindeGeldigheid datum van einde geldigheid
     */
    void opslaanHistorie(final PersistentPersoonGeslachtsnaamcomponent geslachtsnaamcomponent,
                         final PersistentActie actie,
                         final Integer datumAanvangGeldigheid, final Integer datumEindeGeldigheid);
}
