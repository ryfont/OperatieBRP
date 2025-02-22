/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 21-dec-2012 11:50:17 by Hibernate Tools 3.2.4.GA



/**
 * Admhnddoc generated by hbm2java
 */
public class Admhnddoc  implements java.io.Serializable {


     private int id;
     private Admhnd admhnd;
     private Doc doc;

    public Admhnddoc() {
    }

    public Admhnddoc(int id, Admhnd admhnd, Doc doc) {
       this.id = id;
       this.admhnd = admhnd;
       this.doc = doc;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Admhnd getAdmhnd() {
        return this.admhnd;
    }
    
    public void setAdmhnd(Admhnd admhnd) {
        this.admhnd = admhnd;
    }
    public Doc getDoc() {
        return this.doc;
    }
    
    public void setDoc(Doc doc) {
        this.doc = doc;
    }




}


