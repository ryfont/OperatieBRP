/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.algemeen.attribuuttype.lev;

import com.fasterxml.jackson.annotation.JsonCreator;
import javax.persistence.Embeddable;


/**
 * Attribuut wrapper klasse voor Selectieperiode in maanden.
 */
@Embeddable
public class SelectieperiodeInMaandenAttribuut extends AbstractSelectieperiodeInMaandenAttribuut {

    /**
     * Lege private constructor voor SelectieperiodeInMaandenAttribuut, om te voorkomen dat wrappers zonder waarde worden geïnstantieerd.
     */
    private SelectieperiodeInMaandenAttribuut() {
        super();
    }

    /**
     * Constructor voor SelectieperiodeInMaandenAttribuut die de waarde toekent.
     *
     * @param waarde De waarde van het attribuut.
     */
    @JsonCreator
    public SelectieperiodeInMaandenAttribuut(final Short waarde) {
        super(waarde);
    }

}
