// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.model.data.kern.HisPartijgem;

privileged aspect HisPartijgem_Roo_Jpa_Entity {
    
    declare @type: HisPartijgem: @Entity;
    
    declare @type: HisPartijgem: @Table(schema = "kern", name = "his_partijgem");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigserial")
    private Long HisPartijgem.id;
    
    public Long HisPartijgem.getId() {
        return this.id;
    }
    
    public void HisPartijgem.setId(Long id) {
        this.id = id;
    }
    
}
