/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.business.bedrijfsregels.impl.overlijden;

import java.util.List;

import nl.bzk.brp.business.bedrijfsregels.impl.migratie.BRBY0521;
import nl.bzk.brp.business.bedrijfsregels.util.ActieBerichtBuilder;
import nl.bzk.brp.model.attribuuttype.Datum;
import nl.bzk.brp.model.attribuuttype.Gemeentecode;
import nl.bzk.brp.model.attribuuttype.Naam;
import nl.bzk.brp.model.groep.bericht.PersoonOverlijdenGroepBericht;
import nl.bzk.brp.model.objecttype.bericht.ActieBericht;
import nl.bzk.brp.model.objecttype.bericht.PersoonBericht;
import nl.bzk.brp.model.objecttype.logisch.Actie;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Geslachtsaanduiding;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Partij;
import nl.bzk.brp.model.objecttype.operationeel.statisch.SoortActie;
import nl.bzk.brp.model.validatie.Melding;
import nl.bzk.brp.util.PersoonBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/** Unit test voor de {@link BRBY0521} bedrijfsregel. */
public class BRBY0903Test {

    private BRBY0903 brby0903;

    @Before
    public void init() {
        brby0903 = new BRBY0903();
    }

    @Test
    public void testCorrectePeriodeGemeenteGeenPeriode() {
        // happy flow
        List<Melding> meldingen =
            brby0903.executeer(null, maakPersoonOverlijden(maakGemeente((short) 24, "gemeente", null, null), 20120303),
                    maakActie("id.actie1", 20120303, null));
        Assert.assertEquals(0, meldingen.size());
    }

    @Test
    public void testCorrectePeriode() {
        List<Melding> meldingen =
            brby0903.executeer(null, maakPersoonOverlijden(maakGemeente((short) 24, "gemeente", 19000101, null), 19000101),
                    maakActie("id.actie1", 19000101, null));
        Assert.assertEquals(0, meldingen.size());
    }

    @Test
    public void testNietCorrectePeriode() {
        List<Melding> meldingen =
            brby0903.executeer(null, maakPersoonOverlijden(maakGemeente((short) 24, "gemeente", 19000101, 19000110), 19000110),
                    maakActie("id.actie1", 19000110, null));
        Assert.assertEquals(1, meldingen.size());
    }

    @Test
    public void testCorrectePeriodeActieZonderOverlijden() {
        PersoonBericht persoonBericht = maakPersoonOverlijden(null, null);

        List<Melding> meldingen = brby0903.executeer(null, persoonBericht, maakActie("id.actie1", 20120303, 20120404));
        Assert.assertEquals(0, meldingen.size());


        persoonBericht.setOverlijden(null);
        meldingen = brby0903.executeer(null, persoonBericht, maakActie("id.actie1", 20120303, 20120404));
        Assert.assertEquals(0, meldingen.size());
    }




    private Actie maakActie(final String verzendendId, final Integer begin, final Integer eind) {
        Datum beginDatum = null;
        Datum eindDatum = null;

        if (begin != null) {
            beginDatum = new Datum(begin);
        }

        if (eind != null) {
            eindDatum = new Datum(eind);
        }

        ActieBericht actie =
            ActieBerichtBuilder.bouwNieuweActie(SoortActie.AANGIFTE_OVERLIJDEN).setDatumAanvang(beginDatum)
                    .setDatumEinde(eindDatum).getActie();
        actie.setVerzendendId(verzendendId);
        return actie;
    }

    private PersoonBericht maakPersoonOverlijden(final Partij gemeente, final Integer overlijdingsDatum) {
        PersoonBericht persoon =
            PersoonBuilder.bouwPersoon("1234567890", Geslachtsaanduiding.MAN, 19660606, null, "vn", "vg", "gsln");

        PersoonOverlijdenGroepBericht overlijden = new PersoonOverlijdenGroepBericht();
        overlijden.setVerzendendId("overlijden");
        overlijden.setOverlijdenGemeente(gemeente);
        overlijden.setDatumOverlijden(new Datum(overlijdingsDatum));

        persoon.setOverlijden(overlijden);

        return persoon;
    }

    private Partij maakGemeente(final short code, final String naam, final Integer begin, final Integer eind) {
        Partij gemeente = new Partij();
        gemeente.setNaam(new Naam(naam));
        gemeente.setGemeentecode(new Gemeentecode(code));
        if (begin != null) {
            gemeente.setDatumAanvang(new Datum(begin));
        }
        if (eind != null) {
            gemeente.setDatumEinde(new Datum(eind));
        }

        return gemeente;
    }
}
