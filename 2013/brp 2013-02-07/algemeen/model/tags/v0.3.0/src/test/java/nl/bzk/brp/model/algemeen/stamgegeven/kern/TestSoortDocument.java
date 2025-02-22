/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.algemeen.stamgegeven.kern;

import nl.bzk.brp.model.algemeen.attribuuttype.kern.NaamEnumeratiewaarde;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.Volgnummer;

/** SoortDocument ten behoeve van unittest. */
public class TestSoortDocument extends SoortDocument {

    /**
     * Constructor die direct alle attributen instantieert.
     *
     * @param naam naam van SoortDocument.
     */
    public TestSoortDocument(final NaamEnumeratiewaarde naam) {
        super(naam, null, new Volgnummer(new Integer(1)));
    }
}
