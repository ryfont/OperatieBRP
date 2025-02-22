/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.attribuuttype;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonCreator;
import nl.bzk.brp.model.basis.AbstractStatischAttribuutType;

/**
 * Statisch attribuut type applicatie naam.
 */
@Embeddable
public class Applicatienaam extends AbstractStatischAttribuutType<String> {

    /**
     * De (op dit moment) enige constructor voor de immutable AttribuutType classen.
     *
     * @param waarde de waarde
     */
    @JsonCreator
    public Applicatienaam(final String waarde) {
        super(waarde);
    }

    /**
     * Default constructor.
     */
    protected Applicatienaam() {
        super(null);
    }
}
