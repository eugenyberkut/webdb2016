package tables;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Created by Yevhen on 19.01.2016.
 */
@Entity
public class City {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToMany
    @JoinTable(name = "city_has_izdatelstvo")
    private List<Izdatelstvo> izdatelstvoList;

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

    public List<Izdatelstvo> getIzdatelstvoList() {
        return izdatelstvoList;
    }

    public void setIzdatelstvoList(List<Izdatelstvo> izdatelstvoList) {
        this.izdatelstvoList = izdatelstvoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
