// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.brpreview.data.kern.HisPartij;

privileged aspect HisPartij_Roo_Jpa_Entity {
    
    declare @type: HisPartij: @Entity;
    
    declare @type: HisPartij: @Table(schema = "kern", name = "his_partij");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigserial")
    private Long HisPartij.id;
    
    public Long HisPartij.getId() {
        return this.id;
    }
    
    public void HisPartij.setId(Long id) {
        this.id = id;
    }
    
}
