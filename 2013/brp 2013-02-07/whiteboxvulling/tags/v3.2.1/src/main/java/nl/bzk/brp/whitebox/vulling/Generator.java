/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.whitebox.vulling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.DateFormatter;

import jxl.Workbook;
import nl.bzk.brp.whitebox.vulling.model.Gemeente;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Generator {

    private final Logger log = LoggerFactory.getLogger(getClass());

    Workbook workbook;

    private final String xlsFilename;

    public static List<Gemeente> gemeenten = new ArrayList<Gemeente>();

    public Generator(final String xlsFilename) {
	this.xlsFilename = xlsFilename;
    }

    private static List<SheetHandler> sheetHandlers = new ArrayList<SheetHandler>();

    static {
	sheetHandlers.add(new GemeenteMetaHandler(12, gemeenten));
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(0)); // persoon
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(2)); // brpactie
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(3)); // persoon-ident
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(4)); // his_geslacht
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(5)); // his_perssamengesteldenaam
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(7)); // his_geboorte
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(8)); // his_overleiden
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(10)); // persadres
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(11)); // his_persadres
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(14)); // his_bijhgem
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(16)); // relatie
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(17)); // his_relatie
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(18)); // betrokkenheid relatie
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(19)); // his_ouderschap
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(21)); // pers indicatie
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(22)); // his pers indicatie
	sheetHandlers.add(new SheetHandlerImplSimpleInsert(23)); // his pers opschorting
	// sheetHandlers.add(new SheetHandlerImplAfterBurner(20));
    }

    public boolean generate(final String outputName) {

	log.info("Reading '" + xlsFilename + "'");
	log.info("Writing '" + outputName + "'");

	Writer writer = null;
	BufferedWriter bufferedWriter = null;
	PrintWriter printWriter = null;

	try {

	    //writer = new FileOutputStream(file, false);
	    writer = new FileWriter(outputName);
	    bufferedWriter = new BufferedWriter(writer, 1024*1024*4);
	    printWriter = new PrintWriter(bufferedWriter, true);

	    printWriter.println("--- Start " + " " + WhiteBoxFiller.getVersion() + " @ " + new DateFormatter(WhiteBoxFiller.datFormat).valueToString(new Date()));

	    printWriter.println();
	    printWriter.println("--- #     #  #     #  ###  #######  #######  ######   #######  #     #  #######  ###  #        #        #######  ######");
	    printWriter.println("--- #  #  #  #     #   #      #     #        #     #  #     #   #   #   #         #   #        #        #        #     #");
	    printWriter.println("--- #  #  #  #     #   #      #     #        #     #  #     #    # #    #         #   #        #        #        #     #");
	    printWriter.println("--- #  #  #  #######   #      #     #####    ######   #     #     #     #####     #   #        #        #####    ######");
	    printWriter.println("--- #  #  #  #     #   #      #     #        #     #  #     #    # #    #         #   #        #        #        #   #");
	    printWriter.println("--- #  #  #  #     #   #      #     #        #     #  #     #   #   #   #         #   #        #        #        #    #");
	    printWriter.println("---  ## ##   #     #  ###     #     #######  ######   #######  #     #  #        ###  #######  #######  #######  #     #");

	    printWriter.println();
	    printWriter.println("--------------------------------------------------");
	    printWriter.println("--- WhiteBoxFiller");
	    printWriter.println("--- Version:    " + WhiteBoxFiller.getVersion());
	    printWriter.println("--- Timestamp:  " + new DateFormatter(WhiteBoxFiller.datFormat).valueToString(new Date()));
	    printWriter.println("--- Created by: " + System.getProperty("user.name"));
	    printWriter.println("--- XLS file:   " + xlsFilename);
	    printWriter.println("--------------------------------------------------");
	    printWriter.println();

	    addClassPathFile("foreburner.sql", printWriter);

	    workbook = Workbook.getWorkbook(new File(xlsFilename));

	    AdresLookup.initialize(workbook.getSheet(12));

	    printWriter.println("--------------------------------------------------");
	    printWriter.println("--- START Generated from: " + xlsFilename);
	    printWriter.println("--------------------------------------------------");
	    printWriter.println();

	    for (final SheetHandler sheetHandler : sheetHandlers) {
		sheetHandler.print(workbook, printWriter);
		printWriter.flush();
		bufferedWriter.flush();
		writer.flush();
	    }

	    printWriter.println("--------------------------------------------------");
	    printWriter.println("--- END Generated from: " + xlsFilename);
	    printWriter.println("--------------------------------------------------");

	    addClassPathFile("afterburner.sql", printWriter);

	    extraBsnNummers(printWriter);
	    extraANummers(printWriter);

	    printWriter.println();
	    printWriter.println("--- END " + " " + WhiteBoxFiller.getVersion() + " @ " + new DateFormatter(WhiteBoxFiller.datFormat).valueToString(new Date()));

	    return true;

	} catch (final Exception e) {
	    log.error("", e);
	    if (printWriter != null) {
		printWriter.println("An error occurred, dumping exception:");
	    }
	    e.printStackTrace(printWriter);
	} finally {
	    try {
		if (printWriter != null && writer != null && bufferedWriter != null) {

		    bufferedWriter.flush();
		    printWriter.flush();
		    writer.flush();

		    bufferedWriter.close();
		    printWriter.close();
		    writer.close();
		}
	    } catch (final Exception f) {
		log.error("", f);
	    }

	    log.info("Done");

	}
	return false;
    }

    private void extraBsnNummers(final PrintWriter result) throws ParseException {

	log.info("Extra BSN's");

	result.println("--- BEGIN BSN's");
	result.println();
	result.println("DROP TABLE IF EXISTS Kern.bsnvooraad CASCADE;");
	result.println();
	result.println("CREATE TABLE Kern.bsnvooraad (");
	result.println("	bsn int CONSTRAINT bsnvooraad_pk PRIMARY KEY");
	result.println("	,gemeentecode int NOT NULL");
	result.println("	,gemeentenaam varchar(255) NOT NULL");
	result.println("	,ambtenaar int NOT NULL");
	result.println("	);");
	result.println();

	for (final Gemeente gemeente : Generator.gemeenten) {

	    log.debug("BSN's for " + gemeente.naam);

	    for (int ambtenaarCount = 0; ambtenaarCount < WhiteBoxFiller.ambtenarenCount; ambtenaarCount++) {

		result.println("--------------------------------------------------");
		result.println("--- Xtra BSN's");
		result.println("--- Gemeente: " + gemeente.naam);
		result.println("--- Ambtenaar: " + ambtenaarCount);
		result.println("--- Generated at: " + new DateFormatter(WhiteBoxFiller.datFormat).valueToString(new Date()));
		result.println("--------------------------------------------------");

		result.println();
		result.println("BEGIN;");
		result.println();

		for (int i = 0; i < 100; i++) {
		    result.println("INSERT INTO Kern.bsnvooraad (bsn,gemeentecode,gemeentenaam,ambtenaar) VALUES(" + BSNGenerator.nextBSN()+ "," + gemeente.code + ",'" + gemeente.naam + "'," + ambtenaarCount + ");");
		}

		result.println();
		result.println("COMMIT;");
		result.println();
	    }
	}

	result.println("--- END BSN's");
    }

    private void extraANummers(final PrintWriter result) throws ParseException {

	result.println("--- BEGIN ANR's");
	result.println();
	result.println("DROP TABLE IF EXISTS Kern.anrvooraad CASCADE;");
	result.println();
	result.println("CREATE TABLE Kern.anrvooraad (");
	result.println("	anr bigint CONSTRAINT anrvooraad_pk PRIMARY KEY");
	result.println("	,gemeentecode int NOT NULL");
	result.println("	,gemeentenaam varchar(255) NOT NULL");
	result.println("	,ambtenaar int NOT NULL");
	result.println("	);");
	result.println();

	log.info("Extra Anr's");

	for (final Gemeente gemeente : Generator.gemeenten) {

	    log.debug("Anr's for " + gemeente.naam);

	    for (int ambtenaarCount = 0; ambtenaarCount < WhiteBoxFiller.ambtenarenCount; ambtenaarCount++) {

		result.println("--------------------------------------------------");
		result.println("--- ANR's");
		result.println("--- Gemeente: " + gemeente.naam);
		result.println("--- Ambtenaar: " + ambtenaarCount);
		result.println("--- Generated at: " + new DateFormatter(WhiteBoxFiller.datFormat).valueToString(new Date()));
		result.println("--------------------------------------------------");

		result.println();
		result.println("BEGIN;");
		result.println();

		for (int i = 0; i < 100; i++) {
		    result.println("INSERT INTO Kern.anrvooraad (anr,gemeentecode,gemeentenaam,ambtenaar) VALUES(" + AnrGenerator.getNextAnr() + "," + gemeente.code + ",'" + gemeente.naam + "'," + ambtenaarCount + ");");
		}

		result.println();
		result.println("COMMIT;");
		result.println();

	    }
	}

	result.println("--- END ANR's");
    }

    private void addClassPathFile(final String string, final  PrintWriter printWriter) throws IOException, ParseException {
	log.info("Adding '" + string + "'");
	printWriter.println("--------------------------------------------------");
	printWriter.println("--- Included: " + string);
	printWriter.println("--------------------------------------------------");
	printWriter.println();
	printWriter.flush();
	IOUtils.copy(this.getClass().getClassLoader().getResourceAsStream(string), printWriter, "UTF-8");
    }

}
