/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Repository;

import java.util.List;
import java.util.Optional;
import metricas.demo.JpaRepository.TarjetaJR;
import metricas.demo.JpaRepository.UsuarioJR;
import metricas.demo.Model.Tarjeta;
import metricas.demo.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ruisu's
 */
@Repository
public class UsuarioR {
    
    @Autowired
    private UsuarioJR usuarioJR;
    
    public List<Usuario> getAll(){
        return usuarioJR.findAll();
    }
    
    public Optional<Usuario> validateCredentials(String email, String contrasena){
        return usuarioJR.findByEmailAndPassword(email, contrasena);
    }
    
    public Optional<Usuario> validateEmail(String email){
        return usuarioJR.findByEmail(email);
    }
    
    public Optional<Usuario> getById(int id){
        return usuarioJR.findById(id);
    }
    
    public Usuario createUsuario(Usuario usuario){
        return usuarioJR.save(usuario);
    }
    
    public Usuario updateUsuario(Usuario usuario){
        return usuarioJR.save(usuario);
    }
    
    public void deleteUsuario(int id){
        usuarioJR.deleteById(id);
    }
    
}
