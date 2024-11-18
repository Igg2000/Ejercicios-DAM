/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author grovy
 */
public class Particula extends Rectangle {

    private int dx; // Dirección en X
    private int dy=-1; // Dirección en Y
    // Color aleatorio para la partícula
    Random random = new Random();
    Color c = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));

    public Particula(int x, int y, int width, int height) {
        super(x, y, width, height);
        Random random = new Random();
        // Velocidad aleatoria inicial en cada eje (-3 a 3, excluyendo 0)
        this.dx = random.nextInt(7) - 3;
        this.dy = random.nextInt(3) - 3;
        if (dx == 0) dx = 1; // Aseguramos que no sea 0
        if (dy == 0) dy = 1;
    }

    public void pintar(Graphics g) {
        g.setColor(c);
        g.fillOval(x, y, width, height);
    }

    public void mover(Rectangle limites) {
        // Actualizar posición
        x += dx;
        y += dy;

        // Rebotar en los bordes
        if (x <= limites.x || x + width >= limites.x + limites.width) {
            dx *= -1; // Cambiar dirección en X
        }
        if (y <= limites.y || y + height >= limites.y + limites.height) {
            dy *= -1; // Cambiar dirección en Y
        }
    }
}