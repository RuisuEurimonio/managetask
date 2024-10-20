/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Service;

import java.util.List;
import metricas.demo.CustomExceptions.CustomException;
import metricas.demo.Model.Prioridad;
import metricas.demo.Model.Rol;
import metricas.demo.Repository.PrioridadR;
import metricas.demo.Repository.RolR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruisu's
 */
@Service
public class RolS {
    
    
    @Autowired
    private RolR rolR;
    
    public List<Rol> getAll(){
        return rolR.getAll();
    }
    
    public Rol getById(Integer id){
        Rol rol = rolR.getById(id).orElseThrow(()-> new CustomException("No se encontró la prioridad"));
        return rol;
    }
    
    public Rol createLista(Rol rol){
        return rolR.createRol(rol);
    }
    
    public Rol updateLista(Rol rol){
        Rol rolDB = rolR.getById(rol.getId()).orElseThrow(()-> new CustomException("No se encontro la prioridad"));
        if(rol.getName() != null) {rolDB.setName(rol.getName());}
        if(rol.getDescription() != null) {rolDB.setDescription(rol.getDescription());}
        return rolR.updateRol(rolDB);
    }
    
    public void deleteLista(Integer id){
        rolR.getById(id).orElseThrow(()-> new CustomException("No se encontro la prioridad"));
        rolR.deletePrioridad(id);
    }
    
}
