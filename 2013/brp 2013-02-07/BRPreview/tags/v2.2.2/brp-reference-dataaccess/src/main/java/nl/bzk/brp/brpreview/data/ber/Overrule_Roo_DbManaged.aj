// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.ber;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import nl.bzk.brp.brpreview.data.ber.Beroverrule;
import nl.bzk.brp.brpreview.data.ber.Overrule;
import nl.bzk.brp.brpreview.data.kern.Element;
import nl.bzk.brp.brpreview.data.kern.Regel;

privileged aspect Overrule_Roo_DbManaged {
    
    @OneToMany(mappedBy = "overrule")
    private Set<Beroverrule> Overrule.beroverrules;
    
    @ManyToOne
    @JoinColumn(name = "attribuut", referencedColumnName = "id")
    private Element Overrule.attribuut;
    
    @ManyToOne
    @JoinColumn(name = "regel", referencedColumnName = "id", nullable = false)
    private Regel Overrule.regel;
    
    @Column(name = "melding", columnDefinition = "varchar", length = 200)
    private String Overrule.melding;
    
    public Set<Beroverrule> Overrule.getBeroverrules() {
        return beroverrules;
    }
    
    public void Overrule.setBeroverrules(Set<Beroverrule> beroverrules) {
        this.beroverrules = beroverrules;
    }
    
    public Element Overrule.getAttribuut() {
        return attribuut;
    }
    
    public void Overrule.setAttribuut(Element attribuut) {
        this.attribuut = attribuut;
    }
    
    public Regel Overrule.getRegel() {
        return regel;
    }
    
    public void Overrule.setRegel(Regel regel) {
        this.regel = regel;
    }
    
    public String Overrule.getMelding() {
        return melding;
    }
    
    public void Overrule.setMelding(String melding) {
        this.melding = melding;
    }
    
}
