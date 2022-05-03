package se.mau.webbserver.entity.tk.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Second layer of the service catalogue
 */

@Entity
@Table(name = "tk_service")
public class Service {
    @Id @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "c_id")
    private Long categoryId;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
