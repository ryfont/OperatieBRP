/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

/**
 *
 */
package nl.bzk.brp.preview.model;

/**
 * Enum van de ondersteunde bijhoudingstypes.
 *
 */
public enum OndersteundeBijhoudingsTypes {

    /** De VERHUIZING. */
    ONBEKEND ("Onbekend"), VERHUIZING("Verhuizing"), GEBOORTE("Geboorte");

    private String naam;

    /**
     * Zet de naam van het nieuwe ondersteunde bijhoudingstype.
     *
     * @param bijhoudingsType de bijhoudings type
     */
    OndersteundeBijhoudingsTypes(final String bijhoudingsType) {
        naam = bijhoudingsType;
    }

    public String getNaam() {
        return naam;
    }
}
