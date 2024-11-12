/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */
public class Corredor extends Rectangle implements Runnable {

    int id;
    int salto=2;
    long retardo = 10 + (long) (Math.random() * 40);
    Boolean corriendo=false;
    
    public Corredor(int id,int x, int y, int width, int height) {
        super(x, y, width, height);
        this.id = id;
    }
    
    
    public void mover() {
        x= x+salto;
    }
    
    
    public void pintar(Graphics g){
        g.setColor(Color.lightGray);
        g.fillRect(0, y, x, height);
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
        g.setColor(Color.black);
        g.drawString(""+retardo, x, y-20);
        
    }
    
    
    @Override
    public void run() {
        corriendo = true;
        
        while (corriendo) {  // Por ejemplo, hasta que el corredor llegue a x 800
            mover();  
            try {
                Thread.sleep(retardo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void detener() {
        setCorriendo(false);
    }

    public Boolean isCorriendo() {
        return corriendo;
    }

    public void setCorriendo(Boolean corriendo) {
        this.corriendo = corriendo;
    }

    @Override
    public String toString() {
        return "Corredor " + id;
    }
    
    
    
}
