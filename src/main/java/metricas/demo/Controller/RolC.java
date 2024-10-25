/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Controller;

import java.util.List;
import metricas.demo.Model.Rol;
import metricas.demo.Service.RolS;
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
@RequestMapping("/api/rol")
@RestController
@CrossOrigin
public class RolC {
    
    @Autowired
    private RolS rolS;
    
    @GetMapping("/all")
    public ResponseEntity<List<Rol>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(rolS.getAll());
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Rol> getById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(rolS.getById(id));
    }
    
    @PostMapping("/create")
    public ResponseEntity<Rol> createColor(@Validated(onCreate.class) @RequestBody Rol rol){
        return ResponseEntity.status(HttpStatus.CREATED).body(rolS.createRol(rol));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Rol> updateColor(@Validated(onUpdate.class) @RequestBody Rol rol){
        return ResponseEntity.status(HttpStatus.CREATED).body(rolS.updateRol(rol));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteColor(@PathVariable("id") Integer id){
        rolS.deleteRol(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se elimino el rol con id: "+id);
    }
    
    
}
