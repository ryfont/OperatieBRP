/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.binding.bevraging.bijhouding;

import java.io.IOException;

import nl.bzk.brp.binding.AbstractBindingInIntegratieTest;
import nl.bzk.brp.model.bericht.ber.BerichtParametersGroepBericht;
import nl.bzk.brp.model.bericht.ber.BerichtStuurgegevensGroepBericht;
import nl.bzk.brp.model.bericht.ber.BerichtZoekcriteriaPersoonGroepBericht;
import nl.bzk.brp.model.bevraging.bijhouding.ZoekPersoonBericht;

import org.jibx.runtime.JiBXException;
import org.junit.Assert;
import org.junit.Test;


public class ZoekPersoonBerichtBindingTest extends AbstractBindingInIntegratieTest<ZoekPersoonBericht> {

    @Override
    public Class<ZoekPersoonBericht> getBindingClass() {
        return ZoekPersoonBericht.class;
    }

    @Test
    public void testZoekPersoonMaxBericht() throws JiBXException, IOException {
        String xml = leesBestand("bevragen_ZoekPersoon_MAX.xml");
        valideerTegenSchema(xml);

        ZoekPersoonBericht bericht = unmarshalObject(xml);
        Assert.assertNotNull(bericht);

        BerichtStuurgegevensGroepBericht stuurgegevens = bericht.getStuurgegevens();

        Assert.assertEquals("stuurgeg1", stuurgegevens.getCommunicatieID());
        Assert.assertEquals("app", stuurgegevens.getZendendeSysteem().getWaarde());
        Assert.assertEquals("000101", stuurgegevens.getZendendePartijCode());
        Assert.assertEquals("12345678-1234-1234-1234-123456789123", stuurgegevens.getReferentienummer().getWaarde());
        Assert.assertNull(stuurgegevens.getCrossReferentienummer());
        Assert.assertNotNull(stuurgegevens.getDatumTijdVerzending());
        Assert.assertNull(stuurgegevens.getDatumTijdOntvangst());

        final BerichtParametersGroepBericht parameters = bericht.getParameters();
        Assert.assertEquals(20140101, parameters.getPeilmomentMaterieelSelectie().getWaarde().intValue());
        Assert.assertEquals("20140101", parameters.getPeilmomentMaterieelSelectie().getWaarde().toString());

        BerichtZoekcriteriaPersoonGroepBericht criteria = bericht.getZoekcriteriaPersoon();
        Assert.assertEquals("comid.criteria", criteria.getCommunicatieID());
        Assert.assertNotNull(criteria);
        Assert.assertEquals(Integer.valueOf("123456789"), criteria.getBurgerservicenummer().getWaarde());
    }

    @Test
    public void testZoekPersoonMinBericht() throws IOException, JiBXException {
        String xml = leesBestand("bevragen_ZoekPersoon_MIN.xml");
        valideerTegenSchema(xml);

        ZoekPersoonBericht bericht = unmarshalObject(xml);

        BerichtStuurgegevensGroepBericht stuurgegevens = bericht.getStuurgegevens();

        Assert.assertEquals("app", stuurgegevens.getZendendeSysteem().getWaarde());
        Assert.assertEquals("000101", stuurgegevens.getZendendePartijCode());
        Assert.assertEquals("12345678-1234-1234-1234-123456789123", stuurgegevens.getReferentienummer().getWaarde());
        Assert.assertNull(stuurgegevens.getCrossReferentienummer());
        Assert.assertNotNull(stuurgegevens.getDatumTijdVerzending());
        Assert.assertNull(stuurgegevens.getDatumTijdOntvangst());

        Assert.assertNull(bericht.getParameters());

        BerichtZoekcriteriaPersoonGroepBericht criteria = bericht.getZoekcriteriaPersoon();
        Assert.assertNotNull(criteria);
        Assert.assertNull(criteria.getBurgerservicenummer());
    }

    @Override
    protected String getSchemaBestand() {
        return getSchemaUtils().getXsdBijhoudingBevragingBerichten();
    }
}
