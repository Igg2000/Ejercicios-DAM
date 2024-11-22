/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.PanelAnim;
import GUI.Vpal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Monitor m = new Monitor();
        
        Mas m1=new Mas(m);
        m1.start();
        
        Menos m2=new Menos(m);
        m2.start();
        
        Asterisco m3=new Asterisco(m);
        m3.start();
        
        
        Vpal v = new Vpal();
        PanelAnim p;
        if(m.isFin()){
            v.setVisible(true);
            p= new PanelAnim(m.getCad());
            v.ponPanel(p);
            new Thread(p).start();
        }
            
        
        
    }
    
}
