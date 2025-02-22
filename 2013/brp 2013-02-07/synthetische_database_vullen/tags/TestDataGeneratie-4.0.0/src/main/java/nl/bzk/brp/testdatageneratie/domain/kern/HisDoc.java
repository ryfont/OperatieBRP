/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 5-feb-2013 16:30:05 by Hibernate Tools 3.2.4.GA


import java.util.Date;

/**
 * HisDoc generated by hbm2java
 */
public class HisDoc extends His {


     private Integer id;
     private Partij partij;
     private Doc doc;
     private Date tsreg;
     private Date tsverval;
     private Long actieinh;
     private Long actieverval;
     private String ident;
     private String aktenr;
     private String oms;

    public HisDoc() {
    }


    public HisDoc(Partij partij) {
        this.partij = partij;
    }
    public HisDoc(Partij partij, Doc doc, Date tsreg, Date tsverval, Long actieinh, Long actieverval, String ident, String aktenr, String oms) {
       this.partij = partij;
       this.doc = doc;
       this.tsreg = tsreg;
       this.tsverval = tsverval;
       this.actieinh = actieinh;
       this.actieverval = actieverval;
       this.ident = ident;
       this.aktenr = aktenr;
       this.oms = oms;
    }


    public Partij getPartij() {
        return this.partij;
    }

    public void setPartij(Partij partij) {
        this.partij = partij;
    }
    public Doc getDoc() {
        return this.doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public String getIdent() {
        return this.ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }
    public String getAktenr() {
        return this.aktenr;
    }

    public void setAktenr(String aktenr) {
        this.aktenr = aktenr;
    }
    public String getOms() {
        return this.oms;
    }

    public void setOms(String oms) {
        this.oms = oms;
    }




}


