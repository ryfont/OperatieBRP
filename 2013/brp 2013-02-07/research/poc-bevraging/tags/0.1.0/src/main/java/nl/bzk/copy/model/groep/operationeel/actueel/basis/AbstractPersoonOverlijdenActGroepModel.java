/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.copy.model.groep.operationeel.actueel.basis;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import nl.bzk.copy.model.basis.Onderzoekbaar;
import nl.bzk.copy.model.groep.logisch.basis.PersoonOverlijdenGroepBasis;
import nl.bzk.copy.model.groep.operationeel.AbstractPersoonOverlijdenGroep;


/**
 *
 */
@MappedSuperclass
@Access(AccessType.FIELD)
@SuppressWarnings("serial")
public abstract class AbstractPersoonOverlijdenActGroepModel extends AbstractPersoonOverlijdenGroep
        implements Onderzoekbaar
{
    @Transient
    private boolean inOnderzoek;


    /**
     * copy constructor.
     *
     * @param groep de ander object
     */
    protected AbstractPersoonOverlijdenActGroepModel(final PersoonOverlijdenGroepBasis groep) {
        super(groep);
    }

    /**
     * default constructor voor Hibernate.
     */
    protected AbstractPersoonOverlijdenActGroepModel() {
        super();
    }

    @Override
    public boolean isInOnderzoek() {
        return inOnderzoek;
    }

}
