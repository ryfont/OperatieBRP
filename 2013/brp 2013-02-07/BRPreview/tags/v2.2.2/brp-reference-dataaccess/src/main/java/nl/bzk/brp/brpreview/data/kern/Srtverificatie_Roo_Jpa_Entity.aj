// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.brpreview.data.kern.Srtverificatie;

privileged aspect Srtverificatie_Roo_Jpa_Entity {
    
    declare @type: Srtverificatie: @Entity;
    
    declare @type: Srtverificatie: @Table(schema = "kern", name = "srtverificatie");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int2")
    private Short Srtverificatie.id;
    
    public Short Srtverificatie.getId() {
        return this.id;
    }
    
    public void Srtverificatie.setId(Short id) {
        this.id = id;
    }
    
}
