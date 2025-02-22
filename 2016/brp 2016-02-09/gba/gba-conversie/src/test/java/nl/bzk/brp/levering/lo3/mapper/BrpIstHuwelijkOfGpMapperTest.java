/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.lo3.mapper;

import java.util.HashSet;
import java.util.List;
import nl.bzk.brp.model.logisch.ist.Stapel;
import nl.bzk.migratiebrp.conversie.model.brp.BrpStapel;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpIstHuwelijkOfGpGroepInhoud;
import org.junit.Assert;
import org.junit.Test;

public class BrpIstHuwelijkOfGpMapperTest {

    private final BrpIstHuwelijkOfGpMapper mapper = new BrpIstHuwelijkOfGpMapper();

    @Test
    public void testSucces() {

        final List<BrpStapel<BrpIstHuwelijkOfGpGroepInhoud>> brpInhoud = mapper.map(BrpIstTestUtils.maakSimpeleStapelAlleCategorien());

        Assert.assertNotNull(brpInhoud);
        Assert.assertTrue(brpInhoud.size() == 1);
    }

    @Test
    public void testLeeg() {
        final List<BrpStapel<BrpIstHuwelijkOfGpGroepInhoud>> brpInhoud = mapper.map(new HashSet<Stapel>());

        Assert.assertNull(brpInhoud);
    }

    /**
     * Verwacht geen NPE vanwege controle op null-waarden.
     */
    @Test
    public void testGeenWaarde() {
        final List<BrpStapel<BrpIstHuwelijkOfGpGroepInhoud>> brpInhoud = mapper.map(null);
        Assert.assertNull(brpInhoud);
    }

}
