package co.edu.usta.tunja.supermarket.persistence.entity;

import co.edu.usta.tunja.supermarket.persistence.entity.ProductEntity;
import co.edu.usta.tunja.supermarket.persistence.entity.ProviderEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-11-23T17:39:42")
@StaticMetamodel(ProductProviderEntity.class)
public class ProductProviderEntity_ { 

    public static volatile SingularAttribute<ProductProviderEntity, ProductEntity> fkProduct;
    public static volatile SingularAttribute<ProductProviderEntity, String> bar_code;
    public static volatile SingularAttribute<ProductProviderEntity, Integer> fkIdProvider;
    public static volatile SingularAttribute<ProductProviderEntity, Integer> id;
    public static volatile SingularAttribute<ProductProviderEntity, Integer> stock;
    public static volatile SingularAttribute<ProductProviderEntity, Integer> fkIdProduct;
    public static volatile SingularAttribute<ProductProviderEntity, ProviderEntity> fkProviderEntity;

}