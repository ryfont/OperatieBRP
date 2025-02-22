// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.brpreview.data.kern.HisPersverblijfsr;
import nl.bzk.brp.brpreview.data.kern.Pers;
import nl.bzk.brp.brpreview.data.kern.Verblijfsr;

privileged aspect Verblijfsr_Roo_DbManaged {
    
    @OneToMany(mappedBy = "verblijfsr")
    private Set<HisPersverblijfsr> Verblijfsr.hisPersverblijfsrs;
    
    @OneToMany(mappedBy = "verblijfsr")
    private Set<Pers> Verblijfsr.perss;
    
    @Column(name = "oms", columnDefinition = "varchar", length = 250, unique = true)
    @NotNull
    private String Verblijfsr.oms;
    
    @Column(name = "dataanvgel", columnDefinition = "int4")
    private Integer Verblijfsr.dataanvgel;
    
    @Column(name = "dateindegel", columnDefinition = "int4")
    private Integer Verblijfsr.dateindegel;
    
    public Set<HisPersverblijfsr> Verblijfsr.getHisPersverblijfsrs() {
        return hisPersverblijfsrs;
    }
    
    public void Verblijfsr.setHisPersverblijfsrs(Set<HisPersverblijfsr> hisPersverblijfsrs) {
        this.hisPersverblijfsrs = hisPersverblijfsrs;
    }
    
    public Set<Pers> Verblijfsr.getPerss() {
        return perss;
    }
    
    public void Verblijfsr.setPerss(Set<Pers> perss) {
        this.perss = perss;
    }
    
    public String Verblijfsr.getOms() {
        return oms;
    }
    
    public void Verblijfsr.setOms(String oms) {
        this.oms = oms;
    }
    
    public Integer Verblijfsr.getDataanvgel() {
        return dataanvgel;
    }
    
    public void Verblijfsr.setDataanvgel(Integer dataanvgel) {
        this.dataanvgel = dataanvgel;
    }
    
    public Integer Verblijfsr.getDateindegel() {
        return dateindegel;
    }
    
    public void Verblijfsr.setDateindegel(Integer dateindegel) {
        this.dateindegel = dateindegel;
    }
    
}
