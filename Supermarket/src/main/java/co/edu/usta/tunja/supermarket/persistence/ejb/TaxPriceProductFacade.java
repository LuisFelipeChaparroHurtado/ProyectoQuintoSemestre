/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarket.persistence.ejb;

import co.edu.usta.tunja.supermarket.persistence.entity.TaxPriceProductEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TaxPriceProductFacade extends Abstract<TaxPriceProductEntity>{
    
    @PersistenceContext(unitName="supermarketpu")
    private EntityManager _em;
    

    @Override
    protected EntityManager getAdminEntidad() {
        return this._em;
    }
    
    public TaxPriceProductFacade(){
        super(TaxPriceProductEntity.class);
    }
    
}
