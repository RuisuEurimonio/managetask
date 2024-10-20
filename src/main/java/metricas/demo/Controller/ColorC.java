/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Controller;

import java.util.List;
import metricas.demo.Model.Color;
import metricas.demo.Service.ColorS;
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
@RequestMapping("/api/color")
public class ColorC {
    
    @Autowired
    private ColorS colorS;
    
    @GetMapping("/all")
    public ResponseEntity<List<Color>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(colorS.getAll());
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Color> getById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(colorS.getById(id));
    }
    
    @PostMapping("/create")
    public ResponseEntity<Color> createColor(@Validated(OnCreate.class) @RequestBody Color color){
        return ResponseEntity.status(HttpStatus.CREATED).body(colorS.createColor(color));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Color> updateColor(@Validated(OnUpdate.class) @RequestBody Color color){
        return ResponseEntity.status(HttpStatus.CREATED).body(colorS.updateColor(color));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteColor(@PathVariable("id") Integer id){
        colorS.deleteColor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se elimino el color con id: "+id);
    }
    
}
