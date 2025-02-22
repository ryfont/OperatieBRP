/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.lo3.conversie.mutatie;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import javax.inject.Inject;
import javax.sql.DataSource;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import nl.bzk.brp.blobifier.service.BlobifierService;
import nl.bzk.brp.levering.lo3.conversie.ConversieCache;
import nl.bzk.brp.logging.Logger;
import nl.bzk.brp.logging.LoggerFactory;
import nl.bzk.brp.model.hisvolledig.kern.ActieHisVolledig;
import nl.bzk.brp.model.hisvolledig.kern.AdministratieveHandelingHisVolledig;
import nl.bzk.brp.model.hisvolledig.kern.PersoonHisVolledig;
import nl.bzk.brp.model.operationeel.kern.ActieModel;
import nl.bzk.brp.model.operationeel.kern.AdministratieveHandelingModel;
import nl.bzk.migratiebrp.bericht.model.lo3.parser.Lo3PersoonslijstParser;
import nl.bzk.migratiebrp.conversie.model.brp.BrpPersoonslijst;
import nl.bzk.migratiebrp.conversie.model.exceptions.Lo3SyntaxException;
import nl.bzk.migratiebrp.conversie.model.exceptions.OngeldigePersoonslijstException;
import nl.bzk.migratiebrp.conversie.model.lo3.Lo3Persoonslijst;
import nl.bzk.migratiebrp.conversie.model.lo3.herkomst.Lo3CategorieEnum;
import nl.bzk.migratiebrp.conversie.model.lo3.herkomst.Lo3ElementEnum;
import nl.bzk.migratiebrp.conversie.model.lo3.syntax.Lo3CategorieWaarde;
import nl.bzk.migratiebrp.conversie.regels.proces.ConverteerLo3NaarBrpService;
import nl.bzk.migratiebrp.conversie.regels.proces.logging.Logging;
import nl.bzk.migratiebrp.conversie.regels.proces.preconditie.Lo3SyntaxControle;
import nl.bzk.migratiebrp.conversie.regels.proces.preconditie.PreconditiesService;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.Lo3Bericht;
import nl.bzk.migratiebrp.synchronisatie.dal.domein.brp.kern.entity.Lo3BerichtenBron;
import nl.bzk.migratiebrp.synchronisatie.dal.service.BrpDalService;
import nl.bzk.migratiebrp.synchronisatie.dal.service.PersoonslijstPersisteerResultaat;
import nl.bzk.migratiebrp.synchronisatie.dal.service.SyncParameters;
import nl.bzk.migratiebrp.synchronisatie.logging.SynchronisatieLogging;
import nl.bzk.migratiebrp.test.common.resultaat.TestResultaat;
import nl.bzk.migratiebrp.test.dal.TestCasus;
import nl.bzk.migratiebrp.util.common.logging.LoggingContext;
import nl.bzk.migratiebrp.util.excel.ExcelAdapter;
import nl.bzk.migratiebrp.util.excel.ExcelAdapterException;
import nl.bzk.migratiebrp.util.excel.ExcelAdapterImpl;
import nl.bzk.migratiebrp.util.excel.ExcelData;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Let op: geserialiseerde persoonslijsten komen uit migratie levering test om te kunnen reproduceren hoe de
 * migratievoorzieningen een wijziging opbouwen.
 *
 * <p>
 * <strong>HOWTO (na BMR):</strong>
 * <ul>
 * <li>Leveringtesten uitvoeren</li>
 * <li>BLOB's opnieuw kopieren</li>
 * <li>Administratieve handeling ID's aanpassen</li>
 * <li>verConvRepository.addVoorkomen calls aanpassen</li>
 * <li>lo3AanduidingOuderRepository.setAanduidingOuderBijOuderBetrokkenheid calls aanpassen</li>
 * <ul>
 * </p>
 */
public class BlobIntegratieTest extends AbstractMutatieConverteerderIntegratieTest {

