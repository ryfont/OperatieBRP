/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.validatie;


/**
 * Model class voor een Overrulebare melding in een antwoordbericht.
 */
public class OverruleMelding {
    private String code;
    private String omschrijving;
    private String attribuutNaam;
    private String verzendendId;


    /**
     * Standaard lege constructor t.b.v. JiBX en andere frameworks.
     */
    public OverruleMelding() {
    }

    /**
     * Standaard constructor die direct alle waardes initialiseert.
     * @param code de code van de melding.
     */
    public OverruleMelding(final String code) {
        this.code = code;
    }

    /**
     * Standaard constructor die de meeste waarden invult.
     * @param code  de meldingscode (en daarmee de omschrijving)
     */
    public OverruleMelding(final MeldingCode code) {
        this.code = code.getNaam();
        omschrijving = code.getOmschrijving();
    }


    /**
     * Retourneert de code van de melding; de code geeft het type van de melding/fout aan.
     * @return de code van de melding.
     */
    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getAttribuutNaam() {
        return attribuutNaam;
    }

    public void setAttribuutNaam(final String attribuutNaam) {
        this.attribuutNaam = attribuutNaam;
    }

    public String getVerzendendId() {
        return verzendendId;
    }

    public void setVerzendendId(final String verzendendId) {
        this.verzendendId = verzendendId;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(final String omschrijving) {
        this.omschrijving = omschrijving;
    }
}
