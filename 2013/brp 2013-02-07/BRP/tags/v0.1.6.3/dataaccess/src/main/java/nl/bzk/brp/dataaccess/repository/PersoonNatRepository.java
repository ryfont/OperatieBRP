/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.dataaccess.repository;

import nl.bzk.brp.model.attribuuttype.Datum;
import nl.bzk.brp.model.attribuuttype.DatumTijd;
import nl.bzk.brp.model.objecttype.operationeel.ActieModel;
import nl.bzk.brp.model.objecttype.operationeel.PersoonModel;
import nl.bzk.brp.model.objecttype.operationeel.PersoonNationaliteitModel;
import org.springframework.stereotype.Repository;

/**
 *
 *
 */
@Repository
public interface PersoonNatRepository {

    /**
     * .
     * @param persoon .
     * @param nationaliteit .
     * @param actie .
     * @param datumAanvangGeldigheid .
     * @param tijdstipRegistratie .
     * @return .
     */
    PersoonModel voegNationaliteit(final PersoonModel persoon,
            final PersoonNationaliteitModel nationaliteit, final ActieModel actie,
            final Datum datumAanvangGeldigheid, final DatumTijd tijdstipRegistratie);

}
