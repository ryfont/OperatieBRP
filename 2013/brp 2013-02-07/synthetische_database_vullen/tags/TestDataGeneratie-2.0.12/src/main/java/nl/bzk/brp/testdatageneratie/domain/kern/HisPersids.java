/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 12-sep-2012 11:17:43 by Hibernate Tools 3.2.4.GA



/**
 * HisPersids generated by hbm2java
 */
public class HisPersids extends HisMaterieel {


     private Pers pers;
     private Integer bsn;
     private Long anr;

    public HisPersids() {
    }

    public Pers getPers() {
        return this.pers;
    }

    public void setPers(final Pers pers) {
        this.pers = pers;
    }
    public Integer getBsn() {
        return this.bsn;
    }

    public void setBsn(final Integer bsn) {
        this.bsn = bsn;
    }
    public Long getAnr() {
        return this.anr;
    }

    public void setAnr(final Long anr) {
        this.anr = anr;
    }




}


