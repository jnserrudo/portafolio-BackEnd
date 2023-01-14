/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jnserrudoar.nahuelserrudo.Entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author jnser
 */
//@Getter @Setter al poner estas dos entidades ya no es necesario escribir todos los setter y getters, ahorrando codigo
//ahora lo dejo para que quede solo esta de ejemplo, en las siguientes usare solo los getter y setter, esto me lo posibilita lombok
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// automaticamente se generaran numeros, no sera necesario que lo ingresemos nosotros

    //private Long id;
    private int id;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")// el message aparece cuando no se cumple los requisitos de min y max
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")// el message aparece cuando no se cumple los requisitos de min y max
    private String apellido;

    @NotNull

    private String descripcion;

    private String img;

    public Persona() {
    }


//    
//    private String id_domicilio;
//    private String url_linkedin;
//    private String email;
//    private String celular;
    /*private String url_perfil;*/
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public void setApellido(String apellido) {
//        this.apellido = apellido;
//    }
//
//    public void setImg(String img) {
//        this.img = img;
//    }
//
//    public void setId_domicilio(String id_domicilio) {
//        this.id_domicilio = id_domicilio;
//    }
//
//    public void setUrl_linkedin(String url_linkedin) {
//        this.url_linkedin = url_linkedin;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setCelular(String celular) {
//        this.celular = celular;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public String getApellido() {
//        return apellido;
//    }
//
//    public String getImg() {
//        return img;
//    }
//
//    public String getId_domicilio() {
//        return id_domicilio;
//    }
//
//    public String getUrl_linkedin() {
//        return url_linkedin;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getCelular() {
//        return celular;
//    }
//    

    public Persona(String nombre, String apellido, String descripcion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
