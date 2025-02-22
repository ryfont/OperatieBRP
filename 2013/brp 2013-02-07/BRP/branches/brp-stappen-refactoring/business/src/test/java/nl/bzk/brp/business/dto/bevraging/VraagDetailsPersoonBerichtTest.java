/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.business.dto.bevraging;

import junit.framework.Assert;
import nl.bzk.brp.business.dto.bevraging.zoekcriteria.ZoekCriteriaDetailsPersoon;
import nl.bzk.brp.model.algemeen.attribuuttype.ber.Organisatienaam;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.Burgerservicenummer;
import nl.bzk.brp.model.bericht.ber.BerichtStuurgegevensGroepBericht;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Unit test voor de {@link VraagDetailsPersoonBericht} class waarin de specifieke methodes van deze class worden
 * getest.
 */
public class VraagDetailsPersoonBerichtTest {

    @Test
    public void testStandaardGettersEnSetters() {
        VraagDetailsPersoonBericht bericht = new VraagDetailsPersoonBericht();
        Assert.assertNull(bericht.getStuurgegevens());
        Assert.assertNull(bericht.getVraag());

        BerichtStuurgegevensGroepBericht stuurgegevens = new BerichtStuurgegevensGroepBericht();
        DetailsPersoonVraag vraag = new DetailsPersoonVraag();
        ZoekCriteriaDetailsPersoon crit = new ZoekCriteriaDetailsPersoon();
        vraag.setZoekCriteria(crit);
        bericht.setStuurgegevens(stuurgegevens);
        ReflectionTestUtils.setField(bericht, "vraag", vraag);

        Assert.assertSame(stuurgegevens, bericht.getStuurgegevens());
        Assert.assertSame(vraag, bericht.getVraag());
        Assert.assertSame(vraag.getZoekCriteria(), crit);
    }

    @Test
    public void testReadBsns() {
        VraagDetailsPersoonBericht vraagDetailsPersoonBericht = new VraagDetailsPersoonBericht();
        Assert.assertTrue(vraagDetailsPersoonBericht.getReadBsnLocks().isEmpty());

        DetailsPersoonVraag vraag = new DetailsPersoonVraag();
        vraag.getZoekCriteria().setBurgerservicenummer(new Burgerservicenummer("123456789"));
        ReflectionTestUtils.setField(vraagDetailsPersoonBericht, "vraag", vraag);

        Assert.assertFalse(vraagDetailsPersoonBericht.getReadBsnLocks().isEmpty());
        Assert.assertEquals(1, vraagDetailsPersoonBericht.getReadBsnLocks().size());
        Assert.assertEquals("123456789", vraagDetailsPersoonBericht.getReadBsnLocks().iterator().next());
    }

    @Test
    public void testReadBsnsNullZoekCriteria() {
        VraagDetailsPersoonBericht vraagDetailsPersoonBericht = new VraagDetailsPersoonBericht();
        Assert.assertTrue(vraagDetailsPersoonBericht.getReadBsnLocks().isEmpty());

        DetailsPersoonVraag vraag = new DetailsPersoonVraag();
        vraag.setZoekCriteria(null);
        ReflectionTestUtils.setField(vraagDetailsPersoonBericht, "vraag", vraag);

        Assert.assertTrue(vraagDetailsPersoonBericht.getReadBsnLocks().isEmpty());
        Assert.assertNull(vraagDetailsPersoonBericht.getVraag().getBurgerservicenummerForLocks());
    }

    @Test
    public void testWriteBsnsAltijdLeeg() {
        VraagDetailsPersoonBericht vraagDetailsPersoonBericht = new VraagDetailsPersoonBericht();
        Assert.assertTrue(vraagDetailsPersoonBericht.getWriteBsnLocks().isEmpty());

        DetailsPersoonVraag vraag = new DetailsPersoonVraag();
        vraag.getZoekCriteria().setBurgerservicenummer(new Burgerservicenummer("123456789"));
        ReflectionTestUtils.setField(vraagDetailsPersoonBericht, "vraag", vraag);

        Assert.assertTrue(vraagDetailsPersoonBericht.getWriteBsnLocks().isEmpty());
    }

    @Test
    public void testOphalenOngeldigePartijId() {
        VraagDetailsPersoonBericht vraagDetailsPersoonBericht = new VraagDetailsPersoonBericht();

        BerichtStuurgegevensGroepBericht stuurgegevens = new BerichtStuurgegevensGroepBericht();
        stuurgegevens.setOrganisatie(new Organisatienaam("test"));
        vraagDetailsPersoonBericht.setStuurgegevens(stuurgegevens);
        Assert.assertNull(vraagDetailsPersoonBericht.getAdministratieveHandeling());
        // en daarmee dus ook de partij is null.
        stuurgegevens.setOrganisatie(new Organisatienaam(""));
        Assert.assertNull(vraagDetailsPersoonBericht.getAdministratieveHandeling());
    }
}
