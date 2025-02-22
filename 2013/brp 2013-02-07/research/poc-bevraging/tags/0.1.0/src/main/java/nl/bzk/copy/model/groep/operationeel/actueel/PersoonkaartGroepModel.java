/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.copy.model.groep.operationeel.actueel;

import javax.persistence.Embeddable;

import nl.bzk.copy.model.groep.logisch.PersoonskaartGroep;
import nl.bzk.copy.model.groep.logisch.basis.PersoonskaartGroepBasis;
import nl.bzk.copy.model.groep.operationeel.actueel.basis.AbstractPersoonskaartActGroepModel;

/**
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class PersoonkaartGroepModel extends AbstractPersoonskaartActGroepModel
        implements PersoonskaartGroep
{

    /**
     * Copy constructor voor groep.
     *
     * @param groep De te kopieren groep.
     */
    public PersoonkaartGroepModel(final PersoonskaartGroepBasis groep) {
        super(groep);
    }

    /**
     * hibernate.
     */
    @SuppressWarnings("unused")
    private PersoonkaartGroepModel() {
    }
}
