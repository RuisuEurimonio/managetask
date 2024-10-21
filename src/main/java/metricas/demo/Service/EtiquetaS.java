/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Service;

import java.util.List;
import metricas.demo.CustomExceptions.CustomException;
import metricas.demo.Model.Color;
import metricas.demo.Model.Etiqueta;
import metricas.demo.Repository.ColorR;
import metricas.demo.Repository.EtiquetaR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruisu's
 */
@Service
public class EtiquetaS {
    
    @Autowired
    private EtiquetaR etiquetaR;
    
    @Autowired
    private ColorR colorR;
    
    public List<Etiqueta> getAll(){
        return etiquetaR.getAll();
    }
    
    public Etiqueta getById(Integer id){
        Etiqueta tablero = etiquetaR.getById(id).orElseThrow(()-> new CustomException("No se encontró la etiqueta"));
        return tablero;
    }
    
    public Etiqueta createEtiqueta(Etiqueta rol){
        return etiquetaR.createTablero(rol);
    }
    
    public Etiqueta updateEtiqueta(Etiqueta etiqueta){
        Etiqueta etiquetaDB = etiquetaR.getById(etiqueta.getId()).orElseThrow(()-> new CustomException("No se encontro la etiqueta"));
        if(etiqueta.getName() != null) {etiquetaDB.setName(etiqueta.getName());}
        
        Color colorDB = colorR.getById(etiqueta.getColor().getId()).orElseThrow(()-> new CustomException("No se encontro el color referenciada"));
        if(etiqueta.getColor()!= null) {etiquetaDB.setColor(colorDB);}
        return etiquetaR.updateTablero(etiquetaDB);
    }
    
    public void deleteEtiqueta(Integer id){
        etiquetaR.getById(id).orElseThrow(()-> new CustomException("No se encontro el tablero"));
        etiquetaR.deleteTablero(id);
    }
   
}
