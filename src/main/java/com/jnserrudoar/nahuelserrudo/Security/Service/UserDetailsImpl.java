/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jnserrudoar.nahuelserrudo.Security.Service;

import com.jnserrudoar.nahuelserrudo.Security.Entidad.Usuario;
import com.jnserrudoar.nahuelserrudo.Security.Entidad.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author jnser
 */
@Service
public class UserDetailsImpl  implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nomusuario) throws UsernameNotFoundException {
        Usuario usuario=usuarioService.getByNombreUsuario(nomusuario).get();
        return UsuarioPrincipal.build(usuario);
    }
    
}
