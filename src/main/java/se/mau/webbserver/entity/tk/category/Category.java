package se.mau.webbserver.entity.tk.category;

import org.hibernate.annotations.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * First layer of the service catalogue.
 * En entity klass som mappar mot tabellen category.
 */
@Entity
@Table(name = "tk_category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tk_category_id_generator")
    @SequenceGenerator(name = "tk_category_id_generator", sequenceName = "tk_category_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "id_ext")
    private Long idExt;

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

    public Long getIdExt() {
        return idExt;
    }

    public void setIdExt(Long idExt) {
        this.idExt = idExt;
    }
}
