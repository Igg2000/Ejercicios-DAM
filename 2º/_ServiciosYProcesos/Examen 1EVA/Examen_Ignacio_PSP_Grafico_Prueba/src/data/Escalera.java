/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */

import java.awt.Color;
import java.awt.Graphics;

public class Escalera {
    private int x, y, ancho, alto;

    public Escalera(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public void pintar(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, ancho, alto);
        g.setColor(Color.BLACK);
        g.drawString("Escalera", x + 10, y + 20);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    
    
}

