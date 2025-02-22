// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.model.data.kern.HisPersimmigratie;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HisPersimmigratie_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager HisPersimmigratie.entityManager;
    
    public static final EntityManager HisPersimmigratie.entityManager() {
        EntityManager em = new HisPersimmigratie().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long HisPersimmigratie.countHisPersimmigraties() {
        return entityManager().createQuery("SELECT COUNT(o) FROM HisPersimmigratie o", Long.class).getSingleResult();
    }
    
    public static List<HisPersimmigratie> HisPersimmigratie.findAllHisPersimmigraties() {
        return entityManager().createQuery("SELECT o FROM HisPersimmigratie o", HisPersimmigratie.class).getResultList();
    }
    
    public static HisPersimmigratie HisPersimmigratie.findHisPersimmigratie(Long id) {
        if (id == null) return null;
        return entityManager().find(HisPersimmigratie.class, id);
    }
    
    public static List<HisPersimmigratie> HisPersimmigratie.findHisPersimmigratieEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM HisPersimmigratie o", HisPersimmigratie.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void HisPersimmigratie.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void HisPersimmigratie.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            HisPersimmigratie attached = HisPersimmigratie.findHisPersimmigratie(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void HisPersimmigratie.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void HisPersimmigratie.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public HisPersimmigratie HisPersimmigratie.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        HisPersimmigratie merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
