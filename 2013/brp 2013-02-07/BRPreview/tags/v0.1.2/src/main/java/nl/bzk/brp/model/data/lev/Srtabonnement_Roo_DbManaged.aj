// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.lev;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.model.data.lev.Abonnement;
import nl.bzk.brp.model.data.lev.Srtabonnement;

privileged aspect Srtabonnement_Roo_DbManaged {
    
    @OneToMany(mappedBy = "srtabonnement")
    private Set<Abonnement> Srtabonnement.abonnements;
    
    @Column(name = "naam", columnDefinition = "varchar", length = 40, unique = true)
    @NotNull
    private String Srtabonnement.naam;
    
    public Set<Abonnement> Srtabonnement.getAbonnements() {
        return abonnements;
    }
    
    public void Srtabonnement.setAbonnements(Set<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }
    
    public String Srtabonnement.getNaam() {
        return naam;
    }
    
    public void Srtabonnement.setNaam(String naam) {
        this.naam = naam;
    }
    
}
