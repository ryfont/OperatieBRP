/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated Jul 24, 2014 5:36:58 PM by Hibernate Tools 3.2.4.GA


import java.util.Date;

/**
 * HisPersvoornaam generated by hbm2java
 */
public class HisPersvoornaam  implements HisMaterieel,IntegerAsPrimaryKey,java.io.Serializable {


     private int id;
     private int persvoornaam;
     private Integer dataanvgel;
     private Integer dateindegel;
     private Date tsreg;
     private Date tsverval;
     private Long actieinh;
     private Long actieverval;
     private String nadereaandverval;
     private Long actieaanpgel;
     private String naam;

    public HisPersvoornaam() {
    }

	
    public HisPersvoornaam(int id, int persvoornaam, String naam) {
        this.id = id;
        this.persvoornaam = persvoornaam;
        this.naam = naam;
    }
    public HisPersvoornaam(int id, int persvoornaam, Integer dataanvgel, Integer dateindegel, Date tsreg, Date tsverval, Long actieinh, Long actieverval, String nadereaandverval, Long actieaanpgel, String naam) {
       this.id = id;
       this.persvoornaam = persvoornaam;
       this.dataanvgel = dataanvgel;
       this.dateindegel = dateindegel;
       this.tsreg = tsreg;
       this.tsverval = tsverval;
       this.actieinh = actieinh;
       this.actieverval = actieverval;
       this.nadereaandverval = nadereaandverval;
       this.actieaanpgel = actieaanpgel;
       this.naam = naam;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getPersvoornaam() {
        return this.persvoornaam;
    }
    
    public void setPersvoornaam(int persvoornaam) {
        this.persvoornaam = persvoornaam;
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
    public Date getTsreg() {
        return this.tsreg;
    }
    
    public void setTsreg(Date tsreg) {
        this.tsreg = tsreg;
    }
    public Date getTsverval() {
        return this.tsverval;
    }
    
    public void setTsverval(Date tsverval) {
        this.tsverval = tsverval;
    }
    public Long getActieinh() {
        return this.actieinh;
    }
    
    public void setActieinh(Long actieinh) {
        this.actieinh = actieinh;
    }
    public Long getActieverval() {
        return this.actieverval;
    }
    
    public void setActieverval(Long actieverval) {
        this.actieverval = actieverval;
    }
    public String getNadereaandverval() {
        return this.nadereaandverval;
    }
    
    public void setNadereaandverval(String nadereaandverval) {
        this.nadereaandverval = nadereaandverval;
    }
    public Long getActieaanpgel() {
        return this.actieaanpgel;
    }
    
    public void setActieaanpgel(Long actieaanpgel) {
        this.actieaanpgel = actieaanpgel;
    }
    public String getNaam() {
        return this.naam;
    }
    
    public void setNaam(String naam) {
        this.naam = naam;
    }




}


