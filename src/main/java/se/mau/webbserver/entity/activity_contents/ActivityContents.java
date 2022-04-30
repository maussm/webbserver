package se.mau.webbserver.entity.activity_contents;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(ActivityContents.class)
public class ActivityContents implements Serializable {
    @Id
    private Long participantId;
    @Id
    private Long activityId;

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof ActivityContents)) return false;
        ActivityContents that = (ActivityContents) o;
        return Objects.equals(participantId, that.participantId) && Objects.equals(activityId, that.activityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantId, activityId);
    }
}
