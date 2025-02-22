// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.brpreview.data.kern.Aangadresh;
import nl.bzk.brp.brpreview.data.kern.HisPersadres;
import nl.bzk.brp.brpreview.data.kern.Persadres;

privileged aspect Aangadresh_Roo_DbManaged {
    
    @OneToMany(mappedBy = "aangadresh")
    private Set<HisPersadres> Aangadresh.hisPersadreses;
    
    @OneToMany(mappedBy = "aangadresh")
    private Set<Persadres> Aangadresh.persadreses;
    
    @Column(name = "code", columnDefinition = "varchar", length = 1, unique = true)
    @NotNull
    private String Aangadresh.code;
    
    @Column(name = "naam", columnDefinition = "varchar", length = 80, unique = true)
    @NotNull
    private String Aangadresh.naam;
    
    @Column(name = "oms", columnDefinition = "varchar", length = 250)
    @NotNull
    private String Aangadresh.oms;
    
    public Set<HisPersadres> Aangadresh.getHisPersadreses() {
        return hisPersadreses;
    }
    
    public void Aangadresh.setHisPersadreses(Set<HisPersadres> hisPersadreses) {
        this.hisPersadreses = hisPersadreses;
    }
    
    public Set<Persadres> Aangadresh.getPersadreses() {
        return persadreses;
    }
    
    public void Aangadresh.setPersadreses(Set<Persadres> persadreses) {
        this.persadreses = persadreses;
    }
    
    public String Aangadresh.getCode() {
        return code;
    }
    
    public void Aangadresh.setCode(String code) {
        this.code = code;
    }
    
    public String Aangadresh.getNaam() {
        return naam;
    }
    
    public void Aangadresh.setNaam(String naam) {
        this.naam = naam;
    }
    
    public String Aangadresh.getOms() {
        return oms;
    }
    
    public void Aangadresh.setOms(String oms) {
        this.oms = oms;
    }
    
}
