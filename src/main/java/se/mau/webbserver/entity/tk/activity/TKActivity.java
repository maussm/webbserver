package se.mau.webbserver.entity.tk.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Fourth layer of the service-catalogue
 */

@Entity
@Table (name = "tk_activity")
public class TKActivity {
    @Id @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type_id")
    private Long typeId;

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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof TKActivity activity)) return false;
        return Objects.equals(name, activity.name) && Objects.equals(typeId, activity.typeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, typeId);
    }
}
