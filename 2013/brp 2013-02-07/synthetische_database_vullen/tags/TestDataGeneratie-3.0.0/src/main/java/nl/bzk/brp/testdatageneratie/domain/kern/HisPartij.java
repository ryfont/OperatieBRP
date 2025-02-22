/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 21-dec-2012 11:50:17 by Hibernate Tools 3.2.4.GA



/**
 * HisPartij generated by hbm2java
 */
public class HisPartij extends His {

     private Sector sector;
     private Partij partij;
     private Integer dateinde;
     private int dataanv;

    public HisPartij() {
    }

    public Sector getSector() {
        return this.sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
    public Partij getPartij() {
        return this.partij;
    }

    public void setPartij(Partij partij) {
        this.partij = partij;
    }

    public Integer getDateinde() {
        return this.dateinde;
    }

    public void setDateinde(Integer dateinde) {
        this.dateinde = dateinde;
    }
    public int getDataanv() {
        return this.dataanv;
    }

    public void setDataanv(int dataanv) {
        this.dataanv = dataanv;
    }
}


