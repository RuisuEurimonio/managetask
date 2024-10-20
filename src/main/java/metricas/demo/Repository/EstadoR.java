/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Repository;

import java.util.List;
import java.util.Optional;
import metricas.demo.JpaRepository.ColorJR;
import metricas.demo.JpaRepository.EstadoJR;
import metricas.demo.Model.Color;
import metricas.demo.Model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ruisu's
 */
@Repository
public class EstadoR {
    
    @Autowired
    private EstadoJR estadoJR;
    
    
    public List<Estado> getAll(){
        return estadoJR.findAll();
    }
    
    public Optional<Estado> getById(int id){
        return estadoJR.findById(id);
    }
    
    public Estado createEstado(Estado estado){
        return estadoJR.save(estado);
    }
    
    public Estado updateEstado(Estado estado){
        return estadoJR.save(estado);
    }
    
    public void deleteEstado(int id){
        estadoJR.deleteById(id);
    }
    
}
