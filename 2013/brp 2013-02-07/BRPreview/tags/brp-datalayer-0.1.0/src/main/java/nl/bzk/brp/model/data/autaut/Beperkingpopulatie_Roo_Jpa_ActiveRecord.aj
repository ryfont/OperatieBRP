// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.autaut;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.model.data.autaut.Beperkingpopulatie;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Beperkingpopulatie_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Beperkingpopulatie.entityManager;
    
    public static final EntityManager Beperkingpopulatie.entityManager() {
        EntityManager em = new Beperkingpopulatie().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Beperkingpopulatie.countBeperkingpopulaties() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Beperkingpopulatie o", Long.class).getSingleResult();
    }
    
    public static List<Beperkingpopulatie> Beperkingpopulatie.findAllBeperkingpopulaties() {
        return entityManager().createQuery("SELECT o FROM Beperkingpopulatie o", Beperkingpopulatie.class).getResultList();
    }
    
    public static Beperkingpopulatie Beperkingpopulatie.findBeperkingpopulatie(Short id) {
        if (id == null) return null;
        return entityManager().find(Beperkingpopulatie.class, id);
    }
    
    public static List<Beperkingpopulatie> Beperkingpopulatie.findBeperkingpopulatieEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Beperkingpopulatie o", Beperkingpopulatie.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Beperkingpopulatie.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Beperkingpopulatie.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Beperkingpopulatie attached = Beperkingpopulatie.findBeperkingpopulatie(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Beperkingpopulatie.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Beperkingpopulatie.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Beperkingpopulatie Beperkingpopulatie.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Beperkingpopulatie merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
