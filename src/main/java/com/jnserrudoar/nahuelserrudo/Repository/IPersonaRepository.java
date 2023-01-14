/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jnserrudoar.nahuelserrudo.Repository;

import com.jnserrudoar.nahuelserrudo.Entidad.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jnser
 */
//ponemos la notacion para denotar que es un repostirio
@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Integer>{
//se extiende de jparepositori y luego se pone que vamos a tomar y tambien el tipo de la primary key
    
    public Optional<Persona> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
