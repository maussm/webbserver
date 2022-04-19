package se.mau.webbserver.activity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Activity {
    @Id
    @SequenceGenerator(
        name = "activity_seq",
        sequenceName = "activity_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "activity_seq"
    )
    private Long id;
    private LocalDate date;
    private LocalDate reported;
    private String costCenter;
    private String activityId;
    private Integer nrOfParticipants;

    public Activity() {
    }

    public Activity(LocalDate date, LocalDate reported, String costCenter, String activityId, Integer nrOfParticipants) {
        this.date = date;
        this.reported = reported;
        this.costCenter = costCenter;
        this.activityId = activityId;
        this.nrOfParticipants = nrOfParticipants;
    }

    public Activity(Long id, LocalDate date, LocalDate reported, String costCenter, String activityId, Integer nrOfParticipants) {
        this.id = id;
        this.date = date;
        this.reported = reported;
        this.costCenter = costCenter;
        this.activityId = activityId;
        this.nrOfParticipants = nrOfParticipants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getReported() {
        return reported;
    }

    public void setReported(LocalDate reported) {
        this.reported = reported;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public Integer getNrOfParticipants() {
        return nrOfParticipants;
    }

    public void setNrOfParticipants(Integer nrOfParticipants) {
        this.nrOfParticipants = nrOfParticipants;
    }
}
