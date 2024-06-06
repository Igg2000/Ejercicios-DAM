/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class Ronda {
    
    private List<Partido> partidos = new ArrayList();
    private String ronda;

    /**
     * constructor
     * @param numRonda numero de ronda
     */
    public Ronda(int numRonda) {
    
        if (numRonda<1 || numRonda>6){
            JOptionPane.showMessageDialog(null, "Has introducido un numero de ronda invalido");
            return;
        }
        
        switch(numRonda){
            case 1: this.ronda="Final"; break; 
            case 2: this.ronda="Semifinal";break; 
            case 3: this.ronda="Cuartos de final";break; 
            case 4: this.ronda="Octavos de final";break; 
            case 5: this.ronda="Dieciseisavos de final";break; 
            case 6: this.ronda="Treintaidosavos de final";break; 
        }
        
    }

    @Override
    public String toString() {
        
        String cad="\n";
        for (Partido p : partidos) {
            cad += p+"\n";
        }
        
        return "-----"+ronda+"-----"+ " "+cad;
    }

    
    //de aqui hacia abajo solo getter y setters 
    
    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public String getRonda() {
        return ronda;
    }

    public void setRonda(String ronda) {
        this.ronda = ronda;
    }
    
    
    
}
