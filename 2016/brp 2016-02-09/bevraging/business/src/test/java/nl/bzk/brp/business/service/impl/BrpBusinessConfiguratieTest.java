/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.business.service.impl;


import javax.inject.Inject;

import nl.bzk.brp.configuratie.BrpBusinessConfiguratie;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BrpBusinessConfiguratieTest {

    @Inject
    private BrpBusinessConfiguratie brpBusinessConfiguratie;

    @Test
    public final void testDatabaseTimeOutCorrecteIngesteldeWaarde() {
        Assert.assertEquals(10, brpBusinessConfiguratie.getDatabaseTimeOutProperty());
    }
}
