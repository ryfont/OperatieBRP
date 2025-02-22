// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.brm;

import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import nl.bzk.brp.brpreview.data.ber.Srtber;
import nl.bzk.brp.brpreview.data.brm.Regelsituatie;
import nl.bzk.brp.brpreview.data.brm.Regelsrtber;
import nl.bzk.brp.brpreview.data.kern.Regel;

privileged aspect Regelsrtber_Roo_DbManaged {
    
    @OneToMany(mappedBy = "regelimplementatie")
    private Set<Regelsituatie> Regelsrtber.regelsituaties;
    
    @ManyToOne
    @JoinColumn(name = "srtber", referencedColumnName = "id", nullable = false)
    private Srtber Regelsrtber.srtber;
    
    @ManyToOne
    @JoinColumn(name = "regel", referencedColumnName = "id", nullable = false)
    private Regel Regelsrtber.regel;
    
    public Set<Regelsituatie> Regelsrtber.getRegelsituaties() {
        return regelsituaties;
    }
    
    public void Regelsrtber.setRegelsituaties(Set<Regelsituatie> regelsituaties) {
        this.regelsituaties = regelsituaties;
    }
    
    public Srtber Regelsrtber.getSrtber() {
        return srtber;
    }
    
    public void Regelsrtber.setSrtber(Srtber srtber) {
        this.srtber = srtber;
    }
    
    public Regel Regelsrtber.getRegel() {
        return regel;
    }
    
    public void Regelsrtber.setRegel(Regel regel) {
        this.regel = regel;
    }
    
}
