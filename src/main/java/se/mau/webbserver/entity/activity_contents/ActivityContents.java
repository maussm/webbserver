package se.mau.webbserver.entity.activity_contents;

import se.mau.webbserver.entity.activity.Activity;
import se.mau.webbserver.entity.participant.Participant;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "activity_contents")
@IdClass(ActivityContents.class)
public class ActivityContents implements Serializable {
    @EmbeddedId
    private ActivityContentsId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "activity_id", nullable = false, insertable = false, updatable = false)
    private Activity activityId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participant_id", nullable = false, insertable = false, updatable = false)
    private Participant participantId;

    @GeneratedValue()
    @Column(name = "id", nullable = false)
    private Integer internalId;

    public ActivityContentsId getId() {
        return id;
    }

    public void setId(ActivityContentsId id) {
        this.id = id;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public void setActivityId(Activity activity) {
        this.activityId = activity;
    }

    public Participant getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Participant participant) {
        this.participantId = participant;
    }

    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer id) {
        this.internalId = id;
    }
}
