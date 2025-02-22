/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.synchronisatie.runtime.service.synchronisatie.controle.samengesteld;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Named;
import nl.bzk.migratiebrp.bericht.model.sync.impl.SynchroniseerNaarBrpVerzoekBericht;
import nl.bzk.migratiebrp.conversie.model.brp.BrpPersoonslijst;
import nl.bzk.migratiebrp.conversie.model.brp.BrpPersoonslijstBuilder;
import nl.bzk.migratiebrp.synchronisatie.logging.SynchronisatieLogging;
import nl.bzk.migratiebrp.synchronisatie.runtime.service.synchronisatie.controle.lijst.LijstControle;
import nl.bzk.migratiebrp.synchronisatie.runtime.service.synchronisatie.controle.pl.PlControle;
import nl.bzk.migratiebrp.synchronisatie.runtime.service.synchronisatie.controle.verzoek.VerzoekControle;
import nl.bzk.migratiebrp.synchronisatie.runtime.service.synchronisatie.controle.zoeker.PlZoeker;
import nl.bzk.migratiebrp.synchronisatie.runtime.service.synchronisatie.verwerker.context.VerwerkingsContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ControleReguliereWijzigingTest {

    @Mock
    @Named(value = "verzoekControleOudAnummerIsNietGevuld")
    private VerzoekControle verzoekControleOudAnummerIsNietGevuld;

    @Mock
    @Named(value = "plZoekerOpAnummerEnNietFoutiefOpgeschortObvActueelAnummer")
    private PlZoeker plZoekerOpAnummerEnNietFoutiefOpgeschortObvActueelAnummer;

    @Mock
    @Named(value = "lijstControleEen")
    private LijstControle lijstControleEen;

    @Mock
    @Named(value = "plControleBijhoudingsPartijGelijk")
    private PlControle plControleBijhoudingsPartijGelijk;
    @Mock
    @Named(value = "plControleVorigAnummerGelijk")
    private PlControle plControleVorigAnummerGelijk;
    @Mock
    @Named(value = "plControleHistorieAnummerGelijk")
    private PlControle plControleHistorieAnummerGelijk;
    @Mock
    @Named(value = "plControleDezelfdePersoon")
    private PlControle plControleDezelfdePersoon;
    @Mock
    @Named(value = "plControleGevondenVersienummerKleiner")
    private PlControle plControleGevondenVersienummerKleiner;
    @Mock
    @Named(value = "plControleGevondenDatumtijdstempelOuder")
    private PlControle plControleGevondenDatumtijdstempelOuder;

    @InjectMocks
    private ControleReguliereWijziging subject;

    @Before
    public void setupLogging() {
        SynchronisatieLogging.init();
    }

    @Test
    public void ok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Arrays.asList(dbPersoonslijst), true, true, true, true, true, true, true, true);
        Assert.assertTrue(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void verzoekControleOudAnummerIsNietGevuldNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Arrays.asList(dbPersoonslijst), false, true, true, true, true, true, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void lijstControleEenNok() {
        setup(Collections.<BrpPersoonslijst>emptyList(), true, false, true, true, true, true, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void plControleBijhoudingsPartijGelijkNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Arrays.asList(dbPersoonslijst), true, true, false, true, true, true, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void plControleVorigAnummerGelijkNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Arrays.asList(dbPersoonslijst), true, true, true, false, true, true, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void plControleHistorieAnummerGelijkNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Arrays.asList(dbPersoonslijst), true, true, true, true, false, true, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void plControleDezelfdePersoonNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Arrays.asList(dbPersoonslijst), true, true, true, true, true, false, true, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void plControleGevondenVersienummerKleinerNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Arrays.asList(dbPersoonslijst), true, true, true, true, true, true, false, true);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    @Test
    public void plControleGevondenDatumtijdstempelOuderNok() {
        final BrpPersoonslijst dbPersoonslijst = new BrpPersoonslijstBuilder().build();
        setup(Arrays.asList(dbPersoonslijst), true, true, true, true, true, true, true, false);
        Assert.assertFalse(subject.controleer(new VerwerkingsContext(null, null, null, null)));
    }

    private void setup(
        final List<BrpPersoonslijst> plZoekerOpAnummerEnNietFoutiefOpgeschortObvActueelAnummerResult,
        final boolean verzoekControleOudAnummerIsNietGevuldResult,
        final boolean lijstControleEenResult,
        final boolean plControleBijhoudingsPartijGelijkResult,
        final boolean plControleVorigAnummerGelijkResult,
        final boolean plControleHistorieAnummerGelijkResult,
        final boolean plControleDezelfdePersoonResult,
        final boolean plControleGevondenVersienummerKleinerResult,
        final boolean plControleGevondenDatumtijdstempelOuderResult)
    {
        Mockito.when(plZoekerOpAnummerEnNietFoutiefOpgeschortObvActueelAnummer.zoek(Matchers.any(VerwerkingsContext.class))).thenReturn(
            plZoekerOpAnummerEnNietFoutiefOpgeschortObvActueelAnummerResult);

        Mockito.when(verzoekControleOudAnummerIsNietGevuld.controleer(Matchers.any(SynchroniseerNaarBrpVerzoekBericht.class))).thenReturn(
            verzoekControleOudAnummerIsNietGevuldResult);

        Mockito.when(lijstControleEen.controleer(Matchers.anyListOf(BrpPersoonslijst.class))).thenReturn(lijstControleEenResult);

        Mockito.when(plControleBijhoudingsPartijGelijk.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class)))
               .thenReturn(plControleBijhoudingsPartijGelijkResult);
        Mockito.when(plControleVorigAnummerGelijk.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class))).thenReturn(
            plControleVorigAnummerGelijkResult);
        Mockito.when(plControleHistorieAnummerGelijk.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class))).thenReturn(
            plControleHistorieAnummerGelijkResult);
        Mockito.when(plControleDezelfdePersoon.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class))).thenReturn(
            plControleDezelfdePersoonResult);
        Mockito.when(plControleGevondenVersienummerKleiner.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class)))
               .thenReturn(plControleGevondenVersienummerKleinerResult);
        Mockito.when(plControleGevondenDatumtijdstempelOuder.controleer(Matchers.any(VerwerkingsContext.class), Matchers.any(BrpPersoonslijst.class)))
               .thenReturn(plControleGevondenDatumtijdstempelOuderResult);
    }
}
