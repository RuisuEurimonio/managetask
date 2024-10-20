/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Controller;

import java.util.List;
import metricas.demo.Model.Estado;
import metricas.demo.Service.EstadoS;
import metricas.demo.Validations.OnCreate;
import metricas.demo.Validations.OnUpdate;
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

/**
 *
 * @author Ruisu's
 */
@RestController
@RequestMapping("/api/lista")
@CrossOrigin
public class ListaC {
    
    @Autowired
    private EstadoS estadoS;
    
    @GetMapping("/all")
    public ResponseEntity<List<Estado>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(estadoS.getAll());
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Estado> getById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(estadoS.getById(id));
    }
    
    @PostMapping("/create")
    public ResponseEntity<Estado> createColor(@Validated(OnCreate.class) @RequestBody Estado estado){
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoS.createEstado(estado));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Estado> updateColor(@Validated(OnUpdate.class) @RequestBody Estado estado){
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoS.updateEstado(estado));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteColor(@PathVariable("id") Integer id){
        estadoS.deleteEstado(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se elimino el estado con id: "+id);
    }
    
    
}
