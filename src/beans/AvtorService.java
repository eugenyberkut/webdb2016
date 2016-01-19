package beans;

import tables.Avtor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
