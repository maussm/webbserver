package se.mau.webbserver.entity.participant;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_generator", sequenceName = "participant_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "uno_code", nullable = false)
    private String unoCode;

    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "spoken_language")
    private String spokenLanguage;

    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "country")
    private String country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnoCode() {
        return unoCode;
    }

    public void setUnoCode(String unoCode) {
        this.unoCode = unoCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSpokenLanguage() {
        return spokenLanguage;
    }

    public void setSpokenLanguage(String spokenLanguage) {
        this.spokenLanguage = spokenLanguage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
