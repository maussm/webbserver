package se.mau.webbserver.entity.activity;

import java.time.LocalDate;

public class ActivityDTO {
    private Integer id;
    private LocalDate reportedDate;
    private LocalDate occurrenceDate;
    private Integer costCenterId;
    private Integer tkActivityId;
    private Integer participants;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(LocalDate reportedDate) {
        this.reportedDate = reportedDate;
    }

    public LocalDate getOccurrenceDate() {
        return occurrenceDate;
    }

    public void setOccurrenceDate(LocalDate occurrenceDate) {
        this.occurrenceDate = occurrenceDate;
    }

    public Integer getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(Integer costCenterId) {
        this.costCenterId = costCenterId;
    }

    public Integer getTkActivityId() {
        return tkActivityId;
    }

    public void setTkActivityId(Integer tkActivityId) {
        this.tkActivityId = tkActivityId;
    }

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }
}
