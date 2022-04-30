package se.mau.webbserver.entity.cost_center;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table
public class CostCenter {
    @Id
    private Long id;
    private String name;
    private String locaiton;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocaiton() {
        return locaiton;
    }

    public void setLocaiton(String locaiton) {
        this.locaiton = locaiton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof CostCenter that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(locaiton, that.locaiton);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, locaiton);
    }
}
