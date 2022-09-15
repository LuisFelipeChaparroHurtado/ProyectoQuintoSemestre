package co.edu.usta.tunja.supermarket.persistence.entity;

import co.edu.usta.tunja.supermarket.persistence.entity.PriceProductEntity;
import co.edu.usta.tunja.supermarket.persistence.entity.TaxEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-23T17:39:42")
@StaticMetamodel(TaxPriceProductEntity.class)
public class TaxPriceProductEntity_ { 

    public static volatile SingularAttribute<TaxPriceProductEntity, Integer> fkIdPriceProduct;
    public static volatile SingularAttribute<TaxPriceProductEntity, TaxEntity> fkTax;
    public static volatile SingularAttribute<TaxPriceProductEntity, Integer> id;
    public static volatile SingularAttribute<TaxPriceProductEntity, PriceProductEntity> fkPriceProduct;
    public static volatile SingularAttribute<TaxPriceProductEntity, Integer> fkIdTax;

}