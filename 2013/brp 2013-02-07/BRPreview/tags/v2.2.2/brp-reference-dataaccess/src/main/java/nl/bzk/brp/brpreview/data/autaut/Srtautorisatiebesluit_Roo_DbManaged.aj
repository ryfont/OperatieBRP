// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.autaut;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.brpreview.data.autaut.Autorisatiebesluit;
import nl.bzk.brp.brpreview.data.autaut.Srtautorisatiebesluit;

privileged aspect Srtautorisatiebesluit_Roo_DbManaged {
    
    @OneToMany(mappedBy = "srt")
    private Set<Autorisatiebesluit> Srtautorisatiebesluit.autorisatiebesluits;
    
    @Column(name = "naam", columnDefinition = "varchar", length = 80, unique = true)
    @NotNull
    private String Srtautorisatiebesluit.naam;
    
    @Column(name = "oms", columnDefinition = "varchar", length = 250, unique = true)
    @NotNull
    private String Srtautorisatiebesluit.oms;
    
    @Column(name = "dataanvgel", columnDefinition = "int4")
    private Integer Srtautorisatiebesluit.dataanvgel;
    
    @Column(name = "dateindegel", columnDefinition = "int4")
    private Integer Srtautorisatiebesluit.dateindegel;
    
    public Set<Autorisatiebesluit> Srtautorisatiebesluit.getAutorisatiebesluits() {
        return autorisatiebesluits;
    }
    
    public void Srtautorisatiebesluit.setAutorisatiebesluits(Set<Autorisatiebesluit> autorisatiebesluits) {
        this.autorisatiebesluits = autorisatiebesluits;
    }
    
    public String Srtautorisatiebesluit.getNaam() {
        return naam;
    }
    
    public void Srtautorisatiebesluit.setNaam(String naam) {
        this.naam = naam;
    }
    
    public String Srtautorisatiebesluit.getOms() {
        return oms;
    }
    
    public void Srtautorisatiebesluit.setOms(String oms) {
        this.oms = oms;
    }
    
    public Integer Srtautorisatiebesluit.getDataanvgel() {
        return dataanvgel;
    }
    
    public void Srtautorisatiebesluit.setDataanvgel(Integer dataanvgel) {
        this.dataanvgel = dataanvgel;
    }
    
    public Integer Srtautorisatiebesluit.getDateindegel() {
        return dateindegel;
    }
    
    public void Srtautorisatiebesluit.setDateindegel(Integer dateindegel) {
        this.dateindegel = dateindegel;
    }
    
}
