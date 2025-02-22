/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.business.bedrijfsregels.impl.migratie;

import java.util.List;

import junit.framework.Assert;
import nl.bzk.brp.model.attribuuttype.Datum;
import nl.bzk.brp.model.validatie.Melding;
import nl.bzk.brp.model.validatie.MeldingCode;
import nl.bzk.brp.model.validatie.SoortMelding;
import nl.bzk.brp.util.DatumUtil;
import org.junit.Before;
import org.junit.Test;


public class BRBY0011Test {

    private BRBY0011 brby0011;

    @Before
    public void init() {
        brby0011 = new BRBY0011();
    }

    @Test
    public void testDatumAanvangInDeToekomst() {
        List<Melding> meldingen = brby0011.executeer(null, null, new Datum(DatumUtil.vandaag().getWaarde() + 1), null);
        Assert.assertEquals(1, meldingen.size());
        Assert.assertEquals(MeldingCode.BRBY0011, meldingen.get(0).getCode());
        Assert.assertEquals(SoortMelding.FOUT_ONOVERRULEBAAR, meldingen.get(0).getSoort());
    }

    @Test
    public void testDatumAanvangVandaag() {
        List<Melding> meldingen = brby0011.executeer(null, null, DatumUtil.vandaag(), null);
        Assert.assertEquals(0, meldingen.size());
    }

    @Test
    public void testDatumAanvangInHetVerleden() {
        List<Melding> meldingen = brby0011.executeer(null, null, new Datum(DatumUtil.vandaag().getWaarde() - 1), null);
        Assert.assertEquals(0, meldingen.size());
    }
}
