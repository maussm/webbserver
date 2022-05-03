package se.mau.webbserver.entity.tk.alias;

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
    @Id
    private String definition;
    private Long costCenter;
    private String activityName;

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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Alias)) return false;
        Alias alias = (Alias) o;
        return Objects.equals(definition, alias.definition) && Objects.equals(costCenter, alias.costCenter) && Objects.equals(activityName, alias.activityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(definition, costCenter, activityName);
    }
}
