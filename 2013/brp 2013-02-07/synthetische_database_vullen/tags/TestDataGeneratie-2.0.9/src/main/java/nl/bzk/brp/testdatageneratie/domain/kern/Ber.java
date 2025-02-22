/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 12-sep-2012 11:17:43 by Hibernate Tools 3.2.4.GA


import java.util.Date;

/**
 * Ber generated by hbm2java
 */
public class Ber  implements java.io.Serializable {


     private long id;
     private Srtber srtber;
     private Verwerkingsresultaat verwerkingsresultaat;
     private Ber ber;
     private Bijhresultaat bijhresultaat;
     private Richting richting;
     private Srtmelding srtmelding;
     private Date tijdstipreg;
     private Integer peilmommaterieel;
     private Date peilmomformeel;
     private Integer aanschouwer;
     private String data;
     private Date tsontv;
     private Date tsverzenden;
     private String organisatie;
     private String applicatie;
     private String referentienr;
     private String crossreferentienr;
     private Boolean indprevalidatie;

    public Ber() {
    }

	
    public Ber(long id, Richting richting, String data) {
        this.id = id;
        this.richting = richting;
        this.data = data;
    }
    public Ber(long id, Srtber srtber, Verwerkingsresultaat verwerkingsresultaat, Ber ber, Bijhresultaat bijhresultaat, Richting richting, Srtmelding srtmelding, Date tijdstipreg, Integer peilmommaterieel, Date peilmomformeel, Integer aanschouwer, String data, Date tsontv, Date tsverzenden, String organisatie, String applicatie, String referentienr, String crossreferentienr, Boolean indprevalidatie) {
       this.id = id;
       this.srtber = srtber;
       this.verwerkingsresultaat = verwerkingsresultaat;
       this.ber = ber;
       this.bijhresultaat = bijhresultaat;
       this.richting = richting;
       this.srtmelding = srtmelding;
       this.tijdstipreg = tijdstipreg;
       this.peilmommaterieel = peilmommaterieel;
       this.peilmomformeel = peilmomformeel;
       this.aanschouwer = aanschouwer;
       this.data = data;
       this.tsontv = tsontv;
       this.tsverzenden = tsverzenden;
       this.organisatie = organisatie;
       this.applicatie = applicatie;
       this.referentienr = referentienr;
       this.crossreferentienr = crossreferentienr;
       this.indprevalidatie = indprevalidatie;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public Srtber getSrtber() {
        return this.srtber;
    }
    
    public void setSrtber(Srtber srtber) {
        this.srtber = srtber;
    }
    public Verwerkingsresultaat getVerwerkingsresultaat() {
        return this.verwerkingsresultaat;
    }
    
    public void setVerwerkingsresultaat(Verwerkingsresultaat verwerkingsresultaat) {
        this.verwerkingsresultaat = verwerkingsresultaat;
    }
    public Ber getBer() {
        return this.ber;
    }
    
    public void setBer(Ber ber) {
        this.ber = ber;
    }
    public Bijhresultaat getBijhresultaat() {
        return this.bijhresultaat;
    }
    
    public void setBijhresultaat(Bijhresultaat bijhresultaat) {
        this.bijhresultaat = bijhresultaat;
    }
    public Richting getRichting() {
        return this.richting;
    }
    
    public void setRichting(Richting richting) {
        this.richting = richting;
    }
    public Srtmelding getSrtmelding() {
        return this.srtmelding;
    }
    
    public void setSrtmelding(Srtmelding srtmelding) {
        this.srtmelding = srtmelding;
    }
    public Date getTijdstipreg() {
        return this.tijdstipreg;
    }
    
    public void setTijdstipreg(Date tijdstipreg) {
        this.tijdstipreg = tijdstipreg;
    }
    public Integer getPeilmommaterieel() {
        return this.peilmommaterieel;
    }
    
    public void setPeilmommaterieel(Integer peilmommaterieel) {
        this.peilmommaterieel = peilmommaterieel;
    }
    public Date getPeilmomformeel() {
        return this.peilmomformeel;
    }
    
    public void setPeilmomformeel(Date peilmomformeel) {
        this.peilmomformeel = peilmomformeel;
    }
    public Integer getAanschouwer() {
        return this.aanschouwer;
    }
    
    public void setAanschouwer(Integer aanschouwer) {
        this.aanschouwer = aanschouwer;
    }
    public String getData() {
        return this.data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    public Date getTsontv() {
        return this.tsontv;
    }
    
    public void setTsontv(Date tsontv) {
        this.tsontv = tsontv;
    }
    public Date getTsverzenden() {
        return this.tsverzenden;
    }
    
    public void setTsverzenden(Date tsverzenden) {
        this.tsverzenden = tsverzenden;
    }
    public String getOrganisatie() {
        return this.organisatie;
    }
    
    public void setOrganisatie(String organisatie) {
        this.organisatie = organisatie;
    }
    public String getApplicatie() {
        return this.applicatie;
    }
    
    public void setApplicatie(String applicatie) {
        this.applicatie = applicatie;
    }
    public String getReferentienr() {
        return this.referentienr;
    }
    
    public void setReferentienr(String referentienr) {
        this.referentienr = referentienr;
    }
    public String getCrossreferentienr() {
        return this.crossreferentienr;
    }
    
    public void setCrossreferentienr(String crossreferentienr) {
        this.crossreferentienr = crossreferentienr;
    }
    public Boolean getIndprevalidatie() {
        return this.indprevalidatie;
    }
    
    public void setIndprevalidatie(Boolean indprevalidatie) {
        this.indprevalidatie = indprevalidatie;
    }




}


