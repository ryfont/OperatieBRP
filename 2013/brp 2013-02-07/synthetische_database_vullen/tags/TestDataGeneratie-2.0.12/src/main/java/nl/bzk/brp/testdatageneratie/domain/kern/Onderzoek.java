/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;

// Generated 12-sep-2012 11:17:43 by Hibernate Tools 3.2.4.GA

/**
 * De Class Onderzoek.
 */
public class Onderzoek implements java.io.Serializable {

    /** De id. */
    private int       id;

    /** De datbegin. */
    private Integer   datbegin;

    /** De dateinde. */
    private Integer   dateinde;

    /** De oms. */
    private String    oms;

    /** De onderzoekstatushis. */
    private String onderzoekstatushis = StatusHis.A.name();

    /**
     * Instantieert een nieuwe onderzoek.
     */
    public Onderzoek() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Integer getDatbegin() {
        return this.datbegin;
    }

    public void setDatbegin(final Integer datbegin) {
        this.datbegin = datbegin;
    }

    public Integer getDateinde() {
        return this.dateinde;
    }

    public void setDateinde(final Integer dateinde) {
        this.dateinde = dateinde;
    }

    public String getOms() {
        return this.oms;
    }

    public void setOms(final String oms) {
        this.oms = oms;
    }

    public String getOnderzoekstatushis() {
        return this.onderzoekstatushis;
    }

    public void setOnderzoekstatushis(final String onderzoekstatushis) {
        this.onderzoekstatushis = onderzoekstatushis;
    }

}
