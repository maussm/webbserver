package se.mau.webbserver.entity.tk.activity;

import se.mau.webbserver.entity.tk.service.Service;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Fourth layer of the service-catalogue
 */

@Entity
@Table (name = "tk_activity")
public class TKActivity implements Serializable {
    @EmbeddedId
    private TKActivityId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "s_id", nullable = false, referencedColumnName = "id", insertable = false, updatable = false)
    private Service s;

    @Column(name = "id", nullable = false)
    private Integer internalId;

    @Column(name = "id_ext")
    private Long idExt;

    @Column(name = "type_id")
    private Long typeId;

    public TKActivityId getId() {
        return id;
    }

    public void setId(TKActivityId id) {
        this.id = id;
    }

    public Service getS() {
        return s;
    }

    public void setS(Service s) {
        this.s = s;
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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}
