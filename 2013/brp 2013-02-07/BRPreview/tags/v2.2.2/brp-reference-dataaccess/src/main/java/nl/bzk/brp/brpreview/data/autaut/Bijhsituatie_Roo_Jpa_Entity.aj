// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.autaut;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.brpreview.data.autaut.Bijhsituatie;

privileged aspect Bijhsituatie_Roo_Jpa_Entity {
    
    declare @type: Bijhsituatie: @Entity;
    
    declare @type: Bijhsituatie: @Table(schema = "autaut", name = "bijhsituatie");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "serial")
    private Integer Bijhsituatie.id;
    
    public Integer Bijhsituatie.getId() {
        return this.id;
    }
    
    public void Bijhsituatie.setId(Integer id) {
        this.id = id;
    }
    
}
