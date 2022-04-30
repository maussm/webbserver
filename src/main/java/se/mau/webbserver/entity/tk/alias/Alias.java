package se.mau.webbserver.entity.tk.alias;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Alias {
    @Id
    private String name;
    private Long costCenter;
    private String activityName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Objects.equals(name, alias.name) && Objects.equals(costCenter, alias.costCenter) && Objects.equals(activityName, alias.activityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, costCenter, activityName);
    }
}
