// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.brpreview.data.kern.Persverificatie;
import nl.bzk.brp.brpreview.data.kern.Srtverificatie;

privileged aspect Srtverificatie_Roo_DbManaged {
    
    @OneToMany(mappedBy = "srt")
    private Set<Persverificatie> Srtverificatie.persverificaties;
    
    @Column(name = "naam", columnDefinition = "varchar", length = 80, unique = true)
    @NotNull
    private String Srtverificatie.naam;
    
    public Set<Persverificatie> Srtverificatie.getPersverificaties() {
        return persverificaties;
    }
    
    public void Srtverificatie.setPersverificaties(Set<Persverificatie> persverificaties) {
        this.persverificaties = persverificaties;
    }
    
    public String Srtverificatie.getNaam() {
        return naam;
    }
    
    public void Srtverificatie.setNaam(String naam) {
        this.naam = naam;
    }
    
}
