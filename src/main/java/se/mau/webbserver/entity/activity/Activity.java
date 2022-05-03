package se.mau.webbserver.entity.activity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "reported_date")
    private Date reportedDate;
    @Column (name = "occurrence_date")
    private Date occurrenceDate;
    @Column (name = "cost_center")
    private Long costCenterId;
    @Column (name = "activity_id")
    private Long activityID;
    @Column (name = "participants")
    private Long nbrOfParticipants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(Date reportedDate) {
        this.reportedDate = reportedDate;
    }

    public Date getOccurrenceDate() {
        return occurrenceDate;
    }

    public void setOccurrenceDate(Date occurrenceDate) {
        this.occurrenceDate = occurrenceDate;
    }

    public Long getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(Long costCenterId) {
        this.costCenterId = costCenterId;
    }

    public Long getActivityID() {
        return activityID;
    }

    public void setActivityID(Long activityID) {
        this.activityID = activityID;
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
        return Objects.equals(id, activity.id) && Objects.equals(reportedDate, activity.reportedDate) && Objects.equals(occurrenceDate, activity.occurrenceDate) && Objects.equals(costCenterId, activity.costCenterId) && Objects.equals(activityID, activity.activityID) && Objects.equals(nbrOfParticipants, activity.nbrOfParticipants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reportedDate, occurrenceDate, costCenterId, activityID, nbrOfParticipants);
    }
}
