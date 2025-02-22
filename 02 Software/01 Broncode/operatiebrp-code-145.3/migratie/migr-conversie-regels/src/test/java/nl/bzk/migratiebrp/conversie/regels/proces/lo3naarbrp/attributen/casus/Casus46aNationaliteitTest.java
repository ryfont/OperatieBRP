/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.conversie.regels.proces.lo3naarbrp.attributen.casus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import nl.bzk.migratiebrp.conversie.model.brp.BrpActie;
import nl.bzk.migratiebrp.conversie.model.brp.BrpPersoonslijst;
import nl.bzk.migratiebrp.conversie.model.brp.BrpStapel;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpDatumTijd;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpNationaliteitCode;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpNationaliteitInhoud;
import nl.bzk.migratiebrp.conversie.model.lo3.Lo3Categorie;
import nl.bzk.migratiebrp.conversie.model.lo3.Lo3Persoonslijst;
import nl.bzk.migratiebrp.conversie.model.lo3.Lo3Stapel;
import nl.bzk.migratiebrp.conversie.model.lo3.categorie.Lo3NationaliteitInhoud;
import nl.bzk.migratiebrp.conversie.model.lo3.element.Lo3NationaliteitCode;
import nl.bzk.migratiebrp.conversie.model.lo3.herkomst.Lo3CategorieEnum;
import nl.bzk.migratiebrp.conversie.model.lo3.herkomst.Lo3Herkomst;
import nl.bzk.migratiebrp.conversie.model.proces.brpnaarlo3.Lo3StapelHelper;
import nl.bzk.migratiebrp.conversie.model.testutils.StapelUtils;

import org.junit.Test;

public class Casus46aNationaliteitTest extends AbstractCasusTest {

    private final List<Lo3Categorie<Lo3NationaliteitInhoud>> categorieen = new ArrayList<>();

    private final Lo3NationaliteitInhoud lo3Leeg = new Lo3NationaliteitInhoud(null, null, null, null, null);
    private final Lo3NationaliteitInhoud lo3Duits = new Lo3NationaliteitInhoud(new Lo3NationaliteitCode("0055"), null, null, null, null);

    private final BrpNationaliteitInhoud brpDuits =
            new BrpNationaliteitInhoud(new BrpNationaliteitCode("0055"), null, null, null, null, null, null);

    private final BrpTestObject<BrpNationaliteitInhoud> brp1 = new BrpTestObject<>();
    private final BrpTestObject<BrpNationaliteitInhoud> brp2 = new BrpTestObject<>();

    {
        final Lo3TestObject<Lo3NationaliteitInhoud> lo1 = new Lo3TestObject<>(Document.AKTE);
        final Lo3TestObject<Lo3NationaliteitInhoud> lo2 = new Lo3TestObject<>(Document.AKTE);
        final Lo3TestObject<Lo3NationaliteitInhoud> lo3 = new Lo3TestObject<>(Document.AKTE);

        final BrpActie actie3 = buildBrpActie(BrpDatumTijd.fromDatum(19950103, null), "3A");
        final BrpActie actie2 = buildBrpActie(BrpDatumTijd.fromDatum(19950102, null), "2A");
        final BrpActie actie1 = buildBrpActie(BrpDatumTijd.fromDatum(19900102, null), "1A");

        // @formatter:off
        // Duits 1-1-1989 3-1-1995 <A3>
        // - 1-1-1991 2-1-1995 <A2>
        // Duits O 1-1-1990 2-1-1990 <A1>

        // LO3 input
        lo3.vul(lo3Leeg, null, 19910101, 19950102, 2, new Lo3Herkomst(Lo3CategorieEnum.CATEGORIE_04, 0, 0));
        lo2.vul(lo3Duits, null, 19890101, 19950103, 3, new Lo3Herkomst(Lo3CategorieEnum.CATEGORIE_54, 0, 1));
        lo1.vul(lo3Duits, ONJUIST, 19900101, 19900102, 1, new Lo3Herkomst(Lo3CategorieEnum.CATEGORIE_54, 0, 2));

        // verwachte BRP output

        brp1.vul(brpDuits, 19900101, null, 19900102010000L, 19900102010000L, 'O', actie1, null, actie1);
        brp2.vul(brpDuits, 19890101, 19910101, 19950103010000L, null, null, actie3, actie2, null);
        // @formatter:on

        vulCategorieen(lo1, lo2, lo3);
    }

    @Override
    protected Lo3Stapel<Lo3NationaliteitInhoud> maakNationaliteitStapel() {
        return StapelUtils.createStapel(categorieen);
    }

    private void vulCategorieen(final Lo3TestObject<Lo3NationaliteitInhoud>... testObjecten) {
        for (final Lo3TestObject<Lo3NationaliteitInhoud> lo : testObjecten) {
            categorieen.add(new Lo3Categorie<>(lo.getInhoud(), lo.getAkte(), lo.getHistorie(), lo.getLo3Herkomst()));
        }
    }

    @Override
    @Test
    public void testLo3NaarBrp() {
        final Lo3Persoonslijst lo3Persoonslijst = getLo3Persoonslijst();
        final BrpPersoonslijst brpPersoonslijst = converteerLo3NaarBrpService.converteerLo3Persoonslijst(lo3Persoonslijst);
        assertNotNull(brpPersoonslijst);

        final List<BrpStapel<BrpNationaliteitInhoud>> nationaliteiten = brpPersoonslijst.getNationaliteitStapels();
        assertEquals(1, nationaliteiten.size());

        final BrpStapel<BrpNationaliteitInhoud> nationaliteit = nationaliteiten.get(0);
        assertEquals(2, nationaliteit.size());

        assertNationaliteit(nationaliteit.get(0), brp1);
        assertNationaliteit(nationaliteit.get(1), brp2);

    }

    @Override
    @Test
    public void testRondverteer() {
        final BrpPersoonslijst brpPersoonslijst = converteerLo3NaarBrpService.converteerLo3Persoonslijst(getLo3Persoonslijst());
        final Lo3Persoonslijst terug = converteerBrpNaarLo3Service.converteerBrpPersoonslijst(brpPersoonslijst);
        final List<Lo3Stapel<Lo3NationaliteitInhoud>> rondverteerdeStapels = terug.getNationaliteitStapels();
        final List<Lo3Stapel<Lo3NationaliteitInhoud>> origineleStapels = getLo3Persoonslijst().getNationaliteitStapels();
        assertEquals(1, rondverteerdeStapels.size());
        assertEquals(origineleStapels.get(0).size(), rondverteerdeStapels.get(0).size());

        Lo3StapelHelper.vergelijk(origineleStapels, rondverteerdeStapels);
        // assertEquals(origineleStapels, rondverteerdeStapels);
    }
}
