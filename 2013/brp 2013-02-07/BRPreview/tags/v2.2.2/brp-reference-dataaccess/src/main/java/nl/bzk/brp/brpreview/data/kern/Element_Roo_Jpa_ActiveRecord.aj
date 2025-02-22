// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.bzk.brp.brpreview.data.kern.Element;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Element_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Element.entityManager;
    
    public static final EntityManager Element.entityManager() {
        EntityManager em = new Element().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Element.countElements() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Element o", Long.class).getSingleResult();
    }
    
    public static List<Element> Element.findAllElements() {
        return entityManager().createQuery("SELECT o FROM Element o", Element.class).getResultList();
    }
    
    public static Element Element.findElement(Integer id) {
        if (id == null) return null;
        return entityManager().find(Element.class, id);
    }
    
    public static List<Element> Element.findElementEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Element o", Element.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Element.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Element.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Element attached = Element.findElement(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Element.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Element.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Element Element.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Element merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
