// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.model.data.kern.HisVerstrderde;
import nl.bzk.brp.model.data.kern.Partij;
import nl.bzk.brp.model.data.kern.Pers;
import nl.bzk.brp.model.data.kern.Verstrderde;

privileged aspect Verstrderde_Roo_DbManaged {
    
    @OneToMany(mappedBy = "verstrderde")
    private Set<HisVerstrderde> Verstrderde.hisVerstrderdes;
    
    @ManyToOne
    @JoinColumn(name = "derde", referencedColumnName = "id", nullable = false)
    private Partij Verstrderde.derde;
    
    @ManyToOne
    @JoinColumn(name = "pers", referencedColumnName = "id", nullable = false)
    private Pers Verstrderde.pers;
    
    @Column(name = "verstrderdestatushis", columnDefinition = "varchar", length = 1)
    @NotNull
    private String Verstrderde.verstrderdestatushis;
    
    public Set<HisVerstrderde> Verstrderde.getHisVerstrderdes() {
        return hisVerstrderdes;
    }
    
    public void Verstrderde.setHisVerstrderdes(Set<HisVerstrderde> hisVerstrderdes) {
        this.hisVerstrderdes = hisVerstrderdes;
    }
    
    public Partij Verstrderde.getDerde() {
        return derde;
    }
    
    public void Verstrderde.setDerde(Partij derde) {
        this.derde = derde;
    }
    
    public Pers Verstrderde.getPers() {
        return pers;
    }
    
    public void Verstrderde.setPers(Pers pers) {
        this.pers = pers;
    }
    
    public String Verstrderde.getVerstrderdestatushis() {
        return verstrderdestatushis;
    }
    
    public void Verstrderde.setVerstrderdestatushis(String verstrderdestatushis) {
        this.verstrderdestatushis = verstrderdestatushis;
    }
    
}
