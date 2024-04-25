/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class Panel1 extends JPanel{

    public Panel1() {
    
        
    
    
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        
        pintarTortuga(g,50,50,300,150);

    
    }

    private void pintarTortuga(Graphics g, int x, int y, int ancho, int alto) {

        
        //patas
        
        //separacionEntrePatas
        int sp=60;
        
        for (int i = 0; i < 4; i++) {
           g.setColor(Color.green.brighter());
           g.fillOval((80+sp*i)+x, 150+y, 50+ancho, 100+alto);
        }
        
        //caparazon
        g.setColor(Color.green.darker());
        g.fillOval(50+x, 50+y, ancho, alto);
        
        //cabeza
        g.setColor(Color.green.brighter());
        g.fillOval(20+x, 20+y, 100+ancho, 100+alto);
        
     /*
        //patas
        
        //separacionEntrePatas
        int sp=60;
        
        for (int i = 0; i < 4; i++) {
           g.setColor(Color.green.brighter());
           g.fillOval((80+sp*i), 150, 50, 100);
        }
        
        //caparazon
        g.setColor(Color.green.darker());
        g.fillOval(50, 50, 300, 150);
        
        //cabeza
        g.setColor(Color.green.brighter());
        g.fillOval(20, 20, 100, 100);
        
     */
        
        
    }

    
    
}
