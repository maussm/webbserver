package se.mau.webbserver.entity.tk.alias;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Alias for cost-centers various definitions of the fourth layer of the service catalogue
 */

@Entity
@Table(name = "tk_alias")
public class Alias {
    @Id @Column(name = "definition")
    private String definition;
    @Column(name = "cost_center")
    private Long costCenter;
    @Column(name = "activity_id")
    private Long activityReference;

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Long getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(Long costCenter) {
        this.costCenter = costCenter;
    }

    public Long getActivityReference() {
        return activityReference;
    }

    public void setActivityReference(Long activityReference) {
        this.activityReference = activityReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Alias)) return false;
        Alias alias = (Alias) o;
        return Objects.equals(definition, alias.definition) && Objects.equals(costCenter, alias.costCenter) && Objects.equals(activityReference, alias.activityReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(definition, costCenter, activityReference);
    }
}
