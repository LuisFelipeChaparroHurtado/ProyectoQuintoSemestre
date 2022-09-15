/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usta.tunja.supermarket.persistence.ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Felipe
 */
public abstract class Abstract<T> {
    //Clase abstracta en la cual nos ingresa por parametro una clase Template.
    //Consultas generales para cualquier tabla, agregar, eliminar, actualizar, listar
    //T-> es el template (es como un parametro para la clase)
    private final Class<T> entidad;
    protected abstract EntityManager getAdminEntidad();
    public Abstract(Class<T> entidad){
        this.entidad=entidad;
    }
    
    public void grabar(T entidad){
        getAdminEntidad().persist(entidad);
    }
    
    public void borrar(T entidad){
        if (!getAdminEntidad().contains(entidad)) {
            entidad = getAdminEntidad().merge(entidad);
        }
        getAdminEntidad().remove(entidad);
    }
    
    public void update(T entidad){
        getAdminEntidad().merge(entidad);
    }
    
    public T search(Object id){
        return getAdminEntidad().find(entidad, id);
    }
    
    public List<T> listar(){
        //Crear estructura
        CriteriaBuilder cb = getAdminEntidad().getCriteriaBuilder();
        
        CriteriaQuery<T> cq = cb.createQuery(entidad);
        //Coloqueme la entidad en el SELECT
        cq.select(cq.from(entidad));
        //Me trae todos los campos
        List<T> allData = getAdminEntidad().createQuery(cq).getResultList();
        return allData;
    }
    
}
