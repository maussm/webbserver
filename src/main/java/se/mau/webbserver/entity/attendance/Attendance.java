package se.mau.webbserver.entity.attendance;

import jdk.jfr.Enabled;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Enabled
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "date")
    private Date date;
    @Column (name = "participant")
    private Long participantId;
    @Column (name = "c_id")
    private Long costCenterId;

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

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public Long getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(Long costCenterId) {
        this.costCenterId = costCenterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attendance)) return false;
        Attendance that = (Attendance) o;
        return id.equals(that.id) && date.equals(that.date) && participantId.equals(that.participantId) && costCenterId.equals(that.costCenterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, participantId, costCenterId);
    }
}
