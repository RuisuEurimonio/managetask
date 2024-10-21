/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Service;

import java.util.List;
import metricas.demo.CustomExceptions.CustomException;
import metricas.demo.Model.Estado;
import metricas.demo.Model.Prioridad;
import metricas.demo.Model.Tarjeta;
import metricas.demo.Repository.EstadoR;
import metricas.demo.Repository.PrioridadR;
import metricas.demo.Repository.TarjetaR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruisu's
 */
@Service
public class TarjetaS {
    
    @Autowired
    private TarjetaR tarjetaR;
    
    @Autowired
    private EstadoR estadoR;
    
    @Autowired
    private PrioridadR prioridadR;
    
    public List<Tarjeta> getAll(){
        return tarjetaR.getAll();
    }
    
    public Tarjeta getById(Integer id){
        Tarjeta tarjeta = tarjetaR.getById(id).orElseThrow(()-> new CustomException("No se encontró la tarjeta"));
        return tarjeta;
    }
    
    public Tarjeta createTarjeta(Tarjeta tarjeta){
        return tarjetaR.createTarjeta(tarjeta);
    }
    
    public Tarjeta updateTarjeta(Tarjeta tarjeta){
        Tarjeta tarjetaDB = tarjetaR.getById(tarjeta.getId()).orElseThrow(()-> new CustomException("No se encontro la tarjeta"));
        if(tarjeta.getTitulo() != null) {tarjetaDB.setTitulo(tarjeta.getTitulo());}
        if(tarjeta.getDescription() != null) {tarjetaDB.setDescription(tarjeta.getDescription());}
        
        Estado estadoDB = estadoR.getById(tarjeta.getEstado().getId()).orElseThrow(()-> new CustomException("No se encontro el estado referenciado"));
        if(tarjeta.getEstado()!= null) {tarjetaDB.setEstado(estadoDB);}
        
        Prioridad prioridadDB = prioridadR.getById(tarjeta.getPrioridad().getId()).orElseThrow(()-> new CustomException("No se encontro la prioridad referenciada"));
        if(tarjeta.getPrioridad()!= null) {tarjetaDB.setPrioridad(prioridadDB);}
        
        return tarjetaR.updateTarjeta(tarjetaDB);
    }
    
    public void deleteTarjeta(Integer id){
        tarjetaR.getById(id).orElseThrow(()-> new CustomException("No se encontro la tarjeta"));
        tarjetaR.deleteTarjeta(id);
    }
    
    
    
}
