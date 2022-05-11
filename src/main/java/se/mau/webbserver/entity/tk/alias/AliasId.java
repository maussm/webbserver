package se.mau.webbserver.entity.tk.alias;

import org.hibernate.Hibernate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Lob;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AliasId implements Serializable {
    private static final long serialVersionUID = - 6152512980519210746L;
    @Column(name = "cost_center", nullable = false)
    private Integer costCenter;
    @Column(name = "activity_id", nullable = false)
    private Integer activityId;
    @Lob
    @Column(name = "definition", nullable = false)
    private String definition;

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(Integer costCenter) {
        this.costCenter = costCenter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId, costCenter, definition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AliasId entity = (AliasId) o;
        return Objects.equals(this.activityId, entity.activityId) &&
                   Objects.equals(this.costCenter, entity.costCenter) &&
                   Objects.equals(this.definition, entity.definition);
    }
}
