package se.mau.webbserver.entity.tk.service;

import se.mau.webbserver.entity.tk.activity.TKActivity;
import se.mau.webbserver.entity.tk.category.Category;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Second layer of the service catalogue
 */

@Entity
@Table(name = "tk_service")
public class Service {
    @EmbeddedId
    private ServiceId id;

    @MapsId()
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "c_id", nullable = false)
    private Category c;

    @Column(name = "id", nullable = false)
    private Integer internalId;

    @Column(name = "id_ext")
    private Long idExt;

    @OneToMany(mappedBy = "service")
    private Set<TKActivity> tkActivities = new LinkedHashSet<>();

    // public Service(ServiceId serviceId) {
    //     this.id = serviceId;
    // }

    public Set<TKActivity> getTkActivities() {
        return tkActivities;
    }

    public void setTkActivities(Set<TKActivity> tkActivities) {
        this.tkActivities = tkActivities;
    }

    public Long getIdExt() {
        return idExt;
    }

    public void setIdExt(Long idExt) {
        this.idExt = idExt;
    }

    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer id1) {
        this.internalId = id1;
    }

    public Category getC() {
        return c;
    }

    public void setC(Category c) {
        this.c = c;
    }

    public ServiceId getId() {
        return id;
    }

    public void setId(ServiceId id) {
        this.id = id;
    }
}
