package co.edu.usta.tunja.supermarket.persistence.entity;

import co.edu.usta.tunja.supermarket.persistence.entity.PersonEntity;
import co.edu.usta.tunja.supermarket.persistence.entity.TaxPriceProductEntity;
import co.edu.usta.tunja.supermarket.persistence.entity.TicketEntity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-23T17:39:42")
@StaticMetamodel(TicketDetailEntity.class)
public class TicketDetailEntity_ { 

    public static volatile SingularAttribute<TicketDetailEntity, Float> amount;
    public static volatile SingularAttribute<TicketDetailEntity, String> description_devolution;
    public static volatile SingularAttribute<TicketDetailEntity, TicketEntity> fkTicketProduct;
    public static volatile SingularAttribute<TicketDetailEntity, Integer> fkIdAdminPerson;
    public static volatile SingularAttribute<TicketDetailEntity, Integer> fkIdTicketProduct;
    public static volatile SingularAttribute<TicketDetailEntity, TaxPriceProductEntity> fkTaxPriceProduct;
    public static volatile SingularAttribute<TicketDetailEntity, PersonEntity> fkAdminPerson;
    public static volatile SingularAttribute<TicketDetailEntity, Integer> fkIdTaxPriceProduct;
    public static volatile SingularAttribute<TicketDetailEntity, Date> devolution_request;
    public static volatile SingularAttribute<TicketDetailEntity, Integer> id;
    public static volatile SingularAttribute<TicketDetailEntity, Date> devolution_approved;

}