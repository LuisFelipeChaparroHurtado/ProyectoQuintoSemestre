/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarketwebapp.controller;

import co.edu.usta.tunja.supermarket.persistence.ejb.TicketDetailFacade;
import co.edu.usta.tunja.supermarket.persistence.entity.TicketDetailEntity;
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
@Named(value = "ticketDetailController")
@RequestScoped
public class TicketDetailController implements Serializable {

    @EJB
    private TicketDetailFacade _ejbFacade;
    private TicketDetailEntity _objActual;
    
    private Integer fkIdTPriceP;
    private Integer fkIdTicketP;
    private Integer fkIdAdmPer;

    public TicketDetailController() {
    }

    public Integer getFkIdTPriceP() {
        return fkIdTPriceP;
    }

    public void setFkIdTPriceP(Integer fkIdTPriceP) {
        this.fkIdTPriceP = fkIdTPriceP;
    }

    public Integer getFkIdTicketP() {
        return fkIdTicketP;
    }

    public void setFkIdTicketP(Integer fkIdTicketP) {
        this.fkIdTicketP = fkIdTicketP;
    }

    public Integer getFkIdAdmPer() {
        return fkIdAdmPer;
    }

    public void setFkIdAdmPer(Integer fkIdAdmPer) {
        this.fkIdAdmPer = fkIdAdmPer;
    }

    
    
    public TicketDetailEntity getCampo() {
        if (this._objActual == null) {
            this._objActual = new TicketDetailEntity();

        }
        return this._objActual;

    }

    public TicketDetailFacade getFacade() {
        return this._ejbFacade;
    }

    public String grabarTicketDetail() {
        String texto, detalle;
        try {

            texto = "Exito";
            this._objActual.setFkIdTaxPriceProduct(getFkIdTPriceP());
            this._objActual.setFkIdTicketProduct(getFkIdTicketP());
            this._objActual.setFkIdAdminPerson(getFkIdAdmPer());
            //detalle = ResourceBundle.getBundle("/com/usta/clases/utility/txtdepartamentos").getString(texto);
            detalle = "El departamento se creo con exito";
            getFacade().grabar(this._objActual);
            Message.exito(texto, detalle);
            return "listTicketDetail";
        } catch (Exception e) {
            texto = "Error";
            e.printStackTrace();
            //Mensajes.error(texto, detalle);
            return "createTicketDetail";

        }
    }
    
    public String deleteTicketDetail(TicketDetailEntity ticketDetailEntity) {
        this._objActual = ticketDetailEntity;
        String text, detail;
        try {
            text = "Delete success";
            detail = "Detele ticket detail in the data base.";
            Message.exito(text, detail);
            getFacade().borrar(this._objActual);
            return "listTicketDetail";
        } catch (Exception e) {
            text = "Delete error";
            detail = e.getMessage();
            Message.error(text, detail);
            return "listTicketDetail";
        }
    }
    
    public String cargarID(Integer id) {
        _objActual = getFacade().search(id);
        Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sesionMap.put("ticketDetail", _objActual);
        return "updateTicketDetail";
    }

    public String updateTicketDetail() {

        String texto, detail;
        try {
            texto = "Actualizado con exito";
            this._objActual.setFkIdTaxPriceProduct(getFkIdTPriceP());
            this._objActual.setFkIdTicketProduct(getFkIdTicketP());
            this._objActual.setFkIdAdminPerson(getFkIdAdmPer());
            detail = "Actualizado";
            Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            _objActual.setId(((TicketDetailEntity) sesionMap.get("ticketDetail")).getId());
            getFacade().update(_objActual);
            Message.exito(texto, detail);
            return "listTicketDetail";
        } catch (Exception e) {
            texto = "Error";
            detail = "Error";
            Message.error(texto, detail);
            return "updateTicketDetail";
        }
    }
    

    public List<TicketDetailEntity> getTicketDetailListado() {
        return getFacade().listar();
    }

    

}
