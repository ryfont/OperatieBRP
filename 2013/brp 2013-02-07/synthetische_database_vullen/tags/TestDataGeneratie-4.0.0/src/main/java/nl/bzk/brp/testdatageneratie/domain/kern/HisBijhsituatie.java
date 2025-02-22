/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 5-feb-2013 16:30:05 by Hibernate Tools 3.2.4.GA


import java.util.Date;

/**
 * HisBijhsituatie generated by hbm2java
 */
public class HisBijhsituatie extends His {


     private Integer id;
     private Bijhsituatie bijhsituatie;
     private Date tsreg;
     private Date tsverval;
     private Long actieinh;
     private Long actieverval;

    public HisBijhsituatie() {
    }

    public HisBijhsituatie(Bijhsituatie bijhsituatie, Date tsreg, Date tsverval, Long actieinh, Long actieverval) {
       this.bijhsituatie = bijhsituatie;
       this.tsreg = tsreg;
       this.tsverval = tsverval;
       this.actieinh = actieinh;
       this.actieverval = actieverval;
    }


    public Bijhsituatie getBijhsituatie() {
        return this.bijhsituatie;
    }

    public void setBijhsituatie(Bijhsituatie bijhsituatie) {
        this.bijhsituatie = bijhsituatie;
    }




}


