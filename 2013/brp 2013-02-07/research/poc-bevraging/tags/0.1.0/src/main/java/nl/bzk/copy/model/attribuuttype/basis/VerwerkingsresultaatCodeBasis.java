/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

/**
 * Deze code is gegenereerd vanuit het metaregister van het BRP, versie 1.0.18.
 *
 */
package nl.bzk.copy.model.attribuuttype.basis;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;

import nl.bzk.copy.model.basis.AbstractStatischAttribuutType;

/**
 * VerwerkingsresultaatCodeBasis.
 *
 * @version 1.0.18.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class VerwerkingsresultaatCodeBasis extends AbstractStatischAttribuutType<String> {

    /**
     * Private constructor t.b.v. Hibernate.
     */
    private VerwerkingsresultaatCodeBasis() {
        super(null);
    }

    /**
     * De (op dit moment) enige constructor voor deze immutable class.
     *
     * @param waarde de waarde
     */
    public VerwerkingsresultaatCodeBasis(final String waarde) {
        super(waarde);
    }
}
