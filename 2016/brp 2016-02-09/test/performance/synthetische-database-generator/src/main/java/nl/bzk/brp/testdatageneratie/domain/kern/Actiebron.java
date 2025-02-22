/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated Jul 24, 2014 5:36:58 PM by Hibernate Tools 3.2.4.GA



/**
 * Actiebron generated by hbm2java
 */
public class Actiebron  implements java.io.Serializable {


     private long id;
     private long actie;
     private Long doc;
     private Short rechtsgrond;
     private String rechtsgrondoms;

    public Actiebron() {
    }

	
    public Actiebron(long id, long actie) {
        this.id = id;
        this.actie = actie;
    }
    public Actiebron(long id, long actie, Long doc, Short rechtsgrond, String rechtsgrondoms) {
       this.id = id;
       this.actie = actie;
       this.doc = doc;
       this.rechtsgrond = rechtsgrond;
       this.rechtsgrondoms = rechtsgrondoms;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public long getActie() {
        return this.actie;
    }
    
    public void setActie(long actie) {
        this.actie = actie;
    }
    public Long getDoc() {
        return this.doc;
    }
    
    public void setDoc(Long doc) {
        this.doc = doc;
    }
    public Short getRechtsgrond() {
        return this.rechtsgrond;
    }
    
    public void setRechtsgrond(Short rechtsgrond) {
        this.rechtsgrond = rechtsgrond;
    }
    public String getRechtsgrondoms() {
        return this.rechtsgrondoms;
    }
    
    public void setRechtsgrondoms(String rechtsgrondoms) {
        this.rechtsgrondoms = rechtsgrondoms;
    }




}


