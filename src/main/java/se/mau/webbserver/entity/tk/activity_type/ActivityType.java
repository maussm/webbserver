package se.mau.webbserver.entity.tk.activity_type;

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
    @Id
    private String name;
    private String serviceType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof ActivityType that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(serviceType, that.serviceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, serviceType);
    }
}
