/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author grovy
 */
public class Keko extends Rectangle {

    Color color;
    
    public Keko(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.color=Color.red;
    }
    
    public Keko(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color=color;
    }
    
    public void Dibujar(Graphics g){
        
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
        
      /*
        g.setColor(color.white);
        g.fillRect(this.x+3, this.y+3, this.width/3, this.height/3);
        g.setColor(color.white);
        g.fillRect(this.width+3, this.y+3, this.width/3, this.height/3);
      */  
    }
}
