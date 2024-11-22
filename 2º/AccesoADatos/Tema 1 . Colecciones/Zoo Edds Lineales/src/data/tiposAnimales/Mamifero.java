package data.tiposAnimales;

import data.Animal;
import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class Mamifero extends Animal {

    public Mamifero(String nombre, int edad, float peso) {
        super(nombre, edad, peso);
    }

}