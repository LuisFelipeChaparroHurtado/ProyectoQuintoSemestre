package co.edu.usta.tunja.supermarket.persistence.entity;

import co.edu.usta.tunja.supermarket.persistence.entity.PersonEntity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-23T17:39:42")
@StaticMetamodel(TicketEntity.class)
public class TicketEntity_ { 

    public static volatile SingularAttribute<TicketEntity, PersonEntity> fkCashierPerson;
    public static volatile SingularAttribute<TicketEntity, Integer> fkIdCashierPerson;
    public static volatile SingularAttribute<TicketEntity, Date> ticket_date;
    public static volatile SingularAttribute<TicketEntity, PersonEntity> fkCustomerPerson;
    public static volatile SingularAttribute<TicketEntity, Integer> fkIdCustomerPerson;
    public static volatile SingularAttribute<TicketEntity, Integer> id;
    public static volatile SingularAttribute<TicketEntity, Float> haif_payment;

}