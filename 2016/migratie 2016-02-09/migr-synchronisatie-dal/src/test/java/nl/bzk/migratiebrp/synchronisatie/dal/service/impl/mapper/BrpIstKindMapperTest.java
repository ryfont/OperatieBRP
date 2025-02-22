/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.synchronisatie.dal.service.impl.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import nl.bzk.migratiebrp.conversie.model.brp.BrpGroep;
import nl.bzk.migratiebrp.conversie.model.brp.BrpStapel;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpIstRelatieGroepInhoud;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.AdellijkeTitel;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.AdministratieveHandeling;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.Geslachtsaanduiding;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.Partij;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.Persoon;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.Predicaat;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.SoortAdministratieveHandeling;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.SoortDocument;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.SoortPersoon;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.SoortRelatie;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.Stapel;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.StapelVoorkomen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("synchronisatie-brp-mapper-beans.xml")
public class BrpIstKindMapperTest {
    private static final AdministratieveHandeling ADMINISTRATIEVE_HANDELING = new AdministratieveHandeling(
        new Partij("Bierum", 8),
        SoortAdministratieveHandeling.GBA_INITIELE_VULLING);

    @Inject
    private BrpIstKindMapper mapper;

    @Test
    public void testMap() {
        final Set<Stapel> stapels = new LinkedHashSet<>();
        final Stapel stapel = new Stapel(new Persoon(SoortPersoon.INGESCHREVENE), "09", 0);
        final StapelVoorkomen stapelVoorkomen = new StapelVoorkomen(stapel, 0, ADMINISTRATIEVE_HANDELING);

        stapelVoorkomen.setSoortDocument(new SoortDocument("doc_naam", "doc_omschrijving"));
        stapelVoorkomen.setPredicaat(Predicaat.J);
        stapelVoorkomen.setGeslachtsaanduidingBijAdellijkeTitelOfPredikaat(Geslachtsaanduiding.VROUW);
        stapelVoorkomen.setAdellijkeTitel(AdellijkeTitel.H);
        stapelVoorkomen.setSoortRelatie(SoortRelatie.HUWELIJK);

        stapel.addStapelVoorkomen(stapelVoorkomen);
        stapels.add(stapel);
        final List<BrpStapel<BrpIstRelatieGroepInhoud>> result = mapper.map(stapels);
        assertNotNull(result);
        assertEquals(1, result.size());
        final BrpStapel<BrpIstRelatieGroepInhoud> resultStapel = result.get(0);
        assertNotNull(resultStapel);
        assertEquals(1, resultStapel.size());
        final BrpGroep<BrpIstRelatieGroepInhoud> brpGroep = resultStapel.get(0);
        final BrpIstRelatieGroepInhoud inhoud = brpGroep.getInhoud();

        // wel gemapped want standaard groep
        assertEquals("doc_naam", inhoud.getStandaardGegevens().getSoortDocument().getWaarde());
        // wel gemapped want gerelateerde groep
        assertNotNull(inhoud.getPredicaatCode());
        assertNotNull(inhoud.getAdellijkeTitelCode());
        assertEquals(Predicaat.J.toString(), inhoud.getPredicaatCode().getWaarde());
        assertEquals(AdellijkeTitel.H.toString(), inhoud.getAdellijkeTitelCode().getWaarde());
        assertEquals(Geslachtsaanduiding.VROUW.getCode(), inhoud.getPredicaatCode().getGeslachtsaanduiding().getWaarde());
        assertEquals(Geslachtsaanduiding.VROUW.getCode(), inhoud.getAdellijkeTitelCode().getGeslachtsaanduiding().getWaarde());
    }

    @Test
    public void testMapVerkeerdeStapelType() {
        final Set<Stapel> stapels = new LinkedHashSet<>();
        final Stapel stapel = new Stapel(new Persoon(SoortPersoon.INGESCHREVENE), "01", 0);
        final StapelVoorkomen stapelVoorkomen = new StapelVoorkomen(stapel, 0, ADMINISTRATIEVE_HANDELING);
        stapel.addStapelVoorkomen(stapelVoorkomen);
        stapels.add(stapel);
        assertNull(mapper.map(stapels));
    }

    @Test
    public void testMapJuisteStapelType() {
        final Set<Stapel> stapels = new LinkedHashSet<>();
        final Stapel stapel = new Stapel(new Persoon(SoortPersoon.INGESCHREVENE), "09", 0);
        final StapelVoorkomen stapelVoorkomen = new StapelVoorkomen(stapel, 0, ADMINISTRATIEVE_HANDELING);
        stapel.addStapelVoorkomen(stapelVoorkomen);
        stapels.add(stapel);
        assertNotNull(mapper.map(stapels));
    }

    @Test(expected = NullPointerException.class)
    public void testMapNull() {
        mapper.map(null);
    }

    @Test
    public void testMapEmpty() {
        assertNull(mapper.map(Collections.<Stapel>emptySet()));
    }
}
