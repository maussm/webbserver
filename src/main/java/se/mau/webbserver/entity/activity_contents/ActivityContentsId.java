package se.mau.webbserver.entity.activity_contents;

import org.hibernate.Hibernate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ActivityContentsId implements Serializable {
    private static final long serialVersionUID = - 6797686072747520468L;
    @Column(name = "activity_id", nullable = false)
    private Integer activityId;
    @Column(name = "participant_id", nullable = false)
    private Integer participantId;

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantId, activityId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ActivityContentsId entity = (ActivityContentsId) o;
        return Objects.equals(this.participantId, entity.participantId) &&
                   Objects.equals(this.activityId, entity.activityId);
    }
}