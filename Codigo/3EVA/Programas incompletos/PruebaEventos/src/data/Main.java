/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.Ventana;
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
        
        Ventana v= new Ventana();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
        v.setSize(500,500);
        v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
