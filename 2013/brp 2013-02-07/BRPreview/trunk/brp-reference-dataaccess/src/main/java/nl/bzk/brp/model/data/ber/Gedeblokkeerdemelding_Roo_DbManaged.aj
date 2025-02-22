// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.ber;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import nl.bzk.brp.model.data.ber.Admhndgedeblokkeerdemelding;
import nl.bzk.brp.model.data.ber.Gedeblokkeerdemelding;
import nl.bzk.brp.model.data.kern.Element;
import nl.bzk.brp.model.data.kern.Regel;

privileged aspect Gedeblokkeerdemelding_Roo_DbManaged {
    
    @OneToMany(mappedBy = "gedeblokkeerdemelding")
    private Set<Admhndgedeblokkeerdemelding> Gedeblokkeerdemelding.admhndgedeblokkeerdemeldings;
    
    @ManyToOne
    @JoinColumn(name = "attribuut", referencedColumnName = "id")
    private Element Gedeblokkeerdemelding.attribuut;
    
    @ManyToOne
    @JoinColumn(name = "regel", referencedColumnName = "id", nullable = false)
    private Regel Gedeblokkeerdemelding.regel;
    
    @Column(name = "melding", columnDefinition = "varchar", length = 200)
    private String Gedeblokkeerdemelding.melding;
    
    public Set<Admhndgedeblokkeerdemelding> Gedeblokkeerdemelding.getAdmhndgedeblokkeerdemeldings() {
        return admhndgedeblokkeerdemeldings;
    }
    
    public void Gedeblokkeerdemelding.setAdmhndgedeblokkeerdemeldings(Set<Admhndgedeblokkeerdemelding> admhndgedeblokkeerdemeldings) {
        this.admhndgedeblokkeerdemeldings = admhndgedeblokkeerdemeldings;
    }
    
    public Element Gedeblokkeerdemelding.getAttribuut() {
        return attribuut;
    }
    
    public void Gedeblokkeerdemelding.setAttribuut(Element attribuut) {
        this.attribuut = attribuut;
    }
    
    public Regel Gedeblokkeerdemelding.getRegel() {
        return regel;
    }
    
    public void Gedeblokkeerdemelding.setRegel(Regel regel) {
        this.regel = regel;
    }
    
    public String Gedeblokkeerdemelding.getMelding() {
        return melding;
    }
    
    public void Gedeblokkeerdemelding.setMelding(String melding) {
        this.melding = melding;
    }
    
}
