// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.model.data.kern.HisPersgeslnaamcomp;

privileged aspect HisPersgeslnaamcomp_Roo_Jpa_Entity {
    
    declare @type: HisPersgeslnaamcomp: @Entity;
    
    declare @type: HisPersgeslnaamcomp: @Table(schema = "kern", name = "his_persgeslnaamcomp");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "serial")
    private Integer HisPersgeslnaamcomp.id;
    
    public Integer HisPersgeslnaamcomp.getId() {
        return this.id;
    }
    
    public void HisPersgeslnaamcomp.setId(Integer id) {
        this.id = id;
    }
    
}
