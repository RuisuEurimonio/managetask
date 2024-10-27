/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Controller;

import java.util.List;
import metricas.demo.Model.Usuario;
import metricas.demo.Service.UsuarioS;
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
@RequestMapping("/api/usuario")
@CrossOrigin
public class UsuarioC {
    
    @Autowired
    private UsuarioS usuarioS;
    
    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioS.getAll());
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioS.getById(id));
    }
    
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@Validated(onUpdate.class)@RequestBody Usuario usuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(usuarioS.validateCredentials(usuario));
    }
    
    @PostMapping("/create")
    public ResponseEntity<Usuario> createTarjeta(@Validated(onCreate.class) @RequestBody Usuario usuario) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioS.createUsuario(usuario));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Usuario> updateTarjeta(@Validated(onUpdate.class) @RequestBody Usuario usuario) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioS.updateUsuario(usuario));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTarjeta(@PathVariable("id") Integer id){
        usuarioS.deleteUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se elimino el usuario con id: "+id);
    }
    
    
}
