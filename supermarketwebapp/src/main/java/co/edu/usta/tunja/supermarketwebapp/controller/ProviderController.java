/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarketwebapp.controller;

import co.edu.usta.tunja.supermarket.persistence.ejb.ProviderFacade;
import co.edu.usta.tunja.supermarket.persistence.entity.ProviderEntity;
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
@Named(value = "providerController")
@RequestScoped
public class ProviderController implements Serializable {

    @EJB
    private ProviderFacade _ejbFacade;
    private ProviderEntity _objActual;

    public ProviderController() {
    }

    public ProviderEntity getCampo() {
        if (this._objActual == null) {
            this._objActual = new ProviderEntity();

        }
        return this._objActual;

    }

    public ProviderFacade getFacade() {
        return this._ejbFacade;
    }

    public String grabarProvider() {
        String texto, detalle;
        try {

            texto = "Exito";
            //detalle = ResourceBundle.getBundle("/com/usta/clases/utility/txtdepartamentos").getString(texto);
            detalle = "El departamento se creo con exito";
            getFacade().grabar(this._objActual);
            Message.exito(texto, detalle);
            return "crear";
        } catch (Exception e) {
            texto = "Error";
            e.printStackTrace();
            //Mensajes.error(texto, detalle);
            return "crear";

        }
    }

    public String deleteProvider(ProviderEntity providerEntity) {
        this._objActual = providerEntity;
        String text, detail;
        try {
            text = "Delete success";
            detail = "Detele provider in the data base.";
            Message.exito(text, detail);
            getFacade().borrar(this._objActual);
            return "listProvider";
        } catch (Exception e) {
            text = "Delete error";
            detail = e.getMessage();
            Message.error(text, detail);
            return "listProvider";
        }
    }

    public String cargarID(Integer id) {
        _objActual = getFacade().search(id);
        Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sesionMap.put("provider", _objActual);
        return "updateProvider";
    }

    public String updateProvider() {

        String texto, detail;
        try {
            texto = "Actualizado con exito";
            detail = "Actualizado";
            Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            _objActual.setId(((ProviderEntity) sesionMap.get("provider")).getId());
            getFacade().update(_objActual);
            Message.exito(texto, detail);
            return "listProvider";
        } catch (Exception e) {
            texto = "Error";
            detail = "Error";
            Message.error(texto, detail);
            return "updateProvider";
        }
    }

    public List<ProviderEntity> getProviderListado() {
        return getFacade().listar();
    }

}
