package at.htl.bird.business;

import at.htl.bird.entities.Bird;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class BirdFacade {
    @PersistenceContext
    EntityManager em;

    public void create(Bird a){
        em.persist(a);
    }

    public List<Bird> getBirds()
    {
        TypedQuery<Bird> birdTypedQuery = em.createQuery("select b from Bird b",Bird.class);
        return birdTypedQuery.getResultList();
    }

    public void update(Bird b){
        em.merge(b);
    }
}

