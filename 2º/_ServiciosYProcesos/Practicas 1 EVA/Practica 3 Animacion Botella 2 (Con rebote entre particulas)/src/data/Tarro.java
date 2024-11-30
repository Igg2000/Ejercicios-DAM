/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author grovy
 */
public class Tarro extends Rectangle{

    public Tarro(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    public void pintar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Configurar trazos y colores iniciales
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(new Color(200, 200, 255)); // Color base de vidrio (azul claro translúcido)

        // Dibujar el cuerpo principal del tarro (vidrio)
        int arcWidth = width / 6; // Bordes redondeados
        int arcHeight = height / 6;
        g2d.drawRoundRect(x, y, width, height, arcWidth, arcHeight);

        // Crear efecto de reflejo superior
        GradientPaint gradient = new GradientPaint(
            x, y, new Color(220, 220, 255, 180), // Parte superior más clara
            x, y + height / 2, new Color(200, 200, 255, 80) // Parte inferior más translúcida
        );
        g2d.setPaint(gradient);
        g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);

        // Dibujar la boca del tarro
        int lipHeight = height / 10;
        g2d.setColor(new Color(180, 180, 200)); // Color gris claro
        g2d.fillRoundRect(x, y - lipHeight / 2, width, lipHeight, arcWidth, arcWidth);

        // Contorno de la boca
        g2d.setColor(Color.DARK_GRAY);
        g2d.drawRoundRect(x, y - lipHeight / 2, width, lipHeight, arcWidth, arcWidth);

        // Dibujar base gruesa
        int baseHeight = height / 15;
        g2d.setColor(new Color(180, 180, 200));
        g2d.fillRoundRect(x, y + height - baseHeight, width, baseHeight, arcWidth, arcWidth);
        g2d.setColor(Color.DARK_GRAY);
        g2d.drawRoundRect(x, y + height - baseHeight, width, baseHeight, arcWidth, arcWidth);

        // Reflejo lateral izquierdo
        g2d.setColor(new Color(255, 255, 255, 100)); // Blanco translúcido
        g2d.fillRect(x + width / 8, y + height / 8, width / 12, height - height / 4);

        // Reflejo lateral derecho
        g2d.fillRect(x + width - width / 6, y + height / 4, width / 14, height / 2);
    }
}
