/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarketwebapp.controller;

import co.edu.usta.tunja.supermarket.persistence.ejb.TicketFacade;
import co.edu.usta.tunja.supermarket.persistence.entity.TicketEntity;
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
@Named(value = "ticketController")
@RequestScoped
public class TicketController implements Serializable {

    @EJB
    private TicketFacade _ejbFacade;
    private TicketEntity _objActual;
    
    private Integer fkIdCashierPer;
    private Integer fkIdCustomerPer;

    public TicketController() {
    }

    public Integer getFkIdCashierPer() {
        return fkIdCashierPer;
    }

    public void setFkIdCashierPer(Integer fkIdCashierPer) {
        this.fkIdCashierPer = fkIdCashierPer;
    }

    public Integer getFkIdCustomerPer() {
        return fkIdCustomerPer;
    }

    public void setFkIdCustomerPer(Integer fkIdCustomerPer) {
        this.fkIdCustomerPer = fkIdCustomerPer;
    }
    
    
    public TicketEntity getCampo() {
        if (this._objActual == null) {
            this._objActual = new TicketEntity();

        }
        return this._objActual;

    }

    public TicketFacade getFacade() {
        return this._ejbFacade;
    }

    public String grabarTicket() {
        String texto, detalle;
        try {

            texto = "Exito";
            this._objActual.setFkIdCashierPerson(getFkIdCashierPer());
            this._objActual.setFkIdCustomerPerson(getFkIdCustomerPer());
            //detalle = ResourceBundle.getBundle("/com/usta/clases/utility/txtdepartamentos").getString(texto);
            detalle = "El departamento se creo con exito";
            getFacade().grabar(this._objActual);
            Message.exito(texto, detalle);
            return "listTicket";
        } catch (Exception e) {
            texto = "Error";
            e.printStackTrace();
            //Mensajes.error(texto, detalle);
            return "createTicket";

        }
    }
    
    public String deleteTicket(TicketEntity ticketEntity) {
        this._objActual = ticketEntity;
        String text, detail;
        try {
            text = "Delete success";
            detail = "Detele ticket in the data base.";
            Message.exito(text, detail);
            getFacade().borrar(this._objActual);
            return "listTicket";
        } catch (Exception e) {
            text = "Delete error";
            detail = e.getMessage();
            Message.error(text, detail);
            return "listTicket";
        }
    }
    
    
    public String cargarID(Integer id) {
        _objActual = getFacade().search(id);
        Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sesionMap.put("ticket", _objActual);
        return "updateTicket";
    }

    public String updateTicket() {

        String texto, detail;
        try {
            texto = "Actualizado con exito";
            this._objActual.setFkIdCashierPerson(getFkIdCashierPer());
            this._objActual.setFkIdCustomerPerson(getFkIdCustomerPer());
            detail = "Actualizado";
            Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            _objActual.setId(((TicketEntity) sesionMap.get("ticket")).getId());
            getFacade().update(_objActual);
            Message.exito(texto, detail);
            return "listTicket";
        } catch (Exception e) {
            texto = "Error";
            detail = "Error";
            Message.error(texto, detail);
            return "updateTicket";
        }
    }

    public List<TicketEntity> getTicketListado() {
        return getFacade().listar();
    }
    
}
