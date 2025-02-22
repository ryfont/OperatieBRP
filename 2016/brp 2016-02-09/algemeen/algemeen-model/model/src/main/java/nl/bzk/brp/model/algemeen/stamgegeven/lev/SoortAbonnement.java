/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.algemeen.stamgegeven.lev;

/**
 * Het soort abonnement.
 */
public enum SoortAbonnement {

    /**
     * Dummy eerste waarde, omdat enum ordinals bij 0 beginnen te tellen, maar id's in de database bij 1.
     */
    DUMMY("Dummy"),
    /**
     * Levering.
     */
    LEVERING("Levering");

    private final String naam;

    /**
     * Private constructor daar enums niet van buitenaf geinstantieerd mogen/kunnen worden.
     *
     * @param naam Naam voor SoortAbonnement
     */
    private SoortAbonnement(final String naam) {
        this.naam = naam;
    }

    /**
     * Retourneert Naam van Soort abonnement.
     *
     * @return Naam.
     */
    public String getNaam() {
        return naam;
    }

}
