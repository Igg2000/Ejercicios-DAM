/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
public class Perro {
    String nombre;

    public Perro(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Perro" + " llamado " + nombre;
    }
    
}
