// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.ber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.brpreview.data.ber.Bijhresultaat;

privileged aspect Bijhresultaat_Roo_Jpa_Entity {
    
    declare @type: Bijhresultaat: @Entity;
    
    declare @type: Bijhresultaat: @Table(schema = "ber", name = "bijhresultaat");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int2")
    private Short Bijhresultaat.id;
    
    public Short Bijhresultaat.getId() {
        return this.id;
    }
    
    public void Bijhresultaat.setId(Short id) {
        this.id = id;
    }
    
}
