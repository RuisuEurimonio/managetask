/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Repository;

import java.util.List;
import java.util.Optional;
import metricas.demo.JpaRepository.RolJR;
import metricas.demo.JpaRepository.TableroJR;
import metricas.demo.Model.Rol;
import metricas.demo.Model.Tablero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ruisu's
 */
@Repository
public class TableroR {
    
    @Autowired
    private TableroJR tableroJR;
    
    public List<Tablero> getAll(){
        return tableroJR.findAll();
    }
    
    public Optional<Tablero> getById(int id){
        return tableroJR.findById(id);
    }
    
    public Tablero createTablero(Tablero tablero){
        return tableroJR.save(tablero);
    }
    
    public Tablero updateTablero(Tablero tablero){
        return tableroJR.save(tablero);
    }
    
    public void deleteTablero(int id){
        tableroJR.deleteById(id);
    }
    
}
