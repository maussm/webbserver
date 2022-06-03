package se.mau.webbserver.entity.tk.service;

/**
 * En wrapper klass som används av REST APIt. Klassen översätts till entity klasserna av programmet.
 */
public class ServiceDTO {
    private String name;
    private Integer cost_center_id;
    private Integer id_ext;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost_center_id() {
        return cost_center_id;
    }

    public void setCost_center_id(Integer cost_center_id) {
        this.cost_center_id = cost_center_id;
    }

    public Integer getId_ext() {
        return id_ext;
    }

    public void setId_ext(Integer id_ext) {
        this.id_ext = id_ext;
    }
}
