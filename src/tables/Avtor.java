package tables;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Created by Yevhen on 19.01.2016.
 */
@NamedQueries({
        @NamedQuery(name = "Avtor.findAll", query = "select a from Avtor a"),
        @NamedQuery(name = "Avtor.byName", query = "select a from Avtor a where a.name=:avtorName")
})
@Entity
public class Avtor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = true, length = 100)
    private String comment;

    @OneToMany(mappedBy = "avtor")
    private List<Book> books;

    public Avtor(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public Avtor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avtor avtor = (Avtor) o;
        return Objects.equals(id, avtor.id) &&
                Objects.equals(name, avtor.name) &&
                Objects.equals(comment, avtor.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, comment);
    }
}
