package se.mau.webbserver.entity.tk.alias;

import se.mau.webbserver.entity.cost_center.CostCenter;
import se.mau.webbserver.entity.tk.activity.TKActivity;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Alias for cost-centers various definitions of the fourth layer of the service catalogue
 */

@Entity
@Table(name = "tk_alias")
public class Alias {
    @EmbeddedId
    private AliasId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cost_center", nullable = false)
    private CostCenter costCenter;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "activity_id", nullable = false, referencedColumnName = "id")
    private TKActivity activity;

    @Column(name = "id", nullable = false)
    private Integer internalId;

    @Column(name = "id_ext")
    private Long idExt;

    @MapsId("activityId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_id")
    private TKActivity TKActivity;

    public se.mau.webbserver.entity.tk.activity.TKActivity getTKActivity() {
        return TKActivity;
    }

    public void setTKActivity(se.mau.webbserver.entity.tk.activity.TKActivity TKActivity) {
        this.TKActivity = TKActivity;
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

    public TKActivity getActivity() {
        return activity;
    }

    public void setActivity(TKActivity activity) {
        this.activity = activity;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
    }

    public AliasId getId() {
        return id;
    }

    public void setId(AliasId id) {
        this.id = id;
    }
}
