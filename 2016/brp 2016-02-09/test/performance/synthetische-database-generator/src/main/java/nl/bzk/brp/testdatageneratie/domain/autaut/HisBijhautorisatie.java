/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.autaut;
// Generated Apr 9, 2014 4:42:05 PM by Hibernate Tools 3.2.4.GA


import java.util.Date;

/**
 * HisBijhautorisatie generated by hbm2java
 */
public class HisBijhautorisatie  implements java.io.Serializable {


     private int id;
     private short bijhautorisatie;
     private Date tsreg;
     private Date tsverval;
     private Long actieinh;
     private Long actieverval;
     private String nadereaandverval;
     private short srtbevoegdheid;
     private Short geautoriseerdesrtpartij;
     private Short geautoriseerdepartij;
     private short toestand;
     private short categoriepersonen;
     private String oms;
     private int datingang;
     private int dateinde;

    public HisBijhautorisatie() {
    }

	
    public HisBijhautorisatie(int id, short bijhautorisatie, short srtbevoegdheid, short toestand, short categoriepersonen, String oms, int datingang, int dateinde) {
        this.id = id;
        this.bijhautorisatie = bijhautorisatie;
        this.srtbevoegdheid = srtbevoegdheid;
        this.toestand = toestand;
        this.categoriepersonen = categoriepersonen;
        this.oms = oms;
        this.datingang = datingang;
        this.dateinde = dateinde;
    }
    public HisBijhautorisatie(int id, short bijhautorisatie, Date tsreg, Date tsverval, Long actieinh, Long actieverval, String nadereaandverval, short srtbevoegdheid, Short geautoriseerdesrtpartij, Short geautoriseerdepartij, short toestand, short categoriepersonen, String oms, int datingang, int dateinde) {
       this.id = id;
       this.bijhautorisatie = bijhautorisatie;
       this.tsreg = tsreg;
       this.tsverval = tsverval;
       this.actieinh = actieinh;
       this.actieverval = actieverval;
       this.nadereaandverval = nadereaandverval;
       this.srtbevoegdheid = srtbevoegdheid;
       this.geautoriseerdesrtpartij = geautoriseerdesrtpartij;
       this.geautoriseerdepartij = geautoriseerdepartij;
       this.toestand = toestand;
       this.categoriepersonen = categoriepersonen;
       this.oms = oms;
       this.datingang = datingang;
       this.dateinde = dateinde;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public short getBijhautorisatie() {
        return this.bijhautorisatie;
    }
    
    public void setBijhautorisatie(short bijhautorisatie) {
        this.bijhautorisatie = bijhautorisatie;
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
    public short getSrtbevoegdheid() {
        return this.srtbevoegdheid;
    }
    
    public void setSrtbevoegdheid(short srtbevoegdheid) {
        this.srtbevoegdheid = srtbevoegdheid;
    }
    public Short getGeautoriseerdesrtpartij() {
        return this.geautoriseerdesrtpartij;
    }
    
    public void setGeautoriseerdesrtpartij(Short geautoriseerdesrtpartij) {
        this.geautoriseerdesrtpartij = geautoriseerdesrtpartij;
    }
    public Short getGeautoriseerdepartij() {
        return this.geautoriseerdepartij;
    }
    
    public void setGeautoriseerdepartij(Short geautoriseerdepartij) {
        this.geautoriseerdepartij = geautoriseerdepartij;
    }
    public short getToestand() {
        return this.toestand;
    }
    
    public void setToestand(short toestand) {
        this.toestand = toestand;
    }
    public short getCategoriepersonen() {
        return this.categoriepersonen;
    }
    
    public void setCategoriepersonen(short categoriepersonen) {
        this.categoriepersonen = categoriepersonen;
    }
    public String getOms() {
        return this.oms;
    }
    
    public void setOms(String oms) {
        this.oms = oms;
    }
    public int getDatingang() {
        return this.datingang;
    }
    
    public void setDatingang(int datingang) {
        this.datingang = datingang;
    }
    public int getDateinde() {
        return this.dateinde;
    }
    
    public void setDateinde(int dateinde) {
        this.dateinde = dateinde;
    }




}


