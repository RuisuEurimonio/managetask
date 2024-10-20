/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Repository;

import java.util.List;
import java.util.Optional;
import metricas.demo.JpaRepository.RolJR;
import metricas.demo.Model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ruisu's
 */
@Repository
public class RolR {
    
    @Autowired
    private RolJR rolJR;
    
    public List<Rol> getAll(){
        return rolJR.findAll();
    }
    
    public Optional<Rol> getById(int id){
        return rolJR.findById(id);
    }
    
    public Rol createRol(Rol rol){
        return rolJR.save(rol);
    }
    
    public Rol updateRol(Rol rol){
        return rolJR.save(rol);
    }
    
    public void deleteRol(int id){
        rolJR.deleteById(id);
    }
    
}
