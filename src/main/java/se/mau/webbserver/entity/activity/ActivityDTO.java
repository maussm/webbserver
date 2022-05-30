package se.mau.webbserver.entity.activity;

import java.time.LocalDate;

public class ActivityDTO {
    private Integer id;
    private LocalDate reported_date;
    private LocalDate occurrence_date;
    private Integer cost_center_id;
    private Integer tk_activity_id;
    private Integer participants;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getReportedDate() {
        return reported_date;
    }

    public void setReportedDate(LocalDate reportedDate) {
        this.reported_date = reportedDate;
    }

    public LocalDate getOccurrenceDate() {
        return occurrence_date;
    }

    public void setOccurrenceDate(LocalDate occurrenceDate) {
        this.occurrence_date = occurrenceDate;
    }

    public Integer getCostCenterId() {
        return cost_center_id;
    }

    public void setCostCenterId(Integer costCenterId) {
        this.cost_center_id = costCenterId;
    }

    public Integer getTkActivityId() {
        return tk_activity_id;
    }

    public void setTkActivityId(Integer tkActivityId) {
        this.tk_activity_id = tkActivityId;
    }

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }
}
