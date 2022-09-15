/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarketwebapp.controller;

import co.edu.usta.tunja.supermarket.persistence.ejb.PriceProductFacade;
import co.edu.usta.tunja.supermarket.persistence.entity.PriceProductEntity;
import co.edu.usta.tunja.supermarketwebapp.utility.Message;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "priceProductController")
@RequestScoped
public class PriceProductController {

    @EJB
    private PriceProductFacade _ejbFacade;
    private PriceProductEntity _objActual;

    private Integer fkIdProductPro;

    public PriceProductController() {
    }

    public Integer getFkIdProductPro() {
        return fkIdProductPro;
    }

    public void setFkIdProductPro(Integer fkIdProductPro) {
        this.fkIdProductPro = fkIdProductPro;
    }

    public PriceProductEntity getCampo() {
        if (this._objActual == null) {
            this._objActual = new PriceProductEntity();

        }
        return this._objActual;

    }

    public PriceProductFacade getFacade() {
        return this._ejbFacade;
    }

    public String grabarPriceProduct() {
        String texto, detalle;
        try {

            texto = "Exito";
            this._objActual.setFkIdProductProvider(getFkIdProductPro());
            //detalle = ResourceBundle.getBundle("/com/usta/clases/utility/txtdepartamentos").getString(texto);
            detalle = "El departamento se creo con exito";
            getFacade().grabar(this._objActual);
            Message.exito(texto, detalle);
            return "listPriceProduct";
        } catch (Exception e) {
            texto = "Error";
            e.printStackTrace();
            //Mensajes.error(texto, detalle);
            return "createPriceProduct";

        }
    }

    public String deletePriceProduct(PriceProductEntity priceProductEntity) {
        this._objActual = priceProductEntity;
        String text, detail;
        try {
            text = "Delete success";
            detail = "Detele price product in the data base.";
            Message.exito(text, detail);
            getFacade().borrar(this._objActual);
            return "listPriceProduct";
        } catch (Exception e) {
            text = "Delete error";
            detail = e.getMessage();
            Message.error(text, detail);
            return "listPriceProduct";
        }
    }

    public String cargarID(Integer id) {
        _objActual = getFacade().search(id);
        Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sesionMap.put("priceProduct", _objActual);
        return "updatePriceProduct";
    }

    public String updatePriceProduct() {

        String texto, detail;
        try {
            texto = "Actualizado con exito";
            this._objActual.setFkIdProductProvider(getFkIdProductPro());
            detail = "Actualizado";
            Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            _objActual.setId(((PriceProductEntity) sesionMap.get("priceProduct")).getId());
            getFacade().update(_objActual);
            Message.exito(texto, detail);
            return "listPriceProduct";
        } catch (Exception e) {
            texto = "Error";
            detail = "Error";
            Message.error(texto, detail);
            return "updatePriceProduct";
        }
    }

    public List<PriceProductEntity> getPriceProductListado() {
        return getFacade().listar();
    }

}
