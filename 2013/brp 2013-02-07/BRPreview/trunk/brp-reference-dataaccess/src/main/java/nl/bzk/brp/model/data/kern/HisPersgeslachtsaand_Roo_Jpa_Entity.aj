// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.model.data.kern.HisPersgeslachtsaand;

privileged aspect HisPersgeslachtsaand_Roo_Jpa_Entity {
    
    declare @type: HisPersgeslachtsaand: @Entity;
    
    declare @type: HisPersgeslachtsaand: @Table(schema = "kern", name = "his_persgeslachtsaand");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "serial")
    private Integer HisPersgeslachtsaand.id;
    
    public Integer HisPersgeslachtsaand.getId() {
        return this.id;
    }
    
    public void HisPersgeslachtsaand.setId(Integer id) {
        this.id = id;
    }
    
}
