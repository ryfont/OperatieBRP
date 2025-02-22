// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.model.data.kern.HisPersverblijfstitel;
import nl.bzk.brp.model.data.kern.Pers;
import nl.bzk.brp.model.data.kern.Verblijfstitel;

privileged aspect Verblijfstitel_Roo_DbManaged {
    
    @OneToMany(mappedBy = "verblijfstitel")
    private Set<HisPersverblijfstitel> Verblijfstitel.hisPersverblijfstitels;
    
    @OneToMany(mappedBy = "verblijfstitel")
    private Set<Pers> Verblijfstitel.perss;
    
    @Column(name = "code", columnDefinition = "int2")
    @NotNull
    private Short Verblijfstitel.code;
    
    @Column(name = "oms", columnDefinition = "varchar", length = 250, unique = true)
    @NotNull
    private String Verblijfstitel.oms;
    
    @Column(name = "dataanvgel", columnDefinition = "int4")
    private Integer Verblijfstitel.dataanvgel;
    
    @Column(name = "dateindegel", columnDefinition = "int4")
    private Integer Verblijfstitel.dateindegel;
    
    public Set<HisPersverblijfstitel> Verblijfstitel.getHisPersverblijfstitels() {
        return hisPersverblijfstitels;
    }
    
    public void Verblijfstitel.setHisPersverblijfstitels(Set<HisPersverblijfstitel> hisPersverblijfstitels) {
        this.hisPersverblijfstitels = hisPersverblijfstitels;
    }
    
    public Set<Pers> Verblijfstitel.getPerss() {
        return perss;
    }
    
    public void Verblijfstitel.setPerss(Set<Pers> perss) {
        this.perss = perss;
    }
    
    public Short Verblijfstitel.getCode() {
        return code;
    }
    
    public void Verblijfstitel.setCode(Short code) {
        this.code = code;
    }
    
    public String Verblijfstitel.getOms() {
        return oms;
    }
    
    public void Verblijfstitel.setOms(String oms) {
        this.oms = oms;
    }
    
    public Integer Verblijfstitel.getDataanvgel() {
        return dataanvgel;
    }
    
    public void Verblijfstitel.setDataanvgel(Integer dataanvgel) {
        this.dataanvgel = dataanvgel;
    }
    
    public Integer Verblijfstitel.getDateindegel() {
        return dateindegel;
    }
    
    public void Verblijfstitel.setDateindegel(Integer dateindegel) {
        this.dateindegel = dateindegel;
    }
    
}
