/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.bevraging.business.berichtcmds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import nl.bzk.brp.bevraging.business.dto.BerichtContext;
import nl.bzk.brp.bevraging.business.dto.antwoord.PersoonZoekCriteriaAntwoord;
import nl.bzk.brp.bevraging.business.dto.verzoek.PersoonZoekCriteria;
import nl.bzk.brp.bevraging.domein.Persoon;
import nl.bzk.brp.bevraging.domein.SoortPersoon;
import nl.bzk.brp.bevraging.domein.repository.PersoonRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;


/**
 * Unit test voor de {@link OpvragenPersoonCommand} class.
 */
public class OpvragenPersoonCommandTest {

    @Mock
    private PersoonRepository           persoonRepositoryMock;
    private PersoonZoekCriteriaAntwoord antwoordMock;

    /**
     * Test de constructor en of de velden correct zijn geinitialiseerd.
     */
    @Test
    public final void testConstructorVeldInitialisatie() {
        BerichtContext context = getBrpBerichtContext();
        PersoonZoekCriteria criteria = new PersoonZoekCriteria();
        criteria.setBsn(new Long(5));

        OpvragenPersoonCommand command = new OpvragenPersoonCommand(criteria, context);
        assertEquals(5, command.getVerzoek().getBsn().intValue());
        assertEquals(context, command.getContext());
    }

    /**
     * Test de "happy-flow" van de {@link OpvragenPersoonCommand#voerUit()} methode.
     */
    @Test
    public final void testStandaardVoerUit() {
        OpvragenPersoonCommand command;
        PersoonZoekCriteria criteria = new PersoonZoekCriteria();

        criteria.setBsn(new Long(123456789));
        command = new OpvragenPersoonCommand(criteria, getBrpBerichtContext());
        ReflectionTestUtils.setField(command, "persoonRepository", persoonRepositoryMock);
        command.voerUit(antwoordMock);
        assertEquals("Test1", antwoordMock.getPersonen().iterator().next().getGeslachtsnaam());

        criteria = new PersoonZoekCriteria();
        criteria.setBsn(new Long(234567890));
        command = new OpvragenPersoonCommand(criteria, getBrpBerichtContext());
        ReflectionTestUtils.setField(command, "persoonRepository", persoonRepositoryMock);
        command.voerUit(antwoordMock);
        assertEquals("Test2", antwoordMock.getPersonen().iterator().next().getGeslachtsnaam());

        criteria = new PersoonZoekCriteria();
        criteria.setBsn(new Long(345678901));
        command = new OpvragenPersoonCommand(criteria, getBrpBerichtContext());
        ReflectionTestUtils.setField(command, "persoonRepository", persoonRepositoryMock);
        command.voerUit(antwoordMock);
        assertEquals(0, antwoordMock.getPersonen().size());

        criteria = new PersoonZoekCriteria();
        criteria.setBsn(434567890L);
        command = new OpvragenPersoonCommand(criteria, getBrpBerichtContext());
        ReflectionTestUtils.setField(command, "persoonRepository", persoonRepositoryMock);
        command.voerUit(antwoordMock);
        assertEquals(2, antwoordMock.getPersonen().size());
    }

    /**
     * Unit test voor het opvragen van een persoon op basis van een leeg BSN.
     */
    @Test
    public final void testOpvragenPersoonOpBasisVanLeegBsn() {
        PersoonZoekCriteria criteria = new PersoonZoekCriteria();
        OpvragenPersoonCommand command = new OpvragenPersoonCommand(criteria, getBrpBerichtContext());
        ReflectionTestUtils.setField(command, "persoonRepository", persoonRepositoryMock);
        command.voerUit(antwoordMock);
        assertTrue(antwoordMock.getPersonen().size() == 0);
        assertEquals(0, antwoordMock.getFouten().size());
    }

    /**
     * Initializeert de mocks die in deze unit test class worden gebruikt.
     */
    @Before
    public final void initMocksEnService() {
        MockitoAnnotations.initMocks(this);

        Persoon pers1 = new Persoon(SoortPersoon.INGESCHREVENE);
        pers1.setBurgerservicenummer(123456789L);
        pers1.setGeslachtsnaam("Test1");

        Persoon pers2 = new Persoon(SoortPersoon.INGESCHREVENE);
        pers2.setBurgerservicenummer(234567890L);
        pers2.setGeslachtsnaam("Test2");

        Persoon pers3 = new Persoon(SoortPersoon.INGESCHREVENE);
        pers3.setBurgerservicenummer(434567890L);
        pers3.setGeslachtsnaam("Test3a");

        Persoon pers4 = new Persoon(SoortPersoon.INGESCHREVENE);
        pers4.setBurgerservicenummer(434567890L);
        pers4.setGeslachtsnaam("Test3b");

        Mockito.when(persoonRepositoryMock.findByBurgerservicenummer(123456789L)).thenReturn(Arrays.asList(pers1));
        Mockito.when(persoonRepositoryMock.findByBurgerservicenummer(234567890L)).thenReturn(Arrays.asList(pers2));
        Mockito.when(persoonRepositoryMock.findByBurgerservicenummer(434567890L)).thenReturn(
                Arrays.asList(pers3, pers4));

        antwoordMock = new PersoonZoekCriteriaAntwoord();
    }

    /**
     * Retourneert een standaard bericht context voor testen.
     *
     * @return een standaard bericht context.
     */
    private BerichtContext getBrpBerichtContext() {
        BerichtContext context = new BerichtContext();
        return context;
    }
}
