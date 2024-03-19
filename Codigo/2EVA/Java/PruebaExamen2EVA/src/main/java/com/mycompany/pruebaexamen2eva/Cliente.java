/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebaexamen2eva;

/**
 *
 * @author Nacho
 */
public class Cliente extends Persona {
    
    
   private final TipoVehiculo tipoVehiculo;

    public Cliente(String dni, String nombre, int edad, TipoVehiculo tipoVehiculo) {
        super(dni, nombre, edad);
        this.tipoVehiculo = tipoVehiculo;
    }

   

    @Override
    public String toString() {
        return  "Cliente: " + super.toString()+ " tipoVehiculo=" + tipoVehiculo;
    }

   
   
}
