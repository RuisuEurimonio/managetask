/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Repository;

import java.util.List;
import java.util.Optional;
import metricas.demo.JpaRepository.TarjetaJR;
import metricas.demo.Model.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ruisu's
 */
@Repository
public class TarjetaR {
    
    @Autowired
    private TarjetaJR tarjetaJR;
    
    public List<Tarjeta> getAll(){
        return tarjetaJR.findAll();
    }
    
    public Optional<Tarjeta> getById(int id){
        return tarjetaJR.findById(id);
    }
    
    public Tarjeta createTarjeta(Tarjeta tarjeta){
        return tarjetaJR.save(tarjeta);
    }
    
    public Tarjeta updateTarjeta(Tarjeta tarjeta){
        return tarjetaJR.save(tarjeta);
    }
    
    public void deleteTarjeta(int id){
        tarjetaJR.deleteById(id);
    }
    
}
