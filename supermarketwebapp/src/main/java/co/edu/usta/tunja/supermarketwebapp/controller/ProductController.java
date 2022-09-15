/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarketwebapp.controller;

import co.edu.usta.tunja.supermarket.persistence.ejb.ProductFacade;
import co.edu.usta.tunja.supermarket.persistence.entity.ProductEntity;
import co.edu.usta.tunja.supermarketwebapp.utility.Message;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author USUARIO
 */
@Named(value = "productController")
@RequestScoped
public class ProductController implements Serializable {

    @EJB
    private ProductFacade _ejbFacade;
    private ProductEntity _objActual;

    private Integer fkId;

    public ProductController() {
    }

    public Integer getFkId() {
        return fkId;
    }

    public void setFkId(Integer fkId) {
        this.fkId = fkId;
    }

    public ProductEntity getCampo() {
        if (this._objActual == null) {
            this._objActual = new ProductEntity();

        }
        return this._objActual;

    }

    public ProductFacade getFacade() {
        return this._ejbFacade;
    }

    public String grabarProduct() {
        String texto, detalle;
        try {

            texto = "Exito";
            this._objActual.setFkIdProductType(getFkId());
            //detalle = ResourceBundle.getBundle("/com/usta/clases/utility/txtdepartamentos").getString(texto);
            detalle = "El producto se creo con exito";

            getFacade().grabar(this._objActual);
            Message.exito(texto, detalle);
            return "listadoProduct";
        } catch (Exception e) {
            texto = "Error";
            e.printStackTrace();
            //Mensajes.error(texto, detalle);
            return "crearProduct";

        }
    }

    public String deleteProduct(ProductEntity productEntity) {
        this._objActual = productEntity;
        String text, detail;
        try {
            text = "Delete success";
            detail = "Detele product in the data base.";
            Message.exito(text, detail);
            getFacade().borrar(this._objActual);
            return "listProduct";
        } catch (Exception e) {
            text = "Delete error";
            detail = e.getMessage();
            Message.error(text, detail);
            return "listProduct";
        }
    }

    public String cargarID(Integer id) {
        _objActual = getFacade().search(id);
        Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sesionMap.put("product", _objActual);
        return "updateProduct";
    }

    public String actualizarProduct() {

        String texto, detail;
        try {
            texto = "Actualizado con exito";
            this._objActual.setFkIdProductType(getFkId());
            detail = "Actualizado";
            Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            _objActual.setId(((ProductEntity) sesionMap.get("product")).getId());
            getFacade().update(_objActual);
            Message.exito(texto, detail);
            return "listadoProduct";
        } catch (Exception e) {
            texto = "Error";
            detail = "Error";
            Message.error(texto, detail);
            return "updateProduct";
        }
    }

    public List<ProductEntity> getProductListado() {
        return getFacade().listar();
    }

}
