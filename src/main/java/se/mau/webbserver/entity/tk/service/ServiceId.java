package se.mau.webbserver.entity.tk.service;

import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.io.Serializable;
import java.util.Objects;

/**
 * En klass som används internt av programmet.
 */
@Embeddable
public class ServiceId implements Serializable {
    private static final long serialVersionUID = - 8847516353489218073L;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "c_id", nullable = false)
    private Integer cId;

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ServiceId entity = (ServiceId) o;
        return Objects.equals(this.name, entity.name) &&
                   Objects.equals(this.cId, entity.cId);
    }
}
