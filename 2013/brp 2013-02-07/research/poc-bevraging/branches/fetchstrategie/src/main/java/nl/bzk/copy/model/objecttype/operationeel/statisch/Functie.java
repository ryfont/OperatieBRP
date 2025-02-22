/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.copy.model.objecttype.operationeel.statisch;

/**
 */
public enum Functie {

    /**
     * Dummy eerste waarde, omdat enum ordinals bij 0 beginnen te tellen, maar id's in de database bij 1.
     */
    DUMMY(null),
    /**
     * Dummy vulling.
     */
    DUMMY_VULLING("Dummy vulling");

    private String naam;

    /**
     * Private constructor voor eenmalige instantiatie in deze file.
     *
     * @param naam De naam van de waarde.
     */
    private Functie(final String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return this.naam;
    }

}
