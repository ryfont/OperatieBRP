/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.isc.jbpm.uc1003.plaatsen;

import nl.bzk.migratiebrp.bericht.model.lo3.impl.Pf03Bericht;
import nl.bzk.migratiebrp.bericht.model.sync.SyncBericht;
import nl.bzk.migratiebrp.bericht.model.sync.impl.AdHocZoekPersoonVerzoekBericht;
import nl.bzk.migratiebrp.isc.jbpm.uc1003.AbstractUc1003Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test de technische flows rondom het zoeken van persoon.
 */
public class Uc1003PlaatsenZoekPersoonTest extends AbstractUc1003Test {

    private static final String END = "end";
    private static final String FOUTAFHANDELING_FOUT = "foutafhandelingFout";
    private static final String ACHTERNAAM = "Jansen";
    private static final int BSN = 123456789;
    private static final long A_NUMMER = 1234567890L;
    private static final String AFNEMER = "059901";

    public Uc1003PlaatsenZoekPersoonTest() {
        super("/uc1003-plaatsen/processdefinition.xml,/foutafhandeling/processdefinition.xml");
    }

    @BeforeClass
    public static void outputTestIscBerichten() {
        // Output de unittests als migr-test-isc flow.
        // setOutputBerichten("D:\\mGBA\\work\\test-isc");
    }

    @Before
    public void startProces() {
        // Start
        startProcess(PlaatsenAfnIndTestUtil.maakAp01Bericht(AFNEMER, A_NUMMER, BSN, ACHTERNAAM, null));
    }

    @After
    public void endProces() {
        controleerBerichten(0, 0, 0);

        Assert.assertTrue(processEnded());
    }

    @Test
    public void afbreken() {
        controleerBerichten(0, 0, 1);
        getBericht(AdHocZoekPersoonVerzoekBericht.class);

        // Afbreken
        signalProcess("afbreken");

        // Beheerderskeuze: restart
        signalHumanTask("restartAtControlerenPersoon");

        // Nog een keer
        controleerBerichten(0, 0, 1);
        getBericht(AdHocZoekPersoonVerzoekBericht.class);
        signalProcess("afbreken");

        // Beheerderskeuze: end
        checkVariabele(FOUTAFHANDELING_FOUT, "uc1003.zoek.afgebroken");
        signalHumanTask(END);

        // Verwacht 1 output bericht (Pf03) om de ap01/av01 cyclus netjes af te ronden
        controleerBerichten(0, 1, 0);
        getBericht(Pf03Bericht.class);
    }

    @Test
    public void afbrekenGeenPf03() {
        controleerBerichten(0, 0, 1);
        getBericht(AdHocZoekPersoonVerzoekBericht.class);

        // Afbreken
        signalProcess("afbreken");

        // Beheerderskeuze
        signalHumanTask("endWithoutPf03");
    }

    @Test
    public void foutiefBericht() {
        controleerBerichten(0, 0, 1);
        final AdHocZoekPersoonVerzoekBericht adHocZoekPersoonVerzoekBericht = getBericht(AdHocZoekPersoonVerzoekBericht.class);

        // Onverwacht bericht
        final SyncBericht foutiefBericht = maakOnverwachtBericht(adHocZoekPersoonVerzoekBericht);
        signalSync(foutiefBericht);

        // Beheerderskeuze: restart
        signalHumanTask("restartAtControlerenPersoon");

        // Nog een keer
        controleerBerichten(0, 0, 1);
        final AdHocZoekPersoonVerzoekBericht adHocZoekPersoonVerzoekBericht2 = getBericht(AdHocZoekPersoonVerzoekBericht.class);
        final SyncBericht foutiefBericht2 = maakOnverwachtBericht(adHocZoekPersoonVerzoekBericht2);
        signalSync(foutiefBericht2);

        // Beheerderskeuze: end
        checkVariabele(FOUTAFHANDELING_FOUT, "uc1003.zoek.foutiefbericht");
        signalHumanTask(END);

        // Verwacht 1 output bericht (Pf03) om de ap01/av01 cyclus netjes af te ronden
        controleerBerichten(0, 1, 0);
        getBericht(Pf03Bericht.class);
    }

    @Test
    public void foutiefBerichtGeenPf03() {
        controleerBerichten(0, 0, 1);
        final AdHocZoekPersoonVerzoekBericht zoekPersoonVerzoek = getBericht(AdHocZoekPersoonVerzoekBericht.class);

        // Onverwacht bericht
        final SyncBericht foutiefBericht = maakOnverwachtBericht(zoekPersoonVerzoek);
        signalSync(foutiefBericht);

        // Beheerderskeuze
        signalHumanTask("endWithoutPf03");
    }
}
