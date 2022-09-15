package co.edu.usta.tunja.supermarket.persistence.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "PRODUCT_TYPE")
public class ProductTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_type", nullable = false)
    private Integer id;

    @Column(name = "product_type_name", length = 45, nullable = false)
    private String product_type_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_type_name() {
        return product_type_name;
    }

    public void setProduct_type_name(String product_type_name) {
        this.product_type_name = product_type_name;
    }

    @Override
    public String toString() {
        return product_type_name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.product_type_name);
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
        final ProductTypeEntity other = (ProductTypeEntity) obj;
        if (!Objects.equals(this.product_type_name, other.product_type_name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}



