package data.subtiposAnimales;

import data.tiposAnimales.Mamifero;
import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class Acuatico extends Mamifero {

    public Acuatico(String nombre, int edad, float peso) {
        super(nombre, edad, peso);
    }

}