package se.mau.webbserver.entity.activity_contents;

import se.mau.webbserver.entity.activity.Activity;
import se.mau.webbserver.entity.participant.Participant;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "activity_contents")
public class ActivityContents implements Serializable {
    @EmbeddedId
    private ActivityContentsId id;

    @MapsId("activityId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    @MapsId("participantId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participant_id", nullable = false)
    private Participant participant;

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "activity_contents_id_seq")
    @SequenceGenerator(name = "activity_contents_id_seq", sequenceName = "activity_contents_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer internalId;

    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer internalId) {
        this.internalId = internalId;
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
