/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.synchronisatie.runtime.service.synchronisatie.controle.samengesteld;

import java.util.Collections;
import java.util.List;
import nl.bzk.migratiebrp.conversie.model.brp.BrpPersoonslijst;
import nl.bzk.migratiebrp.conversie.model.brp.BrpPersoonslijstBuilder;
import nl.bzk.migratiebrp.synchronisatie.logging.SynchronisatieLogging;
import nl.bzk.migratiebrp.synchronisatie.runtime.service.synchronisatie.controle.lijst.LijstControle;
import nl.bzk.migratiebrp.synchronisatie.runtime.service.synchronisatie.controle.pl.PlControle;
import nl.bzk.migratiebrp.synchronisatie.runtime.service.synchronisatie.controle.zoeker.PlZoeker;
import nl.bzk.migratiebrp.synchronisatie.runtime.service.synchronisatie.verwerker.context.VerwerkingsContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class ControleEmigratieTest {

    @Mock
    private PlZoeker plZoekerObvActueelAnummer;
    @Mock
    private PlZoeker plZoekerObvActueelBsn;
    @Mock
    private LijstControle lijstControleEen;
    @Mock
    private PlControle plControleGevondenBlokkeringssituatieIsJuist;
    @Mock
    private PlControle plControleBijhoudingsPartijOngelijk;
    @Mock
    private PlControle plControleBijhoudingsPartijGelijkVerzendendeGemeente;
    @Mock
    private PlControle plControleBijhoudingsPartijGelijkRni;
    @Mock
    private PlControle plControleVorigAnummerGelijk;
    @Mock
    private PlControle plControleHistorieAnummerGelijk;
    @Mock
    private PlControle plControleDezelfdePersoon;
    @Mock
    private PlControle plControleActueelBsnGelijk;
    @Mock
    private LijstControle lijstControleGeen;
    @Mock
    private PlControle plControleAangebodenAdressenGelijk;
    @Mock
    private PlControle plControleGevondenVersienummerGelijkOfKleiner;
    @Mock
    private PlControle plControleGevondenDatumtijdstempelOuder;

    private ControleEmigratie subject;

    @Before
    public void setupLogging() {
        SynchronisatieLogging.init();
        subject = new ControleEmigratie(null, null);
        ReflectionTestUtils.setField(subject, "plZoekerObvActueelAnummer", plZoekerObvActueelAnummer);
        ReflectionTestUtils.setField(subject, "plZoekerObvActueelBsn", plZoekerObvActueelBsn);
        ReflectionTestUtils.setField(subject, "lijstControleEen", lijstControleEen);
        ReflectionTestUtils.setField(subject, "lijstControleGeen", lijstControleGeen);
        ReflectionTestUtils.setField(subject, "plControleGevondenBlokkeringssituatieIsJuist", plControleGevondenBlokkeringssituatieIsJuist);
        ReflectionTestUtils.setField(subject, "plControleBijhoudingsPartijOngelijk", plControleBijhoudingsPartijOngelijk);
        ReflectionTestUtils.setField(subject, "plControleBijhoudingsPartijGelijkVerzendendeGemeente", plControleBijhoudingsPartijGelijkVerzendendeGemeente);
        ReflectionTestUtils.setField(subject, "plControleBijhoudingsPartijGelijkRni", plControleBijhoudingsPartijGelijkRni);
        ReflectionTestUtils.setField(subject, "plControleVorigAnummerGelijk", plControleVorigAnummerGelijk);
        ReflectionTestUtils.setField(subject, "plControleHistorieAnummerGelijk", plControleHistorieAnummerGelijk);
        ReflectionTestUtils.setField(subject, "plControleDezelfdePersoon", plControleDezelfdePersoon);
        ReflectionTestUtils.setField(subject, "plControleActueelBsnGelijk", plControleActueelBsnGelijk);
        ReflectionTestUtils.setField(subject, "plControleAangebodenAdressenGelijk", plControleAangebodenAdressenGelijk);
        ReflectionTestUtils.setField(subject, "plControleGevondenVersienummerGelijkOfKleiner", plControleGevondenVersienummerGelijkOfKleiner);
        ReflectionTestUtils.setField(subject, "plControleGevondenDatumtijdstempelOuder", plControleGevondenDatumtijdstempelOuder);
    }

    @Test
    public void ok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Collections.singletonList(dbPersoonslijst), Collections.singletonList(dbPersoonslijst),
                true, true, true, true, true, true, true, true, true, true, true, true, true);
        Assert.assertTrue(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void lijstControleEenNok() {
        setup(Collections.emptyList(), Collections.emptyList(),
                false, true, true, true, true, true, true, true, true, true, true, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void testVerzendendeGemeente() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Collections.singletonList(dbPersoonslijst), Collections.singletonList(dbPersoonslijst),
                true, false, true, true, true, true, true, true, true, true, true, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void bijhoudingssituatieNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Collections.singletonList(dbPersoonslijst), Collections.singletonList(dbPersoonslijst),
                true, true, false, true, true, true, true, true, true, true, true, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }


    @Test
    public void plControleBijhoudingsPartijOngelijkNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Collections.singletonList(dbPersoonslijst), Collections.singletonList(dbPersoonslijst),
                true, true, true, false, true, true, true, true, true, true, true, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void plControleVorigAnummerGelijkNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Collections.singletonList(dbPersoonslijst), Collections.singletonList(dbPersoonslijst),
                true, true, true, true, false, true, true, true, true, true, true, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void plControleHistorieAnummerGelijkNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Collections.singletonList(dbPersoonslijst), Collections.singletonList(dbPersoonslijst),
                true, true, true, true, true, false, true, true, true, true, true, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void plControleDezelfdePersoonNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Collections.singletonList(dbPersoonslijst), Collections.singletonList(dbPersoonslijst),
                true, true, true, true, true, true, false, true, true, true, true, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void bsnOk() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Collections.singletonList(dbPersoonslijst), Collections.singletonList(dbPersoonslijst),
                true, true, true, true, true, true, true, false, true, true, true, true, true);
        Assert.assertTrue(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void bsnNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Collections.singletonList(dbPersoonslijst), Collections.singletonList(dbPersoonslijst),
                true, true, true, true, true, true, true, false, false, true, true, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void plControleAangebodenAdressenGelijkNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Collections.singletonList(dbPersoonslijst), Collections.singletonList(dbPersoonslijst),
                true, true, true, true, true, true, true, true, true, false, true, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void plControleGevondenVersienummerGelijkOfKleinerNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Collections.singletonList(dbPersoonslijst), Collections.singletonList(dbPersoonslijst),
                true, true, true, true, true, true, true, true, true, true, false, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void plControleGevondenDatumtijdstempelOuderNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Collections.singletonList(dbPersoonslijst), Collections.singletonList(dbPersoonslijst),
                true, true, true, true, true, true, true, true, true, true, true, false, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void plControleBijhoudingsPartijGelijkRniNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Collections.singletonList(dbPersoonslijst), Collections.singletonList(dbPersoonslijst),
                true, true, true, true, true, true, true, true, true, true, true, true, false);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    private void setup(
            final List<BrpPersoonslijst> plZoekerObvActueelAnummerResult,
            final List<BrpPersoonslijst> plZoekerObvActueelBsnResult,
            final boolean lijstControleEenResult,
            final boolean resultControleVerzendendeGemeente,
            final boolean resultControleBijhoudingssituatie,
            final boolean plControleBijhoudingsPartijOngelijkResult,
            final boolean plControleVorigAnummerGelijkResult,
            final boolean plControleHistorieAnummerGelijkResult,
            final boolean plControleDezelfdePersoonResult,
            final boolean plControleActueelBsnGelijkResult,
            final boolean lijstControleGeenResult,
            final boolean plControleGevondenAdressenKomenVoorInHistorieAangebodenAdressenResult,
            final boolean plControleGevondenVersienummerGelijkOfKleinerResult,
            final boolean plControleGevondenDatumtijdstempelOuderResult,
            final boolean plControleBijhoudingsPartijOngelijkRniResult) {
        Mockito.when(plZoekerObvActueelAnummer.zoek(Matchers.any(VerwerkingsContext.class))).thenReturn(plZoekerObvActueelAnummerResult);
        Mockito.when(plZoekerObvActueelBsn.zoek(Matchers.any(VerwerkingsContext.class))).thenReturn(plZoekerObvActueelBsnResult);

        Mockito.when(lijstControleEen.controleer(Matchers.anyListOf(BrpPersoonslijst.class))).thenReturn(lijstControleEenResult);
        Mockito.when(plControleGevondenBlokkeringssituatieIsJuist.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class)))
                .thenReturn(resultControleBijhoudingssituatie);
        Mockito.when(
                plControleBijhoudingsPartijGelijkVerzendendeGemeente.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class)))
                .thenReturn(resultControleVerzendendeGemeente);
        Mockito.when(plControleBijhoudingsPartijOngelijk.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class)))
                .thenReturn(plControleBijhoudingsPartijOngelijkResult);
        Mockito.when(plControleBijhoudingsPartijGelijkRni.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class)))
                .thenReturn(plControleBijhoudingsPartijOngelijkRniResult);
        Mockito.when(plControleVorigAnummerGelijk.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class)))
                .thenReturn(plControleVorigAnummerGelijkResult);
        Mockito.when(plControleHistorieAnummerGelijk.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class)))
                .thenReturn(plControleHistorieAnummerGelijkResult);
        Mockito.when(plControleDezelfdePersoon.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class)))
                .thenReturn(plControleDezelfdePersoonResult);
        Mockito.when(plControleActueelBsnGelijk.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class)))
                .thenReturn(plControleActueelBsnGelijkResult);
        Mockito.when(lijstControleGeen.controleer(Matchers.anyListOf(BrpPersoonslijst.class))).thenReturn(lijstControleGeenResult);
        Mockito.when(plControleAangebodenAdressenGelijk.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class)))
                .thenReturn(plControleGevondenAdressenKomenVoorInHistorieAangebodenAdressenResult);
        Mockito.when(
                plControleGevondenVersienummerGelijkOfKleiner.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class)))
                .thenReturn(plControleGevondenVersienummerGelijkOfKleinerResult);
        Mockito.when(plControleGevondenDatumtijdstempelOuder.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class)))
                .thenReturn(plControleGevondenDatumtijdstempelOuderResult);
    }
}
