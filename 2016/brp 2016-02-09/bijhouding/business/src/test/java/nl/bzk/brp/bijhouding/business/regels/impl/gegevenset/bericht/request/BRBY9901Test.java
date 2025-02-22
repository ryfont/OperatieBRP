/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.bijhouding.business.regels.impl.gegevenset.bericht.request;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import nl.bzk.brp.bijhouding.business.util.BerichtAdministratieUtil;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.Geslachtsaanduiding;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.Regel;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortPersoon;
import nl.bzk.brp.model.basis.BerichtIdentificeerbaar;
import nl.bzk.brp.model.bericht.kern.ActieRegistratieGeboorteBericht;
import nl.bzk.brp.model.bericht.kern.ActieRegistratieNationaliteitBericht;
import nl.bzk.brp.model.bericht.kern.FamilierechtelijkeBetrekkingBericht;
import nl.bzk.brp.model.bericht.kern.OuderBericht;
import nl.bzk.brp.model.bericht.kern.PersoonAdresBericht;
import nl.bzk.brp.model.bericht.kern.PersoonBericht;
import nl.bzk.brp.model.bericht.kern.RelatieBericht;
import nl.bzk.brp.model.bijhouding.BijhoudingsBericht;
import nl.bzk.brp.model.bijhouding.RegistreerGeboorteBericht;
import nl.bzk.brp.util.BerichtBuilder;
import nl.bzk.brp.util.PersoonAdresBuilder;
import nl.bzk.brp.util.PersoonBuilder;
import nl.bzk.brp.util.RelatieBuilder;
import nl.bzk.brp.util.StatischeObjecttypeBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** Unit test voor de {@link BRBY9901} bedrijfsregel. */
public class BRBY9901Test {


    private BRBY9901 bedrijfsregel;

    @Before
    public void init() {
        bedrijfsregel = new BRBY9901();
    }

    @Test
    public void testGetRegel() {
        Assert.assertEquals(Regel.BRBY9901, bedrijfsregel.getRegel());
    }

    @Test
    public void testGeenBericht() {
        Assert.assertTrue(bedrijfsregel.voerRegelUit(null).isEmpty());
    }

    @Test
    public void testGeenmap() {
        final BijhoudingsBericht simplegGeboorteBericht = maakSimpleInschrijvingBericht2();
        simplegGeboorteBericht.setCommunicatieIdMap(null);
        BerichtAdministratieUtil.verrijktBerichtMetIdentificeerbaarObjectIndex(simplegGeboorteBericht);
        final List<BerichtIdentificeerbaar> berichtenDieDeRegelOvertreden = bedrijfsregel.voerRegelUit(simplegGeboorteBericht);
        Assert.assertEquals(0, berichtenDieDeRegelOvertreden.size());
    }

    @Test
    public void testBRBY9901Normaal() {
        // niemand heeft een referentie, geen dubbele communicatieID's
        final BijhoudingsBericht simplegGeboorteBericht = maakSimpleInschrijvingBericht2();
        BerichtAdministratieUtil.verrijktBerichtMetIdentificeerbaarObjectIndex(simplegGeboorteBericht);
        final List<BerichtIdentificeerbaar> berichtenDieDeRegelOvertreden = bedrijfsregel.voerRegelUit(simplegGeboorteBericht);
        Assert.assertEquals(0, berichtenDieDeRegelOvertreden.size());
    }

    @Test
    public void testBRBY9901DrieDubbeleID() {
        final BijhoudingsBericht simplegGeboorteBericht = maakSimpleInschrijvingBericht2();
        final FamilierechtelijkeBetrekkingBericht famBericht = (FamilierechtelijkeBetrekkingBericht)
                simplegGeboorteBericht.getAdministratieveHandeling().getActies().get(0).getRootObject();

        final PersoonBericht kind = famBericht.getKindBetrokkenheid().getPersoon();
        final Iterator<OuderBericht> it = famBericht.getOuderBetrokkenheden().iterator();
        final PersoonBericht ouder1 = it.next().getPersoon();
        final PersoonBericht ouder2 = it.next().getPersoon();

        // ook met 3 objecten geeft het 1 fout.
        ouder1.setCommunicatieID(kind.getCommunicatieID());
        ouder2.setCommunicatieID(kind.getCommunicatieID());
        BerichtAdministratieUtil.verrijktBerichtMetIdentificeerbaarObjectIndex(simplegGeboorteBericht);
        final List<BerichtIdentificeerbaar> berichtenDieDeRegelOvertreden = bedrijfsregel.voerRegelUit(simplegGeboorteBericht);
        Assert.assertEquals(1, berichtenDieDeRegelOvertreden.size());
    }

    @Test
    public void testBRY9901MeerdereDubbeleID() {
        final BijhoudingsBericht simplegGeboorteBericht = maakSimpleInschrijvingBericht2();
        final FamilierechtelijkeBetrekkingBericht famBericht = (FamilierechtelijkeBetrekkingBericht)
                simplegGeboorteBericht.getAdministratieveHandeling().getActies().get(0).getRootObject();

        final PersoonBericht kind = famBericht.getKindBetrokkenheid().getPersoon();
        final PersoonAdresBericht kindAdres = kind.getAdressen().get(0);
        final Iterator<OuderBericht> it = famBericht.getOuderBetrokkenheden().iterator();
        final PersoonBericht ouder1 = it.next().getPersoon();
        final PersoonBericht ouder2 = it.next().getPersoon();

        //
        kindAdres.setCommunicatieID(ouder1.getCommunicatieID());
        ouder2.setCommunicatieID(kind.getCommunicatieID());
        BerichtAdministratieUtil.verrijktBerichtMetIdentificeerbaarObjectIndex(simplegGeboorteBericht);
        final List<BerichtIdentificeerbaar> berichtenDieDeRegelOvertreden = bedrijfsregel.voerRegelUit(simplegGeboorteBericht);
        Assert.assertEquals(2, berichtenDieDeRegelOvertreden.size());
    }


