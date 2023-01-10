/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jnserrudoar.nahuelserrudo.service;

import com.jnserrudoar.nahuelserrudo.Entidad.Persona;
import com.jnserrudoar.nahuelserrudo.Interface.IPersonaService;
import com.jnserrudoar.nahuelserrudo.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jnser
 */
@Service
public class ImplementacionPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersRepositorio;
//esta  notacion permite inyectar dependencias dentro de otras 
    @Override
    public List<Persona> getPersona() {
        // // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<Persona> persona= ipersRepositorio.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersRepositorio.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersRepositorio.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona=ipersRepositorio.findById(id).orElse(null);//si no lo encuentra, me devuelve nulo
        return persona;
    }
    
}
