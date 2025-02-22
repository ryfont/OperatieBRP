/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.util;

import nl.bzk.brp.model.basis.Attribuut;
import org.apache.commons.lang.StringUtils;


/**
 * Utility class voor het {@link Attribuut}.
 */
public final class AttribuutUtil {

    /**
     * default constructor.
     */
    private AttribuutUtil() {

    }

    /**
     * Controlleert of de Attribuut geen lege waarde heeft.
     * <p/>
     * Voor attribuuType van het type String wordt StringUtils.isNotBlank gebruikt, voor overige type wordt er alleen gekeken of waarde niet null is.
     *
     * @param attribuut Attribuut
     * @return true als Attribuut waarde gevuld is of voor String type voldoen de voorwaarde van StringUtils.isNotBlank
     */
    public static boolean isNotBlank(final Attribuut<? extends Object> attribuut) {
        final boolean isNotBlank;

        if (attribuut != null) {
            if (attribuut.getWaarde() == null) {
                isNotBlank = false;
            } else if (attribuut.getWaarde() instanceof String) {
                isNotBlank = StringUtils.isNotBlank((String) attribuut.getWaarde());
            } else {
                isNotBlank = true;
            }
        } else {
            isNotBlank = false;
        }

        return isNotBlank;
    }

    /**
     * Controleert of het opgegeven attribuut niet leeg is.
     *
     * @param attribuut het attribuut dat gecontroleerd dient te worden.
     * @return <code>true</code> indien de waarde van het attribuut niet <code>null</code> is en (indien het een string is) ook niet leeg is.
     */
    public static boolean isNotEmpty(final Attribuut<? extends Object> attribuut) {
        final boolean isNotEmpty;

        if (attribuut != null) {
            if (attribuut.getWaarde() == null) {
                isNotEmpty = false;
            } else if (attribuut.getWaarde() instanceof String) {
                isNotEmpty = StringUtils.isNotEmpty((String) attribuut.getWaarde());
            } else {
                isNotEmpty = true;
            }
        } else {
            isNotEmpty = false;
        }

        return isNotEmpty;
    }

    /**
     * Controlleert of de Attribuut een lege waarde heeft.
     *
     * @param attribuut Attribuut
     * @return true als Attribuut waarde leeg is (null of lege string)
     * @see AttribuutUtil#isBlank(nl.bzk.brp.model.basis.Attribuut)
     */
    public static boolean isBlank(final Attribuut<? extends Object> attribuut) {
        return !isNotBlank(attribuut);
    }

    /**
     * Retourneert de waarde van het attribuut of indien deze leeg is, dan de opgegeven standaard waarde.
     *
     * @param attribuut     het attribuut
     * @param defaultWaarde de standaard waarde
     * @return de waarde van het attribuut of de standaard waarde indien leeg.
     */
    public static String defaultWaardeIfBlank(final Attribuut<String> attribuut, final String defaultWaarde) {
        if (attribuut == null || attribuut.getWaarde() == null) {
            return defaultWaarde;
        } else {
            return StringUtils.defaultIfBlank(attribuut.getWaarde(), defaultWaarde);
        }
    }
}
