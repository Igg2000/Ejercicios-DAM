package data;


import java.io.*;
import java.util.*;


public class Participante {
    
    public static int numTotalParticipantes=0;
    private int numParticipante;
    private String nombre;
    
    
    /**
     * Constructor que le asigna un nombre al participante
     * @param nombre nombre del participante
     */
    public Participante(String nombre, int numParticipante) {
        numTotalParticipantes++;
        this.numParticipante = numParticipante;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return numParticipante + ". " + nombre;
    }

    //hacia abajo estan los getter y los setters
    
    public int getNumParticipante() {
        return numParticipante;
    }

    public void setNumParticipante(int numParticipante) {
        this.numParticipante = numParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}