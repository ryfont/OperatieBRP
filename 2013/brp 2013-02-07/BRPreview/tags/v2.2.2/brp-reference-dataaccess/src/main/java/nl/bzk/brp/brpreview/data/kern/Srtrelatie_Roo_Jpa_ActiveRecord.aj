// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.brpreview.data.kern.Srtrelatie;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Srtrelatie_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Srtrelatie.entityManager;
    
    public static final EntityManager Srtrelatie.entityManager() {
        EntityManager em = new Srtrelatie().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Srtrelatie.countSrtrelaties() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Srtrelatie o", Long.class).getSingleResult();
    }
    
    public static List<Srtrelatie> Srtrelatie.findAllSrtrelaties() {
        return entityManager().createQuery("SELECT o FROM Srtrelatie o", Srtrelatie.class).getResultList();
    }
    
    public static Srtrelatie Srtrelatie.findSrtrelatie(Short id) {
        if (id == null) return null;
        return entityManager().find(Srtrelatie.class, id);
    }
    
    public static List<Srtrelatie> Srtrelatie.findSrtrelatieEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Srtrelatie o", Srtrelatie.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Srtrelatie.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Srtrelatie.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Srtrelatie attached = Srtrelatie.findSrtrelatie(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Srtrelatie.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Srtrelatie.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Srtrelatie Srtrelatie.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Srtrelatie merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
