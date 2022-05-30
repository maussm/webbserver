package se.mau.webbserver.entity.view;

import org.hibernate.annotations.Immutable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Immutable
@Table(name = "report_data")
public class ReportData {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "activity_name")
    private String activityName;

    @Column(name = "occurrence_date")
    private LocalDate occurrenceDate;

    @Column(name = "reported_date")
    private LocalDate reportedDate;

    @Column(name = "cost_center_name")
    private String costCenterName;

    @Column(name = "participants")
    private Integer participants;

    @Column(name = "reported_participants")
    private Long reportedParticipants;

    public Long getReportedParticipants() {
        return reportedParticipants;
    }

    public Integer getParticipants() {
        return participants;
    }

    public String getCostCenterName() {
        return costCenterName;
    }

    public LocalDate getReportedDate() {
        return reportedDate;
    }

    public LocalDate getOccurrenceDate() {
        return occurrenceDate;
    }

    public String getActivityName() {
        return activityName;
    }

    public Integer getId() {
        return id;
    }

    protected ReportData() {
    }
}
