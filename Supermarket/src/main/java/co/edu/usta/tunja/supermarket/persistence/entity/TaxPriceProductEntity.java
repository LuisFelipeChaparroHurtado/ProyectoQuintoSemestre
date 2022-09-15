package co.edu.usta.tunja.supermarket.persistence.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TAX_PRICE_PRODUCT")

public class TaxPriceProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tax_price_product", nullable = false)
    private Integer id;

    @Column(name = "fk_id_price_product")
    private Integer fkIdPriceProduct;
    
    @Column(name = "fk_id_tax")
    private Integer fkIdTax;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_price_product", insertable = false, updatable = false)
    private PriceProductEntity fkPriceProduct;

    @ManyToOne
    @JoinColumn(name = "fk_id_tax", insertable = false, updatable = false)
    private TaxEntity fkTax;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkIdPriceProduct() {
        return fkIdPriceProduct;
    }

    public void setFkIdPriceProduct(Integer fkIdPriceProduct) {
        this.fkIdPriceProduct = fkIdPriceProduct;
    }

    public Integer getFkIdTax() {
        return fkIdTax;
    }

    public void setFkIdTax(Integer fkIdTax) {
        this.fkIdTax = fkIdTax;
    }

    public PriceProductEntity getFkPriceProduct() {
        return fkPriceProduct;
    }

    public void setFkPriceProduct(PriceProductEntity fkPriceProduct) {
        this.fkPriceProduct = fkPriceProduct;
    }

    public TaxEntity getFkTax() {
        return fkTax;
    }

    public void setFkTax(TaxEntity fkTax) {
        this.fkTax = fkTax;
    }

    
    
    
    @Override
    public String toString() {
        return "TaxPriceProductEntity{" + "id=" + id + ", fkTaxPriceProduct=" + fkPriceProduct + ", fkTax=" + fkTax + ", ticketDetailEntityList=" + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.fkIdPriceProduct);
        hash = 47 * hash + Objects.hashCode(this.fkIdTax);
        hash = 47 * hash + Objects.hashCode(this.fkPriceProduct);
        hash = 47 * hash + Objects.hashCode(this.fkTax);
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
        final TaxPriceProductEntity other = (TaxPriceProductEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fkIdPriceProduct, other.fkIdPriceProduct)) {
            return false;
        }
        if (!Objects.equals(this.fkIdTax, other.fkIdTax)) {
            return false;
        }
        if (!Objects.equals(this.fkPriceProduct, other.fkPriceProduct)) {
            return false;
        }
        if (!Objects.equals(this.fkTax, other.fkTax)) {
            return false;
        }
        return true;
    }

    

    
    
    

    
    
}
