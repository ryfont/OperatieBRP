// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.brpreview.data.kern.Persindicatie;

privileged aspect Persindicatie_Roo_Jpa_Entity {
    
    declare @type: Persindicatie: @Entity;
    
    declare @type: Persindicatie: @Table(schema = "kern", name = "persindicatie");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "serial")
    private Integer Persindicatie.id;
    
    public Integer Persindicatie.getId() {
        return this.id;
    }
    
    public void Persindicatie.setId(Integer id) {
        this.id = id;
    }
    
}
