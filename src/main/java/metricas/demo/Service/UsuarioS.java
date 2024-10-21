/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Service;

import java.util.List;
import metricas.demo.CustomExceptions.CustomException;
import metricas.demo.Model.Estado;
import metricas.demo.Model.Prioridad;
import metricas.demo.Model.Rol;
import metricas.demo.Model.Tarjeta;
import metricas.demo.Model.Usuario;
import metricas.demo.Repository.EstadoR;
import metricas.demo.Repository.PrioridadR;
import metricas.demo.Repository.RolR;
import metricas.demo.Repository.TarjetaR;
import metricas.demo.Repository.UsuarioR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruisu's
 */
@Service
public class UsuarioS {
    
    
    @Autowired
    private UsuarioR usuarioR;
    
    @Autowired
    private RolR rolR;
    
    public List<Usuario> getAll(){
        return usuarioR.getAll();
    }
    
    public Usuario getById(Integer id){
        Usuario tarjeta = usuarioR.getById(id).orElseThrow(()-> new CustomException("No se encontró el usuario"));
        return tarjeta;
    }
    
    public Usuario createUsuario(Usuario usuario){
        return usuarioR.createUsuario(usuario);
    }
    
    public Usuario updateUsuario(Usuario usuario){
        Usuario usuarioDB = usuarioR.getById(usuario.getId()).orElseThrow(()-> new CustomException("No se encontro el usuario"));
        if(usuario.getName()!= null) {usuarioDB.setName(usuario.getName());}
        if(usuario.getEmail()!= null) {usuarioDB.setEmail(usuario.getEmail());}
        if(usuario.getPassword()!= null) {usuarioDB.setPassword(usuario.getPassword());}
        
        Rol rolDB = rolR.getById(usuario.getRol().getId()).orElseThrow(()-> new CustomException("No se encontro el rol referenciado"));
        if(usuario.getRol()!= null) {usuarioDB.setRol(rolDB);}
        
        return usuarioR.updateUsuario(usuarioDB);
    }
    
    public void deleteUsuario(Integer id){
        usuarioR.getById(id).orElseThrow(()-> new CustomException("No se encontro el usuario"));
        usuarioR.deleteUsuario(id);
    }
    
    
    
    
}
