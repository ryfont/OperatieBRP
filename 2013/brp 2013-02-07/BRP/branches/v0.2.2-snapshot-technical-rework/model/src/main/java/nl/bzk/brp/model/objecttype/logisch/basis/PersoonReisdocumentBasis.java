/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.objecttype.logisch.basis;

import nl.bzk.brp.model.basis.AbstractStatischAttribuutType;
import nl.bzk.brp.model.basis.ObjectType;
import nl.bzk.brp.model.groep.logisch.PersoonReisdocumentStandaardGroep;
import nl.bzk.brp.model.objecttype.logisch.Persoon;

/**
 * .
 *
 */
public interface PersoonReisdocumentBasis extends ObjectType  {

    /**
     * .
     * @return .
     */
    AbstractStatischAttribuutType<Integer> getSoort();

    /**
     * .
     * @return .
     */
    Persoon getPersoon();

    /**
     * .
     * @return .
     */
    PersoonReisdocumentStandaardGroep getGegevens();
}
