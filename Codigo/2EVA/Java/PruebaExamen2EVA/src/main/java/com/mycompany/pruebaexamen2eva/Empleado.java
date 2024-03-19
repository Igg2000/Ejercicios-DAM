/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebaexamen2eva;

/**
 *
 * @author Nacho
 */
public class Empleado extends Persona {

    private int sucursal;
    
    public Empleado(String dni, String nombre, int edad) {
        super(dni, nombre, edad);
    }

    
    public void asignarSucursal(Sucursal s){
    
    this.sucursal = s.getId();
    }
    
    @Override
    public String toString() {
        return "Empleado: " + super.toString() ;
    }
    
    
}
