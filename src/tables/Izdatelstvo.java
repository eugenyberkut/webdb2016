package tables;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Created by Yevhen on 19.01.2016.
 */
@Entity
public class Izdatelstvo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "nazvanie", nullable = false, length = 100)
    private String nazvanie;

    @Basic
    @Column(name = "adres", nullable = true, length = 200)
    private String adres;

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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Izdatelstvo that = (Izdatelstvo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nazvanie, that.nazvanie) &&
                Objects.equals(adres, that.adres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazvanie, adres);
    }

    @ManyToMany(mappedBy = "izdatelstvoList")
    private List<City> cities;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
