/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.synchronisatie.runtime.service.synchronisatie.pl;

import java.util.Set;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.AdministratieveHandeling;

/**
 * BRP Bijhouding notificator.
 */
public interface BrpNotificator {
    /**
     * Verstuur notificaties.
     *
     * @param administratieveHandelingen
     *            administratieve handelingen
     * @param persoonslijstId
     *            persoon id
     */
    void stuurGbaBijhoudingBerichten(final Set<AdministratieveHandeling> administratieveHandelingen, final Integer persoonslijstId);
}