    private static final Logger LOGGER = LoggerFactory.getLogger();

    private static GenericXmlApplicationContext synchronisatieContext;

    @Inject
    private BlobifierService blobifierService;

    @BeforeClass
    public static void setupSynchronisatie() {
        // Start RouteringCentrale
        synchronisatieContext = new GenericXmlApplicationContext();
        synchronisatieContext.load("classpath:/config/synchronisatie-test-context.xml");
        synchronisatieContext.refresh();
    }

    @AfterClass
    public static void destorySynchronisatie() {
        synchronisatieContext.close();
        synchronisatieContext = null;
    }

    @Before
    public void cleanDatabase() {
        final DummyTestCasus testCasus = new DummyTestCasus();
        final DataSource dataSource = synchronisatieContext.getBean("syncDalDataSource", DataSource.class);
        testCasus.initierenDatabase(dataSource);
    }

    private static final class DummyTestCasus extends TestCasus {

        public DummyTestCasus() {
            super(null, null, null, null);
        }

        @Override
        public TestResultaat run() {
            return null;
        }

        public void initierenDatabase(final DataSource dataSource) {
            final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            initierenBrpDatabaseIst(jdbcTemplate);
            initierenBrpDatabaseMigblok(jdbcTemplate);
            initierenBrpDatabaseVerconv(jdbcTemplate);
            initierenBrpDatabaseKern(jdbcTemplate);
        }
    };

