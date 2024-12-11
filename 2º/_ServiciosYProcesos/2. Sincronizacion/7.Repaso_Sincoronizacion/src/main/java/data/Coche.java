/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Nacho
 */
public class Coche extends Rectangle{

    private BufferedImage imagen;

    private int velocidad;
    private int pixeles; 
    private Direccion direccion=Direccion.Arriba;

    public Coche(int x, int y, int ancho ,int alto,int velocidad) {
        super(x, y, ancho, alto);
        
        try {
            this.imagen = ImageIO.read(new File(".//res//car1.png"));
        } catch (IOException e) {
             System.out.println("La imagen del coche no ha podido cargar");
        }

        this.velocidad = velocidad;
    }


    public void moverDerecha() {
        x += velocidad; 
        direccion=Direccion.Derecha;
        
    }

    public void moverIzquierda() {
        x -= velocidad;
        direccion=Direccion.Izquierda;
    }

    public void moverArriba() {
        y -= velocidad;
        direccion=Direccion.Arriba;
    }

    public void moverAbajo() {
        y += velocidad;
        direccion=Direccion.Abajo;
    }
    
    public void pintar(Graphics gg){

        Graphics2D g = (Graphics2D) gg;

        AffineTransform transformOG = g.getTransform();

        // Define el ángulo de rotación según la dirección
        double angle = 0;
        switch (direccion) {
            case Izquierda:
                angle = -90;
                break;
            case Derecha:
                angle = 90;
                break;
            case Arriba:
                angle = 0;
                break;
            case Abajo:
                angle = 180;
                break;
            default:
                throw new AssertionError(direccion.name());
        }

        // Rota la imagen
        g.translate(x + width / 2, y + height / 2); // Traduce la posición de origen a la posición actual
        g.rotate(Math.toRadians(angle));
        g.translate(-width / 2, -height / 2); // Traduce la posición de origen nuevamente a la posición original
        g.drawImage(imagen, 0, 0, width, height, null);

        // Restaura la transformación
        g.setTransform(transformOG);
    }
    
    public BufferedImage invertirHorizontalmente(BufferedImage imagen) {
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
        BufferedImage imagenInvertida = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho / 2; x++) {
                int pixelOriginal = imagen.getRGB(x, y);
                int pixelInvertido = imagen.getRGB(ancho - x - 1, y);
                imagenInvertida.setRGB(x, y, pixelInvertido);
                imagenInvertida.setRGB(ancho - x - 1, y, pixelOriginal);
            }
        }
        return imagenInvertida;
    }

    private static enum Direccion {
        Izquierda,Derecha,Arriba,Abajo
    }
    
}