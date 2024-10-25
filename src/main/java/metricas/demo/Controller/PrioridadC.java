/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Controller;

import java.util.List;
import metricas.demo.Model.Prioridad;
import metricas.demo.Service.PrioridadS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import metricas.demo.Validations.onCreate;
import metricas.demo.Validations.onUpdate;

/**
 *
 * @author Ruisu's
 */
@RestController
@RequestMapping("/api/prioridad")
@CrossOrigin
public class PrioridadC {
    
    @Autowired
    private PrioridadS prioridadS;
    
    @GetMapping("/all")
    public ResponseEntity<List<Prioridad>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(prioridadS.getAll());
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Prioridad> getById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(prioridadS.getById(id));
    }
    
    @PostMapping("/create")
    public ResponseEntity<Prioridad> createColor(@Validated(onCreate.class) @RequestBody Prioridad prioridad){
        return ResponseEntity.status(HttpStatus.CREATED).body(prioridadS.createLista(prioridad));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Prioridad> updateColor(@Validated(onUpdate.class) @RequestBody Prioridad prioridad){
        return ResponseEntity.status(HttpStatus.CREATED).body(prioridadS.updateLista(prioridad));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteColor(@PathVariable("id") Integer id){
        prioridadS.deleteLista(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se elimino la prioridad con id: "+id);
    }
    
    
}