    /**
     * Er wordt een onderzoek gestart op 01.02.10 (Persoon.Voornamen).
     *
     * @throws OngeldigePersoonslijstException
     * @throws Lo3SyntaxException
     * @throws ExcelAdapterException
     * @throws NotSupportedException
     * @throws SystemException
     * @throws HeuristicRollbackException
     * @throws HeuristicMixedException
     * @throws RollbackException
     * @throws IllegalStateException
     * @throws SecurityException
     */
    @Test
    public void testStartOnderzoek() {
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/Gv01-00C20T10 (start onderzoek)");

        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_01, true, Lo3ElementEnum.ELEMENT_8310, "010210", Lo3ElementEnum.ELEMENT_8320, "20140101");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_51, true, Lo3ElementEnum.ELEMENT_8310, "", Lo3ElementEnum.ELEMENT_8320, "");
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_07,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0004",
            Lo3ElementEnum.ELEMENT_8020,
            "20140101121501000");
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_57,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0003",
            Lo3ElementEnum.ELEMENT_8020,
            "20120701143501000");
        Assert.assertEquals(4, resultaat.size());
    }

    /**
     * Er wordt een onderzoek beeindigd zonder correctie of actualisatie.
     */
    @Test
    public void testBeeindigOnderzoek() {
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/Gv01-00C20T30a (beeindig onderzoek; gegevens correct)");

        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_01,
            true,
            Lo3ElementEnum.ELEMENT_8310,
            "010210",
            Lo3ElementEnum.ELEMENT_8320,
            "20140101",
            Lo3ElementEnum.ELEMENT_8330,
            "20140606");
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_51,
            true,
            Lo3ElementEnum.ELEMENT_8310,
            "010210",
            Lo3ElementEnum.ELEMENT_8320,
            "20140101",
            Lo3ElementEnum.ELEMENT_8330,
            "");

        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_07,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0005",
            Lo3ElementEnum.ELEMENT_8020,
            "20140606082501000");
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_57,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0004",
            Lo3ElementEnum.ELEMENT_8020,
            "20140101121501000");

        Assert.assertEquals(4, resultaat.size());
    }

    /**
     * Er wordt een onderzoek beeindigd zonder correctie of actualisatie.
     */
    @Test
    public void testWijzigOnderzoek() {
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-01C30T080");

        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_01, true, Lo3ElementEnum.ELEMENT_8310, "010240", Lo3ElementEnum.ELEMENT_8320, "20130701");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_51, true, Lo3ElementEnum.ELEMENT_8310, "010200", Lo3ElementEnum.ELEMENT_8320, "20130701");

        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_07,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0005",
            Lo3ElementEnum.ELEMENT_8020,
            "20130702143501000");
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_57,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0004",
            Lo3ElementEnum.ELEMENT_8020,
            "20130701143501000");

        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    public void testOnderzoekOpOuder() {
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-02C40T010");

        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_02,
            true,
            Lo3ElementEnum.ELEMENT_0210,
            "Greetje Gertruda",
            Lo3ElementEnum.ELEMENT_8120,
            "1 A2014",
            Lo3ElementEnum.ELEMENT_8310,
            "020200",
            Lo3ElementEnum.ELEMENT_8320,
            "20140101",
            Lo3ElementEnum.ELEMENT_8510,
            "20140101",
            Lo3ElementEnum.ELEMENT_8610,
            "20140102");
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_52,
            true,
            Lo3ElementEnum.ELEMENT_0210,
            "Greetje Gerda",
            Lo3ElementEnum.ELEMENT_8120,
            "1 A2013",
            Lo3ElementEnum.ELEMENT_8310,
            "020200",
            Lo3ElementEnum.ELEMENT_8320,
            "20140101",
            Lo3ElementEnum.ELEMENT_8510,
            "19761030",
            Lo3ElementEnum.ELEMENT_8610,
            "19761031");

        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_07,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0003",
            Lo3ElementEnum.ELEMENT_8020,
            "20141010000000000");
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_57,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0002",
            Lo3ElementEnum.ELEMENT_8020,
            "20140102000000000");

        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    public void testNieuwHuwelijk() {
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-05C10T040");

        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_05,
            true,
            Lo3ElementEnum.ELEMENT_0210,
            "Sarah",
            Lo3ElementEnum.ELEMENT_0240,
            "Pieters",
            Lo3ElementEnum.ELEMENT_0310,
            "19781010",
            Lo3ElementEnum.ELEMENT_0320,
            "0599",
            Lo3ElementEnum.ELEMENT_0330,
            "6030",
            Lo3ElementEnum.ELEMENT_0410,
            "V",
            Lo3ElementEnum.ELEMENT_0610,
            "20110331",
            Lo3ElementEnum.ELEMENT_0620,
            "1901",
            Lo3ElementEnum.ELEMENT_0630,
            "6030",
            Lo3ElementEnum.ELEMENT_1510,
            "H",
            Lo3ElementEnum.ELEMENT_8110,
            "1901",
            Lo3ElementEnum.ELEMENT_8120,
            "3 A9999",
            Lo3ElementEnum.ELEMENT_8510,
            "20110331",
            Lo3ElementEnum.ELEMENT_8610,
            "20110331");
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_55,
            true,
            Lo3ElementEnum.ELEMENT_0210,
            "",
            Lo3ElementEnum.ELEMENT_0240,
            "",
            Lo3ElementEnum.ELEMENT_0310,
            "",
            Lo3ElementEnum.ELEMENT_0320,
            "",
            Lo3ElementEnum.ELEMENT_0330,
            "",
            Lo3ElementEnum.ELEMENT_0410,
            "",
            Lo3ElementEnum.ELEMENT_0610,
            "",
            Lo3ElementEnum.ELEMENT_0620,
            "",
            Lo3ElementEnum.ELEMENT_0630,
            "",
            Lo3ElementEnum.ELEMENT_1510,
            "",
            Lo3ElementEnum.ELEMENT_8110,
            "",
            Lo3ElementEnum.ELEMENT_8120,
            "",
            Lo3ElementEnum.ELEMENT_8510,
            "",
            Lo3ElementEnum.ELEMENT_8610,
            "");

        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_07,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0002",
            Lo3ElementEnum.ELEMENT_8020,
            "20110331000000000");
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_57,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0001",
            Lo3ElementEnum.ELEMENT_8020,
            "20090331000000000");

        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    public void testHuwelijkOmzettenNaarPartnerschap() {
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-05C30T070");

        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_55, false, Lo3ElementEnum.ELEMENT_1510, "H");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_05, false, Lo3ElementEnum.ELEMENT_1510, "P");
        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    public void testStartOnderzoekOpTweeNationaliteiten() {
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-04C30T010");

        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        // Onderzoek zijn beide hetzelfde
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_04, true, Lo3ElementEnum.ELEMENT_8310, "040510", Lo3ElementEnum.ELEMENT_8320, "20130102");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_54, true, Lo3ElementEnum.ELEMENT_8310, "", Lo3ElementEnum.ELEMENT_8320, "");

        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_07,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0004",
            Lo3ElementEnum.ELEMENT_8020,
            "20130102000000000");
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_57,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0003",
            Lo3ElementEnum.ELEMENT_8020,
            "20130101000000000");

        // Twee onderzoeken, vandaar 6
        Assert.assertEquals(6, resultaat.size());
    }

    @Test
    public void testStartOnderzoekOpReisdocument() {
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-12C30T010");

        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_12, true, Lo3ElementEnum.ELEMENT_8310, "123500", Lo3ElementEnum.ELEMENT_8320, "19900111");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_62, true, Lo3ElementEnum.ELEMENT_8310, "", Lo3ElementEnum.ELEMENT_8320, "");

        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_07,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0002",
            Lo3ElementEnum.ELEMENT_8020,
            "19900111000000000");
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_57,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0001",
            Lo3ElementEnum.ELEMENT_8020,
            "19840204000000000");

        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    public void testWijzigAdellijkeTitelBijOuderMetOnderzoek() {
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-03C40T010");

        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }
    }

    @Test
    public void testOverlijden() {
        // Setup verconv
        // verConvRepository.addVoorkomen(2088L, maakLO3Voorkomen("07"));

        // Verwerk
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-06C10T010");

        // Debug
        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        // Check
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_07,
            true,
            Lo3ElementEnum.ELEMENT_6710,
            "20140901",
            Lo3ElementEnum.ELEMENT_6720,
            "O",
            Lo3ElementEnum.ELEMENT_8010,
            "0004",
            Lo3ElementEnum.ELEMENT_8020,
            "20140902000000000");

        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_57,
            true,
            Lo3ElementEnum.ELEMENT_6710,
            "",
            Lo3ElementEnum.ELEMENT_6720,
            "",
            Lo3ElementEnum.ELEMENT_8010,
            "0003",
            Lo3ElementEnum.ELEMENT_8020,
            "20100511000000000");

        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_06,
            true,
            Lo3ElementEnum.ELEMENT_0810,
            "20140830",
            Lo3ElementEnum.ELEMENT_0820,
            "0626",
            Lo3ElementEnum.ELEMENT_0830,
            "6030",
            Lo3ElementEnum.ELEMENT_8110,
            "0626",
            Lo3ElementEnum.ELEMENT_8120,
            "2XA0734",
            Lo3ElementEnum.ELEMENT_8510,
            "20140830",
            Lo3ElementEnum.ELEMENT_8610,
            "20140901");
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_56,
            true,
            Lo3ElementEnum.ELEMENT_0810,
            "",
            Lo3ElementEnum.ELEMENT_0820,
            "",
            Lo3ElementEnum.ELEMENT_0830,
            "",
            Lo3ElementEnum.ELEMENT_8110,
            "",
            Lo3ElementEnum.ELEMENT_8120,
            "",
            Lo3ElementEnum.ELEMENT_8510,
            "",
            Lo3ElementEnum.ELEMENT_8610,
            "");

        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    @Ignore("TODO: Fixen - 57.80.20 springt heen en weer")
    public void testInfraWijzingOpOpgeschortePl() {
        // Setup verconv
        // verConvRepository.addVoorkomen(74L, maakLO3Voorkomen("08"));

        // Verwerk
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv02-01C10T060");

        // Debug
        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        // Datum opschorting moet hier niet gewijzigd zijn (beide wordt 20101030 verwacht)
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_07,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0002",
            Lo3ElementEnum.ELEMENT_8020,
            "20110101000000000");
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_57,
            true,
            Lo3ElementEnum.ELEMENT_8010,
            "0001",
            Lo3ElementEnum.ELEMENT_8020,
            "20101031000000000");

        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_08,
            true,
            Lo3ElementEnum.ELEMENT_0910,
            "1901",
            Lo3ElementEnum.ELEMENT_0920,
            "20110101",
            Lo3ElementEnum.ELEMENT_1320,
            "20110101",
            Lo3ElementEnum.ELEMENT_7210,
            "W",
            Lo3ElementEnum.ELEMENT_8510,
            "20110101",
            Lo3ElementEnum.ELEMENT_8610,
            "20110101");
        assertElementen(
            resultaat,
            Lo3CategorieEnum.CATEGORIE_58,
            true,
            Lo3ElementEnum.ELEMENT_0910,
            "0595",
            Lo3ElementEnum.ELEMENT_0920,
            "20101030",
            Lo3ElementEnum.ELEMENT_1320,
            "20101030",
            Lo3ElementEnum.ELEMENT_7210,
            "I",
            Lo3ElementEnum.ELEMENT_8510,
            "20101030",
            Lo3ElementEnum.ELEMENT_8610,
            "20101031");

        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    public void testGeenOuderNaarBekendeOuder() {
        // lo3AanduidingOuderRepository.setAanduidingOuderBijOuderBetrokkenheid(179, LO3SoortAanduidingOuder.OUDER1);
        // lo3AanduidingOuderRepository.setAanduidingOuderBijOuderBetrokkenheid(180, LO3SoortAanduidingOuder.OUDER2);

        // Verwerk
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-02C20T010");

        // Debug
        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        // 53.02.40 leeg
        // 03.02.40 gevuld
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_02, false, Lo3ElementEnum.ELEMENT_0240, "Bigelow");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_52, false, Lo3ElementEnum.ELEMENT_0240, "");

        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    public void testOnbekendeOuderNaarBekendeOuder() {
        // lo3AanduidingOuderRepository.setAanduidingOuderBijOuderBetrokkenheid(182, LO3SoortAanduidingOuder.OUDER1);
        // lo3AanduidingOuderRepository.setAanduidingOuderBijOuderBetrokkenheid(184, LO3SoortAanduidingOuder.OUDER1);
        // lo3AanduidingOuderRepository.setAanduidingOuderBijOuderBetrokkenheid(183, LO3SoortAanduidingOuder.OUDER2);

        // Verwerk
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-02C20T020");

        // Debug
        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_02, false, Lo3ElementEnum.ELEMENT_0240, "Waters");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_52, false, Lo3ElementEnum.ELEMENT_0240, ".");

        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    public void testBekendeOuderNaarBekendeOuder() {
        // lo3AanduidingOuderRepository.setAanduidingOuderBijOuderBetrokkenheid(186, LO3SoortAanduidingOuder.OUDER1);
        // lo3AanduidingOuderRepository.setAanduidingOuderBijOuderBetrokkenheid(188, LO3SoortAanduidingOuder.OUDER1);
        // lo3AanduidingOuderRepository.setAanduidingOuderBijOuderBetrokkenheid(187, LO3SoortAanduidingOuder.OUDER2);
        // Verwerk
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-02C20T030");

        // Debug
        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_02, false, Lo3ElementEnum.ELEMENT_0240, "Witt");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_52, false, Lo3ElementEnum.ELEMENT_0240, "Grote");

        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    @Ignore("Testdata klopt niet")
    public void testBekendeOuderNaarGeenOuder() {
        // lo3AanduidingOuderRepository.setAanduidingOuderBijOuderBetrokkenheid(1902, LO3SoortAanduidingOuder.OUDER1);
        // lo3AanduidingOuderRepository.setAanduidingOuderBijOuderBetrokkenheid(1904, LO3SoortAanduidingOuder.OUDER1);
        // lo3AanduidingOuderRepository.setAanduidingOuderBijOuderBetrokkenheid(1903, LO3SoortAanduidingOuder.OUDER2);

        // Verwerk
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-02C20T040");

        // Debug
        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_02, false, Lo3ElementEnum.ELEMENT_0240, "");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_52, false, Lo3ElementEnum.ELEMENT_0240, "Naam");

        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    public void testOnbekendeOuderNaarGeenOuder() {
        // Verwerk
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-02C20T060");

        // Debug
        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_02, false, Lo3ElementEnum.ELEMENT_0240, "");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_52, false, Lo3ElementEnum.ELEMENT_0240, ".");

        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    public void testGeenOuderNaarOnbekendeOuder() {
        // Verwerk
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-02C70T010");

        // Debug
        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_02, false, Lo3ElementEnum.ELEMENT_0240, ".");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_52, false, Lo3ElementEnum.ELEMENT_0240, "");

        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    @Ignore("Testdata klopt niet")
    public void testBekendeOuderNaarOnbekendeOuder() {
        // Verwerk
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Gv01-02C70T050");

        // Debug
        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_03, false, Lo3ElementEnum.ELEMENT_0240, ".");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_53, false, Lo3ElementEnum.ELEMENT_0240, "Naam");

        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    public void testOnderzoekOpBsn() {
        // Verwerk
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Ondz-01.01.20");

        // Debug
        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        // Controleer onderzoek
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_01, false, Lo3ElementEnum.ELEMENT_8310, "010120");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_51, false, Lo3ElementEnum.ELEMENT_8310, "");

        // Controleer RNI verstrekking
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_01, false, Lo3ElementEnum.ELEMENT_8810, "0101", Lo3ElementEnum.ELEMENT_8820, "Verdrag");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_51, false, Lo3ElementEnum.ELEMENT_8810, "0101", Lo3ElementEnum.ELEMENT_8820, "Verdrag");

        Assert.assertEquals(4, resultaat.size());
    }

    @Test
    public void testOnderzoekOpSignaleringReisdocument() {
        // Verwerk
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/uc1001-Ondz-12.36.10");

        // Debug
        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

        // Controleer onderzoek
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_12, false, Lo3ElementEnum.ELEMENT_8310, "123610");
        assertElementen(resultaat, Lo3CategorieEnum.CATEGORIE_62, false, Lo3ElementEnum.ELEMENT_8310, "");

    }

    @Test
    @Ignore("Work in progress")
    public void testOnderzoekOpMigratieLand() {
        // Verwerk
        final List<Lo3CategorieWaarde> resultaat = verwerk("/data/OndzWijz-08.14.10");

        // Debug
        LOGGER.info("Resultaat ({}):", resultaat.size());
        for (final Lo3CategorieWaarde categorie : resultaat) {
            LOGGER.info(" - {}", categorie);
        }

    }

    private List<Lo3CategorieWaarde> verwerk(final String bijhoudingResourceLocation) {
        initierenPersoon(bijhoudingResourceLocation + "/persoon.xls", Lo3BerichtenBron.INITIELE_VULLING);
        final PersoonslijstPersisteerResultaat gbaBijhouding =
                initierenPersoon(bijhoudingResourceLocation + "/gbaBijhouding.xls", Lo3BerichtenBron.SYNCHRONISATIE);
        final PersoonHisVolledig persoonHisVolledig = blobifierService.leesBlob(gbaBijhouding.getPersoon().getId());
        return verwerk(persoonHisVolledig, gbaBijhouding.getAdministratieveHandelingen().iterator().next().getId());
    }

    private PersoonslijstPersisteerResultaat initierenPersoon(final String resource, final Lo3BerichtenBron bron) {
        // Application context dependencies
        final SyncParameters syncParameters = synchronisatieContext.getBean(SyncParameters.class);
        final ExcelAdapter excelAdapter = new ExcelAdapterImpl();
        final Lo3SyntaxControle syntaxControle = synchronisatieContext.getBean(Lo3SyntaxControle.class);
        final Lo3PersoonslijstParser lo3Parser = new Lo3PersoonslijstParser();
        final PreconditiesService preconditieService = synchronisatieContext.getBean(PreconditiesService.class);
        final ConverteerLo3NaarBrpService converteerLo3NaarBrpService = synchronisatieContext.getBean(ConverteerLo3NaarBrpService.class);
        final BrpDalService brpDalService = synchronisatieContext.getBean(BrpDalService.class);

        // Start transactie
        final PlatformTransactionManager transactionManager = synchronisatieContext.getBean("syncDalTransactionManager", PlatformTransactionManager.class);
        final TransactionDefinition transactionDefiniton = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        final TransactionStatus transaction = transactionManager.getTransaction(transactionDefiniton);

        if (Lo3BerichtenBron.INITIELE_VULLING.equals(bron)) {
            syncParameters.setInitieleVulling(true);
            LOGGER.info("Verwerken GBA initiele vulling");
        } else {
            syncParameters.setInitieleVulling(false);
            LOGGER.info("Verwerken GBA bijhouding");
        }

        LOGGER.info("Inlezen Excel sheet");
        try (InputStream fis = BlobIntegratieTest.class.getResourceAsStream(resource)) {
            if (fis == null) {
                throw new IllegalArgumentException("Resource '" + resource + "' bestaat niet.");
            }
            Logging.initContext();
            SynchronisatieLogging.init();
            final List<ExcelData> excelDatas = excelAdapter.leesExcelBestand(fis);

            if (excelDatas.isEmpty()) {
                throw new IllegalArgumentException("Persoon.xls bevat geen persoonsgegevens");
            }

            final ExcelData excelData = excelDatas.get(0);
            final List<Lo3CategorieWaarde> lo3Inhoud = excelData.getCategorieLijst();

            // Lo3 syntax controle
            final List<Lo3CategorieWaarde> lo3InhoudNaSyntaxControle = syntaxControle.controleer(lo3Inhoud);

            // Parse persoonslijst
            final Lo3Persoonslijst lo3Persoonslijst = lo3Parser.parse(lo3InhoudNaSyntaxControle);

            // Controleer precondities
            final Lo3Persoonslijst schoneLo3Persoonslijst = preconditieService.verwerk(lo3Persoonslijst);
            // LOG.info("Lo3 persoonslijst: {}", lo3Pl);

            final BrpPersoonslijst brpPl = converteerLo3NaarBrpService.converteerLo3Persoonslijst(schoneLo3Persoonslijst);

            final Lo3Bericht lo3Bericht = new Lo3Bericht("persoon", bron, new Timestamp(System.currentTimeMillis()), "ExcelData", true);
            LOGGER.info("Bericht: {}", lo3Bericht);

            final PersoonslijstPersisteerResultaat result =
                    brpDalService.persisteerPersoonslijst(brpPl, brpPl.getActueelAdministratienummer(), false, lo3Bericht);
            LOGGER.info("Persoon.id: {}", result.getPersoon().getId());
            LOGGER.info("Administratieve handeling(en): {}", result.getAdministratieveHandelingen());

            return result;
        } catch (
            ExcelAdapterException
            | Lo3SyntaxException
            | OngeldigePersoonslijstException e)
        {
            transaction.setRollbackOnly();
            throw new IllegalArgumentException("Kan persoonlijst niet verwerken", e);
        } catch (final IOException ioe) {
            transaction.setRollbackOnly();
            throw new IllegalArgumentException("Kan persoonlijst niet lezen: " + resource, ioe);
        } finally {
            LoggingContext.reset();
            LOGGER.info("Logging: {}", Logging.getLogging());
            Logging.destroyContext();

            if (transaction.isRollbackOnly()) {
                transactionManager.rollback(transaction);
            } else {
                transactionManager.commit(transaction);
            }

        }

    }
    //
    // private List<Lo3CategorieWaarde> verwerk(final String blobResource, final long admHndId) throws IOException {
    // final byte[] blob = lees(blobResource);
    // final PersoonHisVolledigImpl persoon = deserialiseer(blob);
    // return verwerk(persoon, admHndId);
    // }

    private List<Lo3CategorieWaarde> verwerk(final PersoonHisVolledig persoon, final long admHndId) {
        AdministratieveHandelingHisVolledig administratieveHandelingHisVolledigImpl = null;
        for (final AdministratieveHandelingHisVolledig admHnd : persoon.getAdministratieveHandelingen()) {
            LOGGER.info("Adm hnd: {}", admHnd.getID());
            if (admHndId == admHnd.getID()) {
                administratieveHandelingHisVolledigImpl = admHnd;
            }
        }
        Assert.assertNotNull("De gewenste administratieve handeling is niet gevonden", administratieveHandelingHisVolledigImpl);

        final AdministratieveHandelingModel administratieveHandeling = maakAdministratieveHandelingModel(administratieveHandelingHisVolledigImpl);

        LOGGER.info("Administratieve handeling: {}", administratieveHandeling.getID());

        final List<Lo3CategorieWaarde> resultaat = subject.converteer(persoon, null, administratieveHandeling, new ConversieCache());
        return resultaat;
    }

    private AdministratieveHandelingModel maakAdministratieveHandelingModel(
        final AdministratieveHandelingHisVolledig administratieveHandelingHisVolledigImpl)
    {
        final AdministratieveHandelingModel administratieveHandeling =
                new AdministratieveHandelingModel(
                    administratieveHandelingHisVolledigImpl.getSoort(),
                    administratieveHandelingHisVolledigImpl.getPartij(),
                    null,
                    administratieveHandelingHisVolledigImpl.getTijdstipRegistratie());
        ReflectionTestUtils.setField(administratieveHandeling, "iD", administratieveHandelingHisVolledigImpl.getID());

        for (final ActieHisVolledig actieHisVolledigImpl : administratieveHandelingHisVolledigImpl.getActies()) {
            final ActieModel actie = maakActieModel(administratieveHandeling, actieHisVolledigImpl);
            administratieveHandeling.getActies().add(actie);
        }

        return administratieveHandeling;
    }

    private ActieModel maakActieModel(final AdministratieveHandelingModel administratieveHandeling, final ActieHisVolledig actieHisVolledigImpl) {
        final ActieModel actie =
                new ActieModel(
                    actieHisVolledigImpl.getSoort(),
                    administratieveHandeling,
                    actieHisVolledigImpl.getPartij(),
                    actieHisVolledigImpl.getDatumAanvangGeldigheid(),
                    actieHisVolledigImpl.getDatumEindeGeldigheid(),
                    actieHisVolledigImpl.getTijdstipRegistratie(),
                    actieHisVolledigImpl.getDatumOntlening());
        ReflectionTestUtils.setField(actie, "iD", actieHisVolledigImpl.getID());
        return actie;
    }
    //
    // private byte[] lees(final String resource) throws IOException {
    // try (InputStream is = this.getClass().getResourceAsStream(resource)) {
    // return IOUtils.toByteArray(is);
    // }
    // }
    //
    // private PersoonHisVolledigImpl deserialiseer(final byte[] blob) {
    // final PersoonHisVolledigSerializer persoonHisVolledigSerializer = new PersoonHisVolledigStringSerializer();
    // return persoonHisVolledigSerializer.deserialiseer(blob);
    // }
}
