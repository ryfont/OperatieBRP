/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.moderniseringgba.isc.esb.message.lo3.impl;

import junit.framework.Assert;
import nl.moderniseringgba.isc.esb.message.lo3.Lo3HeaderVeld;

import org.junit.Test;

public class NullBerichtTest {

    private static final String BRON_GEMEENTE = "1905";
    private static final String DOEL_GEMEENTE = "1904";
    private static final String CORRELATION_ID = "123484";
    private static final String MESSAGE_ID = "86451523";

    @Test
    public void testVertaal() throws Exception {
        final NullBericht nullBericht = new NullBericht(CORRELATION_ID);
        nullBericht.parse("");
        Assert.assertEquals(CORRELATION_ID, nullBericht.getCorrelationId());
        Assert.assertEquals("", nullBericht.format());
        Assert.assertEquals("Null", nullBericht.getBerichtType());
        Assert.assertEquals(null, nullBericht.getStartCyclus());
    }

    @Test
    public void testGetterEnSetters() {
        final NullBericht nullBericht = new NullBericht();
        nullBericht.setBronGemeente(BRON_GEMEENTE);
        nullBericht.setDoelGemeente(DOEL_GEMEENTE);
        nullBericht.setCorrelationId(CORRELATION_ID);
        nullBericht.setMessageId(MESSAGE_ID);
        Assert.assertEquals(CORRELATION_ID, nullBericht.getCorrelationId());
        Assert.assertEquals(MESSAGE_ID, nullBericht.getMessageId());
        Assert.assertEquals(BRON_GEMEENTE, nullBericht.getBronGemeente());
        Assert.assertEquals(DOEL_GEMEENTE, nullBericht.getDoelGemeente());
        Assert.assertEquals(null, nullBericht.getHeader(Lo3HeaderVeld.GEMEENTE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHeader() {
        final NullBericht nullBericht = new NullBericht();
        try {
            nullBericht.setHeader(Lo3HeaderVeld.GEMEENTE, BRON_GEMEENTE);
        } catch (final IllegalArgumentException exception) {
            throw exception;
        }
    }

    @Test
    public void testVergelijken() {
        final NullBericht nullBerichtOrigineel = new NullBericht(CORRELATION_ID);
        final NullBericht nullBerichtKopie = new NullBericht(CORRELATION_ID);
        final NullBericht nullBerichtObjectKopie = nullBerichtOrigineel;
        nullBerichtKopie.setMessageId(nullBerichtOrigineel.getMessageId());

        Assert.assertTrue(nullBerichtOrigineel.equals(nullBerichtKopie));
        Assert.assertTrue(nullBerichtOrigineel.equals(nullBerichtObjectKopie));
        Assert.assertFalse(nullBerichtOrigineel.equals(Integer.valueOf(1)));
        Assert.assertEquals(nullBerichtOrigineel.hashCode(), nullBerichtKopie.hashCode());
        Assert.assertEquals(nullBerichtOrigineel.toString(), nullBerichtKopie.toString());
    }
}
