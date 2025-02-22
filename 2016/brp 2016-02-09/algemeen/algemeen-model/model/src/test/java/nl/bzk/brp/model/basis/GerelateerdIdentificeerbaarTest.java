/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.basis;

import nl.bzk.brp.model.algemeen.stamgegeven.kern.ElementEnum;
import org.junit.Assert;
import org.junit.Test;

public class GerelateerdIdentificeerbaarTest {

    final GerelateerdIdentificeerbaar gerelateerdIdentificeerbaar = new GerelateerdIdentificeerbaarImpl();

    @Test
    public void testGetGerelateerdeObjectType() {
        gerelateerdIdentificeerbaar.setGerelateerdeObjectType(ElementEnum.ACTIE);
        Assert.assertEquals(ElementEnum.ACTIE, gerelateerdIdentificeerbaar.getGerelateerdeObjectType());
    }

    /**
     * Testklasse om abstracte klasse te dekken.
     */
    class GerelateerdIdentificeerbaarImpl extends AbstractGerelateerdIdentificeerbaar {
    }
}