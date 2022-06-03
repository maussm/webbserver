package se.mau.webbserver.entity.tk.service;

import se.mau.webbserver.entity.tk.category.Category;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Second layer of the service catalogue.
 * En entity klass som mappar mot tabellen activity_contents.
 */
@Entity
@Table(name = "tk_service")
public class Service implements Serializable {
    @EmbeddedId
    private ServiceId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "c_id", nullable = false, insertable = false, updatable = false)
    private Category c;

    @Column(name = "id", nullable = false)
    private Integer internalId;

    @Column(name = "id_ext")
    private Long idExt;

    public ServiceId getId() {
        return id;
    }

    public void setId(ServiceId id) {
        this.id = id;
    }

    public Category getC() {
        return c;
    }

    public void setC(Category c) {
        this.c = c;
    }

    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer internalId) {
        this.internalId = internalId;
    }

    public Long getIdExt() {
        return idExt;
    }

    public void setIdExt(Long idExt) {
        this.idExt = idExt;
    }
}
