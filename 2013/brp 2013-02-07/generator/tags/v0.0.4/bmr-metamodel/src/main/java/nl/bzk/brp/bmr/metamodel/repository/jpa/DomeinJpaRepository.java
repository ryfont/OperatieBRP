/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.bmr.metamodel.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nl.bzk.brp.bmr.metamodel.Domein;
import nl.bzk.brp.bmr.metamodel.repository.DomeinRepository;

import org.springframework.stereotype.Repository;


/**
 * Abstracte superclasse voor alle JPA repositories van de BMR generator.
 */
@Repository("domeinRepository")
public class DomeinJpaRepository implements DomeinRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Domein> findAll() {
        return em.createQuery("select d from Domein d", Domein.class).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Domein findByNaam(final String naam) {
        return em.createQuery("select d from Domein d where naam = :naam", Domein.class).setParameter("naam", naam)
                .getSingleResult();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
