/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.autaut;
// Generated Apr 9, 2014 4:42:05 PM by Hibernate Tools 3.2.4.GA



/**
 * Abonnementdoelbinding generated by hbm2java
 */
public class Abonnementdoelbinding  implements java.io.Serializable {


     private int id;
     private int abonnement;
     private int doelbinding;

    public Abonnementdoelbinding() {
    }

    public Abonnementdoelbinding(int id, int abonnement, int doelbinding) {
       this.id = id;
       this.abonnement = abonnement;
       this.doelbinding = doelbinding;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getAbonnement() {
        return this.abonnement;
    }
    
    public void setAbonnement(int abonnement) {
        this.abonnement = abonnement;
    }
    public int getDoelbinding() {
        return this.doelbinding;
    }
    
    public void setDoelbinding(int doelbinding) {
        this.doelbinding = doelbinding;
    }




}


