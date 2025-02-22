// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.model.data.kern.Actie;
import nl.bzk.brp.model.data.kern.Srtactie;

privileged aspect Srtactie_Roo_DbManaged {
    
    @OneToMany(mappedBy = "srt")
    private Set<Actie> Srtactie.acties;
    
    @Column(name = "naam", columnDefinition = "varchar", length = 80)
    @NotNull
    private String Srtactie.naam;
    
    public Set<Actie> Srtactie.getActies() {
        return acties;
    }
    
    public void Srtactie.setActies(Set<Actie> acties) {
        this.acties = acties;
    }
    
    public String Srtactie.getNaam() {
        return naam;
    }
    
    public void Srtactie.setNaam(String naam) {
        this.naam = naam;
    }
    
}
