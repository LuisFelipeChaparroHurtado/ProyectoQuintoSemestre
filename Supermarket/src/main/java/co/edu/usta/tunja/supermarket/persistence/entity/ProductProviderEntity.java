package co.edu.usta.tunja.supermarket.persistence.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT_PROVIDER")

public class ProductProviderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_provider", nullable = false)
    private Integer id;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "bar_code", length = 45, nullable = false)
    private String bar_code;

    @Column(name = "fk_id_product")
    private Integer fkIdProduct;

    @Column(name = "fk_id_provider")
    private Integer fkIdProvider;

    @ManyToOne
    @JoinColumn(name = "fk_id_product", insertable = false, updatable = false)
    private ProductEntity fkProduct;

    @ManyToOne
    @JoinColumn(name = "fk_id_provider", insertable = false, updatable = false)
    private ProviderEntity fkProviderEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getBar_code() {
        return bar_code;
    }

    public void setBar_code(String bar_code) {
        this.bar_code = bar_code;
    }

    public Integer getFkIdProduct() {
        return fkIdProduct;
    }

    public void setFkIdProduct(Integer fkIdProduct) {
        this.fkIdProduct = fkIdProduct;
    }

    public Integer getFkIdProvider() {
        return fkIdProvider;
    }

    public void setFkIdProvider(Integer fkIdProvider) {
        this.fkIdProvider = fkIdProvider;
    }

    public ProductEntity getFkProduct() {
        return fkProduct;
    }

    public void setFkProduct(ProductEntity fkProduct) {
        this.fkProduct = fkProduct;
    }

    public ProviderEntity getFkProviderEntity() {
        return fkProviderEntity;
    }

    public void setFkProviderEntity(ProviderEntity fkProviderEntity) {
        this.fkProviderEntity = fkProviderEntity;
    }

    @Override
    public String toString() {
        return "ProductProviderEntity{" + "bar_code=" + bar_code + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.stock);
        hash = 83 * hash + Objects.hashCode(this.bar_code);
        hash = 83 * hash + Objects.hashCode(this.fkIdProduct);
        hash = 83 * hash + Objects.hashCode(this.fkIdProvider);
        hash = 83 * hash + Objects.hashCode(this.fkProduct);
        hash = 83 * hash + Objects.hashCode(this.fkProviderEntity);
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
        final ProductProviderEntity other = (ProductProviderEntity) obj;
        if (!Objects.equals(this.bar_code, other.bar_code)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.stock, other.stock)) {
            return false;
        }
        if (!Objects.equals(this.fkIdProduct, other.fkIdProduct)) {
            return false;
        }
        if (!Objects.equals(this.fkIdProvider, other.fkIdProvider)) {
            return false;
        }
        if (!Objects.equals(this.fkProduct, other.fkProduct)) {
            return false;
        }
        if (!Objects.equals(this.fkProviderEntity, other.fkProviderEntity)) {
            return false;
        }
        return true;
    }
    
    
    

}
