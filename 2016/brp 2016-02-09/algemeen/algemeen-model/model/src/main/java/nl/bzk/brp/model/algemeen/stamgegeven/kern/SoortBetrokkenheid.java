/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.algemeen.stamgegeven.kern;

import javax.annotation.Generated;
import nl.bzk.brp.model.basis.ElementIdentificeerbaar;

/**
 * De mogelijke wijzen om Betrokken te zijn in een Relatie.
 *
 *
 *
 */
@Generated(value = "nl.bzk.brp.generatoren.java.StatischeStamgegevensGenerator")
public enum SoortBetrokkenheid implements ElementIdentificeerbaar {

    /**
     * Dummy eerste waarde, omdat enum ordinals bij 0 beginnen te tellen, maar id's in de database bij 1.
     */
    DUMMY("-1", "Dummy"),
    /**
     * Kind.
     */
    KIND("K", "Kind"),
    /**
     * Ouder.
     */
    OUDER("O", "Ouder"),
    /**
     * Partner.
     */
    PARTNER("P", "Partner"),
    /**
     * Erkenner.
     */
    ERKENNER("E", "Erkenner"),
    /**
     * Instemmer.
     */
    INSTEMMER("I", "Instemmer"),
    /**
     * Naamgever.
     */
    NAAMGEVER("N", "Naamgever");

    private final String code;
    private final String naam;

    /**
     * Private constructor daar enums niet van buitenaf geinstantieerd mogen/kunnen worden.
     *
     * @param code Code voor SoortBetrokkenheid
     * @param naam Naam voor SoortBetrokkenheid
     */
    private SoortBetrokkenheid(final String code, final String naam) {
        this.code = code;
        this.naam = naam;
    }

    /**
     * Retourneert Code van Soort betrokkenheid.
     *
     * @return Code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Retourneert Naam van Soort betrokkenheid.
     *
     * @return Naam.
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Retourneert het Element behorende bij dit objecttype.
     *
     * @return Element enum instantie behorende bij dit objecttype.
     */
    public final ElementEnum getElementIdentificatie() {
        return ElementEnum.SOORTBETROKKENHEID;
    }

}
