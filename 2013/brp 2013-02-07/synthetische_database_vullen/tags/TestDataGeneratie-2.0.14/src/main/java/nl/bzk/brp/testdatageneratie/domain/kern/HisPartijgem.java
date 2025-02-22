/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 21-dec-2012 11:50:17 by Hibernate Tools 3.2.4.GA



/**
 * HisPartijgem generated by hbm2java
 */
public class HisPartijgem extends His {

     private Partij partijByPartij;
     private Partij partijByVoortzettendegem;
     private Partij partijByOnderdeelvan;


    public HisPartijgem() {
    }

    public Partij getPartijByPartij() {
        return this.partijByPartij;
    }

    public void setPartijByPartij(Partij partijByPartij) {
        this.partijByPartij = partijByPartij;
    }

    public Partij getPartijByVoortzettendegem() {
        return this.partijByVoortzettendegem;
    }

    public void setPartijByVoortzettendegem(Partij partijByVoortzettendegem) {
        this.partijByVoortzettendegem = partijByVoortzettendegem;
    }

    public Partij getPartijByOnderdeelvan() {
        return this.partijByOnderdeelvan;
    }

    public void setPartijByOnderdeelvan(Partij partijByOnderdeelvan) {
        this.partijByOnderdeelvan = partijByOnderdeelvan;
    }
}


