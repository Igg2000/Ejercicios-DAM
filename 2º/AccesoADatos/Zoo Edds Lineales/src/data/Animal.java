package data;

import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class Animal {

    
    private String nombre;
    private int edad;
    private float peso;

    public Animal(String nombre, int edad, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public void desplazarse() {
        // TODO implement here
    }

    public String sacarRazaDelAnimal(){
        String raza;
        String[] split = this.getClass().getName().split("\\.");
        raza=split[split.length-1];
        return raza;
    }
    
    @Override
    public String toString() {
        return "Animal: "+ sacarRazaDelAnimal() + " nombre: " + nombre + ", edad: " + edad + ", peso: " + peso;
    }

    
}