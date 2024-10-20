/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Controller;

import java.util.List;
import metricas.demo.Model.Rol;
import metricas.demo.Model.Tablero;
import metricas.demo.Service.RolS;
import metricas.demo.Service.TableroS;
import metricas.demo.Validations.OnCreate;
import metricas.demo.Validations.OnUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/api/tablero")
public class TableroC {
    
    @Autowired
    private TableroS tableroS;
    
    @GetMapping("/all")
    public ResponseEntity<List<Tablero>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(tableroS.getAll());
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Tablero> getById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(tableroS.getById(id));
    }
    
    @PostMapping("/create")
    public ResponseEntity<Tablero> createTablero(@Validated(OnCreate.class) @RequestBody Tablero tablero){
        return ResponseEntity.status(HttpStatus.CREATED).body(tableroS.createTablero(tablero));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Tablero> updateTablero(@Validated(OnUpdate.class) @RequestBody Tablero tablero){
        return ResponseEntity.status(HttpStatus.CREATED).body(tableroS.updateTablero(tablero));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTablero(@PathVariable("id") Integer id){
        tableroS.deleteTablero(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se elimino el rol con id: "+id);
    }
    
    
}
