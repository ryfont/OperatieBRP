/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 12-sep-2012 11:17:43 by Hibernate Tools 3.2.4.GA



/**
 * HisPersgeslachtsaand generated by hbm2java
 */
public class HisPersgeslachtsaand extends His {


     private Geslachtsaand geslachtsaand;
     private Pers pers;
     private Actie actieByActieaanpgel;
     public HisPersgeslachtsaand() {
    }

    public HisPersgeslachtsaand(final Pers pers) {
        this.pers = pers;
        pers.setGeslachtsaandstatushis(StatusHis.A);
        setGeslachtsaand(pers.getGeslachtsaand());
    }
   
    public Geslachtsaand getGeslachtsaand() {
        return this.geslachtsaand;
    }
    
    public void setGeslachtsaand(Geslachtsaand geslachtsaand) {
        this.geslachtsaand = geslachtsaand;
    }
    public Pers getPers() {
        return this.pers;
    }
    
    public void setPers(Pers pers) {
        this.pers = pers;
    }
    public Actie getActieByActieaanpgel() {
        return this.actieByActieaanpgel;
    }
    
    public void setActieByActieaanpgel(Actie actieByActieaanpgel) {
        this.actieByActieaanpgel = actieByActieaanpgel;
    }




}


