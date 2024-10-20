/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Service;

import java.util.List;
import metricas.demo.CustomExceptions.CustomException;
import metricas.demo.Model.Rol;
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
        Rol rol = rolR.getById(id).orElseThrow(()-> new CustomException("No se encontró el rol"));
        return rol;
    }
    
    public Rol createRol(Rol rol){
        return rolR.createRol(rol);
    }
    
    public Rol updateRol(Rol rol){
        Rol rolDB = rolR.getById(rol.getId()).orElseThrow(()-> new CustomException("No se encontro el rol"));
        if(rol.getName() != null) {rolDB.setName(rol.getName());}
        if(rol.getDescription() != null) {rolDB.setDescription(rol.getDescription());}
        return rolR.updateRol(rolDB);
    }
    
    public void deleteRol(Integer id){
        rolR.getById(id).orElseThrow(()-> new CustomException("No se encontro el rol"));
        rolR.deleteRol(id);
    }
    
}
