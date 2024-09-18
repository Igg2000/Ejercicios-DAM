/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.NBoton;
import GUI.VPP;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VPP v= new VPP();
        
        JPanel p = new JPanel();
        //p.setLayout(null);
        NBoton b= new NBoton("Boton de prueba", Color.red);
        NBoton b2= new NBoton("Hola");
        NBoton b3= new NBoton("Buenos dias", new Color(51, 255, 193), Color.yellow.brighter(),new Font("MV Boli", 1, 16),Color.blue);
       // b.setBounds(50, 50, 50, 50);
       
        p.add(b);
        p.add(b2);
        p.add(b3);
        
        
        v.ponPanel(p);
    }
    
    
    
}