    private RegistreerGeboorteBericht maakSimpleInschrijvingBericht2() {
        final RegistreerGeboorteBericht bericht = new RegistreerGeboorteBericht();
        final PersoonBericht kind = PersoonBuilder.bouwPersoon(SoortPersoon.INGESCHREVENE,
                123456789, Geslachtsaanduiding.MAN, 20100704,
                StatischeObjecttypeBuilder.GEMEENTE_BREDA.getWaarde(),
                StatischeObjecttypeBuilder.PARTIJ_GEMEENTE_BREDA.getWaarde(),
                "Klaas", "van", "Veldhuijsen");
        kind.setAdressen(Arrays.asList(
                PersoonAdresBuilder.bouwWoonadres(
                    "STRAAT", 12, "1255AA",
                    StatischeObjecttypeBuilder.WOONPLAATS_BREDA.getWaarde(),
                    StatischeObjecttypeBuilder.GEMEENTE_BREDA.getWaarde(),
                    20100809)));
        final PersoonBericht vader = PersoonBuilder.bouwPersoon(SoortPersoon.INGESCHREVENE,
                123456789, Geslachtsaanduiding.MAN, 19830404,
                StatischeObjecttypeBuilder.GEMEENTE_BREDA.getWaarde(),
                StatischeObjecttypeBuilder.PARTIJ_GEMEENTE_BREDA.getWaarde(),
                "Piet", "van", "Veldhuijsen");
        vader.setAdressen(Arrays.asList(
                PersoonAdresBuilder.bouwWoonadres(
                    "STRAAT", 12, "1255AA",
                    StatischeObjecttypeBuilder.WOONPLAATS_BREDA.getWaarde(),
                    StatischeObjecttypeBuilder.GEMEENTE_BREDA.getWaarde(),
                    20100809)));
        final PersoonBericht moeder = PersoonBuilder.bouwPersoon(SoortPersoon.INGESCHREVENE,
                123456789, Geslachtsaanduiding.MAN, 19830404,
                StatischeObjecttypeBuilder.GEMEENTE_BREDA.getWaarde(),
                StatischeObjecttypeBuilder.PARTIJ_GEMEENTE_BREDA.getWaarde(),
                "Marie", "van", "Veldhuijsen-Teunis");
        moeder.setAdressen(Arrays.asList(
                PersoonAdresBuilder.bouwWoonadres(
                    "STRAAT", 12, "1255AA",
                    StatischeObjecttypeBuilder.WOONPLAATS_BREDA.getWaarde(),
                    StatischeObjecttypeBuilder.GEMEENTE_BREDA.getWaarde(),
                    20100809)));
        final RelatieBuilder<FamilierechtelijkeBetrekkingBericht> builder = new RelatieBuilder<>();
        final RelatieBericht familieBericht = builder
            .bouwFamilieRechtelijkeBetrekkingRelatie()
            .voegKindToe(kind)
            .voegOuderToe(vader)
            .voegOuderToe(moeder)
            .getRelatie();

        final PersoonBericht kindNat = PersoonBuilder.bouwPersoon(SoortPersoon.INGESCHREVENE,
                123456789, Geslachtsaanduiding.MAN, 20100704,
                StatischeObjecttypeBuilder.GEMEENTE_BREDA.getWaarde(),
                StatischeObjecttypeBuilder.PARTIJ_GEMEENTE_BREDA.getWaarde(),
                "Klaas", "van", "Veldhuijsen");
        kindNat.setAdressen(Arrays.asList(
                PersoonAdresBuilder.bouwWoonadres(
                    "STRAAT", 12, "1255AA",
                    StatischeObjecttypeBuilder.WOONPLAATS_BREDA.getWaarde(),
                    StatischeObjecttypeBuilder.GEMEENTE_BREDA.getWaarde(),
                    20100809)));

        final ActieRegistratieGeboorteBericht geboorteActie = BerichtBuilder.bouwActieRegistratieGeboorte(
                20100909, null,
                StatischeObjecttypeBuilder.PARTIJ_GEMEENTE_BREDA.getWaarde(),
                familieBericht);
        final ActieRegistratieNationaliteitBericht nationActie = BerichtBuilder.bouwActieRegistratieNationaliteit(
                20100909, null,
                StatischeObjecttypeBuilder.PARTIJ_GEMEENTE_BREDA.getWaarde(),
                kindNat);

        bericht.getStandaard().setAdministratieveHandeling(
                BerichtBuilder.bouwHandelingGeboorte(
                    StatischeObjecttypeBuilder.PARTIJ_GEMEENTE_BREDA.getWaarde(),
                    null, geboorteActie, nationActie
            ));
        bericht.setMeldingen(null);
        bericht.setStuurgegevens(BerichtBuilder.bouwStuurGegegevens(
                "APP", "ORG", "REFNR", "CROSREF"));
        return bericht;
    }
}
