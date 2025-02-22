// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.model.data.kern.Voorvoegsel;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Voorvoegsel_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Voorvoegsel.entityManager;
    
    public static final EntityManager Voorvoegsel.entityManager() {
        EntityManager em = new Voorvoegsel().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Voorvoegsel.countVoorvoegsels() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Voorvoegsel o", Long.class).getSingleResult();
    }
    
    public static List<Voorvoegsel> Voorvoegsel.findAllVoorvoegsels() {
        return entityManager().createQuery("SELECT o FROM Voorvoegsel o", Voorvoegsel.class).getResultList();
    }
    
    public static Voorvoegsel Voorvoegsel.findVoorvoegsel(Short id) {
        if (id == null) return null;
        return entityManager().find(Voorvoegsel.class, id);
    }
    
    public static List<Voorvoegsel> Voorvoegsel.findVoorvoegselEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Voorvoegsel o", Voorvoegsel.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Voorvoegsel.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Voorvoegsel.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Voorvoegsel attached = Voorvoegsel.findVoorvoegsel(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Voorvoegsel.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Voorvoegsel.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Voorvoegsel Voorvoegsel.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Voorvoegsel merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
