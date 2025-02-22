// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.brpreview.data.kern.HisRelatie;
import nl.bzk.brp.brpreview.data.kern.Rdnbeeindrelatie;
import nl.bzk.brp.brpreview.data.kern.Relatie;

privileged aspect Rdnbeeindrelatie_Roo_DbManaged {
    
    @OneToMany(mappedBy = "rdneinde")
    private Set<HisRelatie> Rdnbeeindrelatie.hisRelaties;
    
    @OneToMany(mappedBy = "rdneinde")
    private Set<Relatie> Rdnbeeindrelatie.relaties;
    
    @Column(name = "code", columnDefinition = "varchar", length = 1)
    @NotNull
    private String Rdnbeeindrelatie.code;
    
    @Column(name = "oms", columnDefinition = "varchar", length = 250, unique = true)
    @NotNull
    private String Rdnbeeindrelatie.oms;
    
    public Set<HisRelatie> Rdnbeeindrelatie.getHisRelaties() {
        return hisRelaties;
    }
    
    public void Rdnbeeindrelatie.setHisRelaties(Set<HisRelatie> hisRelaties) {
        this.hisRelaties = hisRelaties;
    }
    
    public Set<Relatie> Rdnbeeindrelatie.getRelaties() {
        return relaties;
    }
    
    public void Rdnbeeindrelatie.setRelaties(Set<Relatie> relaties) {
        this.relaties = relaties;
    }
    
    public String Rdnbeeindrelatie.getCode() {
        return code;
    }
    
    public void Rdnbeeindrelatie.setCode(String code) {
        this.code = code;
    }
    
    public String Rdnbeeindrelatie.getOms() {
        return oms;
    }
    
    public void Rdnbeeindrelatie.setOms(String oms) {
        this.oms = oms;
    }
    
}
