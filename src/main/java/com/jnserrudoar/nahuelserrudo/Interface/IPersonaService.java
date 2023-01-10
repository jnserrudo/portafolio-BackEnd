/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jnserrudoar.nahuelserrudo.Interface;

import com.jnserrudoar.nahuelserrudo.Entidad.Persona;
import java.util.List;


/**
 *
 * @author jnser
 */
public interface IPersonaService {
//es la interfaz del servicio de persona

//traer una lista de personas
public List<Persona> getPersona();

//guardar objetos persona
public void savePersona(Persona persona);

public void deletePersona(Long id);

public Persona findPersona(Long id);

}

