// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.lev;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import nl.bzk.brp.brpreview.data.lev.Abonnement;

privileged aspect Abonnement_Roo_Jpa_Entity {
    
    declare @type: Abonnement: @Entity;
    
    declare @type: Abonnement: @Table(schema = "lev", name = "abonnement");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "serial")
    private Integer Abonnement.id;
    
    public Integer Abonnement.getId() {
        return this.id;
    }
    
    public void Abonnement.setId(Integer id) {
        this.id = id;
    }
    
}
