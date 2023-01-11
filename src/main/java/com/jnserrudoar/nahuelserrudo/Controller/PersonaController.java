/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jnserrudoar.nahuelserrudo.Controller;

import com.jnserrudoar.nahuelserrudo.Entidad.Persona;
import com.jnserrudoar.nahuelserrudo.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jnser
 */
@RestController
//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins = "https://portafolio-backend-jnserrudo.onrender.com")
public class PersonaController {
    @Autowired IPersonaService ipersonaService; 
//el servicio llama al controlador , hacemos inyeccion de la interface, ya que la interface llama al servicio
    
    
    @GetMapping("/personas/traer")//esto lo podra hacer cualquiera
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){  
        return ipersonaService.findPersona((long)2);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String postPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "se creo la persona";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")// lo que esta antes del id es fijo, solo variara el id
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "se elimino la persona";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}") //esta anotacion permite editar
    public Persona updatePersona(@PathVariable Long id,
                                @RequestParam("nombre") String newnombre,
                                @RequestParam("celular") String newcel,
                                @RequestParam("apellido") String newapellido,
                                @RequestParam("url_linkedin") String newurl_linkedin,
                                @RequestParam("img") String newimg,
                                @RequestParam("email") String newemail
                                ){
        Persona persona=ipersonaService.findPersona(id);
        
        
        persona.setNombre(newnombre);
        persona.setApellido(newapellido);
        persona.setCelular(newemail);
        persona.setEmail(newemail);
        persona.setUrl_linkedin(newurl_linkedin);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
            
}
