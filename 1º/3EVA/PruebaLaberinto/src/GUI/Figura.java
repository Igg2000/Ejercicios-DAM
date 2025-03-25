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
public class Figura extends Rectangle {

    Color color;
    
    public Figura(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.color=Color.red;
    }
    
    public Figura(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color=color;
    }
    
    public void Dibujar(Graphics g){
        
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
        
    }
}
