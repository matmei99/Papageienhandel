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
public class PillFacade {
    @PersistenceContext
    EntityManager em;

    public void create(Pill a){
        em.persist(a);
    }

    public List<Pill> getPills()
    {
        TypedQuery<Pill> pillTypedQuery = em.createQuery("select p from Pill p",Pill.class);
        return pillTypedQuery.getResultList();
    }
}