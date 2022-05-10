package se.mau.webbserver.entity.activity;


import se.mau.webbserver.entity.activity_contents.ActivityContents;
import se.mau.webbserver.entity.cost_center.CostCenter;
import se.mau.webbserver.entity.tk.activity.TKActivity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "reported_date", nullable = false)
    private LocalDate reportedDate;

    @Column(name = "occurrence_date", nullable = false)
    private LocalDate occurrenceDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cost_center", nullable = false)
    private CostCenter costCenter;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "activity_id", nullable = false, referencedColumnName = "id")
    private TKActivity tkActivity;

    @Column(name = "participants")
    private Integer participants;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_id")
    private TKActivity activity;

    @OneToMany(mappedBy = "activity")
    private Set<ActivityContents> activityContents = new LinkedHashSet<>();

    public Set<ActivityContents> getActivityContents() {
        return activityContents;
    }

    public void setActivityContents(Set<ActivityContents> activityContents) {
        this.activityContents = activityContents;
    }

    public TKActivity getActivity() {
        return activity;
    }

    public void setActivity(TKActivity activity) {
        this.activity = activity;
    }

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    public TKActivity getTkActivity() {
        return tkActivity;
    }

    public void setTkActivity(TKActivity activity) {
        this.tkActivity = activity;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
    }

    public LocalDate getOccurrenceDate() {
        return occurrenceDate;
    }

    public void setOccurrenceDate(LocalDate occurrenceDate) {
        this.occurrenceDate = occurrenceDate;
    }

    public LocalDate getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(LocalDate reportedDate) {
        this.reportedDate = reportedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
