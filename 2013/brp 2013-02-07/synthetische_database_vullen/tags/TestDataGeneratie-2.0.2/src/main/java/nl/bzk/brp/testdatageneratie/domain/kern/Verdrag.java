/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 12-sep-2012 11:17:43 by Hibernate Tools 3.2.4.GA



/**
 * Verdrag generated by hbm2java
 */
public class Verdrag  implements java.io.Serializable {


     private int id;
     private String oms;
     private Integer dataanvgel;
     private Integer dateindegel;

    public Verdrag() {
    }

	
    public Verdrag(int id, String oms) {
        this.id = id;
        this.oms = oms;
    }
    public Verdrag(int id, String oms, Integer dataanvgel, Integer dateindegel) {
       this.id = id;
       this.oms = oms;
       this.dataanvgel = dataanvgel;
       this.dateindegel = dateindegel;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getOms() {
        return this.oms;
    }
    
    public void setOms(String oms) {
        this.oms = oms;
    }
    public Integer getDataanvgel() {
        return this.dataanvgel;
    }
    
    public void setDataanvgel(Integer dataanvgel) {
        this.dataanvgel = dataanvgel;
    }
    public Integer getDateindegel() {
        return this.dateindegel;
    }
    
    public void setDateindegel(Integer dateindegel) {
        this.dateindegel = dateindegel;
    }




}


