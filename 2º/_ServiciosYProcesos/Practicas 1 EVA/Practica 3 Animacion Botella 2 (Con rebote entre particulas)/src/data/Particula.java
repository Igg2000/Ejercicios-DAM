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

        // Detectar y corregir colisión con los bordes
        if (x < limites.x) { // Borde izquierdo
            x = limites.x; // Ajustar posición
            dx *= -1; // Cambiar dirección en X
        } else if (x + width > limites.x + limites.width) { // Borde derecho
            x = limites.x + limites.width - width; // Ajustar posición
            dx *= -1; // Cambiar dirección en X
        }

        if (y < limites.y) { // Borde superior
            y = limites.y; // Ajustar posición
            dy *= -1; // Cambiar dirección en Y
        } else if (y + height > limites.y + limites.height) { // Borde inferior
            y = limites.y + limites.height - height; // Ajustar posición
            dy *= -1; // Cambiar dirección en Y
        }

    }
    
    public void verificarColision(Particula otra) {

        // Verificar si las partículas se intersectan
        if (this.intersects(otra)) {
            // Invertir las direcciones de ambas partículas
            int tempDx = this.dx;
            int tempDy = this.dy;
            this.dx = otra.dx;
            this.dy = otra.dy;
            otra.dx = tempDx;
            otra.dy = tempDy;

            // Calcular el desplazamiento necesario para separar las partículas
            int overlapX = (this.x + this.width / 2) - (otra.x + otra.width / 2);
            int overlapY = (this.y + this.height / 2) - (otra.y + otra.height / 2);

            // Mover en direcciones opuestas según el solapamiento
            if (Math.abs(overlapX) > Math.abs(overlapY)) {
                this.x += overlapX > 0 ? 1 : -1;
                otra.x -= overlapX > 0 ? 1 : -1;
            } else {
                this.y += overlapY > 0 ? 1 : -1;
                otra.y -= overlapY > 0 ? 1 : -1;
            }
        }
    }

    
}