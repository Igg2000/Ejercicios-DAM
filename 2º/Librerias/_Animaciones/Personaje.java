/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author Nacho
 */
public class Personaje {
    private SpriteSheet ss;
    private Sprite[] sprites;
    private int spriteActual;
    private int x, y;
    private int velocidad;
    private int pixeles; 
    private boolean derecha;

    public Personaje(int x, int y, int velocidad) {
        this.ss = new SpriteSheet(".//img//spritesheet_caveman.png");
        this.pixeles=32; //sprites de 32 bits
        this.sprites = new Sprite[ss.getNumeroDeSpritesPorFila(pixeles)]; 
        this.spriteActual = 0;
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;

        int fila=pixeles*2;
        
        for (int i = 0; i < ss.getNumeroDeSpritesPorFila(pixeles); i++) {
            sprites[i] = ss.getSprite(i * pixeles, fila , pixeles, pixeles);
        }
    }

    public void moverDerecha() {
        x += velocidad;
        spriteActual = (spriteActual + 1) % sprites.length;
        derecha = true;
    }

    public void moverIzquierda() {
        x -= velocidad;
        spriteActual = (spriteActual + sprites.length - 1) % sprites.length;
        derecha= false;
    }

    public void moverArriba() {
        y -= velocidad;
        spriteActual = (spriteActual + sprites.length - 1) % sprites.length;
    }

    public void moverAbajo() {
        y += velocidad;
        spriteActual = (spriteActual + 1) % sprites.length;
    }

    public void pintar(Graphics g){
        if(derecha){ 
            g.drawImage(invertirHorizontalmente(sprites[spriteActual].getImage()), x, y,null);
        }
        else{
            g.drawImage(sprites[spriteActual].getImage(), x, y,null);
        }
    }
    
    public Sprite getSpriteActual() {
        return sprites[spriteActual];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
    
}