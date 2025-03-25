/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebaexamen2eva;

/**
 *
 * @author Nacho
 */
abstract class Persona {

protected String dni;
protected String nombre;
protected int edad;

    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }



    @Override
    public String toString() {
        return "dni=" + dni + ", nombre=" + nombre + ", edad=" + edad;
    }



}
