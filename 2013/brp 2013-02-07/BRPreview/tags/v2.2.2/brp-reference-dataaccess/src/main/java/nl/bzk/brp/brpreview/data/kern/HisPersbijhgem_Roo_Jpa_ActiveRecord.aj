// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.brpreview.data.kern.HisPersbijhgem;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HisPersbijhgem_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager HisPersbijhgem.entityManager;
    
    public static final EntityManager HisPersbijhgem.entityManager() {
        EntityManager em = new HisPersbijhgem().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long HisPersbijhgem.countHisPersbijhgems() {
        return entityManager().createQuery("SELECT COUNT(o) FROM HisPersbijhgem o", Long.class).getSingleResult();
    }
    
    public static List<HisPersbijhgem> HisPersbijhgem.findAllHisPersbijhgems() {
        return entityManager().createQuery("SELECT o FROM HisPersbijhgem o", HisPersbijhgem.class).getResultList();
    }
    
    public static HisPersbijhgem HisPersbijhgem.findHisPersbijhgem(Long id) {
        if (id == null) return null;
        return entityManager().find(HisPersbijhgem.class, id);
    }
    
    public static List<HisPersbijhgem> HisPersbijhgem.findHisPersbijhgemEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM HisPersbijhgem o", HisPersbijhgem.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void HisPersbijhgem.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void HisPersbijhgem.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            HisPersbijhgem attached = HisPersbijhgem.findHisPersbijhgem(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void HisPersbijhgem.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void HisPersbijhgem.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public HisPersbijhgem HisPersbijhgem.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        HisPersbijhgem merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
