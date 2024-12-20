/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.JpaRepository;

import java.util.Optional;
import metricas.demo.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ruisu's
 */
public interface UsuarioJR extends JpaRepository<Usuario, Integer>{
    
    public Optional<Usuario> findByEmailAndPassword(String email, String password);
    public Optional<Usuario> findByEmail(String email);
    
}
