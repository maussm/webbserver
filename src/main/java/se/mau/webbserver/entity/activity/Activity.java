package se.mau.webbserver.entity.activity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Activity {
    @Id
    private Long id;
    private Date date;
    private Date occurrence;
    private Long costCenterId;
    private String activityName;
    private Long nbrOfParticipants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Date occurrence) {
        this.occurrence = occurrence;
    }

    public Long getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(Long costCenterId) {
        this.costCenterId = costCenterId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Long getNbrOfParticipants() {
        return nbrOfParticipants;
    }

    public void setNbrOfParticipants(Long nbrOfParticipants) {
        this.nbrOfParticipants = nbrOfParticipants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Activity)) return false;
        Activity activity = (Activity) o;
        return Objects.equals(id, activity.id) && Objects.equals(date, activity.date) && Objects.equals(occurrence, activity.occurrence) && Objects.equals(costCenterId, activity.costCenterId) && Objects.equals(activityName, activity.activityName) && Objects.equals(nbrOfParticipants, activity.nbrOfParticipants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, occurrence, costCenterId, activityName, nbrOfParticipants);
    }
}
