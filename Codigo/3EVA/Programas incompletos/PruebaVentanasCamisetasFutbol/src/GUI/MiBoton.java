/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author Nacho
 */
class MiBoton extends JButton{
    
    int numRayas=5;

    public MiBoton(String nombre) {
        super(nombre);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        int anchoRaya=this.getWidth()/this.numRayas;
        
        
        g.setColor(Color.red.darker());
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
               
        for (int i = 0; i < numRayas; i++) {
            if (i%2==0){
                g.setColor(Color.red.darker());
            } else{
                g.setColor(Color.blue.darker());
            }
            
            g.fillRect(i*anchoRaya, 0, anchoRaya, this.getHeight());
        }
        g.setColor(Color.yellow.darker());
        //g.drawLine(0, 50,50, 50);
        
        g.drawString(this.getText(), this.getWidth()/2-this.getText().length(), 15);
        
    }
    
    
}
