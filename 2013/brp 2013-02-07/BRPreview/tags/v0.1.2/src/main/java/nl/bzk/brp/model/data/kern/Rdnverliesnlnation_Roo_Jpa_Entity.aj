// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.model.data.kern.Rdnverliesnlnation;

privileged aspect Rdnverliesnlnation_Roo_Jpa_Entity {
    
    declare @type: Rdnverliesnlnation: @Entity;
    
    declare @type: Rdnverliesnlnation: @Table(schema = "kern", name = "rdnverliesnlnation");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int4")
    private Integer Rdnverliesnlnation.id;
    
    public Integer Rdnverliesnlnation.getId() {
        return this.id;
    }
    
    public void Rdnverliesnlnation.setId(Integer id) {
        this.id = id;
    }
    
}
