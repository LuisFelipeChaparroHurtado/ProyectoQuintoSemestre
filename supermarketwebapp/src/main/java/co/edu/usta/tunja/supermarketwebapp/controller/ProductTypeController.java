/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarketwebapp.controller;

import co.edu.usta.tunja.supermarket.persistence.ejb.ProductTypeFacade;
import co.edu.usta.tunja.supermarket.persistence.entity.PersonTypeEntity;
import co.edu.usta.tunja.supermarket.persistence.entity.ProductTypeEntity;
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
@Named(value = "productTypeController")
@RequestScoped
public class ProductTypeController implements Serializable {

    @EJB
    private ProductTypeFacade _ejbFacade;
    private ProductTypeEntity _objActual;

    public ProductTypeController() {
    }

    public ProductTypeEntity getCampo() {
        if (this._objActual == null) {
            this._objActual = new ProductTypeEntity();

        }
        return this._objActual;

    }

    public ProductTypeFacade getFacade() {
        return this._ejbFacade;
    }

    public String grabarProductType() {
        String texto, detalle;
        try {

            texto = "Exito";
            //detalle = ResourceBundle.getBundle("/com/usta/clases/utility/txtdepartamentos").getString(texto);
            detalle = "El departamento se creo con exito";
            getFacade().grabar(this._objActual);
            Message.exito(texto, detalle);
            return "createProductType";
        } catch (Exception e) {
            texto = "Error";
            e.printStackTrace();
            //Mensajes.error(texto, detalle);
            return "createProductType";

        }
    }

    public String deleteProductType(ProductTypeEntity productTypeEntity) {
        this._objActual = productTypeEntity;
        String text, detail;
        try {
            text = "Delete success";
            detail = "Detele product type in the data base.";
            Message.exito(text, detail);
            getFacade().borrar(this._objActual);
            return "listProductType";
        } catch (Exception e) {
            text = "Delete error";
            detail = e.getMessage();
            Message.error(text, detail);
            return "listProductType";
        }
    }

    public String cargarID(Integer id) {
        _objActual = getFacade().search(id);
        Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sesionMap.put("productType", _objActual);
        return "updateProductType";
    }

    public String updateProductType() {

        String texto, detail;
        try {
            texto = "Actualizado con exito";
            detail = "Actualizado";
            Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            _objActual.setId(((ProductTypeEntity) sesionMap.get("productType")).getId());
            getFacade().update(_objActual);
            Message.exito(texto, detail);
            return "listProductType";
        } catch (Exception e) {
            texto = "Error";
            detail = "Error";
            Message.error(texto, detail);
            return "updateProductType";
        }
    }

    public List<ProductTypeEntity> getProductTypeListado() {
        return getFacade().listar();
    }

}
