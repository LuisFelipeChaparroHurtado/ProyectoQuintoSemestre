package co.edu.usta.tunja.supermarket.persistence.entity;

import co.edu.usta.tunja.supermarket.persistence.entity.ProductProviderEntity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-23T17:39:42")
@StaticMetamodel(PriceProductEntity.class)
public class PriceProductEntity_ { 

    public static volatile SingularAttribute<PriceProductEntity, Float> shop_price;
    public static volatile SingularAttribute<PriceProductEntity, String> user_update;
    public static volatile SingularAttribute<PriceProductEntity, ProductProviderEntity> fkProductProvider;
    public static volatile SingularAttribute<PriceProductEntity, Date> date_update;
    public static volatile SingularAttribute<PriceProductEntity, Integer> id;
    public static volatile SingularAttribute<PriceProductEntity, Float> sale_price;
    public static volatile SingularAttribute<PriceProductEntity, Integer> fkIdProductProvider;
    public static volatile SingularAttribute<PriceProductEntity, Date> start_date;

}