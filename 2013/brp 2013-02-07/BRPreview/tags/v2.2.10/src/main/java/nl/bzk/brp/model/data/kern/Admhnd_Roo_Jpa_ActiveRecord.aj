// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.model.data.kern.Admhnd;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Admhnd_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Admhnd.entityManager;
    
    public static final EntityManager Admhnd.entityManager() {
        EntityManager em = new Admhnd().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Admhnd.countAdmhnds() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Admhnd o", Long.class).getSingleResult();
    }
    
    public static List<Admhnd> Admhnd.findAllAdmhnds() {
        return entityManager().createQuery("SELECT o FROM Admhnd o", Admhnd.class).getResultList();
    }
    
    public static Admhnd Admhnd.findAdmhnd(Long id) {
        if (id == null) return null;
        return entityManager().find(Admhnd.class, id);
    }
    
    public static List<Admhnd> Admhnd.findAdmhndEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Admhnd o", Admhnd.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Admhnd.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Admhnd.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Admhnd attached = Admhnd.findAdmhnd(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Admhnd.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Admhnd.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Admhnd Admhnd.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Admhnd merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
