/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarketwebapp.controller;

import co.edu.usta.tunja.supermarket.persistence.ejb.TaxFacade;
import co.edu.usta.tunja.supermarket.persistence.entity.TaxEntity;
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
@Named(value = "taxController")
@RequestScoped
public class TaxController  implements Serializable {

    @EJB
    private TaxFacade _ejbFacade;
    private TaxEntity _objActual;

    public TaxController() {
    }

    public TaxEntity getCampo() {
        if (this._objActual == null)
        {
            this._objActual = new TaxEntity();

        }
        return this._objActual;

    }

    public TaxFacade getFacade() {
        return this._ejbFacade;
    }

    public String grabarTax(){
        String texto, detalle;
        try{

            texto = "Exito";
            //detalle = ResourceBundle.getBundle("/com/usta/clases/utility/txtdepartamentos").getString(texto);
            detalle="El departamento se creo con exito";
            getFacade().grabar(this._objActual);
            Message.exito(texto, detalle);
            return "crearTax";
        }catch(Exception e){
            texto="Error";
            e.printStackTrace();
            //Mensajes.error(texto, detalle);
            return "crearTax";

        }
    }
    
    public String deleteTax(TaxEntity taxEntity) {
        this._objActual = taxEntity;
        String text, detail;
        try {
            text = "Delete success";
            detail = "Detele tax in the data base.";
            Message.exito(text, detail);
            getFacade().borrar(this._objActual);
            return "listTax";
        } catch (Exception e) {
            text = "Delete error";
            detail = e.getMessage();
            Message.error(text, detail);
            return "listTax";
        }
    }
    
    public String cargarID(Integer id) {
        _objActual = getFacade().search(id);
        Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sesionMap.put("tax", _objActual);
        return "updateTax";
    }

    public String updateTax() {

        String texto, detail;
        try {
            texto = "Actualizado con exito";
            detail = "Actualizado";
            Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            _objActual.setId(((TaxEntity) sesionMap.get("tax")).getId());
            getFacade().update(_objActual);
            Message.exito(texto, detail);
            return "listTax";
        } catch (Exception e) {
            texto = "Error";
            detail = "Error";
            Message.error(texto, detail);
            return "updateTax";
        }
    }
    
     public List<TaxEntity> getTaxListado(){
        return getFacade().listar();
    }

}

