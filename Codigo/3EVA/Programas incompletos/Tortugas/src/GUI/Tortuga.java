/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author grovy
 */
class Tortuga extends JLabel {

    int x;
    int y;
    int ancho;
    int alto;

    public Tortuga(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }
    

    
    @Override
    protected void paintComponent(Graphics g) {
    
        
        pintaTortuga(g);
    }

    private void pintaTortuga(Graphics g) {
            
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
        
        //ojos
           g.setColor(Color.black);
           g.fillOval(40, 45, 20, 20);
           g.fillOval(80, 45, 20, 20);
    }
}

