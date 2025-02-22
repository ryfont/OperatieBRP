/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.synchronisatie.runtime.service.toevalligegebeurtenis.controle;

import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpAdellijkeTitelCode;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpBoolean;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpCharacter;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpDatum;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpGemeenteCode;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpGeslachtsaanduidingCode;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpLandOfGebiedCode;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpPredicaatCode;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpString;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpSamengesteldeNaamInhoud;
import nl.bzk.migratiebrp.conversie.model.brp.toevalligegebeurtenis.BrpToevalligeGebeurtenisPersoon;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class SamengesteldeNaamVergelijkerTest {

    private final SamengesteldeNaamVergelijker subject = new SamengesteldeNaamVergelijker();

    @Test
    public void testVergelijkTrue() {
        final BrpToevalligeGebeurtenisPersoon persoon =
                new BrpToevalligeGebeurtenisPersoon(
                        new BrpString("1"),
                        new BrpString("1"),
                        new BrpPredicaatCode("J"),
                        new BrpString("Hij"),
                        null,
                        new BrpCharacter(' '),
                        new BrpAdellijkeTitelCode("R"),
                        new BrpString("geslachtsnaamstam"),
                        new BrpDatum(19700101, null),
                        new BrpGemeenteCode("0003"),
                        null,
                        BrpLandOfGebiedCode.NEDERLAND,
                        null,
                        BrpGeslachtsaanduidingCode.MAN);
        final BrpSamengesteldeNaamInhoud inhoud =
                new BrpSamengesteldeNaamInhoud(
                        new BrpPredicaatCode("J"),
                        new BrpString("Hij"),
                        null,
                        new BrpCharacter(' '),
                        new BrpAdellijkeTitelCode("R"),
                        new BrpString("geslachtsnaamstam"),
                        new BrpBoolean(false),
                        new BrpBoolean(false));
        Assert.assertTrue("objecten moeten gelijk zijn", subject.vergelijk(persoon, inhoud));
    }

    @Test
    public void testVergelijkFalse() {
        final BrpToevalligeGebeurtenisPersoon persoon =
                new BrpToevalligeGebeurtenisPersoon(
                        new BrpString("1"),
                        new BrpString("1"),
                        new BrpPredicaatCode("J"),
                        new BrpString("Hij"),
                        null,
                        new BrpCharacter(' '),
                        new BrpAdellijkeTitelCode("R"),
                        new BrpString("geslachtsnaamstam"),
                        new BrpDatum(19700101, null),
                        new BrpGemeenteCode("0003"),
                        null,
                        BrpLandOfGebiedCode.NEDERLAND,
                        null,
                        BrpGeslachtsaanduidingCode.MAN);

        final BrpSamengesteldeNaamInhoud inhoud =
                new BrpSamengesteldeNaamInhoud(
                        new BrpPredicaatCode("J"),
                        new BrpString("Hij"),
                        null,
                        new BrpCharacter(' '),
                        new BrpAdellijkeTitelCode("R"),
                        new BrpString("andere naam"),
                        new BrpBoolean(false),
                        new BrpBoolean(false));
        Assert.assertFalse("objecten moeten ongelijk zijn", subject.vergelijk(persoon, inhoud));
    }
}
