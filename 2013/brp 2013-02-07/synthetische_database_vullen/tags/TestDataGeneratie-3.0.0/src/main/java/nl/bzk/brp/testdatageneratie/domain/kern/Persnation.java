/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 21-dec-2012 11:50:17 by Hibernate Tools 3.2.4.GA



/**
 * Persnation generated by hbm2java
 */
public class Persnation  implements java.io.Serializable {


     private Integer id;
     private Nation nation;
     private Pers pers;
     private Rdnverliesnlnation rdnverliesnlnation;
     private Rdnverknlnation rdnverknlnation;
     private String persnationstatushis = StatusHis.A.name();

    public Persnation() {
    }


    public Persnation(Nation nation, Pers pers, String persnationstatushis) {
        this.nation = nation;
        this.pers = pers;
        this.persnationstatushis = persnationstatushis;
    }
    public Persnation(Nation nation, Pers pers, Rdnverliesnlnation rdnverliesnlnation, Rdnverknlnation rdnverknlnation, String persnationstatushis) {
       this.nation = nation;
       this.pers = pers;
       this.rdnverliesnlnation = rdnverliesnlnation;
       this.rdnverknlnation = rdnverknlnation;
       this.persnationstatushis = persnationstatushis;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Nation getNation() {
        return this.nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }
    public Pers getPers() {
        return this.pers;
    }

    public void setPers(Pers pers) {
        this.pers = pers;
    }
    public Rdnverliesnlnation getRdnverliesnlnation() {
        return this.rdnverliesnlnation;
    }

    public void setRdnverliesnlnation(Rdnverliesnlnation rdnverliesnlnation) {
        this.rdnverliesnlnation = rdnverliesnlnation;
    }
    public Rdnverknlnation getRdnverknlnation() {
        return this.rdnverknlnation;
    }

    public void setRdnverknlnation(Rdnverknlnation rdnverknlnation) {
        this.rdnverknlnation = rdnverknlnation;
    }
    public String getPersnationstatushis() {
        return this.persnationstatushis;
    }

    public void setPersnationstatushis(String persnationstatushis) {
        this.persnationstatushis = persnationstatushis;
    }




}


