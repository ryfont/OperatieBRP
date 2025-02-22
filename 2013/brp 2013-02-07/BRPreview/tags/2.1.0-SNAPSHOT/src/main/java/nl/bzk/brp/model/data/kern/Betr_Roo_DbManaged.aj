// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.model.data.kern.Betr;
import nl.bzk.brp.model.data.kern.HisBetrouder;
import nl.bzk.brp.model.data.kern.HisBetrouderlijkgezag;
import nl.bzk.brp.model.data.kern.Multirealiteitregel;
import nl.bzk.brp.model.data.kern.Pers;
import nl.bzk.brp.model.data.kern.Relatie;
import nl.bzk.brp.model.data.kern.Srtbetr;

privileged aspect Betr_Roo_DbManaged {
    
    @OneToMany(mappedBy = "betr")
    private Set<HisBetrouder> Betr.hisBetrouders;
    
    @OneToMany(mappedBy = "betr")
    private Set<HisBetrouderlijkgezag> Betr.hisBetrouderlijkgezags;
    
    @OneToMany(mappedBy = "betr")
    private Set<Multirealiteitregel> Betr.multirealiteitregels;
    
    @ManyToOne
    @JoinColumn(name = "betrokkene", referencedColumnName = "id", nullable = false)
    private Pers Betr.betrokkene;
    
    @ManyToOne
    @JoinColumn(name = "relatie", referencedColumnName = "id", nullable = false)
    private Relatie Betr.relatie;
    
    @ManyToOne
    @JoinColumn(name = "rol", referencedColumnName = "id", nullable = false)
    private Srtbetr Betr.rol;
    
    @Column(name = "indouder", columnDefinition = "bool")
    private Boolean Betr.indouder;
    
    @Column(name = "ouderstatushis", columnDefinition = "varchar", length = 1)
    @NotNull
    private String Betr.ouderstatushis;
    
    @Column(name = "indouderheeftgezag", columnDefinition = "bool")
    private Boolean Betr.indouderheeftgezag;
    
    @Column(name = "ouderlijkgezagstatushis", columnDefinition = "varchar", length = 1)
    @NotNull
    private String Betr.ouderlijkgezagstatushis;
    
    public Set<HisBetrouder> Betr.getHisBetrouders() {
        return hisBetrouders;
    }
    
    public void Betr.setHisBetrouders(Set<HisBetrouder> hisBetrouders) {
        this.hisBetrouders = hisBetrouders;
    }
    
    public Set<HisBetrouderlijkgezag> Betr.getHisBetrouderlijkgezags() {
        return hisBetrouderlijkgezags;
    }
    
    public void Betr.setHisBetrouderlijkgezags(Set<HisBetrouderlijkgezag> hisBetrouderlijkgezags) {
        this.hisBetrouderlijkgezags = hisBetrouderlijkgezags;
    }
    
    public Set<Multirealiteitregel> Betr.getMultirealiteitregels() {
        return multirealiteitregels;
    }
    
    public void Betr.setMultirealiteitregels(Set<Multirealiteitregel> multirealiteitregels) {
        this.multirealiteitregels = multirealiteitregels;
    }
    
    public Pers Betr.getBetrokkene() {
        return betrokkene;
    }
    
    public void Betr.setBetrokkene(Pers betrokkene) {
        this.betrokkene = betrokkene;
    }
    
    public Relatie Betr.getRelatie() {
        return relatie;
    }
    
    public void Betr.setRelatie(Relatie relatie) {
        this.relatie = relatie;
    }
    
    public Srtbetr Betr.getRol() {
        return rol;
    }
    
    public void Betr.setRol(Srtbetr rol) {
        this.rol = rol;
    }
    
    public Boolean Betr.getIndouder() {
        return indouder;
    }
    
    public void Betr.setIndouder(Boolean indouder) {
        this.indouder = indouder;
    }
    
    public String Betr.getOuderstatushis() {
        return ouderstatushis;
    }
    
    public void Betr.setOuderstatushis(String ouderstatushis) {
        this.ouderstatushis = ouderstatushis;
    }
    
    public Boolean Betr.getIndouderheeftgezag() {
        return indouderheeftgezag;
    }
    
    public void Betr.setIndouderheeftgezag(Boolean indouderheeftgezag) {
        this.indouderheeftgezag = indouderheeftgezag;
    }
    
    public String Betr.getOuderlijkgezagstatushis() {
        return ouderlijkgezagstatushis;
    }
    
    public void Betr.setOuderlijkgezagstatushis(String ouderlijkgezagstatushis) {
        this.ouderlijkgezagstatushis = ouderlijkgezagstatushis;
    }
    
}
