// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.model.data.kern.Srtadmhnd;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Srtadmhnd_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Srtadmhnd.entityManager;
    
    public static final EntityManager Srtadmhnd.entityManager() {
        EntityManager em = new Srtadmhnd().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Srtadmhnd.countSrtadmhnds() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Srtadmhnd o", Long.class).getSingleResult();
    }
    
    public static List<Srtadmhnd> Srtadmhnd.findAllSrtadmhnds() {
        return entityManager().createQuery("SELECT o FROM Srtadmhnd o", Srtadmhnd.class).getResultList();
    }
    
    public static Srtadmhnd Srtadmhnd.findSrtadmhnd(Short id) {
        if (id == null) return null;
        return entityManager().find(Srtadmhnd.class, id);
    }
    
    public static List<Srtadmhnd> Srtadmhnd.findSrtadmhndEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Srtadmhnd o", Srtadmhnd.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Srtadmhnd.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Srtadmhnd.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Srtadmhnd attached = Srtadmhnd.findSrtadmhnd(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Srtadmhnd.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Srtadmhnd.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Srtadmhnd Srtadmhnd.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Srtadmhnd merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
