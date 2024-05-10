/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.PInfoTiempo;
import GUI.PanelP;
import GUI.VPP;
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
        
        VPP v= new VPP("Prueba Combo Box");
        v.setVisible(true);
        v.setSize(500,400);
        v.setLocationRelativeTo(null);
        v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        PanelP p= new PanelP(v);
        v.setContentPane(p);
        v.revalidate();
        
      /*  
        PInfoTiempo pi= new PInfoTiempo(v,"mañana","madrid");
       
        v.setContentPane(pi);
        v.revalidate();
     */
    }
    
}
