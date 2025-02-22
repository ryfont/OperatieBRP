// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.autaut;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.model.data.autaut.HisUitgeslotene;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HisUitgeslotene_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager HisUitgeslotene.entityManager;
    
    public static final EntityManager HisUitgeslotene.entityManager() {
        EntityManager em = new HisUitgeslotene().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long HisUitgeslotene.countHisUitgeslotenes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM HisUitgeslotene o", Long.class).getSingleResult();
    }
    
    public static List<HisUitgeslotene> HisUitgeslotene.findAllHisUitgeslotenes() {
        return entityManager().createQuery("SELECT o FROM HisUitgeslotene o", HisUitgeslotene.class).getResultList();
    }
    
    public static HisUitgeslotene HisUitgeslotene.findHisUitgeslotene(Integer id) {
        if (id == null) return null;
        return entityManager().find(HisUitgeslotene.class, id);
    }
    
    public static List<HisUitgeslotene> HisUitgeslotene.findHisUitgesloteneEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM HisUitgeslotene o", HisUitgeslotene.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void HisUitgeslotene.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void HisUitgeslotene.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            HisUitgeslotene attached = HisUitgeslotene.findHisUitgeslotene(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void HisUitgeslotene.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void HisUitgeslotene.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public HisUitgeslotene HisUitgeslotene.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        HisUitgeslotene merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
