// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.autaut;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.brpreview.data.autaut.HisBijhautorisatie;

privileged aspect HisBijhautorisatie_Roo_Jpa_Entity {
    
    declare @type: HisBijhautorisatie: @Entity;
    
    declare @type: HisBijhautorisatie: @Table(schema = "autaut", name = "his_bijhautorisatie");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigserial")
    private Long HisBijhautorisatie.id;
    
    public Long HisBijhautorisatie.getId() {
        return this.id;
    }
    
    public void HisBijhautorisatie.setId(Long id) {
        this.id = id;
    }
    
}
