package co.edu.usta.tunja.supermarket.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRICE_PRODUCT")

public class PriceProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_price_product", nullable = false)
    private Integer id;

    @Column(name = "sale_price", length = 13,precision = 2,nullable = false)
    private Float sale_price;

    @Column(name = "shop_price",  length = 13,precision = 2,nullable = false)
    private Float shop_price;

    @Column(name = "start_date", nullable = false)
    private Date start_date;

    @Column(name = "user_update", length = 40, nullable = false)
    private String user_update;

    @Column(name = "date_update", nullable = false)
    private Date date_update;
    
    @Column(name = "fk_id_product_provider")
    private Integer fkIdProductProvider;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_product_provider", insertable = false, updatable = false)
    private ProductProviderEntity fkProductProvider;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getSale_price() {
        return sale_price;
    }

    public void setSale_price(Float sale_price) {
        this.sale_price = sale_price;
    }

    public Float getShop_price() {
        return shop_price;
    }

    public void setShop_price(Float shop_price) {
        this.shop_price = shop_price;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getUser_update() {
        return user_update;
    }

    public void setUser_update(String user_update) {
        this.user_update = user_update;
    }

    public Date getDate_update() {
        return date_update;
    }

    public void setDate_update(Date date_update) {
        this.date_update = date_update;
    }

    public Integer getFkIdProductProvider() {
        return fkIdProductProvider;
    }

    public void setFkIdProductProvider(Integer fkIdProductProvider) {
        this.fkIdProductProvider = fkIdProductProvider;
    }

    public ProductProviderEntity getFkProductProvider() {
        return fkProductProvider;
    }

    public void setFkProductProvider(ProductProviderEntity fkProductProvider) {
        this.fkProductProvider = fkProductProvider;
    }

    
    
    
    
    @Override
    public String toString() {
        return sale_price+"";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.sale_price);
        hash = 83 * hash + Objects.hashCode(this.shop_price);
        hash = 83 * hash + Objects.hashCode(this.start_date);
        hash = 83 * hash + Objects.hashCode(this.user_update);
        hash = 83 * hash + Objects.hashCode(this.date_update);
        hash = 83 * hash + Objects.hashCode(this.fkIdProductProvider);
        hash = 83 * hash + Objects.hashCode(this.fkProductProvider);
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
        final PriceProductEntity other = (PriceProductEntity) obj;
        if (!Objects.equals(this.user_update, other.user_update)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.sale_price, other.sale_price)) {
            return false;
        }
        if (!Objects.equals(this.shop_price, other.shop_price)) {
            return false;
        }
        if (!Objects.equals(this.start_date, other.start_date)) {
            return false;
        }
        if (!Objects.equals(this.date_update, other.date_update)) {
            return false;
        }
        if (!Objects.equals(this.fkIdProductProvider, other.fkIdProductProvider)) {
            return false;
        }
        if (!Objects.equals(this.fkProductProvider, other.fkProductProvider)) {
            return false;
        }
        return true;
    }

    
    
    
}
