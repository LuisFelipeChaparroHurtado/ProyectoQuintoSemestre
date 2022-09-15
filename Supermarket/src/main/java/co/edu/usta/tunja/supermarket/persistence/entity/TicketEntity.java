package co.edu.usta.tunja.supermarket.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TICKET")

public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket", nullable = false)
    private Integer id;

    @Column(name = "ticket_date", nullable = false)
    private Date ticket_date;

    @Column(name = "half_payment", length = 15, precision = 2, nullable = false)
    private Float haif_payment;

    @Column(name = "fk_id_person_cashier")
    private Integer fkIdCashierPerson;

    @Column(name = "fk_id_person_customer")
    private Integer fkIdCustomerPerson;

    @ManyToOne
    @JoinColumn(name = "fk_id_person_cashier", insertable = false, updatable = false)
    private PersonEntity fkCashierPerson;

    @ManyToOne
    @JoinColumn(name = "fk_id_person_customer", insertable = false, updatable = false)
    private PersonEntity fkCustomerPerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTicket_date() {
        return ticket_date;
    }

    public void setTicket_date(Date ticket_date) {
        this.ticket_date = ticket_date;
    }

    public Float getHaif_payment() {
        return haif_payment;
    }

    public void setHaif_payment(Float haif_payment) {
        this.haif_payment = haif_payment;
    }

    public Integer getFkIdCashierPerson() {
        return fkIdCashierPerson;
    }

    public void setFkIdCashierPerson(Integer fkIdCashierPerson) {
        this.fkIdCashierPerson = fkIdCashierPerson;
    }

    public Integer getFkIdCustomerPerson() {
        return fkIdCustomerPerson;
    }

    public void setFkIdCustomerPerson(Integer fkIdCustomerPerson) {
        this.fkIdCustomerPerson = fkIdCustomerPerson;
    }

    public PersonEntity getFkCashierPerson() {
        return fkCashierPerson;
    }

    public void setFkCashierPerson(PersonEntity fkCashierPerson) {
        this.fkCashierPerson = fkCashierPerson;
    }

    public PersonEntity getFkCustomerPerson() {
        return fkCustomerPerson;
    }

    public void setFkCustomerPerson(PersonEntity fkCustomerPerson) {
        this.fkCustomerPerson = fkCustomerPerson;
    }

    @Override
    public String toString() {
        String cashierName = fkCashierPerson.getPerson_first_name() + " " + fkCashierPerson.getPerson_last_name();
        String customerInfo = fkCustomerPerson.getPerson_first_name() + "" + fkCustomerPerson.getPerson_last_name() + ", DNI: " + fkCustomerPerson.getDni();
        return "Date: " + ticket_date + ", CashierPerson:" + fkCashierPerson + ", ClientPerson=" + cashierName + "Customer Info: " + customerInfo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.ticket_date);
        hash = 29 * hash + Objects.hashCode(this.haif_payment);
        hash = 29 * hash + Objects.hashCode(this.fkIdCashierPerson);
        hash = 29 * hash + Objects.hashCode(this.fkIdCustomerPerson);
        hash = 29 * hash + Objects.hashCode(this.fkCashierPerson);
        hash = 29 * hash + Objects.hashCode(this.fkCustomerPerson);
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
        final TicketEntity other = (TicketEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.ticket_date, other.ticket_date)) {
            return false;
        }
        if (!Objects.equals(this.haif_payment, other.haif_payment)) {
            return false;
        }
        if (!Objects.equals(this.fkIdCashierPerson, other.fkIdCashierPerson)) {
            return false;
        }
        if (!Objects.equals(this.fkIdCustomerPerson, other.fkIdCustomerPerson)) {
            return false;
        }
        if (!Objects.equals(this.fkCashierPerson, other.fkCashierPerson)) {
            return false;
        }
        if (!Objects.equals(this.fkCustomerPerson, other.fkCustomerPerson)) {
            return false;
        }
        return true;
    }

}
