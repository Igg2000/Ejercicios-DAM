/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.pruebaexamen2eva;

/**
 *
 * @author Nacho
 */
public enum TipoVehiculo {
    
    Coche,Moto,Camion;
    
    @Override    
    public String toString() {
        
        if (ordinal() == Coche.ordinal()){
            return "Coche";}
            else if (ordinal() == Moto.ordinal()){
                   return "Moto";}
            else if (ordinal() == Camion.ordinal()){
                return "Camion";
            }
        return null;
    }
    
}
