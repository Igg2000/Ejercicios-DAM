/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.PanelAnimacion;
import GUI.Ventana;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana v = new Ventana("Animacion Robot");
        PanelAnimacion p = new PanelAnimacion(v);
        v.ponPanel(p);
        new Thread(p).start();
    }
    
}
