/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jnserrudoar.nahuelserrudo.Controller;

import com.jnserrudoar.nahuelserrudo.Dto.dtoPersona;
import com.jnserrudoar.nahuelserrudo.Entidad.Persona;
import com.jnserrudoar.nahuelserrudo.Security.Controller.Mensaje;
import com.jnserrudoar.nahuelserrudo.service.ImplementacionPersonaService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jnser
 */
@RestController
//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/personas")
@CrossOrigin(origins = {"https://portafolio-serrudo-jose-nahuel.web.app","http://localhost:4200"})
public class PersonaController {
    
    @Autowired
    ImplementacionPersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("persona eliminada"), HttpStatus.OK);
    }
    
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
//        if(StringUtils.isBlank(dtopersona.getNombre())){
//            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        }
//        if(personaService.existsByNombreE(dtopersona.getNombre())){
//            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
//        }
//        
//        Persona persona = new Persona(
//                dtopersona.getNombre(), dtopersona.getDescripcion()
//            );
//        personaService.save(persona);
//        return new ResponseEntity(new Mensaje("persona creada"), HttpStatus.OK);
//                
//    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg()); 
        
        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
    
    
    
    
    
    
    
    
//    @Autowired IPersonaService ipersonaService; 
////el servicio llama al controlador , hacemos inyeccion de la interface, ya que la interface llama al servicio
//    
//    
//    @GetMapping("/personas/traer")//esto lo podra hacer cualquiera
//    public List<Persona> getPersona(){
//        return ipersonaService.getPersona();
//    }
//    @GetMapping("/personas/traer/perfil")
//    public Persona findPersona(){  
//        return ipersonaService.findPersona((long)2);
//    }
//    
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/personas/crear")
//    public String postPersona(@RequestBody Persona persona){
//        ipersonaService.savePersona(persona);
//        return "se creo la persona";
//    }
//    
//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/personas/borrar/{id}")// lo que esta antes del id es fijo, solo variara el id
//    public String deletePersona(@PathVariable Long id){
//        ipersonaService.deletePersona(id);
//        return "se elimino la persona";
//    }
//    
//    @PreAuthorize("hasRole('ADMIN')")
//    @PutMapping("/personas/editar/{id}") //esta anotacion permite editar
//    public Persona updatePersona(@PathVariable Long id,
//                                @RequestParam("nombre") String newnombre,
//                                @RequestParam("celular") String newcel,
//                                @RequestParam("apellido") String newapellido,
//                                @RequestParam("url_linkedin") String newurl_linkedin,
//                                @RequestParam("img") String newimg,
//                                @RequestParam("email") String newemail
//                                ){
//        Persona persona=ipersonaService.findPersona(id);
//        
//        
//        persona.setNombre(newnombre);
//        persona.setApellido(newapellido);
//        persona.setCelular(newemail);
//        persona.setEmail(newemail);
//        persona.setUrl_linkedin(newurl_linkedin);
//        
//        ipersonaService.savePersona(persona);
//        return persona;
//    }
//            
}
