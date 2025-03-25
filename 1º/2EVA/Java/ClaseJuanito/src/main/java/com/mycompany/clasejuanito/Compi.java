/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clasejuanito;

/**
 *
 * @author Nacho
 */
public class Compi {
    
    
    String nombre;
    String equipoFavorito;
    boolean esAmigo;

    public Compi(String nombre, String equipoFavorito, boolean esAmigo) {
        this.nombre = nombre;
        this.equipoFavorito = equipoFavorito;
        this.esAmigo = esAmigo;
    }

  /*
    public void mostrar(String nombre, String equipo) {
        
        System.out.println("El nombre del compi es "+ nombre +" y su equipo favorito es el "+ equipo);
       
    }*/

    @Override
    public String toString() {
        return "Mi compi se llama " + nombre + " y su equipoFavorito es " + equipoFavorito + ", esAmigo=" + esAmigo;
    }

    
}
