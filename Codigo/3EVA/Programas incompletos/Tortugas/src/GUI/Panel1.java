/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class Panel1 extends JPanel{

    public Panel1() {
    
        Tortuga t1= new Tortuga(10,10,150,150);
        //Tortuga t1= new Tortuga();
        //this.setLayout(new GridLayout());
        
         this.setLayout(new BorderLayout());
         this.setPreferredSize(new Dimension(400, 300));
         
        //this.setLayout(null);
        //this.add(t1);
        this.add(t1, BorderLayout.CENTER);
    
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        
        pintarTortuga(g,50,50,300,150);

    
    }

    private void pintarTortuga(Graphics g, int x, int y, int ancho, int alto) {

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

       //ojos
           g.setColor(Color.black);
           g.fillOval(40, 45, 20, 20);
           g.fillOval(80, 45, 20, 20);
        
     */
        

    }

    
    
}
