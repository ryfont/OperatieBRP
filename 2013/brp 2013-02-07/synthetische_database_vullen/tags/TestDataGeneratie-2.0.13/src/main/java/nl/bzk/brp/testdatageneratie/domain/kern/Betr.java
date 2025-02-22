/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 12-sep-2012 11:17:43 by Hibernate Tools 3.2.4.GA



/**
 * Betr generated by hbm2java
 */
public class Betr  implements java.io.Serializable {


     private int id;
     private Long pers;
     private Relatie relatie;
     private Srtbetr srtbetr;
     private Boolean indouder;
     private String ouderschapstatushis = StatusHis.A.name();
     private Boolean indouderheeftgezag;
     private String ouderlijkgezagstatushis = StatusHis.A.name();

    public Betr() {
    }

    public Betr(final Srtbetr srtbetr, final Relatie relatie, final long persId) {
        setSrtbetr(srtbetr);
        setRelatie(relatie);
        setPers(persId);
        setIndouder(false);
        setIndouderheeftgezag(false);
    }


    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }
    public Long getPers() {
        return this.pers;
    }

    public void setPers(final Long pers) {
        this.pers = pers;
    }
    public Relatie getRelatie() {
        return this.relatie;
    }

    public void setRelatie(final Relatie relatie) {
        this.relatie = relatie;
    }
    public Srtbetr getSrtbetr() {
        return this.srtbetr;
    }

    public void setSrtbetr(final Srtbetr srtbetr) {
        this.srtbetr = srtbetr;
    }
    public Boolean getIndouder() {
        return this.indouder;
    }

    public void setIndouder(final Boolean indouder) {
        this.indouder = indouder;
    }
    public String getOuderschapstatushis() {
        return this.ouderschapstatushis;
    }

    public void setOuderschapstatushis(final String ouderschapstatushis) {
        this.ouderschapstatushis = ouderschapstatushis;
    }
    public Boolean getIndouderheeftgezag() {
        return this.indouderheeftgezag;
    }

    public void setIndouderheeftgezag(final Boolean indouderheeftgezag) {
        this.indouderheeftgezag = indouderheeftgezag;
    }
    public String getOuderlijkgezagstatushis() {
        return this.ouderlijkgezagstatushis;
    }

    public void setOuderlijkgezagstatushis(final String ouderlijkgezagstatushis) {
        this.ouderlijkgezagstatushis = ouderlijkgezagstatushis;
    }




}


