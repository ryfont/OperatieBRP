// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.autaut;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.brpreview.data.autaut.Uitgeslotene;

privileged aspect Uitgeslotene_Roo_Jpa_Entity {
    
    declare @type: Uitgeslotene: @Entity;
    
    declare @type: Uitgeslotene: @Table(schema = "autaut", name = "uitgeslotene");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "serial")
    private Integer Uitgeslotene.id;
    
    public Integer Uitgeslotene.getId() {
        return this.id;
    }
    
    public void Uitgeslotene.setId(Integer id) {
        this.id = id;
    }
    
}
