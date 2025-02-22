/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.moderniseringgba.migratie.logging;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test het contract van de migratie LoggerFactory.
 * 
 */
public class LoggerFactoryTest {

    private static final Logger LOG = LoggerFactory.getLogger();

    @Test
    public void testNewLogger() {
        Logger logger = LoggerFactory.getLogger();
        assertEquals(this.getClass().getName(), logger.getName());
        LOG.info("LOG doet het");
    }
}
