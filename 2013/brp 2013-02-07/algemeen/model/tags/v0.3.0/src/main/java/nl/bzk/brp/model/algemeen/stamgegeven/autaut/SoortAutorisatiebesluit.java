/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.algemeen.stamgegeven.autaut;

/**
 * Classificatie van Autorisatiebesluit.
 *
 *
 *
 */
public enum SoortAutorisatiebesluit {

    /**
     * Dummy eerste waarde, omdat enum ordinals bij 0 beginnen te tellen, maar id's in de database bij 1.
     */
    DUMMY("Dummy", "Dummy"),
    /**
     * Een autorisatie ten behoeve van het leveren van gegevens aan Partijen in de rol van Afnemer..
     */
    LEVERINGSAUTORISATIE("Leveringsautorisatie",
            "Een autorisatie ten behoeve van het leveren van gegevens aan Partijen in de rol van Afnemer."),
    /**
     * Een autorisatie ten behoeve van het bijhouden..
     */
    BIJHOUDINGSAUTORISATIE("Bijhoudingsautorisatie", "Een autorisatie ten behoeve van het bijhouden.");

    private final String naam;
    private final String omschrijving;

    /**
     * Private constructor daar enums niet van buitenaf geinstantieerd mogen/kunnen worden.
     *
     * @param naam Naam voor SoortAutorisatiebesluit
     * @param omschrijving Omschrijving voor SoortAutorisatiebesluit
     */
    private SoortAutorisatiebesluit(final String naam, final String omschrijving) {
        this.naam = naam;
        this.omschrijving = omschrijving;
    }

    /**
     * Retourneert Naam van Soort autorisatiebesluit.
     *
     * @return Naam.
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Retourneert Omschrijving van Soort autorisatiebesluit.
     *
     * @return Omschrijving.
     */
    public String getOmschrijving() {
        return omschrijving;
    }

}
