// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.autaut;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.brpreview.data.autaut.HisDoelbinding;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HisDoelbinding_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager HisDoelbinding.entityManager;
    
    public static final EntityManager HisDoelbinding.entityManager() {
        EntityManager em = new HisDoelbinding().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long HisDoelbinding.countHisDoelbindings() {
        return entityManager().createQuery("SELECT COUNT(o) FROM HisDoelbinding o", Long.class).getSingleResult();
    }
    
    public static List<HisDoelbinding> HisDoelbinding.findAllHisDoelbindings() {
        return entityManager().createQuery("SELECT o FROM HisDoelbinding o", HisDoelbinding.class).getResultList();
    }
    
    public static HisDoelbinding HisDoelbinding.findHisDoelbinding(Long id) {
        if (id == null) return null;
        return entityManager().find(HisDoelbinding.class, id);
    }
    
    public static List<HisDoelbinding> HisDoelbinding.findHisDoelbindingEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM HisDoelbinding o", HisDoelbinding.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void HisDoelbinding.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void HisDoelbinding.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            HisDoelbinding attached = HisDoelbinding.findHisDoelbinding(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void HisDoelbinding.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void HisDoelbinding.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public HisDoelbinding HisDoelbinding.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        HisDoelbinding merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
