package tables;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Created by Yevhen on 19.01.2016.
 */
@Entity
public class Izdatelstvo {
    private Integer id;
    private String nazvanie;
    private String adres;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nazvanie", nullable = false, length = 100)
    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    @Basic
    @Column(name = "adres", nullable = true, length = 200)
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
}
