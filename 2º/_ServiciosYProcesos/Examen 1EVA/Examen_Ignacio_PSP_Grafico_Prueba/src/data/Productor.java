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

public class Productor extends Thread {
    private int x, y, ancho, alto;
    private final Mesa mesa;
    private final int cantidadProduccion;
    private volatile boolean fin = false;

    public Productor(int x, int y, int ancho, int alto, Mesa mesa, int cantidadProduccion) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.mesa = mesa;
        this.cantidadProduccion = cantidadProduccion;
    }

    public void run() {
        try {
            while (!fin) {
                mesa.ponerPollo(cantidadProduccion);
                Thread.sleep(1000); // Simula el tiempo para producir el pollo
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            String mensaje = "Productor ha finalizado.";
            System.out.println(mensaje);
        }
    }

    public void finalizarHilo() {
        fin = true;
    }

    public boolean isFin() {
        return fin;
    }

    public void pintar(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, ancho, alto);
        g.setColor(Color.BLACK);
        g.drawString("Productor", x + 10, y + 20);
    }
}
