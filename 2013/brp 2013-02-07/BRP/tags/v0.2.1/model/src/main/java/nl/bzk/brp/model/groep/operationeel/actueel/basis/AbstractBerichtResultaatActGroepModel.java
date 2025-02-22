/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.groep.operationeel.actueel.basis;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;

import nl.bzk.brp.model.groep.logisch.basis.BerichtResultaatGroepBasis;
import nl.bzk.brp.model.groep.operationeel.AbstractBerichtResultaatGroep;

/**
 *.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
@SuppressWarnings("serial")
public abstract class AbstractBerichtResultaatActGroepModel extends AbstractBerichtResultaatGroep {

    /**
     * Copy constructor.
     * @param berichtResultaatGroepBasis Bericht resultaat waarvan gekopieerd dient te worden.
     */
    public AbstractBerichtResultaatActGroepModel(final BerichtResultaatGroepBasis berichtResultaatGroepBasis) {
        super(berichtResultaatGroepBasis);
    }

    /**
     * Default constructor.
     */
    public AbstractBerichtResultaatActGroepModel() {
    }
}
