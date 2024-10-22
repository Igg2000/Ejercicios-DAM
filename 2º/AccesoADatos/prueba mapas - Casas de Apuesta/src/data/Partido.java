/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
public class Partido {
    String Equipo1;
    String Equipo2;

    public Partido(String Equipo1, String Equipo2) {
        this.Equipo1 = Equipo1;
        this.Equipo2 = Equipo2;
    }

    @Override
    public String toString() {
        return Equipo1 + " VS " + Equipo2;
    }

    
    
}
