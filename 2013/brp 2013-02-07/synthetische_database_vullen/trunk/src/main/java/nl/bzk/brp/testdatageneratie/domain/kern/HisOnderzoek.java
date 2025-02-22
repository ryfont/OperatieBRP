/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 5-feb-2013 16:30:05 by Hibernate Tools 3.2.4.GA


import java.util.Date;

/**
 * HisOnderzoek generated by hbm2java
 */
public class HisOnderzoek  extends His {


     private Integer id;
     private Onderzoek onderzoek;
     private Date tsreg;
     private Date tsverval;
     private Long actieinh;
     private Long actieverval;
     private int datbegin;
     private Integer dateinde;
     private String oms;

    public HisOnderzoek() {
    }

	
    public HisOnderzoek(int datbegin) {
        this.datbegin = datbegin;
    }
    public HisOnderzoek(Onderzoek onderzoek, Date tsreg, Date tsverval, Long actieinh, Long actieverval, int datbegin, Integer dateinde, String oms) {
       this.onderzoek = onderzoek;
       this.tsreg = tsreg;
       this.tsverval = tsverval;
       this.actieinh = actieinh;
       this.actieverval = actieverval;
       this.datbegin = datbegin;
       this.dateinde = dateinde;
       this.oms = oms;
    }
   
    public Onderzoek getOnderzoek() {
        return this.onderzoek;
    }
    
    public void setOnderzoek(Onderzoek onderzoek) {
        this.onderzoek = onderzoek;
    }
    public int getDatbegin() {
        return this.datbegin;
    }
    
    public void setDatbegin(int datbegin) {
        this.datbegin = datbegin;
    }
    public Integer getDateinde() {
        return this.dateinde;
    }
    
    public void setDateinde(Integer dateinde) {
        this.dateinde = dateinde;
    }
    public String getOms() {
        return this.oms;
    }
    
    public void setOms(String oms) {
        this.oms = oms;
    }




}


