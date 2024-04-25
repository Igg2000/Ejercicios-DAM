/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author Nacho
 */
class MiBoton extends JButton{
    
    int numRayas=5;

    public MiBoton(int x,int y,int WIDTH,int HEIGHT) {
        this.setBounds(x , y, WIDTH, HEIGHT);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

               
        for (int i = 0; i < numRayas; i++) {
            if (i%2==0){
                g.setColor(Color.red);
                g.fill3DRect(i*this.getWidth()/this.numRayas, 0, this.getWidth()/this.numRayas, this.getHeight(), true);
            } else{
                g.setColor(Color.blue.darker());
                g.fill3DRect(i*this.getWidth()/this.numRayas, 0, this.getWidth()/this.numRayas, this.getHeight(), true);
            }
        }
       
        
        
    }
    
    
}
