// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.brpreview.data.kern.Autvanafgiftereisdoc;

privileged aspect Autvanafgiftereisdoc_Roo_Jpa_Entity {
    
    declare @type: Autvanafgiftereisdoc: @Entity;
    
    declare @type: Autvanafgiftereisdoc: @Table(schema = "kern", name = "autvanafgiftereisdoc");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int4")
    private Integer Autvanafgiftereisdoc.id;
    
    public Integer Autvanafgiftereisdoc.getId() {
        return this.id;
    }
    
    public void Autvanafgiftereisdoc.setId(Integer id) {
        this.id = id;
    }
    
}
