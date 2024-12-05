/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Nacho
 */
public class ImagenRebote extends Rectangle {

    private int dx; // Dirección en X
    private int dy=-1; // Dirección en Y
    // Color aleatorio para la partícula
    Random random = new Random();
    Color c = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    private BufferedImage imagen;

    public ImagenRebote(int x, int y, int width, int height) {
        super(x, y, width, height);
        Random random = new Random();
        // Velocidad aleatoria inicial en cada eje (-3 a 3, excluyendo 0)
        this.dx = 3;
        this.dy = 3;
        if (dx == 0) dx = 1; // Aseguramos que no sea 0
        if (dy == 0) dy = 1;
        
        
        try {
            // Cargar la imagen desde el archivo
            imagen = ImageIO.read(new File(".//src//res//rebote.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la imagen obstaculo.png");
        }
    }

    public void pintar(Graphics g) {
        
        if (imagen != null) {
            // Dibujar la imagen escalada al tamaño del rectángulo
            g.drawImage(imagen, x, y, width, height, null);
        } else {
            g.setColor(c);
            g.fillOval(x, y, width, height);
        }
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

    public void verificarColision(Rectangle r) {
        if (this.intersects(r)) {
            // Calcular las áreas de intersección en cada eje
            int interseccionAncho = Math.min(this.x + this.width, r.x + r.width) - Math.max(this.x, r.x);
            int interseccionAlto = Math.min(this.y + this.height, r.y + r.height) - Math.max(this.y, r.y);

            // Cambiar dirección basado en el eje dominante de intersección
            if (interseccionAncho < interseccionAlto) {
                // Colisión en el eje X (rebote horizontal)
                dx *= -1;
                // Ajustar posición para evitar solapamiento
                if (this.x < r.x) {
                    this.x = r.x - this.width; // Mover hacia la izquierda
                } else {
                    this.x = r.x + r.width; // Mover hacia la derecha
                }
            } else {
                // Colisión en el eje Y (rebote vertical)
                dy *= -1;
                // Ajustar posición para evitar solapamiento
                if (this.y < r.y) {
                    this.y = r.y - this.height; // Mover hacia arriba
                } else {
                    this.y = r.y + r.height; // Mover hacia abajo
                }
            }
        }
    }



    
}