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

public class Casa {
    private int x, y, ancho, alto;
    private int contadorPollo = 0;

    public Casa(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public synchronized void entregarPollo(int cantidad, String voluntario) throws InterruptedException {
        // Simula el tiempo de viaje a la casa
        Thread.sleep(2000);
        contadorPollo += cantidad;
        System.out.println(voluntario + " ha entregado " + cantidad + " piezas de pollo a la casa. Total recibido: " + contadorPollo);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAlto() {
        return alto;
    }

    public void pintar(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, ancho, alto);
        g.setColor(Color.WHITE);
        g.drawString("Casa", x + 10, y + 20);
        g.drawString("Recibido: " + contadorPollo, x + 10, y + 40);
    }
}
