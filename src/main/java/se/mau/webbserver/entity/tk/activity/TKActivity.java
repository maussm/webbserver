package se.mau.webbserver.entity.tk.activity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Fourth layer of the service-catalogue
 *
 */

@Entity
@Table (name = "tk_activity")
public class TKActivity {
    @Id
    private String name;
    private String activityType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof TKActivity activity)) return false;
        return Objects.equals(name, activity.name) && Objects.equals(activityType, activity.activityType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, activityType);
    }
}
