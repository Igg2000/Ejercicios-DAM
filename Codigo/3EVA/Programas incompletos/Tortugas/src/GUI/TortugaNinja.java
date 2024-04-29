/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Nacho
 */
public class TortugaNinja extends Tortuga{

    Color color;
    
    public TortugaNinja(float escalado, Color color) {
        super(escalado);
        this.color=color;
    }

    public TortugaNinja() {
    }

    @Override
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
        
        //cinta
        g.setColor(color);
        g.fillRect((int)(escalado*22), (int)(escalado*45), (int)(escalado*95), (int)(escalado*20));
        
        
        //ojos
        g.setColor(Color.black);
        g.fillOval((int)(escalado*40), (int)(escalado*45), (int)(escalado*20),(int)(escalado* 20));
        g.fillOval((int)(escalado*80), (int)(escalado*45), (int)(escalado*20), (int)(escalado*20));
        
    }

    
    
    
    
}
