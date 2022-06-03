package se.mau.webbserver.entity.tk.alias;

/**
 * En wrapper klass som används av REST APIt. Klassen översätts till entity klasserna av programmet.
 */
public class AliasDTO {
    private Integer cost_center_id;
    private Integer activity_id;
    private String definition;
    private Integer id_ext;

    public Integer getCost_center_id() {
        return cost_center_id;
    }

    public void setCost_center_id(Integer cost_center_id) {
        this.cost_center_id = cost_center_id;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Integer getId_ext() {
        return id_ext;
    }

    public void setId_ext(Integer id_ext) {
        this.id_ext = id_ext;
    }
}
