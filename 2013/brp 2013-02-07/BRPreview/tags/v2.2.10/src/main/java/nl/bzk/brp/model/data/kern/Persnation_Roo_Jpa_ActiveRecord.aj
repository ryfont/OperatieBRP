// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.model.data.kern.Persnation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Persnation_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Persnation.entityManager;
    
    public static final EntityManager Persnation.entityManager() {
        EntityManager em = new Persnation().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Persnation.countPersnations() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Persnation o", Long.class).getSingleResult();
    }
    
    public static List<Persnation> Persnation.findAllPersnations() {
        return entityManager().createQuery("SELECT o FROM Persnation o", Persnation.class).getResultList();
    }
    
    public static Persnation Persnation.findPersnation(Integer id) {
        if (id == null) return null;
        return entityManager().find(Persnation.class, id);
    }
    
    public static List<Persnation> Persnation.findPersnationEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Persnation o", Persnation.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Persnation.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Persnation.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Persnation attached = Persnation.findPersnation(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Persnation.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Persnation.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Persnation Persnation.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Persnation merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
