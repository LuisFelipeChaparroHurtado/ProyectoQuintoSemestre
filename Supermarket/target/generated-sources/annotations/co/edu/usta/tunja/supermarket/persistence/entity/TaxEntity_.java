package co.edu.usta.tunja.supermarket.persistence.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-23T17:39:42")
@StaticMetamodel(TaxEntity.class)
public class TaxEntity_ { 

    public static volatile SingularAttribute<TaxEntity, Float> tax_value;
    public static volatile SingularAttribute<TaxEntity, String> tax_name;
    public static volatile SingularAttribute<TaxEntity, Integer> id;
    public static volatile SingularAttribute<TaxEntity, Date> creation_date;

}