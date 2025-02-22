/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.expressietaal.expressies.literals;

import nl.bzk.brp.expressietaal.Context;
import nl.bzk.brp.expressietaal.ExpressieType;
import nl.bzk.brp.model.basis.Attribuut;
import nl.bzk.brp.model.basis.Groep;
import org.apache.commons.lang.StringUtils;

/**
 * Representeert een stringconstante.
 */
public final class StringLiteralExpressie extends AbstractNietNumeriekRepresenteerbareLiteralExpressie {

    private static final String ONGEBRUIKTE_JAVA_REGEX_CHARACTERS = "<([{\\^-=$!|]})+.>";
    private static final char   MATCH_ENKEL_CHARACTER             = '?';
    private static final char   MATCH_MEERDERE_CHARACTERS         = '*';

    private String value;
    private String patroon;

    /**
     * Constructor.
     *
     * @param aValue De waarde van het vaste-waardeobject.
     */
    public StringLiteralExpressie(final String aValue) {
        super();
        setValue(aValue);
    }

    /**
     * Constructor.
     *
     * @param object Stringwaarde van de expressie.
     */
    public StringLiteralExpressie(final Object object) {
        super();
        if (object instanceof String) {
            setValue((String) object);
        } else if (object != null) {
            setValue(object.toString());
        } else {
            setValue("");
        }
    }

    /**
     * Zet de stringwaarde van de expressie.
     *
     * @param nieuweWaarde Nieuwe stringwaarde.
     */
    private void setValue(final String nieuweWaarde) {
        this.value = nieuweWaarde;
        this.patroon = maakRegexPatroon(this.value);
    }

    @Override
    public ExpressieType getType(final Context context) {
        return ExpressieType.STRING;
    }

    @Override
    public boolean alsBoolean() {
        // Default boolean-waarde voor een expressie is FALSE.
        return false;
    }

    @Override
    public String alsString() {
        return value;
    }

    @Override
    public Attribuut getAttribuut() {
        return null;
    }

    @Override
    public Groep getGroep() {
        return null;
    }

    @Override
    public String stringRepresentatie() {
        return String.format("\"%s\"", value);
    }

    public String getStringWaardeAlsReguliereExpressie() {
        return patroon;
    }

    /**
     * Maakt een patroon voor reguliere expressies. De in de expressietaal ondersteunde wildcards worden vertaald naar de corresponderende speciale
     * karakters. Karakters die een betekenis hebben in reguliere expressies, maar niet in de expressietaal worden omgezet naar 'normale' karakters (m.b.v.
     * backslash).
     *
     * @param waarde Om te zetten string.
     * @return Reguliere expressie voor string.
     */
    private static String maakRegexPatroon(final String waarde) {
        String result = null;
        if (waarde != null) {
            final StringBuilder patroonBuilder = new StringBuilder();
            for (int i = 0; i < waarde.length(); i++) {
                final char ch = waarde.charAt(i);
                if (StringUtils.contains(ONGEBRUIKTE_JAVA_REGEX_CHARACTERS, ch)) {
                    patroonBuilder.append('\\');
                    patroonBuilder.append(ch);
                } else if (ch == MATCH_ENKEL_CHARACTER) {
                    patroonBuilder.append('.');
                } else if (ch == MATCH_MEERDERE_CHARACTERS) {
                    patroonBuilder.append(".*");
                } else {
                    patroonBuilder.append(ch);
                }
            }

            result = patroonBuilder.toString();
        }
        return result;
    }
}

