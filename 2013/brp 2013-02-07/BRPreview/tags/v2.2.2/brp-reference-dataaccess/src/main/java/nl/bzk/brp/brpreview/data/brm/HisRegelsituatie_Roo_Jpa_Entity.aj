// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.brm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.brpreview.data.brm.HisRegelsituatie;

privileged aspect HisRegelsituatie_Roo_Jpa_Entity {
    
    declare @type: HisRegelsituatie: @Entity;
    
    declare @type: HisRegelsituatie: @Table(schema = "brm", name = "his_regelsituatie");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigserial")
    private Long HisRegelsituatie.id;
    
    public Long HisRegelsituatie.getId() {
        return this.id;
    }
    
    public void HisRegelsituatie.setId(Long id) {
        this.id = id;
    }
    
}
