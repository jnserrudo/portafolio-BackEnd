/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jnserrudoar.nahuelserrudo.Security.Service;

import com.jnserrudoar.nahuelserrudo.Security.Entidad.Rol;
import com.jnserrudoar.nahuelserrudo.Security.Enums.RolNombre;
import com.jnserrudoar.nahuelserrudo.Security.Repository.IRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jnser
 */
@Service
@Transactional//permite la persistencia con la bd mediante de rollbacks si se falla
public class RolService {
    @Autowired
    IRolRepository irolRepository;
    
    public Optional <Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
    
}
