/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.lo3.tabel;

import nl.bzk.brp.gba.dataaccess.ConversieTabelRepository;
import nl.bzk.brp.gba.dataaccess.StamTabelRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Lo3ConversieTabelFactoryTest {

    @Mock
    private ConversieTabelRepository conversieTabelRepository;
    @Mock
    private StamTabelRepository stamTabelRepository;

    @InjectMocks
    private Lo3ConversieTabelFactory subject;

    @Test
    public void test() {
        Assert.assertNotNull(conversieTabelRepository);
        Assert.assertNotNull(stamTabelRepository);
        Assert.assertNotNull(subject.createAdellijkeTitelPredikaatConversietabel());
        Assert.assertNotNull(subject.createRedenEindeRelatieConversietabel());
        Assert.assertNotNull(subject.createVerblijfsrechtConversietabel());
        Assert.assertNotNull(subject.createRedenOpnameNationaliteitConversietabel());
        Assert.assertNotNull(subject.createRedenBeeindigingNationaliteitConversietabel());
        Assert.assertNotNull(subject.createAangeverRedenWijzigingVerblijfConversietabel());
        Assert.assertNotNull(subject.createSoortReisdocumentConversietabel());
        Assert.assertNotNull(subject.createAanduidingInhoudingVermissingReisdocumentConversietabel());
        Assert.assertNotNull(subject.createRedenOpschortingBijhoudingConversietabel());
        Assert.assertNotNull(subject.createRNIDeelnemerConversietabel());
        Assert.assertNotNull(subject.createVoorvoegselScheidingstekenConversietabel());
        Assert.assertNotNull(subject.createWoonplaatsnaamConversietabel());
        Assert.assertNotNull(subject.createPartijConversietabel());
        Assert.assertNotNull(subject.createGemeenteConversietabel());
        Assert.assertNotNull(subject.createLandConversietabel());
        Assert.assertNotNull(subject.createNationaliteitConversietabel());
        Assert.assertNotNull(subject.createSoortRegisterSoortDocumentConversietabel());
        Assert.assertNotNull(subject.createVerstrekkingsbeperkingConversietabel());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCreateFilterRubriekConversietabel() {
        subject.createLo3RubriekConversietabel();
    }
}
