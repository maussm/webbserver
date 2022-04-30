package se.mau.webbserver.entity.participant;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Participant {
    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Participant participant)) return false;
        return Objects.equals(id, participant.id) && Objects.equals(name, participant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
