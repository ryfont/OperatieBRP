/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.business.regels.impl.levering;

import nl.bzk.brp.business.regels.context.HuidigeSituatieRegelContext;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.DatumTijdAttribuut;
import nl.bzk.brp.model.algemeen.stamgegeven.autaut.Dienst;
import nl.bzk.brp.model.algemeen.stamgegeven.autaut.Leveringsautorisatie;
import nl.bzk.brp.model.algemeen.stamgegeven.autaut.TestDienstBuilder;
import nl.bzk.brp.model.algemeen.stamgegeven.autaut.TestLeveringsautorisatieBuilder;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.Partij;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.Regel;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortPersoon;
import nl.bzk.brp.model.hisvolledig.impl.autaut.PersoonAfnemerindicatieHisVolledigImpl;
import nl.bzk.brp.model.hisvolledig.impl.kern.PersoonHisVolledigImpl;
import nl.bzk.brp.model.hisvolledig.momentview.kern.PersoonView;
import nl.bzk.brp.model.logisch.autaut.PersoonAfnemerindicatieStandaardGroep;
import nl.bzk.brp.model.operationeel.autaut.HisPersoonAfnemerindicatieModel;
import nl.bzk.brp.util.StatischeObjecttypeBuilder;
import nl.bzk.brp.util.hisvolledig.autaut.PersoonAfnemerindicatieHisVolledigImplBuilder;
import nl.bzk.brp.util.hisvolledig.kern.PersoonHisVolledigImplBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

public class BRLV0006Test {

    private final BRLV0006 brlv0006 = new BRLV0006();

    @Test
    public void testGetRegel() {
        Assert.assertEquals(Regel.BRLV0006, brlv0006.getRegel());
    }

    @Test
    public void testValideer() {
        final PersoonView persoonView = maakHuidigeSituatie(SoortPersoon.INGESCHREVENE);

        final HuidigeSituatieRegelContext context =
                new HuidigeSituatieRegelContext(persoonView);
        final boolean resultaat = brlv0006.valideer(context);

        Assert.assertTrue(resultaat);
    }

    @Test
    public void testValideerNietIngeschreven() {
        final PersoonView persoonView = maakHuidigeSituatie(SoortPersoon.NIET_INGESCHREVENE);

        final HuidigeSituatieRegelContext context =
                new HuidigeSituatieRegelContext(persoonView);
        final boolean resultaat = brlv0006.valideer(context);

        Assert.assertFalse(resultaat);
    }

    @Test
    public void testGetContextType() {
        Assert.assertEquals(HuidigeSituatieRegelContext.class, brlv0006.getContextType());
    }

    private PersoonView maakHuidigeSituatie(final SoortPersoon soortPersoon) {
        final PersoonHisVolledigImpl persoonHisVolledig =
                new PersoonHisVolledigImplBuilder(soortPersoon).build();

        final Leveringsautorisatie leveringsautorisatie =
            TestLeveringsautorisatieBuilder.maker().maak();

        final Dienst dienst =
            TestDienstBuilder.dummy();

        final Partij afnemer = StatischeObjecttypeBuilder.PARTIJ_GEMEENTE_AMSTERDAM.getWaarde();
        final PersoonAfnemerindicatieHisVolledigImpl afnemerIndicatie =
                new PersoonAfnemerindicatieHisVolledigImplBuilder(persoonHisVolledig, afnemer, leveringsautorisatie)
                        .build();
        final HisPersoonAfnemerindicatieModel hisPersoonAfnemerindicatieModel =
                new HisPersoonAfnemerindicatieModel(afnemerIndicatie,
                        Mockito.mock(PersoonAfnemerindicatieStandaardGroep.class),
                        dienst, DatumTijdAttribuut.bouwDatumTijd(2010, 1, 1));
        afnemerIndicatie.getPersoonAfnemerindicatieHistorie().voegToe(hisPersoonAfnemerindicatieModel);

        persoonHisVolledig.getAfnemerindicaties().add(afnemerIndicatie);

        return new PersoonView(persoonHisVolledig);
    }
}
