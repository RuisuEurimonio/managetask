/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Service;

import java.util.List;
import metricas.demo.CustomExceptions.CustomException;
import metricas.demo.Model.Lista;
import metricas.demo.Model.Prioridad;
import metricas.demo.Repository.ListaR;
import metricas.demo.Repository.PrioridadR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruisu's
 */
@Service
public class PrioridadS {
    
    
    @Autowired
    private PrioridadR prioridadR;
    
    public List<Prioridad> getAll(){
        return prioridadR.getAll();
    }
    
    public Prioridad getById(Integer id){
        Prioridad prioridad = prioridadR.getById(id).orElseThrow(()-> new CustomException("No se encontró la prioridad"));
        return prioridad;
    }
    
    public Prioridad createLista(Prioridad prioridad){
        return prioridadR.createPrioridad(prioridad);
    }
    
    public Prioridad updateLista(Prioridad prioridad){
        Prioridad prioridadDB = prioridadR.getById(prioridad.getId()).orElseThrow(()-> new CustomException("No se encontro la prioridad"));
        if(prioridad.getName() != null) {prioridadDB.setName(prioridad.getName());}
        if(prioridad.getDescription() != null) {prioridadDB.setDescription(prioridad.getDescription());}
        return prioridadR.updatePrioridad(prioridadDB);
    }
    
    public void deleteLista(Integer id){
        prioridadR.getById(id).orElseThrow(()-> new CustomException("No se encontro la prioridad"));
        prioridadR.deletePrioridad(id);
    }
    
}
