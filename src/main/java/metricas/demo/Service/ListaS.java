/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Service;

import java.util.List;
import metricas.demo.CustomExceptions.CustomException;
import metricas.demo.Model.Estado;
import metricas.demo.Model.Lista;
import metricas.demo.Repository.EstadoR;
import metricas.demo.Repository.ListaR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruisu's
 */
@Service
public class ListaS {
    
    @Autowired
    private ListaR listaR;
    
    public List<Lista> getAll(){
        return listaR.getAll();
    }
    
    public Lista getById(Integer id){
        Lista lista = listaR.getById(id).orElseThrow(()-> new CustomException("No se encontró la lista"));
        return lista;
    }
    
    public Lista createLista(Lista lista){
        return listaR.createLista(lista);
    }
    
    public Lista updateLista(Lista lista){
        Lista listaDB = listaR.getById(lista.getId()).orElseThrow(()-> new CustomException("No se encontro la lista"));
        if(lista.getName() != null) {listaDB.setName(lista.getName());}
        if(lista.getDescription() != null) {listaDB.setDescription(lista.getDescription());}
        return listaR.updateLista(listaDB);
    }
    
    public void deleteLista(Integer id){
        listaR.getById(id).orElseThrow(()-> new CustomException("No se encontro la lista"));
        listaR.deleteLista(id);
    }
    
}
