/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.isc.jbpm.uc301;

import java.util.HashMap;
import java.util.Map;
import nl.bzk.migratiebrp.bericht.model.lo3.impl.Iv01Bericht;
import nl.bzk.migratiebrp.bericht.model.lo3.impl.NullBericht;
import nl.bzk.migratiebrp.isc.jbpm.common.berichten.BerichtenDao;
import nl.bzk.migratiebrp.isc.jbpm.common.berichten.InMemoryBerichtenDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class MaakNullActionTest {

    private MaakNullAction subject;
    private BerichtenDao berichtenDao;

    @Before
    public void setup() {
        subject = new MaakNullAction();
        berichtenDao = new InMemoryBerichtenDao();
        ReflectionTestUtils.setField(subject, "berichtenDao", berichtenDao);
    }

    @Test
    public void test() {
        final Iv01Bericht iv01Bericht = new Iv01Bericht();
        iv01Bericht.setBronGemeente("1234");
        iv01Bericht.setDoelGemeente("5678");

        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("iv01Bericht", berichtenDao.bewaarBericht(iv01Bericht));

        final Map<String, Object> result = subject.execute(parameters);
        Assert.assertEquals(1, result.size());

        final NullBericht nullBericht = (NullBericht) berichtenDao.leesBericht((Long) result.get("nullBericht"));
        Assert.assertNotNull(nullBericht);
        Assert.assertEquals("1234", nullBericht.getDoelGemeente());
        Assert.assertEquals("5678", nullBericht.getBronGemeente());
        Assert.assertEquals(iv01Bericht.getMessageId(), nullBericht.getCorrelationId());
    }

}
