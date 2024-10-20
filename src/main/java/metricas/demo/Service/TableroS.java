/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Service;

import java.util.List;
import metricas.demo.CustomExceptions.CustomException;
import metricas.demo.Model.Lista;
import metricas.demo.Model.Rol;
import metricas.demo.Model.Tablero;
import metricas.demo.Repository.ListaR;
import metricas.demo.Repository.RolR;
import metricas.demo.Repository.TableroR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruisu's
 */
@Service
public class TableroS {
    
    
    @Autowired
    private TableroR tableroR;
    
    @Autowired
    private ListaR listaR;
    
    public List<Tablero> getAll(){
        return tableroR.getAll();
    }
    
    public Tablero getById(Integer id){
        Tablero tablero = tableroR.getById(id).orElseThrow(()-> new CustomException("No se encontró el tablero"));
        return tablero;
    }
    
    public Tablero createTablero(Tablero rol){
        return tableroR.createTablero(rol);
    }
    
    public Tablero updateTablero(Tablero tablero){
        Tablero tableroDB = tableroR.getById(tablero.getId()).orElseThrow(()-> new CustomException("No se encontro el tablero"));
        if(tablero.getName() != null) {tableroDB.setName(tablero.getName());}
        if(tablero.getDescription() != null) {tableroDB.setDescription(tablero.getDescription());}
        if(tablero.getDescription() != null) {tableroDB.setDescription(tablero.getDescription());}
        
        Lista listaDB = listaR.getById(tablero.getLista().getId()).orElseThrow(()-> new CustomException("No se encontro la lista referenciada"));
        if(tablero.getLista() != null) {tableroDB.setLista(listaDB);}
        return tableroR.updateTablero(tableroDB);
    }
    
    public void deleteTablero(Integer id){
        tableroR.getById(id).orElseThrow(()-> new CustomException("No se encontro el tablero"));
        tableroR.deleteTablero(id);
    }
    
    
}
