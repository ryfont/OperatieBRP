/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 21-dec-2012 11:50:17 by Hibernate Tools 3.2.4.GA


import nl.bzk.brp.testdatageneratie.dataaccess.Cacheable;

/**
 * Nation generated by hbm2java
 */
public class Nation  implements Cacheable<Short> {

    private static final short CODE_NL = 1;

     private int id;
     private short code;
     private String naam;
     private Integer dataanvgel;
     private Integer dateindegel;

    public Nation() {
    }

    public boolean isNederlandse() {
        return code == CODE_NL;
    }
    public Nation(int id, short code, String naam, Integer dataanvgel, Integer dateindegel) {
       this.id = id;
       this.code = code;
       this.naam = naam;
       this.dataanvgel = dataanvgel;
       this.dateindegel = dateindegel;
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public short getCode() {
        return this.code;
    }
    
    public void setCode(short code) {
        this.code = code;
    }
    public String getNaam() {
        return this.naam;
    }
    
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public Integer getDataanvgel() {
        return this.dataanvgel;
    }
    
    public void setDataanvgel(Integer dataanvgel) {
        this.dataanvgel = dataanvgel;
    }
    public Integer getDateindegel() {
        return this.dateindegel;
    }
    
    public void setDateindegel(Integer dateindegel) {
        this.dateindegel = dateindegel;
    }


    @Override
    public Short getKey() {
        return code;
    }
}


