
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.VentanaPrincipal;

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
        
        App a = new App(new Humano("Cris"),new CPU("Bot"),3);
        
        VentanaPrincipal v = new VentanaPrincipal(a);
        
        v.setVisible(true);
        v.setLocationRelativeTo(null);
        
        
        //a.iniciarJuego();
        
    }
    
}
