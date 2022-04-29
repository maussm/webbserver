package se.mau.webbserver.entity.participant;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Participant {
    @Id
    @SequenceGenerator(
            name = "participent_seq",
            sequenceName = "participent_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "participent_seq"
    )
    private Long id;
    private String name;

    public Participant(){
    }

    public Participant(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
