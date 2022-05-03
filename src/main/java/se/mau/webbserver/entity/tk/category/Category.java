package se.mau.webbserver.entity.tk.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * First layer of the service catalogue
 */

@Entity
@Table(name = "tk_category")
public class Category {
    @Id @Column (name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

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
}
