package data.subtiposAnimales;

import data.tiposAnimales.Mamifero;
import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class Terrestre extends Mamifero {

    public Terrestre(String nombre, int edad, float peso) {
        super(nombre, edad, peso);
    }
}