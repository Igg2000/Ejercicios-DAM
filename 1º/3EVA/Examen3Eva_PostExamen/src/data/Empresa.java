package data;


import java.io.*;
import java.util.*;

public class Empresa {

    private String nombre;
    private List<Torneo> torneos = new ArrayList();

    /**
     * Constructor
     * @param nombre nombre de la empresa 
     */
    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", torneos=" + torneos + '}';
    }

    
    //hacia abajo estan los getter y los setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Torneo> getTorneos() {
        return torneos;
    }

    public void setTorneos(List<Torneo> torneos) {
        this.torneos = torneos;
    }
    
    
    

}