/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;

public enum Srtpers {

    /**
     * Deze enumeratie correspondeert met een statische tabel waarvan de id's bij 1 beginnen te tellen. De ordinal van
     * een enum begint echter bij 0.
     */
    DUMMY(null, null, null),
    /**
     * De persoon is ingeschreven.
     */
    INGESCHREVENE("I", "Ingeschrevene", "Ingeschrevene"),
    /**
     * De persoos niet ingeschreven maar moet wel aanwezig zijn omdat er wel naar verwezen wordt.
     */
    NIET_INGESCHREVENE("N", "Niet ingeschrevene", "Niet ingeschrevene"),
    /**
     * Alternatieve realiteit.
     */
    ALTERNATIEVE_REALITEIT("A", "Alternatieve realiteit", "Alternatieve realiteit");

    private String code;
    private String naam;
    private String omschrijving;

    /**
     * Constructor voor de initialisatie van de enumeratie.
     *
     * @param code code.
     * @param omschrijving omschrijving.
     */
    private Srtpers(final String code, final String naam, final String omschrijving) {
        this.code = code;
        this.naam = naam;
        this.omschrijving = omschrijving;
    }

    public String getCode() {
        return code;
    }

    public String getNaam() {
        return naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }
}
