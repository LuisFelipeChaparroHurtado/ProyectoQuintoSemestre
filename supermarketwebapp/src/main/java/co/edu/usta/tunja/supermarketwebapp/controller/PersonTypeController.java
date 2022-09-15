/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarketwebapp.controller;


import co.edu.usta.tunja.supermarket.persistence.ejb.PersonTypeFacade;
import co.edu.usta.tunja.supermarket.persistence.entity.PersonTypeEntity;
import co.edu.usta.tunja.supermarketwebapp.utility.Forms;
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

@Named(value = "personTypeController")
@RequestScoped

public class PersonTypeController implements Serializable{
     @EJB
    private PersonTypeFacade _ejbFacade;
    private PersonTypeEntity _objActual;

    public PersonTypeController() {
    }

    public PersonTypeEntity getCampo() {
        if (this._objActual == null)
        {
            this._objActual = new PersonTypeEntity();

        }
        return this._objActual;

    }

    public PersonTypeFacade getFacade() {
        return this._ejbFacade;
    }

    public String grabarPersonType(){
        String texto, detalle;
        try{

            texto = "Exito";
            //detalle = ResourceBundle.getBundle("/com/usta/clases/utility/txtdepartamentos").getString(texto);
            detalle="El departamento se creo con exito";
            getFacade().grabar(this._objActual);
            Message.exito(texto, detalle);
            return "listPersonType";
        }catch(Exception e){
            texto="Error";
            e.printStackTrace();
            //Mensajes.error(texto, detalle);
            return "createPersonType";

        }
    }
    
    public String deletePersonType(PersonTypeEntity personTypeEntity) {
        this._objActual = personTypeEntity;
        String text, detail;
        try {
            text = "Delete success";
            detail = "Detele person type in the data base.";
            Message.exito(text, detail);
            getFacade().borrar(this._objActual);
            return "listPersonType";
        } catch (Exception e) {
            text = "Delete error";
            detail = e.getMessage();
            Message.error(text, detail);
            return "listPersonType";
        }
    }
    
    
    public String cargarID(Integer id) {
        _objActual = getFacade().search(id);
        Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sesionMap.put("personType", _objActual);
        return "updatePersonType";
    }

    public String updatePersonType() {

        String texto, detail;
        try {
            texto = "Actualizado con exito";
            detail = "Actualizado";
            Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            _objActual.setId(((PersonTypeEntity) sesionMap.get("personType")).getId());
            getFacade().update(_objActual);
            Message.exito(texto, detail);
            return "listPersonType";
        } catch (Exception e) {
            texto = "Error";
            detail = "Error";
            Message.error(texto, detail);
            return "updatePersonType";
        }
    }
    
    public SelectItem[] getListadoCombo(String value){
        return Forms.addObject(getFacade().listar(), value);
    }
     public List<PersonTypeEntity> getPersonTypeListado(){
        return getFacade().listar();
    }
     
    
    
}
