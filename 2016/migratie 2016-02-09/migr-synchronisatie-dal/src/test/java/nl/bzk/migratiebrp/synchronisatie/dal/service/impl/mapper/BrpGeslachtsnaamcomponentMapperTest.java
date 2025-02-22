/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.synchronisatie.dal.service.impl.mapper;

import java.util.ArrayList;
import javax.inject.Inject;
import junit.framework.Assert;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpAdellijkeTitelCode;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpCharacter;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpInteger;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpPredicaatCode;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpString;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpGeslachtsnaamcomponentInhoud;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.AdellijkeTitel;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.Onderzoek;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.Persoon;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.PersoonGeslachtsnaamcomponent;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.PersoonGeslachtsnaamcomponentHistorie;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.Predicaat;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.SoortPersoon;
import nl.bzk.migratiebrp.synchronisatie.dal.service.impl.mapper.strategie.BrpOnderzoekMapper;
import nl.bzk.migratiebrp.synchronisatie.dal.service.impl.mapper.strategie.BrpOnderzoekMapperImpl;
import org.junit.Test;

public class BrpGeslachtsnaamcomponentMapperTest extends BrpAbstractTest {

    private final BrpOnderzoekMapper brpOnderzoekMapper = new BrpOnderzoekMapperImpl(new ArrayList<Onderzoek>());

    @Inject
    private BrpGeslachtsnaamcomponentMapper.BrpGeslachtsnaamcomponentInhoudMapper mapper;

    @Test
    public void testMapInhoud() {
        final PersoonGeslachtsnaamcomponent persoonGeslachtsnaamcomponent =
                new PersoonGeslachtsnaamcomponent(new Persoon(SoortPersoon.INGESCHREVENE), 1234);
        final PersoonGeslachtsnaamcomponentHistorie historie =
                new PersoonGeslachtsnaamcomponentHistorie(persoonGeslachtsnaamcomponent, "stam");
        historie.setVoorvoegsel("voor");
        historie.setScheidingsteken('x');
        historie.setPredicaat(Predicaat.J);
        historie.setAdellijkeTitel(AdellijkeTitel.M);

        final BrpGeslachtsnaamcomponentInhoud result = mapper.mapInhoud(historie, brpOnderzoekMapper);

        Assert.assertNotNull(result);
        Assert.assertEquals("voor", BrpString.unwrap(result.getVoorvoegsel()));
        Assert.assertEquals(Character.valueOf('x'), BrpCharacter.unwrap(result.getScheidingsteken()));
        Assert.assertEquals("stam", BrpString.unwrap(result.getStam()));
        Assert.assertEquals(new BrpPredicaatCode("J"), result.getPredicaatCode());
        Assert.assertEquals(new BrpAdellijkeTitelCode("M"), result.getAdellijkeTitelCode());
        Assert.assertEquals(new BrpInteger(persoonGeslachtsnaamcomponent.getVolgnummer()), result.getVolgnummer());
    }
}
