/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Controller;

import java.util.List;
import metricas.demo.Model.Etiqueta;
import metricas.demo.Model.Tarjeta;
import metricas.demo.Service.EtiquetaS;
import metricas.demo.Service.TarjetaS;
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
@RequestMapping("/api/tarjeta")
@CrossOrigin
public class TarjetaC {
    
    @Autowired
    private TarjetaS tarjetaS;
    
    @GetMapping("/all")
    public ResponseEntity<List<Tarjeta>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(tarjetaS.getAll());
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Tarjeta> getById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(tarjetaS.getById(id));
    }
    
    @PostMapping("/create")
    public ResponseEntity<Tarjeta> createTarjeta(@Validated(OnCreate.class) @RequestBody Tarjeta tarjeta){
        return ResponseEntity.status(HttpStatus.CREATED).body(tarjetaS.createTarjeta(tarjeta));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Tarjeta> updateTarjeta(@Validated(OnUpdate.class) @RequestBody Tarjeta tarjeta){
        return ResponseEntity.status(HttpStatus.CREATED).body(tarjetaS.updateTarjeta(tarjeta));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTarjeta(@PathVariable("id") Integer id){
        tarjetaS.deleteTarjeta(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se elimino la tarjeta con id: "+id);
    }
    
}
