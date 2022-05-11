package se.mau.webbserver.entity.tk.activity;

import org.hibernate.Hibernate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Lob;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TKActivityId implements Serializable {
    private static final long serialVersionUID = - 4266712122611447255L;
    @Lob
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "s_id", nullable = false)
    private Integer sId;

    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TKActivityId entity = (TKActivityId) o;
        return Objects.equals(this.name, entity.name) &&
                   Objects.equals(this.sId, entity.sId);
    }
}
