/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarketwebapp.controller;

import co.edu.usta.tunja.supermarket.persistence.ejb.PersonFacade;
import co.edu.usta.tunja.supermarket.persistence.ejb.PersonPersonTypeFacade;
import co.edu.usta.tunja.supermarket.persistence.entity.PersonEntity;
import co.edu.usta.tunja.supermarket.persistence.entity.PersonPersonTypeEntity;
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
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named(value = "personController")
@RequestScoped
public class PersonController implements Serializable{
    
    @EJB
    private PersonFacade _ejbFacade;
    @EJB
    private PersonPersonTypeFacade _ejbRelationship;
    
    private PersonEntity _objActual;
    private PersonTypeEntity pte;

    public PersonController() {
    }

    public PersonTypeEntity getPte() {
        return pte;
    }

    public void setPte(PersonTypeEntity pte) {
        this.pte = pte;
    }

    
    
    public PersonEntity getCampo() {
        if (this._objActual == null)
        {
            this._objActual = new PersonEntity();

        }
        return this._objActual;

    }

    public PersonFacade getFacade() {
        return this._ejbFacade;
    }

    public String grabarPerson(){
        String texto, detalle;
        PersonPersonTypeEntity ppte=new PersonPersonTypeEntity();
        try{

            texto = "Exito";
            //detalle = ResourceBundle.getBundle("/com/usta/clases/utility/txtdepartamentos").getString(texto);
            detalle="La persona se creo con exito";
            getFacade().grabar(this._objActual);
            ppte.setFkPerson(_objActual);//almacena en la relación el obejto recien creado
            ppte.setFkPersonType(pte);//almacena en la relación el objeto seleccionado en la lista deplegable
            this._ejbRelationship.grabar(ppte);
            Message.exito(texto, detalle);
            return "listPerson";
        }catch(Exception e){
            texto="Error";
            e.printStackTrace();
            //Mensajes.error(texto, detalle);
            return "createPerson";

        }
    }
    
    public String deletePerson(PersonEntity personEntity) {
        this._objActual = personEntity;
        String text, detail;
        try {
            text = "Delete success";
            detail = "Detele person in the data base.";
            Message.exito(text, detail);
            getFacade().borrar(this._objActual);
            return "listPerson";
        } catch (Exception e) {
            text = "Delete error";
            detail = e.getMessage();
            Message.error(text, detail);
            return "listPerson";
        }
    }
    
    public String cargarID(Integer id) {
        _objActual = getFacade().search(id);
        Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sesionMap.put("person", _objActual);
        return "updatePerson";
    }

    public String actualizarPerson() {

        String texto, detail;
        try
        {
            texto = "Actualizado con exito";
            detail = "Actualizado";
            Map<String, Object> sesionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            _objActual.setId(((PersonEntity) sesionMap.get("person")).getId());
            getFacade().update(_objActual);
            Message.exito(texto, detail);
            return "listPerson";
        } catch (Exception e)
        {
            texto = "Error";
            detail = "Error";
            Message.error(texto, detail);
            return "updatePerson";
        }
    }
    
     public List<PersonEntity> getPersonListado(){
        return getFacade().listar();
    }
     
     public SelectItem[] getListadoCombo(String value) {

        return Forms.addObject(getFacade().listar(), value);
    }
     
    
    

   

}
