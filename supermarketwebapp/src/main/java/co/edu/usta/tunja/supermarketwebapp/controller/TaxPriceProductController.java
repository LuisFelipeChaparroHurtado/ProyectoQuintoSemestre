/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarketwebapp.controller;

import co.edu.usta.tunja.supermarket.persistence.ejb.TaxPriceProductFacade;
import co.edu.usta.tunja.supermarket.persistence.entity.TaxPriceProductEntity;
import co.edu.usta.tunja.supermarketwebapp.utility.Message;
import java.io.Serializable;
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
@Named(value = "taxPriceProductController")
@RequestScoped
public class TaxPriceProductController implements Serializable {

    @EJB
    private TaxPriceProductFacade _ejbFacade;
    private TaxPriceProductEntity _objActual;

    private Integer fkIdPriceProd;
    private Integer fkIdTa;
    
    
    public TaxPriceProductController() {
    }

    public Integer getFkIdPriceProd() {
        return fkIdPriceProd;
    }

    public void setFkIdPriceProd(Integer fkIdPriceProd) {
        this.fkIdPriceProd = fkIdPriceProd;
    }

    public Integer getFkIdTa() {
        return fkIdTa;
    }

    public void setFkIdTa(Integer fkIdTa) {
        this.fkIdTa = fkIdTa;
    }

    
    
    public TaxPriceProductEntity getCampo() {
        if (this._objActual == null) {
            this._objActual = new TaxPriceProductEntity();
        }
        return this._objActual;

    }

    public TaxPriceProductFacade getFacade() {
        return this._ejbFacade;
    }

    public String grabarTaxPriceProduct() {
        String texto, detalle;
        try {

            texto = "Exito";
            this._objActual.setFkIdPriceProduct(getFkIdPriceProd());
            this._objActual.setFkIdTax(getFkIdTa());
            //detalle = ResourceBundle.getBundle("/com/usta/clases/utility/txtdepartamentos").getString(texto);
            detalle = "El departamento se creo con exito";
            getFacade().grabar(this._objActual);
            Message.exito(texto, detalle);
            return "listTaxPriceProduct";
        } catch (Exception e) {
            texto = "Error";
            e.printStackTrace();
            //Mensajes.error(texto, detalle);
            return "createTaxPriceProduct";

        }
    }
    
    public String deleteTaxPriceProduct(TaxPriceProductEntity taxPriceProductEntity) {
        this._objActual = taxPriceProductEntity;
        String text, detail;
        try {
            text = "Delete success";
            detail = "Detele tax price product in the data base.";
            Message.exito(text, detail);
            getFacade().borrar(this._objActual);
            return "listTaxPriceProduct";
        } catch (Exception e) {
            text = "Delete error";
            detail = e.getMessage();
            Message.error(text, detail);
            return "listTaxPriceProduct";
        }
    }
    
    
    public String cargarID(Integer id) {
        _objActual = getFacade().search(id);
        Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sesionMap.put("taxPriceProduct", _objActual);
        return "updateTaxPriceProduct";
    }

    public String updateTaxPriceProduct() {

        String texto, detail;
        try {
            texto = "Actualizado con exito";
            this._objActual.setFkIdPriceProduct(getFkIdPriceProd());
            this._objActual.setFkIdTax(getFkIdTa());
            detail = "Actualizado";
            Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            _objActual.setId(((TaxPriceProductEntity) sesionMap.get("taxPriceProduct")).getId());
            getFacade().update(_objActual);
            Message.exito(texto, detail);
            return "listTaxPriceProduct";
        } catch (Exception e) {
            texto = "Error";
            detail = "Error";
            Message.error(texto, detail);
            return "updateTaxPriceProduct";
        }
    }
    

    public List<TaxPriceProductEntity> getTaxPriceProductListado() {
        return getFacade().listar();
    }


}
