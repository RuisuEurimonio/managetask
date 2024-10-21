/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Repository;

import java.util.List;
import java.util.Optional;
import metricas.demo.JpaRepository.EtiquetaJR;
import metricas.demo.Model.Etiqueta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ruisu's
 */
@Repository
public class EtiquetaR {
    
    
    @Autowired
    private EtiquetaJR etiquetaJR;
    
    public List<Etiqueta> getAll(){
        return etiquetaJR.findAll();
    }
    
    public Optional<Etiqueta> getById(int id){
        return etiquetaJR.findById(id);
    }
    
    public Etiqueta createTablero(Etiqueta etiqueta){
        return etiquetaJR.save(etiqueta);
    }
    
    public Etiqueta updateTablero(Etiqueta etiqueta){
        return etiquetaJR.save(etiqueta);
    }
    
    public void deleteTablero(int id){
        etiquetaJR.deleteById(id);
    }
    
}
