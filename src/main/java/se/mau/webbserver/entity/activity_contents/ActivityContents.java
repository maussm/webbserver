package se.mau.webbserver.entity.activity_contents;

import se.mau.webbserver.entity.activity.Activity;
import se.mau.webbserver.entity.participant.Participant;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "activity_contents")
@IdClass(ActivityContents.class)
public class ActivityContents implements Serializable {

    @EmbeddedId
    private ActivityContentsId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participant_id", nullable = false)
    private Participant participant;

    @Column(name = "id", nullable = false)
    private Integer internalId;

    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer id1) {
        this.internalId = id1;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public ActivityContentsId getId() {
        return id;
    }

    public void setId(ActivityContentsId id) {
        this.id = id;
    }
}
