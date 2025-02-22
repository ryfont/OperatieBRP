/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.domain.berichtmodel;

import static org.junit.Assert.assertEquals;

import nl.bzk.algemeenbrp.dal.domein.brp.entity.SoortVrijBericht;
import org.junit.Test;

public class BerichtVrijBerichtTest {

    @Test
    public void test() {
        final VrijBericht vrijBericht = new VrijBericht("test", new SoortVrijBericht("soort"));
        final BerichtVrijBericht berichtVrijBericht = new BerichtVrijBericht(vrijBericht);

        assertEquals(vrijBericht, berichtVrijBericht.getVrijBericht());
    }
}
