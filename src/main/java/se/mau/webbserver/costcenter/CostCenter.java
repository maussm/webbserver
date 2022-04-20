package se.mau.webbserver.costcenter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class CostCenter {
    @Id
    @SequenceGenerator(
            name = "cost_center_seq",
            sequenceName = "cost_center_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cost_center_seq"
    )
    private Long id;
    private String centerName;
    private String centerCategory;

    public CostCenter() {
    }

    public CostCenter(String centerName, String centerCategory) {
        this.centerName = centerName;
        this.centerCategory = centerCategory;
    }

    public CostCenter(Long id, String centerName, String centerCategory) {
        this.id = id;
        this.centerName = centerName;
        this.centerCategory = centerCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterCategory() {
        return centerCategory;
    }

    public void setCenterCategory(String centerCategory) {
        this.centerCategory = centerCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CostCenter that = (CostCenter) o;
        return Objects.equals(id, that.id) && Objects.equals(centerName, that.centerName) && Objects.equals(centerCategory, that.centerCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, centerName, centerCategory);
    }
}
