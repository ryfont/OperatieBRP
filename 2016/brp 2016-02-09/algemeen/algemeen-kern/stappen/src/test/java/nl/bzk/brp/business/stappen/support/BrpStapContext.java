/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.business.stappen.support;

import nl.bzk.brp.business.stappen.StappenContext;


/**
 * Dummy context voor unit test purposes.
 */
public class BrpStapContext implements StappenContext {

    @Override
    public Long getReferentieId() {
        return 123L;
    }

    @Override
    public Long getResultaatId() {
        return 654L;
    }
}
