// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.brpreview.data.kern.Verblijfsr;

privileged aspect Verblijfsr_Roo_Jpa_Entity {
    
    declare @type: Verblijfsr: @Entity;
    
    declare @type: Verblijfsr: @Table(schema = "kern", name = "verblijfsr");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int2")
    private Short Verblijfsr.id;
    
    public Short Verblijfsr.getId() {
        return this.id;
    }
    
    public void Verblijfsr.setId(Short id) {
        this.id = id;
    }
    
}
