package co.edu.usta.tunja.supermarket.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "TAX")
public class TaxEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tax", nullable = false)
    private Integer id;

    @Column(name = "tax_value", length = 5,precision = 2,nullable = false)
    private Float tax_value;

    @Column(name = "tax_name", length = 15, nullable = false)
    private String tax_name;

    @Column(name = "creation_date", nullable = false)
    private Date creation_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTax_value() {
        return tax_value;
    }

    public void setTax_value(Float tax_value) {
        this.tax_value = tax_value;
    }

    public String getTax_name() {
        return tax_name;
    }

    public void setTax_name(String tax_name) {
        this.tax_name = tax_name;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }


    
    
    @Override
    public String toString() {
        return tax_value +"";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.tax_value);
        hash = 79 * hash + Objects.hashCode(this.tax_name);
        hash = 79 * hash + Objects.hashCode(this.creation_date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaxEntity other = (TaxEntity) obj;
        if (!Objects.equals(this.tax_name, other.tax_name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.tax_value, other.tax_value)) {
            return false;
        }
        if (!Objects.equals(this.creation_date, other.creation_date)) {
            return false;
        }
        return true;
    }

    
    
}
