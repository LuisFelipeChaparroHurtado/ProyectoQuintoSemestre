package co.edu.usta.tunja.supermarket.persistence.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")

public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false)
    private Integer id;

    @Column(name = "product_name", length = 45, nullable = false)
    private String product_name;

    @Column(name = "fk_id_product_type")
    private Integer fkIdProductType;

    @ManyToOne
    @JoinColumn(name = "fk_id_product_type", insertable = false, updatable = false)
    private ProductTypeEntity fkProductType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public ProductTypeEntity getFkProductType() {
        return fkProductType;
    }

    public void setFkProductType(ProductTypeEntity fkProductType) {
        this.fkProductType = fkProductType;
    }

    public Integer getFkIdProductType() {
        return fkIdProductType;
    }

    public void setFkIdProductType(Integer fkIdProductType) {
        this.fkIdProductType = fkIdProductType;
    }

    @Override
    public String toString() {
        return "ProductEntity{" + "product_name=" + product_name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.product_name);
        hash = 97 * hash + Objects.hashCode(this.fkProductType);
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
        final ProductEntity other = (ProductEntity) obj;
        if (!Objects.equals(this.product_name, other.product_name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fkProductType, other.fkProductType)) {
            return false;
        }
        return true;
    }

    
    
    

}
