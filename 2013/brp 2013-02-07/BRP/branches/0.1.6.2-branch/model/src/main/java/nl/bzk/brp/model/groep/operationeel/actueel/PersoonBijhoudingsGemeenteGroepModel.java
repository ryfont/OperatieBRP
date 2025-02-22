/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.groep.operationeel.actueel;

import javax.persistence.Embeddable;

import nl.bzk.brp.model.groep.logisch.PersoonBijhoudingsGemeenteGroep;
import nl.bzk.brp.model.groep.logisch.basis.PersoonBijhoudingsGemeenteGroepBasis;
import nl.bzk.brp.model.groep.operationeel.actueel.basis.AbstractPersoonBijhoudingsGemeenteActGroepModel;

/**
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class PersoonBijhoudingsGemeenteGroepModel extends AbstractPersoonBijhoudingsGemeenteActGroepModel
    implements PersoonBijhoudingsGemeenteGroep
{
    /**
     * copy constructor.
     * @param bijhoudingsGemeenteGroepBasis de ander object.
     */
    public PersoonBijhoudingsGemeenteGroepModel(
            final PersoonBijhoudingsGemeenteGroepBasis bijhoudingsGemeenteGroepBasis)
    {
        super(bijhoudingsGemeenteGroepBasis);
    }

    /**
     * hibernate constructor.
     */
    @SuppressWarnings("unused")
    private PersoonBijhoudingsGemeenteGroepModel() {
    }
}
