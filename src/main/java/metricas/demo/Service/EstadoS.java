/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Service;

import java.util.List;
import metricas.demo.CustomExceptions.CustomException;
import metricas.demo.Model.Color;
import metricas.demo.Model.Estado;
import metricas.demo.Repository.ColorR;
import metricas.demo.Repository.EstadoR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruisu's
 */
@Service
public class EstadoS {
    
    @Autowired
    private EstadoR estadoR;
    
    public List<Estado> getAll(){
        return estadoR.getAll();
    }
    
    public Estado getById(Integer id){
        Estado estado = estadoR.getById(id).orElseThrow(()-> new CustomException("No se encontró el estado"));
        return estado;
    }
    
    public Estado createEstado(Estado estado){
        return estadoR.createEstado(estado);
    }
    
    public Estado updateEstado(Estado estado){
        Estado estadoDB = estadoR.getById(estado.getId()).orElseThrow(()-> new CustomException("No se encontro el estado"));
        if(estado.getName() != null) {estadoDB.setName(estado.getName());}
        if(estado.getDescription() != null) {estadoDB.setDescription(estado.getDescription());}
        return estadoR.updateEstado(estadoDB);
    }
    
    public void deleteEstado(Integer id){
        estadoR.getById(id).orElseThrow(()-> new CustomException("No se encontro el estado"));
        estadoR.deleteEstado(id);
    }
    
}
