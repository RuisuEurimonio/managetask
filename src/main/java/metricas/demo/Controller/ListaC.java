/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Controller;

import java.util.List;
import metricas.demo.Model.Estado;
import metricas.demo.Model.Lista;
import metricas.demo.Service.EstadoS;
import metricas.demo.Service.ListaS;
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
@RequestMapping("/api/lista")
@CrossOrigin
public class ListaC {
    
    @Autowired
    private ListaS listaS;
    
    @GetMapping("/all")
    public ResponseEntity<List<Lista>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(listaS.getAll());
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Lista> getById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(listaS.getById(id));
    }
    
    @PostMapping("/create")
    public ResponseEntity<Lista> createColor(@Validated(onCreate.class) @RequestBody Lista lista){
        return ResponseEntity.status(HttpStatus.CREATED).body(listaS.createLista(lista));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Lista> updateColor(@Validated(onUpdate.class) @RequestBody Lista lista){
        return ResponseEntity.status(HttpStatus.CREATED).body(listaS.updateLista(lista));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteColor(@PathVariable("id") Integer id){
        listaS.deleteLista(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se elimino la lista con id: "+id);
    }
    
    
}
