/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.copy.model.attribuuttype;

import javax.persistence.Embeddable;

import nl.bzk.copy.model.basis.AbstractStatischAttribuutType;

/**
 * Statisch attribuut type organistatie naam.
 */
@Embeddable
public class Organisatienaam extends AbstractStatischAttribuutType<String> {

    /**
     * De (op dit moment) enige constructor voor de immutable AttribuutType classen.
     *
     * @param waarde de waarde
     */
    public Organisatienaam(final String waarde) {
        super(waarde);
    }

    /**
     * Default constructor.
     */
    protected Organisatienaam() {
        super(null);
    }
}
