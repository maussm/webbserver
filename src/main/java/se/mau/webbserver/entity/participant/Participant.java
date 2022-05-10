package se.mau.webbserver.entity.participant;

import se.mau.webbserver.entity.activity_contents.ActivityContents;
import se.mau.webbserver.entity.attendance.Attendance;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "participant")
    private Set<Attendance> attendances = new LinkedHashSet<>();

    @OneToMany(mappedBy = "participant")
    private Set<ActivityContents> activityContents = new LinkedHashSet<>();

    public Set<ActivityContents> getActivityContents() {
        return activityContents;
    }

    public void setActivityContents(Set<ActivityContents> activityContents) {
        this.activityContents = activityContents;
    }

    public Set<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
