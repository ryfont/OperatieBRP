// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.brpreview.data.kern.HisPersverblijfsr;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HisPersverblijfsr_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager HisPersverblijfsr.entityManager;
    
    public static final EntityManager HisPersverblijfsr.entityManager() {
        EntityManager em = new HisPersverblijfsr().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long HisPersverblijfsr.countHisPersverblijfsrs() {
        return entityManager().createQuery("SELECT COUNT(o) FROM HisPersverblijfsr o", Long.class).getSingleResult();
    }
    
    public static List<HisPersverblijfsr> HisPersverblijfsr.findAllHisPersverblijfsrs() {
        return entityManager().createQuery("SELECT o FROM HisPersverblijfsr o", HisPersverblijfsr.class).getResultList();
    }
    
    public static HisPersverblijfsr HisPersverblijfsr.findHisPersverblijfsr(Long id) {
        if (id == null) return null;
        return entityManager().find(HisPersverblijfsr.class, id);
    }
    
    public static List<HisPersverblijfsr> HisPersverblijfsr.findHisPersverblijfsrEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM HisPersverblijfsr o", HisPersverblijfsr.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void HisPersverblijfsr.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void HisPersverblijfsr.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            HisPersverblijfsr attached = HisPersverblijfsr.findHisPersverblijfsr(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void HisPersverblijfsr.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void HisPersverblijfsr.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public HisPersverblijfsr HisPersverblijfsr.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        HisPersverblijfsr merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
