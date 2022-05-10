package se.mau.webbserver.entity.cost_center;

import se.mau.webbserver.entity.activity.Activity;
import se.mau.webbserver.entity.attendance.Attendance;
import se.mau.webbserver.entity.tk.alias.Alias;
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
@Table(name = "cost_center")
public class CostCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "costCenter")
    private Set<Alias> tkAliases = new LinkedHashSet<>();

    @OneToMany(mappedBy = "c")
    private Set<Attendance> attendances = new LinkedHashSet<>();

    @OneToMany(mappedBy = "costCenter")
    private Set<Activity> activities = new LinkedHashSet<>();

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Set<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }

    public Set<Alias> getTkAliases() {
        return tkAliases;
    }

    public void setTkAliases(Set<Alias> tkAliases) {
        this.tkAliases = tkAliases;
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
