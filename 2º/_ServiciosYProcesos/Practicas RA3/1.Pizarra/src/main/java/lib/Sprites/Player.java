/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sprites;

/**
 *
 * @author Nacho
 */

import java.awt.Graphics;
import java.awt.Rectangle;

import java.awt.event.KeyEvent;

public class Player extends Rectangle {
    private Sprite sprite;
    private int speed = 5;
    private int frame = 0;
    private int currentRow = 0;
    private int numFramesPerRow;

    public Player(Sprite sprite, int x, int y, int ancho, int alto) {
        super(x, y, ancho, alto);
        this.sprite = sprite;
        this.numFramesPerRow = sprite.getSheet().getNumFramesPerRow();
    }
    

    public void move(int dx, int dy) {
        x += dx * speed;
        y += dy * speed;
        updateAnimationFrame();
    }

    /**
     * Gestiona los sprites de moverte arriba, derecha, abajo, izquierda
     * @param keyCode el keyCode del keyEventListener del panel
     * @param posAnimArriba es el numero de fila en el SpriteSheet que corresponde a la animacion de andar hacia arriba
     * @param posAnimDerecha es el numero de fila en el SpriteSheet que corresponde a la animacion de andar hacia la derecha
     * @param posAnimAbajo es el numero de fila en el SpriteSheet que corresponde a la animacion de andar hacia abajo
     * @param posAnimIzquierda es el numero de fila en el SpriteSheet que corresponde a la animacion de andar hacia la izquierda
     */
    public void gestionarMovimiento(int keyCode, int posAnimArriba,int posAnimDerecha,int posAnimAbajo,int posAnimIzquierda) {
        switch (keyCode) {
            case KeyEvent.VK_W:
                currentRow = posAnimArriba; // animación hacia arriba
                move(0, -1);
                break;
            case KeyEvent.VK_A:
                currentRow = posAnimIzquierda; // animación hacia la izquierda
                move(-1, 0);
                break;
            case KeyEvent.VK_S:
                currentRow = posAnimAbajo; // animación hacia abajo
                move(0, 1);
                break;
            case KeyEvent.VK_D:
                currentRow = posAnimDerecha; // animación hacia la derecha
                move(1, 0);
                break;
            default:
                break;
        }
    }

    private void updateAnimationFrame() {
        frame = (frame + 1) % numFramesPerRow; // Cicla entre los frames disponibles
        sprite.updateFrame(frame, currentRow);
    }
    

    public Sprite getSprite() {
        return sprite;
    }

    public void pintar(Graphics g) {
        g.drawImage(sprite.getBufferedImage(), x, y, width, height, null);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    
}
