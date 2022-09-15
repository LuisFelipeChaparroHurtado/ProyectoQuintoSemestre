/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarketwebapp.controller;

import co.edu.usta.tunja.supermarket.persistence.ejb.PersonFacade;
import co.edu.usta.tunja.supermarket.persistence.ejb.PersonPersonTypeFacade;
import co.edu.usta.tunja.supermarket.persistence.entity.PersonPersonTypeEntity;
import co.edu.usta.tunja.supermarketwebapp.utility.Message;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "personPersonTypeController")
@RequestScoped
public class PersonPersonTypeController implements Serializable {

    @EJB
    private PersonPersonTypeFacade _ejbFacade;
    private PersonPersonTypeEntity _objActual;

    private Integer fkIdPersonType;
    private Integer fkIdPerson;

    public PersonPersonTypeController() {
    }

    public Integer getFkIdPersonType() {
        return fkIdPersonType;
    }

    public void setFkIdPersonType(Integer fkIdPersonType) {
        this.fkIdPersonType = fkIdPersonType;
    }

    public Integer getFkIdPerson() {
        return fkIdPerson;
    }

    public void setFkIdPerson(Integer fkIdPerson) {
        this.fkIdPerson = fkIdPerson;
    }

    
    

    public PersonPersonTypeEntity getCampo() {
        if (this._objActual == null) {
            this._objActual = new PersonPersonTypeEntity();

        }
        return this._objActual;

    }

    public PersonPersonTypeFacade getFacade() {
        return this._ejbFacade;
    }

    public String grabarPersonPersonType() {
        String texto, detalle;

        try {
            System.out.println("LLEGO!");
            texto = "Success";
            
            this._objActual.setFkIdPersonType(getFkIdPersonType());
            this._objActual.setFkIdPerson(getFkIdPerson());
            
            System.out.println(getFkIdPersonType());
            System.out.println(getFkIdPerson());
            
            //detalle=ResourceBundle.getBundle("co/edu/usta/tunja/web/utility/txtdepartment").getString("MsgGrabarExito");
            detalle = "This tax register is success";
            getFacade().grabar(this._objActual);
            Message.exito(texto, detalle);
            return "listPersonPersonType";
        } catch (Exception e) {
            texto = "Error";
            detalle = e.getMessage();
            //Message.error(texto, detalle);
            return "createPersonPersonType";

        }
    }

    public String deletePersonPersonType(PersonPersonTypeEntity personPersonTypeEntity) {
        this._objActual = personPersonTypeEntity;
        String text, detail;
        try {
            text = "Delete success";
            detail = "Detele person person type in the data base.";
            Message.exito(text, detail);
            getFacade().borrar(this._objActual);
            return "listPersonPersonType";
        } catch (Exception e) {
            text = "Delete error";
            detail = e.getMessage();
            Message.error(text, detail);
            return "listPersonPersonType";
        }
    }
    
    
    public String cargarID(Integer id) {
        _objActual = getFacade().search(id);
        Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sesionMap.put("personPersonType", _objActual);
        return "updatePersonPersonType";
    }

    public String actualizarPersonPersonType() {

        String texto, detail;
        try {
            texto = "Actualizado con exito";
            this._objActual.setFkIdPersonType(getFkIdPersonType());
            this._objActual.setFkIdPerson(getFkIdPerson());
            detail = "Actualizado";
            Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            _objActual.setId(((PersonPersonTypeEntity) sesionMap.get("personPersonType")).getId());
            getFacade().update(_objActual);
            Message.exito(texto, detail);
            return "listPersonPersonType";
        } catch (Exception e) {
            texto = "Error";
            detail = "Error";
            Message.error(texto, detail);
            return "updatePersonPersonType";
        }
    }

    
     public List<PersonPersonTypeEntity> getPersonPersonTypeListado(){
        return getFacade().listar();
    }
     
}
