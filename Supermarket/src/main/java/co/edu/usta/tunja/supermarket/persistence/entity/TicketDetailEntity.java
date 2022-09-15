package co.edu.usta.tunja.supermarket.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TICKET_DETAIL")

public class TicketDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket_detail", nullable = false)
    private Integer id;

    @Column(name = "amount", nullable = false)
    private Float amount;

    @Column(name = "devolution_request", nullable = false)
    private Date devolution_request;

    @Column(name = "devolution_approved", nullable = false)
    private Date devolution_approved;

    @Column(name = "description_devolution", length = 45, nullable = false)
    private String description_devolution;
    
    @Column(name = "fk_id_tax_price_product")
    private Integer fkIdTaxPriceProduct;
    
    @Column(name = "fk_id_ticket")
    private Integer fkIdTicketProduct;
    
    @Column(name = "fk_id_person_administrator")
    private Integer fkIdAdminPerson;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_tax_price_product", insertable = false, updatable = false)
    private TaxPriceProductEntity fkTaxPriceProduct;

    @ManyToOne
    @JoinColumn(name = "fk_id_ticket", insertable = false, updatable = false)
    private TicketEntity fkTicketProduct;

    @ManyToOne
    @JoinColumn(name = "fk_id_person_administrator", insertable = false, updatable = false)
    private PersonEntity fkAdminPerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getDevolution_request() {
        return devolution_request;
    }

    public void setDevolution_request(Date devolution_request) {
        this.devolution_request = devolution_request;
    }

    public Date getDevolution_approved() {
        return devolution_approved;
    }

    public void setDevolution_approved(Date devolution_approved) {
        this.devolution_approved = devolution_approved;
    }

    public String getDescription_devolution() {
        return description_devolution;
    }

    public void setDescription_devolution(String description_devolution) {
        this.description_devolution = description_devolution;
    }

    public Integer getFkIdTaxPriceProduct() {
        return fkIdTaxPriceProduct;
    }

    public void setFkIdTaxPriceProduct(Integer fkIdTaxPriceProduct) {
        this.fkIdTaxPriceProduct = fkIdTaxPriceProduct;
    }

    public Integer getFkIdTicketProduct() {
        return fkIdTicketProduct;
    }

    public void setFkIdTicketProduct(Integer fkIdTicketProduct) {
        this.fkIdTicketProduct = fkIdTicketProduct;
    }

    public Integer getFkIdAdminPerson() {
        return fkIdAdminPerson;
    }

    public void setFkIdAdminPerson(Integer fkIdAdminPerson) {
        this.fkIdAdminPerson = fkIdAdminPerson;
    }

    public TaxPriceProductEntity getFkTaxPriceProduct() {
        return fkTaxPriceProduct;
    }

    public void setFkTaxPriceProduct(TaxPriceProductEntity fkTaxPriceProduct) {
        this.fkTaxPriceProduct = fkTaxPriceProduct;
    }

    public TicketEntity getFkTicketProduct() {
        return fkTicketProduct;
    }

    public void setFkTicketProduct(TicketEntity fkTicketProduct) {
        this.fkTicketProduct = fkTicketProduct;
    }

    public PersonEntity getFkAdminPerson() {
        return fkAdminPerson;
    }

    public void setFkAdminPerson(PersonEntity fkAdminPerson) {
        this.fkAdminPerson = fkAdminPerson;
    }

    
    
    @Override
    public String toString() {
        String prdName = fkTaxPriceProduct.getFkPriceProduct().getFkProductProvider().getFkProduct().getProduct_name();
        Float price = fkTaxPriceProduct.getFkPriceProduct().getSale_price();
        Float tax = fkTaxPriceProduct.getFkTax().getTax_value();
        Float total = amount * (price * (1 + tax));
        String prueba = fkAdminPerson.getPerson_first_name();
        return "Nombre producto: " + prdName
                + ", Cantidad: " + amount
                + ", Precio: " + price
                + ", Precio: " + tax
              + ", Total: "+total;
         
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.amount);
        hash = 67 * hash + Objects.hashCode(this.devolution_request);
        hash = 67 * hash + Objects.hashCode(this.devolution_approved);
        hash = 67 * hash + Objects.hashCode(this.description_devolution);
        hash = 67 * hash + Objects.hashCode(this.fkIdTaxPriceProduct);
        hash = 67 * hash + Objects.hashCode(this.fkIdTicketProduct);
        hash = 67 * hash + Objects.hashCode(this.fkIdAdminPerson);
        hash = 67 * hash + Objects.hashCode(this.fkTaxPriceProduct);
        hash = 67 * hash + Objects.hashCode(this.fkTicketProduct);
        hash = 67 * hash + Objects.hashCode(this.fkAdminPerson);
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
        final TicketDetailEntity other = (TicketDetailEntity) obj;
        if (!Objects.equals(this.description_devolution, other.description_devolution)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        if (!Objects.equals(this.devolution_request, other.devolution_request)) {
            return false;
        }
        if (!Objects.equals(this.devolution_approved, other.devolution_approved)) {
            return false;
        }
        if (!Objects.equals(this.fkIdTaxPriceProduct, other.fkIdTaxPriceProduct)) {
            return false;
        }
        if (!Objects.equals(this.fkIdTicketProduct, other.fkIdTicketProduct)) {
            return false;
        }
        if (!Objects.equals(this.fkIdAdminPerson, other.fkIdAdminPerson)) {
            return false;
        }
        if (!Objects.equals(this.fkTaxPriceProduct, other.fkTaxPriceProduct)) {
            return false;
        }
        if (!Objects.equals(this.fkTicketProduct, other.fkTicketProduct)) {
            return false;
        }
        if (!Objects.equals(this.fkAdminPerson, other.fkAdminPerson)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
    

}
