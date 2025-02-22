/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.objecttype.logisch.basis;

import nl.bzk.brp.model.basis.ObjectType;
import nl.bzk.brp.model.groep.logisch.BerichtResultaatGroep;
import nl.bzk.brp.model.groep.logisch.BerichtStuurgegevensGroep;


/**
 * .
 *
 */
public interface BerichtBasis extends ObjectType {

    /**
     * De stuurgegevens groep.
     * @return Stuur gegevens groep.
     */
    BerichtStuurgegevensGroep getBerichtStuurgegevensGroep();

    /**
     * Resultaat groep.
     * @return Resultaat groep.
     */
    BerichtResultaatGroep getBerichtResultaatGroep();

}
