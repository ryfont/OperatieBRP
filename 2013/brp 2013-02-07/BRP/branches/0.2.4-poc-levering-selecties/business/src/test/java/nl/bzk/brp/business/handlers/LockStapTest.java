/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.business.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import nl.bzk.brp.business.dto.BerichtVerwerkingsResultaat;
import nl.bzk.brp.business.dto.bijhouding.AbstractBijhoudingsBericht;
import nl.bzk.brp.business.service.BsnLocker;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Soortbericht;
import nl.bzk.brp.model.validatie.Melding;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;


public class LockStapTest extends AbstractStapTest {

    @Mock
    private AbstractBijhoudingsBericht bericht;

    @Mock
    private BsnLocker          bsnLocker;

    private LockStap           lockStap;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testVoerVerwerkingsStapUitVoorBericht() {
        List<Melding> meldingen = new ArrayList<Melding>();
        BerichtVerwerkingsResultaat resultaat = new BerichtVerwerkingsResultaat(meldingen);
        ArgumentCaptor<Collection> readLocks = ArgumentCaptor.forClass(Collection.class);
        ArgumentCaptor<Collection> writeLocks = ArgumentCaptor.forClass(Collection.class);
        ArgumentCaptor<Long> berichtContext = ArgumentCaptor.forClass(Long.class);

        lockStap.voerVerwerkingsStapUitVoorBericht(bericht, bouwBerichtContext(), resultaat);

        Mockito.verify(bsnLocker).getLocks(readLocks.capture(), writeLocks.capture(), berichtContext.capture());

        Assert.assertEquals(bericht.getReadBsnLocks(), readLocks.getValue());
        Assert.assertEquals(bericht.getWriteBsnLocks(), writeLocks.getValue());

    }

    @Test
    public void testNaVerwerkingsStap() {
        List<Melding> meldingen = new ArrayList<Melding>();
        BerichtVerwerkingsResultaat resultaat = new BerichtVerwerkingsResultaat(meldingen);
        lockStap.naVerwerkingsStapVoorBericht(bericht, bouwBerichtContext(), resultaat);
        Mockito.verify(bsnLocker).unLock();
    }

    @Before
    public final void initMocksEnService() {
        MockitoAnnotations.initMocks(this);
        lockStap = new LockStap();

        bericht = createBericht();

        ReflectionTestUtils.setField(lockStap, "bsnLocker", bsnLocker);
    }

    private AbstractBijhoudingsBericht createBericht() {
        return new AbstractBijhoudingsBericht() {

            @Override
            public Collection<String> getReadBsnLocks() {
                return Arrays.asList("1435", "3242312", "4523");
            }

            @Override
            public Collection<String> getWriteBsnLocks() {
                return Arrays.asList("43524", "324133", "1234");
            }

            @Override
            public Soortbericht getSoortBericht() {
                return null;
            }

            @Override
            public void setVerzendendId(final String verzendendId) {

            }

            @Override
            public String getVerzendendId() {
                return null;
            }
        };

    }

}
