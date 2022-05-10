package se.mau.webbserver.entity.tk.activity;

import se.mau.webbserver.entity.activity.Activity;
import se.mau.webbserver.entity.tk.alias.Alias;
import se.mau.webbserver.entity.tk.service.Service;
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
 * Fourth layer of the service-catalogue
 */

@Entity
@Table (name = "tk_activity")
public class TKActivity {
    @EmbeddedId
    private TKActivityId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "s_id", nullable = false, referencedColumnName = "id")
    private Service s;

    @Column(name = "id", nullable = false)
    private Integer internalId;

    @Column(name = "id_ext")
    private Long idExt;

    @MapsId("sId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "s_id")
    private Service service;

    @OneToMany(mappedBy = "TKActivity")
    private Set<Alias> tkAliases = new LinkedHashSet<>();

    @OneToMany(mappedBy = "activity")
    private Set<Activity> activities = new LinkedHashSet<>();

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Set<Alias> getTkAliases() {
        return tkAliases;
    }

    public void setTkAliases(Set<Alias> tkAliases) {
        this.tkAliases = tkAliases;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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

    public Service getS() {
        return s;
    }

    public void setS(Service s) {
        this.s = s;
    }

    public TKActivityId getId() {
        return id;
    }

    public void setId(TKActivityId id) {
        this.id = id;
    }
}
