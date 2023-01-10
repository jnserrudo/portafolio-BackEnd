/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jnserrudoar.nahuelserrudo.Security.Service;

import com.jnserrudoar.nahuelserrudo.Security.Entidad.Usuario;
import com.jnserrudoar.nahuelserrudo.Security.Repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jnser
 */

/*
@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String usuario){
        return iusuarioRepository.findByNombreUsuario(usuario);
    }
    
    public boolean existByNombreUsuario(String usuario){
        return iusuarioRepository.existByNombreUsuario(usuario);
        
    }
    
    public boolean existsByEmail(String email){
        return iusuarioRepository.existByEmail(email);
        
    }
    
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
    
}
*/
@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iusuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}