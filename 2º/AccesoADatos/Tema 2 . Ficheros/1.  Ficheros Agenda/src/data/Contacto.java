/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
public class Contacto {
    private int id;
    private static int numeroDeContactos=0;
    private String nombre;
    private int telefono;

    public Contacto(String nombre, int telefono) {
        numeroDeContactos++;
        this.id = numeroDeContactos;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }
    
    

    @Override
    public String toString() {
        return id + ":" + nombre + ":" + telefono;
    }
    
    
}
