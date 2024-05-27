/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.MiVentana;
import java.io.IOException;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
    Laberinto l= new Laberinto();
    

    l.leerLab();
    l.pintarLabConsola();
    l.pintarLabVentana();
    
    
    }
    
}
