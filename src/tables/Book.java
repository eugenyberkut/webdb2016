package tables;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Yevhen on 19.01.2016.
 */
@NamedQuery(name = "Book.findAll", query = "select b from Book b")
@Entity
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nazvanie;
    private Integer pages;

    @ManyToOne(optional = false)
    private Avtor avtor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(nazvanie, book.nazvanie) &&
                Objects.equals(pages, book.pages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazvanie, pages);
    }


    public Avtor getAvtor() {
        return avtor;
    }

    public void setAvtor(Avtor avtor) {
        this.avtor = avtor;
    }
}
