/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.business.stappen.locking;

import java.util.Collection;



/**
 * Creeert shared en exclusive locks op basis van BSN's.
 */
public interface BsnLocker {

    /**
     * Cre&euml;ert locks.
     *
     * @param readBSNLocks De BSN's die een shared-lock moeten hebben
     * @param writeBSNLocks De BSN's die een exclusive-lock moeten hebben
     * @param referentieNummer De context, meestal een id welke wordt gebruikt in de foutmelding.
     */
    void getLocks(Collection<String> readBSNLocks, Collection<String> writeBSNLocks, Long referentieNummer);

    /**
     * Geeft de gemaakte locks weer vrij.
     */
    void unLock();
}
