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

    float escalado;

    public Tortuga(float escalado) {
        this.escalado = escalado;
    }
    
    
    public Tortuga() {

       this.escalado= 1.0f;
    }


    
    @Override
    protected void paintComponent(Graphics g) {
    
        
        pintaTortuga(g,this.escalado);
    }

    protected void pintaTortuga(Graphics g, float escalado) {
            
         //patas
        
        //separacionEntrePatas
        int sp=60;
        
        for (int i = 0; i < 4; i++) {
           g.setColor(Color.green.brighter());
           g.fillOval((int)(escalado*(80+sp*i)),(int)(escalado* 150),(int)(escalado* 50),(int)(escalado* 100));
        }
        
        //caparazon
        g.setColor(Color.green.darker());
        g.fillOval((int)(escalado*50),(int)(escalado* 50),(int)(escalado* 300),(int)(escalado* 150));
        
        //cabeza
        g.setColor(Color.green.brighter());
        g.fillOval((int)(escalado*20), (int)(escalado*20), (int)(escalado*100), (int)(escalado*100));
        
        //ojos
        g.setColor(Color.black);
        g.fillOval((int)(escalado*40), (int)(escalado*45), (int)(escalado*20),(int)(escalado* 20));
        g.fillOval((int)(escalado*80), (int)(escalado*45), (int)(escalado*20), (int)(escalado*20));
    }
}

