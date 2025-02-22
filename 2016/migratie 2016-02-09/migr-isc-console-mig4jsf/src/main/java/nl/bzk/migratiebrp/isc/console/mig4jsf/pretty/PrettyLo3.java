/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.isc.console.mig4jsf.pretty;

import edu.emory.mathcs.backport.java.util.Collections;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import nl.bzk.migratiebrp.bericht.model.BerichtSyntaxException;
import nl.bzk.migratiebrp.bericht.model.lo3.Lo3Bericht;
import nl.bzk.migratiebrp.bericht.model.lo3.Lo3Header;
import nl.bzk.migratiebrp.bericht.model.lo3.Lo3Inhoud;
import nl.bzk.migratiebrp.bericht.model.lo3.factory.Lo3BerichtFactory;
import nl.bzk.migratiebrp.conversie.model.lo3.herkomst.Lo3ElementEnum;
import nl.bzk.migratiebrp.conversie.model.lo3.syntax.Lo3CategorieWaarde;
import nl.bzk.migratiebrp.isc.console.mig4jsf.util.PropertyBasedMap;

/**
 * Pretty printer for LO3 berichten.
 */
public final class PrettyLo3 {

    private static final String TABLE_START_HEADER = "<table class=\"dataform pretty-lo3-header\">";
    private static final String TABLE_START_INHOUD = "<table class=\"dataform pretty-lo3-inhoud\"><col width=\"25%\"><col width=\"75%\">";
    private static final String TABLE_END = "</table>";

    private static final String TBODY_START = "<tbody>";
    private static final String TBODY_END = "</tbody>";

    private static final Map<String, String> CATEGORIEEN = new PropertyBasedMap("/categorieen.properties");
    private static final Map<String, String> ELEMENTEN = new PropertyBasedMap("/rubrieken.properties");

    private final Random randomGenerator = new Random();

    /**
     * Pretty print.
     *
     * @param lo3
     *            lo3
     * @return pretty printed lo3
     */
    public String prettyPrint(final String lo3) {
        try {
            final Lo3BerichtFactory berichtFactory = new Lo3BerichtFactory();
            final Lo3Bericht bericht = berichtFactory.getBericht(lo3);
            final Lo3Header header = bericht.getHeader();
            final String inhoud = lo3 == null ? null : lo3.substring(getTotalHeaderSize(header, lo3));

            final StringBuilder sb = new StringBuilder();

            appendOrigineelBericht(sb, lo3);
            appendHeader(sb, header, lo3);
            appendInhoud(sb, inhoud);

            return sb.toString();
        } catch (final BerichtSyntaxException e) {
            return "Fout opgetreden bij parsen bericht: " + e;
        }
    }

    /**
     * Raw print LO3 bericht.
     *
     * @param sb
     *            output
     * @param lo3Bericht
     *            lo3 bericht
     */
    void appendOrigineelBericht(final StringBuilder sb, final String lo3Bericht) {
        sb.append("<table class=\"dataform\">");
        sb.append("<thead><tr><th>Oorspronkelijk bericht</th></tr></thead>");
        sb.append(TBODY_START);
        sb.append("<tr><td><textarea class=\"pretty-xml\" rows=\"8\" wrap=\"off\" readonly=\"true\">");
        sb.append(lo3Bericht);
        sb.append("</textarea>");
        sb.append("</td></tr></tbody></table><br/>");
    }

    /**
     * Pretty print LO3 header.
     *
     * @param sb
     *            output
     * @param lo3Header
     *            lo3 header
     * @param lo3
     *            Het LO3 bericht als string
     * @throws BerichtSyntaxException
     *             In het geval dat de headers niet correct geparsed kunnen worden.
     */
    void appendHeader(final StringBuilder sb, final Lo3Header lo3Header, final String lo3) throws BerichtSyntaxException {
        sb.append(TABLE_START_HEADER);
        sb.append("<thead><tr><th>LO3 Bericht headers</th></tr></thead>");
        sb.append(TBODY_START);
        for (final String headerValue : lo3Header.parseHeaders(lo3)) {
            sb.append("<tr><td>").append(headerValue).append("</td></tr>");
        }
        sb.append(TBODY_END);
        sb.append(TABLE_END);
        sb.append("<br/>");
    }

