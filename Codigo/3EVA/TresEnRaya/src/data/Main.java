/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.*;
import javax.swing.JFrame;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        App a= new App();
        
        MiVentana v= new MiVentana();
        //PanelJuego p = new PanelJuego(a);
        
        PanelPrincipal p1 = new PanelPrincipal(a);
        
        v.ponPanel(p1);
        
        
        
        
    }


    
}
