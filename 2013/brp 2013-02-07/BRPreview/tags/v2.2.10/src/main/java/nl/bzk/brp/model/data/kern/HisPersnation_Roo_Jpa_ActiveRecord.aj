// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.model.data.kern.HisPersnation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HisPersnation_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager HisPersnation.entityManager;
    
    public static final EntityManager HisPersnation.entityManager() {
        EntityManager em = new HisPersnation().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long HisPersnation.countHisPersnations() {
        return entityManager().createQuery("SELECT COUNT(o) FROM HisPersnation o", Long.class).getSingleResult();
    }
    
    public static List<HisPersnation> HisPersnation.findAllHisPersnations() {
        return entityManager().createQuery("SELECT o FROM HisPersnation o", HisPersnation.class).getResultList();
    }
    
    public static HisPersnation HisPersnation.findHisPersnation(Integer id) {
        if (id == null) return null;
        return entityManager().find(HisPersnation.class, id);
    }
    
    public static List<HisPersnation> HisPersnation.findHisPersnationEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM HisPersnation o", HisPersnation.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void HisPersnation.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void HisPersnation.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            HisPersnation attached = HisPersnation.findHisPersnation(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void HisPersnation.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void HisPersnation.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public HisPersnation HisPersnation.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        HisPersnation merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
