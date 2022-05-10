package se.mau.webbserver.entity.tk.category;

import se.mau.webbserver.entity.tk.service.Service;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * First layer of the service catalogue
 */

@Entity
@Table(name = "tk_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "id_ext")
    private Long idExt;

    @OneToMany(mappedBy = "c")
    private Set<Service> tkServices = new LinkedHashSet<>();

    public Set<Service> getTkServices() {
        return tkServices;
    }

    public void setTkServices(Set<Service> tkServices) {
        this.tkServices = tkServices;
    }

    public Long getIdExt() {
        return idExt;
    }

    public void setIdExt(Long idExt) {
        this.idExt = idExt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
