/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 5-feb-2013 16:30:05 by Hibernate Tools 3.2.4.GA


import java.util.Date;

/**
 * HisOuderouderlijkgezag generated by hbm2java
 */
public class HisOuderouderlijkgezag extends HisMaterieel {


     private Integer id;
     private Betr betr;
     private Integer dataanvgel;
     private Integer dateindegel;
     private Date tsreg;
     private Date tsverval;
     private Long actieinh;
     private Long actieverval;
     private Long actieaanpgel;
     private boolean indouderheeftgezag;

    public HisOuderouderlijkgezag() {
    }


    public HisOuderouderlijkgezag(boolean indouderheeftgezag) {
        this.indouderheeftgezag = indouderheeftgezag;
    }
    public HisOuderouderlijkgezag(Betr betr, Integer dataanvgel, Integer dateindegel, Date tsreg, Date tsverval, Long actieinh, Long actieverval, Long actieaanpgel, boolean indouderheeftgezag) {
       this.betr = betr;
       this.dataanvgel = dataanvgel;
       this.dateindegel = dateindegel;
       this.tsreg = tsreg;
       this.tsverval = tsverval;
       this.actieinh = actieinh;
       this.actieverval = actieverval;
       this.actieaanpgel = actieaanpgel;
       this.indouderheeftgezag = indouderheeftgezag;
    }

    public Betr getBetr() {
        return this.betr;
    }

    public void setBetr(Betr betr) {
        this.betr = betr;
    }
    public Long getActieaanpgel() {
        return this.actieaanpgel;
    }

    public void setActieaanpgel(Long actieaanpgel) {
        this.actieaanpgel = actieaanpgel;
    }
    public boolean isIndouderheeftgezag() {
        return this.indouderheeftgezag;
    }

    public void setIndouderheeftgezag(boolean indouderheeftgezag) {
        this.indouderheeftgezag = indouderheeftgezag;
    }




}


