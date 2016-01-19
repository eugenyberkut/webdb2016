package beans;

import tables.Avtor;
import tables.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Yevhen on 19.01.2016.
 */
@Stateless
public class BookService {
    @PersistenceContext
    EntityManager em;

    public List<Book> findAll() {
        return em.createNamedQuery("Book.findAll").getResultList();
    }

    public Avtor findById(Integer avtorId) {
        return em.find(Avtor.class, avtorId);
    }
}
