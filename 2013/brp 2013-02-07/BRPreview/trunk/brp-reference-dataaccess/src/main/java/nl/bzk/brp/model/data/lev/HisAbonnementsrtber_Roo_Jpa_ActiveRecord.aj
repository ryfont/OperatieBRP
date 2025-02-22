// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.lev;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.model.data.lev.HisAbonnementsrtber;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HisAbonnementsrtber_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager HisAbonnementsrtber.entityManager;
    
    public static final EntityManager HisAbonnementsrtber.entityManager() {
        EntityManager em = new HisAbonnementsrtber().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long HisAbonnementsrtber.countHisAbonnementsrtbers() {
        return entityManager().createQuery("SELECT COUNT(o) FROM HisAbonnementsrtber o", Long.class).getSingleResult();
    }
    
    public static List<HisAbonnementsrtber> HisAbonnementsrtber.findAllHisAbonnementsrtbers() {
        return entityManager().createQuery("SELECT o FROM HisAbonnementsrtber o", HisAbonnementsrtber.class).getResultList();
    }
    
    public static HisAbonnementsrtber HisAbonnementsrtber.findHisAbonnementsrtber(Integer id) {
        if (id == null) return null;
        return entityManager().find(HisAbonnementsrtber.class, id);
    }
    
    public static List<HisAbonnementsrtber> HisAbonnementsrtber.findHisAbonnementsrtberEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM HisAbonnementsrtber o", HisAbonnementsrtber.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void HisAbonnementsrtber.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void HisAbonnementsrtber.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            HisAbonnementsrtber attached = HisAbonnementsrtber.findHisAbonnementsrtber(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void HisAbonnementsrtber.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void HisAbonnementsrtber.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public HisAbonnementsrtber HisAbonnementsrtber.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        HisAbonnementsrtber merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
