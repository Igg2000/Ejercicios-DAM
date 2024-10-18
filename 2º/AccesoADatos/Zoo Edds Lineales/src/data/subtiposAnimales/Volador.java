package data.subtiposAnimales;

import data.tiposAnimales.Mamifero;
import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class Volador extends Mamifero {

    public Volador(String nombre, int edad, float peso) {
        super(nombre, edad, peso);
    }

}