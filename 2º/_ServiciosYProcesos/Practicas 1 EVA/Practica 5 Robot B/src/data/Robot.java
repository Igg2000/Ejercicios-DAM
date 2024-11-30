/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.*;
/**
 *
 * @author Nacho
 */
import java.awt.geom.AffineTransform;

public class Robot {
    private int x, y; // Posición del robot
    private int brazoAngulo; // Ángulo para movimiento de brazos
    private int piernaAngulo; // Ángulo para movimiento de piernas
    private boolean brazoDelantero; // Dirección del brazo delantero
    private boolean piernaDelantera; // Dirección de la pierna delantera
    private int size; // Tamaño del robot (factor de escala)
    private boolean agachado = false; // Estado para saber si el robot está agachado

    public Robot(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size; // Factor de escala
        this.brazoAngulo = 0;
        this.piernaAngulo = 0;
        this.brazoDelantero = true;
        this.piernaDelantera = true;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Guardar la transformación original
        AffineTransform originalTransform = g2.getTransform();

        // Elegir los colores de cada parte del cuerpo
        Color colorCabeza = new Color(220,220,220);  
        Color colorTorso = new Color(8, 119, 223);       
        Color colorBrazoIzquierdo = new Color(200,200,200); 
        Color colorBrazoDerecho = new Color(220,220,220); 
        Color colorPiernaIzquierda = new Color(200,200,200);
        Color colorPiernaDerecha = new Color(220,220,220);  
        
        
        
        // Escalar todas las dimensiones
        int torsoWidth = size * 40 / 100;
        int torsoHeight = agachado ? size/2 : size; // Ajusta el tamaño del torso si está agachado
        int brazoWidth = size * 10 / 100;
        int brazoHeight = size * 60 / 100;
        int piernaWidth = size * 10 / 100;
        int piernaHeight = agachado ? size * 30 / 100 : size * 60 / 100; // Ajusta el tamaño de las piernas si está agachado
        int cabezaWidth = size * 30 / 100;
        int cabezaHeight = size * 30 / 100;

        // **Centro para los brazos (a la mitad superior del torso)**
        int centroBrazosX = x + torsoWidth / 2;
        int centroBrazosY = y + size * 25 / 100;

        // **Centro para las piernas (debajo del torso)**
        int centroPiernasX = x + torsoWidth / 2;
        int centroPiernasY = y + torsoHeight;

        // **Pierna izquierda (detrás del torso)**
        g2.setColor(colorPiernaIzquierda);
        AffineTransform piernaIzqTransform = new AffineTransform();
        piernaIzqTransform.translate(centroPiernasX, centroPiernasY);
        piernaIzqTransform.rotate(Math.toRadians(-piernaAngulo));
        g2.setTransform(piernaIzqTransform);
        g2.fillRect(-piernaWidth / 2, 0, piernaWidth, piernaHeight);

        // Restaurar transformación original
        g2.setTransform(originalTransform);

        // **Brazo izquierdo (detrás del torso)**
        g2.setColor(colorBrazoIzquierdo);
        AffineTransform brazoIzqTransform = new AffineTransform();
        brazoIzqTransform.translate(centroBrazosX, centroBrazosY);
        brazoIzqTransform.rotate(Math.toRadians(-brazoAngulo));
        g2.setTransform(brazoIzqTransform);
        g2.fillRect(-brazoWidth / 2, 0, brazoWidth, brazoHeight);

        // Restaurar transformación original
        g2.setTransform(originalTransform);

        // **Torso**
        g2.setColor(colorTorso);
        g2.fillRect(x, y, torsoWidth, torsoHeight);

        // **Cabeza**
        g2.setColor(colorCabeza);
        g2.fillOval(x + (torsoWidth - cabezaWidth) / 2, y - cabezaHeight, cabezaWidth, cabezaHeight);

        // **Pierna derecha (delante del torso)**
        g2.setColor(colorPiernaDerecha);
        AffineTransform piernaDerTransform = new AffineTransform();
        piernaDerTransform.translate(centroPiernasX, centroPiernasY);
        piernaDerTransform.rotate(Math.toRadians(piernaAngulo));
        g2.setTransform(piernaDerTransform);
        g2.fillRect(-piernaWidth / 2, 0, piernaWidth, piernaHeight);

        // Restaurar transformación original
        g2.setTransform(originalTransform);

        // **Brazo derecho (delante del torso)**
        g2.setColor(colorBrazoDerecho);
        AffineTransform brazoDerTransform = new AffineTransform();
        brazoDerTransform.translate(centroBrazosX, centroBrazosY);
        brazoDerTransform.rotate(Math.toRadians(brazoAngulo));
        g2.setTransform(brazoDerTransform);
        g2.fillRect(-brazoWidth / 2, 0, brazoWidth, brazoHeight);

        // Restaurar transformación original
        g2.setTransform(originalTransform);
    }

    public void moveRight() {
        x += 5; // Movimiento horizontal
        updateLimbAngles(); // Actualizar los ángulos de brazos y piernas
    }
    
    public void moveLeft() {
        x -= 5; // Movimiento horizontal
        updateLimbAngles(); // Actualizar los ángulos de brazos y piernas
    }

    private void updateLimbAngles() {
        // Movimiento oscilante de los brazos
        if (brazoDelantero) {
            brazoAngulo += 5;
            if (brazoAngulo >= 30) brazoDelantero = false;
        } else {
            brazoAngulo -= 5;
            if (brazoAngulo <= -30) brazoDelantero = true;
        }

        // Movimiento oscilante de las piernas
        if (piernaDelantera) {
            piernaAngulo += 5;
            if (piernaAngulo >= 30) piernaDelantera = false;
        } else {
            piernaAngulo -= 5;
            if (piernaAngulo <= -30) piernaDelantera = true;
        }
    }

    public boolean isOutOfBounds(int width) {
        return x > width; // Verificar si salió de la pantalla
    }

    public void resetPosition() {
        x = -size; // Reiniciar posición
    }
    

    public void agacharse() {
        if(!agachado)
            y+=75;
        agachado = true;
    }

    public void levantarse() {
        if(agachado)
        y-=75;
        agachado = false;
    }

}
