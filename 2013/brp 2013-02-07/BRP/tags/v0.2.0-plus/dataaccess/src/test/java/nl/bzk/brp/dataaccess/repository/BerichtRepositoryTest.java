/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.dataaccess.repository;

import javax.inject.Inject;

import nl.bzk.brp.dataaccess.AbstractRepositoryTestCase;
import nl.bzk.brp.model.attribuuttype.Applicatienaam;
import nl.bzk.brp.model.attribuuttype.Berichtdata;
import nl.bzk.brp.model.attribuuttype.Organisatienaam;
import nl.bzk.brp.model.attribuuttype.Sleutelwaardetekst;
import nl.bzk.brp.model.objecttype.operationeel.BerichtModel;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Bijhoudingsresultaat;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Richting;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Soortbericht;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Soortmelding;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Verwerkingsresultaat;
import org.junit.Assert;
import org.junit.Test;


public class BerichtRepositoryTest extends AbstractRepositoryTestCase {

    @Inject
    private BerichtRepository repository;

    @Test
    public void testFindOneIngaand() {
        BerichtModel bericht = repository.findOne(2001L);
        Assert.assertNotNull(bericht);
        Assert.assertEquals(2001L, bericht.getId().longValue());
        Assert.assertEquals(Richting.INGAAND, bericht.getRichting());
        Assert.assertEquals("in", bericht.getData().getWaarde());
        Assert.assertEquals(1302519660000L, bericht.getDatumTijdOntvangst().getWaarde().getTime());
        Assert.assertNull(bericht.getDatumTijdVerzenden());
        Assert.assertNull(bericht.getAntwoordOp());
        Assert.assertEquals(Verwerkingsresultaat.GOED, bericht.getBerichtResultaatGroep().getVerwerkingsresultaat());
        Assert.assertEquals(Bijhoudingsresultaat.VERWERKT, bericht.getBerichtResultaatGroep().getBijhoudingsresultaat());
        Assert.assertEquals(Soortmelding.WAARSCHUWING, bericht.getBerichtResultaatGroep().getHoogsteMeldingNiveau());
        Assert.assertEquals(Soortbericht.MIGRATIE_VERHUIZING_BIJHOUDING, bericht.getSoortbericht());
        Assert.assertEquals(new Organisatienaam("Org"), bericht.getBerichtStuurgegevensGroep().getOrganisatie());
        Assert.assertEquals(new Applicatienaam("App"), bericht.getBerichtStuurgegevensGroep().getApplicatie());
        Assert.assertEquals(new Sleutelwaardetekst("1234567890"), bericht.getBerichtStuurgegevensGroep().getReferentienummer());
        Assert.assertEquals(new Sleutelwaardetekst("1234567890"), bericht.getBerichtStuurgegevensGroep().getCrossReferentienummer());
    }

    @Test
    public void testFindOneUitgaand() {
        BerichtModel bericht = repository.findOne(2002L);
        Assert.assertNotNull(bericht);
        Assert.assertEquals(2002L, bericht.getId().longValue());
        Assert.assertEquals(Richting.UITGAAND, bericht.getRichting());
        Assert.assertEquals("uit", bericht.getData().getWaarde());
        Assert.assertNull(bericht.getDatumTijdOntvangst());
        Assert.assertEquals(1302519720000L, bericht.getDatumTijdVerzenden().getWaarde().getTime());
        Assert.assertNotNull(bericht.getAntwoordOp());
        Assert.assertEquals(2001L, bericht.getAntwoordOp().getId().longValue());
    }

    @Test
    public void testSave() {
        BerichtModel bericht = new BerichtModel(Richting.INGAAND, new Berichtdata("test"));
        repository.save(bericht);
        Assert.assertNotNull(bericht.getId());
    }

}
