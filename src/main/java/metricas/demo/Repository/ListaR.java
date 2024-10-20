/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Repository;

import java.util.List;
import java.util.Optional;
import metricas.demo.JpaRepository.ListaJR;
import metricas.demo.Model.Lista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ruisu's
 */
@Repository
public class ListaR {
    
    @Autowired
    private ListaJR listaJR;
    
    
    public List<Lista> getAll(){
        return listaJR.findAll();
    }
    
    public Optional<Lista> getById(int id){
        return listaJR.findById(id);
    }
    
    public Lista createLista(Lista lista){
        return listaJR.save(lista);
    }
    
    public Lista updateLista(Lista lista){
        return listaJR.save(lista);
    }
    
    public void deleteLista(int id){
        listaJR.deleteById(id);
    }
    
}
