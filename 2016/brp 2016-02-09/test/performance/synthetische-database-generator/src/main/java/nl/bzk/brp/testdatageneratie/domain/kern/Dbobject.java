/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated Jul 24, 2014 5:36:58 PM by Hibernate Tools 3.2.4.GA



/**
 * Dbobject generated by hbm2java
 */
public class Dbobject  implements nl.bzk.brp.testdatageneratie.dataaccess.Cacheable<System>,java.io.Serializable {


     private int id;
     private String naam;
     private short srt;
     private Integer ouder;
     private String javaidentifier;
     private Boolean indonderdeelpl;
     private Boolean indonderdeelplouder;
     private Boolean indonderdeelplkind;
     private Boolean indonderdeelplpartner;
     private Boolean indverantwoordingpl;
     private Integer dataanvgel;
     private Integer dateindegel;

    public Dbobject() {
    }

	
    public Dbobject(int id, String naam, short srt, String javaidentifier) {
        this.id = id;
        this.naam = naam;
        this.srt = srt;
        this.javaidentifier = javaidentifier;
    }
    public Dbobject(int id, String naam, short srt, Integer ouder, String javaidentifier, Boolean indonderdeelpl, Boolean indonderdeelplouder, Boolean indonderdeelplkind, Boolean indonderdeelplpartner, Boolean indverantwoordingpl, Integer dataanvgel, Integer dateindegel) {
       this.id = id;
       this.naam = naam;
       this.srt = srt;
       this.ouder = ouder;
       this.javaidentifier = javaidentifier;
       this.indonderdeelpl = indonderdeelpl;
       this.indonderdeelplouder = indonderdeelplouder;
       this.indonderdeelplkind = indonderdeelplkind;
       this.indonderdeelplpartner = indonderdeelplpartner;
       this.indverantwoordingpl = indverantwoordingpl;
       this.dataanvgel = dataanvgel;
       this.dateindegel = dateindegel;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNaam() {
        return this.naam;
    }
    
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public short getSrt() {
        return this.srt;
    }
    
    public void setSrt(short srt) {
        this.srt = srt;
    }
    public Integer getOuder() {
        return this.ouder;
    }
    
    public void setOuder(Integer ouder) {
        this.ouder = ouder;
    }
    public String getJavaidentifier() {
        return this.javaidentifier;
    }
    
    public void setJavaidentifier(String javaidentifier) {
        this.javaidentifier = javaidentifier;
    }
    public Boolean getIndonderdeelpl() {
        return this.indonderdeelpl;
    }
    
    public void setIndonderdeelpl(Boolean indonderdeelpl) {
        this.indonderdeelpl = indonderdeelpl;
    }
    public Boolean getIndonderdeelplouder() {
        return this.indonderdeelplouder;
    }
    
    public void setIndonderdeelplouder(Boolean indonderdeelplouder) {
        this.indonderdeelplouder = indonderdeelplouder;
    }
    public Boolean getIndonderdeelplkind() {
        return this.indonderdeelplkind;
    }
    
    public void setIndonderdeelplkind(Boolean indonderdeelplkind) {
        this.indonderdeelplkind = indonderdeelplkind;
    }
    public Boolean getIndonderdeelplpartner() {
        return this.indonderdeelplpartner;
    }
    
    public void setIndonderdeelplpartner(Boolean indonderdeelplpartner) {
        this.indonderdeelplpartner = indonderdeelplpartner;
    }
    public Boolean getIndverantwoordingpl() {
        return this.indverantwoordingpl;
    }
    
    public void setIndverantwoordingpl(Boolean indverantwoordingpl) {
        this.indverantwoordingpl = indverantwoordingpl;
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



  // The following is extra code specified in the hbm.xml files
@Override public System getKey() { return null; }
  // end of extra code specified in the hbm.xml files

}


