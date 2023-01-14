/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jnserrudoar.nahuelserrudo.service;

import com.jnserrudoar.nahuelserrudo.Entidad.Persona;
import com.jnserrudoar.nahuelserrudo.Repository.IPersonaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jnser
 */
@Service
@Transactional
public class ImplementacionPersonaService{
    @Autowired IPersonaRepository ipersRepositorio;
//esta  notacion permite inyectar dependencias dentro de otras 
   public List<Persona> list(){
         return ipersRepositorio.findAll();
     }
     
     public Optional<Persona> getOne(int id){
         return ipersRepositorio.findById(id);
     }
     
     public Optional<Persona> getByNombre(String nombre){
         return ipersRepositorio.findByNombre(nombre);
     }
     
     public void save(Persona persona){
         ipersRepositorio.save(persona);
     }
     
     public void delete(int id){
         ipersRepositorio.deleteById(id);
     }
     
     public boolean existsById(int id){
         return ipersRepositorio.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return ipersRepositorio.existsByNombre(nombre);
     }
    
    
}



//public class ImplementacionPersonaService implements IPersonaService{
//    @Autowired IPersonaRepository ipersRepositorio;
////esta  notacion permite inyectar dependencias dentro de otras 
//    @Override
//    public List<Persona> getPersona() {
//        // // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        List<Persona> persona= ipersRepositorio.findAll();
//        return persona;
//    }
//
//    @Override
//    public void savePersona(Persona persona) {
//        ipersRepositorio.save(persona);
//    }
//
//    @Override
//    public void deletePersona(Long id) {
//        ipersRepositorio.deleteById(id);
//    }
//
//    @Override
//    public Persona findPersona(Long id) {
//        Persona persona=ipersRepositorio.findById(id).orElse(null);//si no lo encuentra, me devuelve nulo
//        return persona;
//    }
//    
//}
