package beans;

import tables.Avtor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Yevhen on 19.01.2016.
 */
@Stateless
public class AvtorService {
    @PersistenceContext
    EntityManager em;

    public List<Avtor> findAll() {
        return em.createNamedQuery("Avtor.findAll").getResultList();
    }

    public void createAvtor(String name, String comment) {
        Avtor avtor = new Avtor(name, comment);
        em.persist(avtor);
    }

    public Avtor findAvtorByName(String avtorname) {
        Query avtorByName = em.createNamedQuery("Avtor.byName");
        avtorByName.setParameter("avtorName", avtorname);
        List<Avtor> avtorByNameResultList = avtorByName.getResultList();
        if (avtorByNameResultList.size()==0) {
            return new Avtor("not found","");
        } else return avtorByNameResultList.get(0);
    }
}
