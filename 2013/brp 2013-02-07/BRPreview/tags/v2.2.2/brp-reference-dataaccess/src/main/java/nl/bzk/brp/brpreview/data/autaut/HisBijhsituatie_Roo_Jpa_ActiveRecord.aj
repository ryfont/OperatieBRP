// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.autaut;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.brpreview.data.autaut.HisBijhsituatie;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HisBijhsituatie_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager HisBijhsituatie.entityManager;
    
    public static final EntityManager HisBijhsituatie.entityManager() {
        EntityManager em = new HisBijhsituatie().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long HisBijhsituatie.countHisBijhsituaties() {
        return entityManager().createQuery("SELECT COUNT(o) FROM HisBijhsituatie o", Long.class).getSingleResult();
    }
    
    public static List<HisBijhsituatie> HisBijhsituatie.findAllHisBijhsituaties() {
        return entityManager().createQuery("SELECT o FROM HisBijhsituatie o", HisBijhsituatie.class).getResultList();
    }
    
    public static HisBijhsituatie HisBijhsituatie.findHisBijhsituatie(Long id) {
        if (id == null) return null;
        return entityManager().find(HisBijhsituatie.class, id);
    }
    
    public static List<HisBijhsituatie> HisBijhsituatie.findHisBijhsituatieEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM HisBijhsituatie o", HisBijhsituatie.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void HisBijhsituatie.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void HisBijhsituatie.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            HisBijhsituatie attached = HisBijhsituatie.findHisBijhsituatie(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void HisBijhsituatie.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void HisBijhsituatie.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public HisBijhsituatie HisBijhsituatie.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        HisBijhsituatie merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
