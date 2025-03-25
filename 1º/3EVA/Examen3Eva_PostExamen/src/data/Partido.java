package data;


import java.io.*;
import java.util.*;

/**
 * 
 */
public class Partido {



    private Participante participante1;
    private Participante participante2;
    private Participante ganador=null;

    public Partido(Participante participante1, Participante participante2) {
        this.participante1 = participante1;
        this.participante2 = participante2;
    }

    
    public void JugarPartido() {
        Random rand = new Random();
        this.ganador = rand.nextBoolean() ? participante1 : participante2;
    }

    @Override
    public String toString() {
        return participante1.getNombre() + " VS " + participante2.getNombre();
    }

    
    
    //hacia abajo estan los getter y los setters
    
    public Participante getParticipante1() {
        return participante1;
    }

    public void setParticipante1(Participante participante1) {
        this.participante1 = participante1;
    }

    public Participante getParticipante2() {
        return participante2;
    }

    public void setParticipante2(Participante participante2) {
        this.participante2 = participante2;
    }

    public Participante getGanador() {
        return ganador;
    }

    public void setGanador(Participante ganador) {
        this.ganador = ganador;
    }

    
    
    
}