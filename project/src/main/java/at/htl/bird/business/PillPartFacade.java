package at.htl.bird.business;

import at.htl.bird.entities.Bird;
import at.htl.bird.entities.Pill;
import at.htl.bird.entities.Pillpart;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PillPartFacade {
    @PersistenceContext
    EntityManager em;

    public void create(Pillpart a){
        em.persist(a);
    }

    public List<Pillpart> getPills()
    {
        TypedQuery<Pillpart> pillTypedQuery = em.createQuery("select p from Pillpart p",Pillpart.class);
        return pillTypedQuery.getResultList();
    }

    public Pillpart getPillByBird(String birdId){
        return em.createQuery("select p from Pillpart p where p.bird.birdId = :bId",Pillpart.class).setParameter("bId",birdId).getSingleResult();
    }

    public void remove(String birdId){
        em.remove(getPillByBird(birdId));
    }
}
