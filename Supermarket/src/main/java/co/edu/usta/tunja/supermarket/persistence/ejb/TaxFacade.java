/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarket.persistence.ejb;

import co.edu.usta.tunja.supermarket.persistence.entity.TaxEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TaxFacade extends Abstract<TaxEntity>{
    
    @PersistenceContext(unitName="supermarketpu")
    private EntityManager _em;
    

    @Override
    protected EntityManager getAdminEntidad() {
        return this._em;
    }
    
    public TaxFacade(){
        super(TaxEntity.class);
    }
    
}