    /**
     * Pretty print LO3 inhoud.
     *
     * @param sb
     *            output
     * @param lo3Inhoud
     *            lo3 inhoud
     * @throws BerichtSyntaxException
     *             In het geval het parsen van de inhoud mislukt.
     */
    void appendInhoud(final StringBuilder sb, final String lo3Inhoud) throws BerichtSyntaxException {
        final List<Lo3CategorieWaarde> categorieen = Lo3Inhoud.parseInhoud(lo3Inhoud);

        sb.append(TABLE_START_INHOUD);
        sb.append("<thead><tr><th colspan=\"2\">LO3 Bericht inhoud</th></tr></thead>");
        sb.append(TBODY_START);

        final String random = Integer.toHexString(randomGenerator.nextInt());
        int catCount = 0;

        for (final Lo3CategorieWaarde categorie : categorieen) {

            final String catIdent = "cat-" + random + "-" + catCount;
            final boolean folded = !categorie.getCategorie().isActueel();
            final String foldIdent = folded ? "folded" : "unfolded";

            sb.append("<tr class=\"categorie ");
            sb.append(catIdent);
            sb.append("\"><th colspan=\"2\"><a class=\"foldToggle ");
            sb.append(foldIdent);
            sb.append("\" onClick=\"javascript:toggleFold('");
            sb.append(catIdent);
            sb.append("')\"><span>fold/unfold &nbsp;</span></a>");

            sb.append("Categorie ").append(categorie.getCategorie());
            if (CATEGORIEEN.containsKey(categorie.getCategorie().getCategorie())) {
                sb.append(" - ").append(CATEGORIEEN.get(categorie.getCategorie().getCategorie()));
            }
            sb.append("</th></tr>");

            voegElementenBinnenHuidigeCategorieToe(sb, categorie, catIdent, foldIdent);

            catCount++;
        }
        sb.append("</tbody></table>");
    }

    private void voegElementenBinnenHuidigeCategorieToe(
        final StringBuilder sb,
        final Lo3CategorieWaarde categorie,
        final String catIdent,
        final String foldIdent)
    {
        final List<Lo3ElementEnum> sortedElementList = new ArrayList<Lo3ElementEnum>(categorie.getElementen().keySet());
        Collections.sort(sortedElementList, new Lo3ElementEnumComparator());

        for (final Lo3ElementEnum element : sortedElementList) {
            sb.append("<tr class=\"element ").append(catIdent).append(" ").append(foldIdent).append("\">");
            sb.append("<th>").append(element.getElementNummer(true));
            if (ELEMENTEN.containsKey(element.getElementNummer())) {
                sb.append(": ").append(ELEMENTEN.get(element.getElementNummer()));
            }
            sb.append("</th>");
            sb.append("<td>").append(categorie.getElementen().get(element)).append("</td>");
            sb.append("</tr>");
        }
    }

    /**
     * Geef de waarde van total header size.
     *
     * @param lo3Header
     *            bevat de informatie over welke headers in het bericht zitten.
     * @param lo3
     *            het bericht als string waaruit de headers worden geparsed.
     *
     * @return total header size
     * @throws BerichtSyntaxException
     *             In het geval dat de headers niet geparsed kunnen worden
     */
    private int getTotalHeaderSize(final Lo3Header lo3Header, final String lo3) throws BerichtSyntaxException {
        int totalHeaderSize = 0;
        for (final String header : lo3Header.parseHeaders(lo3)) {
            totalHeaderSize += header.length();
        }
        return totalHeaderSize;
    }

    /**
     * Klasse voor het sorteren van Lo3ElementEnums.
     */
    private static class Lo3ElementEnumComparator implements Comparator<Lo3ElementEnum>, Serializable {

        @Override
        public int compare(final Lo3ElementEnum o1, final Lo3ElementEnum o2) {
            final Short short1 = Short.parseShort(o1.getElementNummer());
            final Short short2 = Short.parseShort(o2.getElementNummer());
            return short1.compareTo(short2);
        }

    }

}
