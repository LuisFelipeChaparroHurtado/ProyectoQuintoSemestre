/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarketwebapp.controller;

import co.edu.usta.tunja.supermarket.persistence.ejb.ProductProviderFacade;
import co.edu.usta.tunja.supermarket.persistence.entity.ProductProviderEntity;
import co.edu.usta.tunja.supermarketwebapp.utility.Message;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author USUARIO
 */
@Named(value = "productProviderController")
@RequestScoped
public class ProductProviderController implements Serializable {

    @EJB
    private ProductProviderFacade _ejbFacade;
    private ProductProviderEntity _objActual;
    
    private Integer fkIdProd;
    private Integer fkIdProvid;

    public ProductProviderController() {
    }

    public Integer getFkIdProd() {
        return fkIdProd;
    }

    public void setFkIdProd(Integer fkIdProd) {
        this.fkIdProd = fkIdProd;
    }

    public Integer getFkIdProvid() {
        return fkIdProvid;
    }

    public void setFkIdProvid(Integer fkIdProvid) {
        this.fkIdProvid = fkIdProvid;
    }
    
    
    
    public ProductProviderEntity getCampo() {
        if (this._objActual == null) {
            this._objActual = new ProductProviderEntity();

        }
        return this._objActual;

    }

    public ProductProviderFacade getFacade() {
        return this._ejbFacade;
    }

    public String grabarProductProvider() {
        String texto, detalle;
        try {

            texto = "Exito";
            this._objActual.setFkIdProduct(getFkIdProd());
            this._objActual.setFkIdProvider(getFkIdProvid());
            //detalle = ResourceBundle.getBundle("/com/usta/clases/utility/txtdepartamentos").getString(texto);
            detalle = "El departamento se creo con exito";
            getFacade().grabar(this._objActual);
            Message.exito(texto, detalle);
            return "listProductProvider";
        } catch (Exception e) {
            texto = "Error";
            e.printStackTrace();
            //Mensajes.error(texto, detalle);
            return "createProductProvider";

        }
    }

    public String deleteProductProvider(ProductProviderEntity productProviderEntity) {
        this._objActual = productProviderEntity;
        String text, detail;
        try {
            text = "Delete success";
            detail = "Detele product provider in the data base.";
            Message.exito(text, detail);
            getFacade().borrar(this._objActual);
            return "listProductProvider";
        } catch (Exception e) {
            text = "Delete error";
            detail = e.getMessage();
            Message.error(text, detail);
            return "listProductProvider";
        }
    }
    
    
    public String cargarID(Integer id) {
        _objActual = getFacade().search(id);
        Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sesionMap.put("productProvider", _objActual);
        return "updateProductProvider";
    }

    public String updateProductProvider() {

        String texto, detail;
        try {
            texto = "Actualizado con exito";
            this._objActual.setFkIdProduct(getFkIdProd());
            this._objActual.setFkIdProvider(getFkIdProvid());
            detail = "Actualizado";
            Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            _objActual.setId(((ProductProviderEntity) sesionMap.get("productProvider")).getId());
            getFacade().update(_objActual);
            Message.exito(texto, detail);
            return "listProductProvider";
        } catch (Exception e) {
            texto = "Error";
            detail = "Error";
            Message.error(texto, detail);
            return "updateProductProvider";
        }
    }

    public List<ProductProviderEntity> getProductProviderListado() {
        return getFacade().listar();
    }

}
