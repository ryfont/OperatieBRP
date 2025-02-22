/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 21-dec-2012 11:50:17 by Hibernate Tools 3.2.4.GA



/**
 * Bermelding generated by hbm2java
 */
public class Bermelding  implements java.io.Serializable {


     private Long id;
     private Melding melding;
     private Ber ber;

    public Bermelding() {
    }

    public Bermelding(Melding melding, Ber ber) {
       this.melding = melding;
       this.ber = ber;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Melding getMelding() {
        return this.melding;
    }
    
    public void setMelding(Melding melding) {
        this.melding = melding;
    }
    public Ber getBer() {
        return this.ber;
    }
    
    public void setBer(Ber ber) {
        this.ber = ber;
    }




}


