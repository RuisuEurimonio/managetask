/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.JpaRepository;

import metricas.demo.Model.Prioridad;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ruisu's
 */
public interface PrioridadJR extends JpaRepository<Prioridad, Integer>{
    
}
