// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.autaut;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.brpreview.data.autaut.Autorisatiebesluit;
import nl.bzk.brp.brpreview.data.autaut.Doelbinding;
import nl.bzk.brp.brpreview.data.autaut.Doelbindinggegevenselement;
import nl.bzk.brp.brpreview.data.autaut.HisDoelbinding;
import nl.bzk.brp.brpreview.data.autaut.Protocolleringsniveau;
import nl.bzk.brp.brpreview.data.kern.Partij;
import nl.bzk.brp.brpreview.data.lev.Abonnement;

privileged aspect Doelbinding_Roo_DbManaged {
    
    @OneToMany(mappedBy = "doelbinding")
    private Set<Doelbindinggegevenselement> Doelbinding.doelbindinggegevenselements;
    
    @OneToMany(mappedBy = "doelbinding")
    private Set<HisDoelbinding> Doelbinding.hisDoelbindings;
    
    @OneToMany(mappedBy = "doelbinding")
    private Set<Abonnement> Doelbinding.abonnements;
    
    @ManyToOne
    @JoinColumn(name = "levsautorisatiebesluit", referencedColumnName = "id", nullable = false)
    private Autorisatiebesluit Doelbinding.levsautorisatiebesluit;
    
    @ManyToOne
    @JoinColumn(name = "protocolleringsniveau", referencedColumnName = "id")
    private Protocolleringsniveau Doelbinding.protocolleringsniveau;
    
    @ManyToOne
    @JoinColumn(name = "geautoriseerde", referencedColumnName = "id", nullable = false)
    private Partij Doelbinding.geautoriseerde;
    
    @Column(name = "tekstdoelbinding", columnDefinition = "text")
    private String Doelbinding.tekstdoelbinding;
    
    @Column(name = "populatiecriterium", columnDefinition = "text")
    private String Doelbinding.populatiecriterium;
    
    @Column(name = "indverstrbeperkinghonoreren", columnDefinition = "bool")
    private Boolean Doelbinding.indverstrbeperkinghonoreren;
    
    @Column(name = "doelbindingstatushis", columnDefinition = "varchar", length = 1)
    @NotNull
    private String Doelbinding.doelbindingstatushis;
    
    public Set<Doelbindinggegevenselement> Doelbinding.getDoelbindinggegevenselements() {
        return doelbindinggegevenselements;
    }
    
    public void Doelbinding.setDoelbindinggegevenselements(Set<Doelbindinggegevenselement> doelbindinggegevenselements) {
        this.doelbindinggegevenselements = doelbindinggegevenselements;
    }
    
    public Set<HisDoelbinding> Doelbinding.getHisDoelbindings() {
        return hisDoelbindings;
    }
    
    public void Doelbinding.setHisDoelbindings(Set<HisDoelbinding> hisDoelbindings) {
        this.hisDoelbindings = hisDoelbindings;
    }
    
    public Set<Abonnement> Doelbinding.getAbonnements() {
        return abonnements;
    }
    
    public void Doelbinding.setAbonnements(Set<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }
    
    public Autorisatiebesluit Doelbinding.getLevsautorisatiebesluit() {
        return levsautorisatiebesluit;
    }
    
    public void Doelbinding.setLevsautorisatiebesluit(Autorisatiebesluit levsautorisatiebesluit) {
        this.levsautorisatiebesluit = levsautorisatiebesluit;
    }
    
    public Protocolleringsniveau Doelbinding.getProtocolleringsniveau() {
        return protocolleringsniveau;
    }
    
    public void Doelbinding.setProtocolleringsniveau(Protocolleringsniveau protocolleringsniveau) {
        this.protocolleringsniveau = protocolleringsniveau;
    }
    
    public Partij Doelbinding.getGeautoriseerde() {
        return geautoriseerde;
    }
    
    public void Doelbinding.setGeautoriseerde(Partij geautoriseerde) {
        this.geautoriseerde = geautoriseerde;
    }
    
    public String Doelbinding.getTekstdoelbinding() {
        return tekstdoelbinding;
    }
    
    public void Doelbinding.setTekstdoelbinding(String tekstdoelbinding) {
        this.tekstdoelbinding = tekstdoelbinding;
    }
    
    public String Doelbinding.getPopulatiecriterium() {
        return populatiecriterium;
    }
    
    public void Doelbinding.setPopulatiecriterium(String populatiecriterium) {
        this.populatiecriterium = populatiecriterium;
    }
    
    public Boolean Doelbinding.getIndverstrbeperkinghonoreren() {
        return indverstrbeperkinghonoreren;
    }
    
    public void Doelbinding.setIndverstrbeperkinghonoreren(Boolean indverstrbeperkinghonoreren) {
        this.indverstrbeperkinghonoreren = indverstrbeperkinghonoreren;
    }
    
    public String Doelbinding.getDoelbindingstatushis() {
        return doelbindingstatushis;
    }
    
    public void Doelbinding.setDoelbindingstatushis(String doelbindingstatushis) {
        this.doelbindingstatushis = doelbindingstatushis;
    }
    
}
