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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Escalera {
    private int x, y, ancho, alto;
    private BufferedImage imagen;

    public Escalera(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        
        try {
            imagen = ImageIO.read(new File(".//src//res//esc.png"));
        } catch (IOException ex) {
            System.out.println("Error al cargar la foto de fondo");
        }
    }

    public void pintar(Graphics g) {
        /*
        g.setColor(Color.GRAY);
        g.fillRect(x, y, ancho, alto);
        g.setColor(Color.BLACK);
        g.drawString("Escalera", x + 10, y + 20);
        */
        g.drawImage(imagen, x, y, ancho, alto, null);
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

