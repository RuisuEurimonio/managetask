/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Repository;

import java.util.List;
import java.util.Optional;
import metricas.demo.JpaRepository.PrioridadJR;
import metricas.demo.Model.Prioridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ruisu's
 */
@Repository
public class PrioridadR {
    
    @Autowired
    private PrioridadJR prioridadJR;
    
    public List<Prioridad> getAll(){
        return prioridadJR.findAll();
    }
    
    public Optional<Prioridad> getById(int id){
        return prioridadJR.findById(id);
    }
    
    public Prioridad createPrioridad(Prioridad prioridad){
        return prioridadJR.save(prioridad);
    }
    
    public Prioridad updatePrioridad(Prioridad prioridad){
        return prioridadJR.save(prioridad);
    }
    
    public void deletePrioridad(int id){
        prioridadJR.deleteById(id);
    }
    
}
