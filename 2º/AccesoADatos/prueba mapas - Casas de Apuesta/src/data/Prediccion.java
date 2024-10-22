/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
public class Prediccion {
    int puntosEquipo1;
    int puntosEquipo2;

    public Prediccion(int puntosEquipo1, int puntosEquipo2) {
        this.puntosEquipo1 = puntosEquipo1;
        this.puntosEquipo2 = puntosEquipo2;
    }

    @Override
    public String toString() {
        return "Prediccion: "+ puntosEquipo1 + "-" + puntosEquipo2;
    }
    
    
}
