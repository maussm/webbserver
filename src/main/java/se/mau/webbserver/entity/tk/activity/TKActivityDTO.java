package se.mau.webbserver.entity.tk.activity;

/**
 * En wrapper klass som används av REST APIt. Klassen översätts till entity klasserna av programmet.
 */
public class TKActivityDTO {
    private String name;
    private Integer serivce_id;
    private Integer id_ext;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSerivce_id() {
        return serivce_id;
    }

    public void setSerivce_id(Integer serivce_id) {
        this.serivce_id = serivce_id;
    }

    public Integer getId_ext() {
        return id_ext;
    }

    public void setId_ext(Integer id_ext) {
        this.id_ext = id_ext;
    }
}
