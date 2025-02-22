// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.model.data.kern.HisVerstrderde;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HisVerstrderde_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager HisVerstrderde.entityManager;
    
    public static final EntityManager HisVerstrderde.entityManager() {
        EntityManager em = new HisVerstrderde().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long HisVerstrderde.countHisVerstrderdes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM HisVerstrderde o", Long.class).getSingleResult();
    }
    
    public static List<HisVerstrderde> HisVerstrderde.findAllHisVerstrderdes() {
        return entityManager().createQuery("SELECT o FROM HisVerstrderde o", HisVerstrderde.class).getResultList();
    }
    
    public static HisVerstrderde HisVerstrderde.findHisVerstrderde(Integer id) {
        if (id == null) return null;
        return entityManager().find(HisVerstrderde.class, id);
    }
    
    public static List<HisVerstrderde> HisVerstrderde.findHisVerstrderdeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM HisVerstrderde o", HisVerstrderde.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void HisVerstrderde.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void HisVerstrderde.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            HisVerstrderde attached = HisVerstrderde.findHisVerstrderde(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void HisVerstrderde.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void HisVerstrderde.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public HisVerstrderde HisVerstrderde.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        HisVerstrderde merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
