// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.brm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.model.data.brm.Regelimplementatie;

privileged aspect Regelimplementatie_Roo_Jpa_Entity {
    
    declare @type: Regelimplementatie: @Entity;
    
    declare @type: Regelimplementatie: @Table(schema = "brm", name = "regelimplementatie");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int4")
    private Integer Regelimplementatie.id;
    
    public Integer Regelimplementatie.getId() {
        return this.id;
    }
    
    public void Regelimplementatie.setId(Integer id) {
        this.id = id;
    }
    
}
