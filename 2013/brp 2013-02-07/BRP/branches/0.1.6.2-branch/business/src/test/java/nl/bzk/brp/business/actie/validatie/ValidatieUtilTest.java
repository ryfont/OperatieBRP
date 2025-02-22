/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.business.actie.validatie;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import nl.bzk.brp.model.validatie.Melding;
import nl.bzk.brp.model.attribuuttype.Voornaam;
import org.junit.Test;

public class ValidatieUtilTest {

    @Test
    public void testControleerVerplichtVeldNull() {
        List<Melding> meldingen = new ArrayList<Melding>();
        ValidatieUtil.controleerVerplichtVeld(meldingen, null, "veld");
        Assert.assertFalse(meldingen.isEmpty());
    }

    @Test
    public void testControleerVerplichtLeegWaarde() {
        List<Melding> meldingen = new ArrayList<Melding>();
        ValidatieUtil.controleerVerplichtVeld(meldingen, "", "veld");
        Assert.assertFalse(meldingen.isEmpty());
    }

    @Test
    public void testControleerVerplichtLeegSpatiesWaarde() {
        List<Melding> meldingen = new ArrayList<Melding>();
        ValidatieUtil.controleerVerplichtVeld(meldingen, "        ", "veld");
        Assert.assertFalse(meldingen.isEmpty());
    }

    @Test
    public void testControleerVerplichtWelEenWaarde() {
        List<Melding> meldingen = new ArrayList<Melding>();
        ValidatieUtil.controleerVerplichtVeld(meldingen, "   546", "veld");
        Assert.assertTrue(meldingen.isEmpty());
    }

    @Test
    public void testControleerVerplichtGeenWaardeAtribuutType() {
        List<Melding> meldingen = new ArrayList<Melding>();
        ValidatieUtil.controleerVerplichtVeld(meldingen, new Voornaam(""), "veld");
        Assert.assertFalse(meldingen.isEmpty());
    }
}
