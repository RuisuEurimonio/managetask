/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Controller;

import java.util.List;
import metricas.demo.Model.Etiqueta;
import metricas.demo.Model.Tablero;
import metricas.demo.Service.EtiquetaS;
import metricas.demo.Service.TableroS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author Ruisu's
 */
@RestController
@RequestMapping("/api/etiqueta")
@CrossOrigin
public class EtiquetaC {
    
    @Autowired
    private EtiquetaS etiquetaS;
    
    @GetMapping("/all")
    public ResponseEntity<List<Etiqueta>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(etiquetaS.getAll());
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Etiqueta> getById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(etiquetaS.getById(id));
    }
    
    @PostMapping("/create")
    public ResponseEntity<Etiqueta> createEtiqueta(@Validated(onCreate.class) @RequestBody Etiqueta etiqueta){
        return ResponseEntity.status(HttpStatus.CREATED).body(etiquetaS.createEtiqueta(etiqueta));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Etiqueta> updateEtiqueta(@Validated(onUpdate.class) @RequestBody Etiqueta etiqueta){
        return ResponseEntity.status(HttpStatus.CREATED).body(etiquetaS.updateEtiqueta(etiqueta));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEtiqueta(@PathVariable("id") Integer id){
        etiquetaS.deleteEtiqueta(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se elimino la etiqueta con id: "+id);
    }
    
}
