/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.copy.model.groep.operationeel.actueel;

import javax.persistence.Embeddable;

import nl.bzk.copy.model.groep.logisch.PersoonUitsluitingNLKiesrechtGroep;
import nl.bzk.copy.model.groep.logisch.basis.PersoonUitsluitingNLKiesrechtGroepBasis;
import nl.bzk.copy.model.groep.operationeel.actueel.basis.AbstractPersoonUitsluitingNLKiesrechtActGroepModel;

/**
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class PersoonUitsluitingNLKiesrechtGroepModel extends AbstractPersoonUitsluitingNLKiesrechtActGroepModel
        implements PersoonUitsluitingNLKiesrechtGroep
{

    /**
     * Copy constructor voor groep.
     *
     * @param groep De te kopieren groep.
     */
    public PersoonUitsluitingNLKiesrechtGroepModel(final PersoonUitsluitingNLKiesrechtGroepBasis groep) {
        super(groep);
    }

    /**
     * .
     */
    @SuppressWarnings("unused")
    public PersoonUitsluitingNLKiesrechtGroepModel() {
    }
}
