// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.brpreview.data.kern.Verblijfsr;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Verblijfsr_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Verblijfsr.entityManager;
    
    public static final EntityManager Verblijfsr.entityManager() {
        EntityManager em = new Verblijfsr().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Verblijfsr.countVerblijfsrs() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Verblijfsr o", Long.class).getSingleResult();
    }
    
    public static List<Verblijfsr> Verblijfsr.findAllVerblijfsrs() {
        return entityManager().createQuery("SELECT o FROM Verblijfsr o", Verblijfsr.class).getResultList();
    }
    
    public static Verblijfsr Verblijfsr.findVerblijfsr(Short id) {
        if (id == null) return null;
        return entityManager().find(Verblijfsr.class, id);
    }
    
    public static List<Verblijfsr> Verblijfsr.findVerblijfsrEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Verblijfsr o", Verblijfsr.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Verblijfsr.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Verblijfsr.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Verblijfsr attached = Verblijfsr.findVerblijfsr(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Verblijfsr.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Verblijfsr.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Verblijfsr Verblijfsr.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Verblijfsr merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
