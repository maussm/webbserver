package se.mau.webbserver.entity.tk.activity_type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Third layer of the service catalogue
 */

@Entity
@Table(name = "tk_activity_type")
public class ActivityType {
    @Id @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "s_id")
    private Long serviceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof ActivityType that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(serviceId, that.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, serviceId);
    }
}
