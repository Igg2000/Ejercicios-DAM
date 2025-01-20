/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 * La mesa aquí actuaría como un monitor
 * @author Nacho
 * 
 */

import java.awt.Color;
import java.awt.Graphics;

public class Mesa {
    private int x, y, ancho, alto;
    private int cantidadPollo = 0;
    private final int capacidad = 10;

    public Mesa(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public synchronized void ponerPollo(int cantidad) throws InterruptedException {
        while (cantidadPollo + cantidad > capacidad) {
            wait();
        }
        cantidadPollo += cantidad;
        String mensaje = "Se han puesto " + cantidad + " piezas de pollo en la mesa. Pollo actual: " + cantidadPollo;
        System.out.println(mensaje);
        notifyAll();
    }

    public synchronized void tomarPollo(int cantidad, String voluntario) throws InterruptedException {
        while (cantidadPollo < cantidad) {
            String mensaje = voluntario + " está esperando a que haya pollo disponible.";
            System.out.println(mensaje);
            wait();
        }
        cantidadPollo -= cantidad;
        String mensaje = voluntario + " ha tomado " + cantidad + " piezas de pollo de la mesa. Pollo actual: " + cantidadPollo;
        System.out.println(mensaje);
        notifyAll();
    }

    public void pintar(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, ancho, alto);
        g.setColor(Color.BLACK);
        g.drawString("Pollo: " + cantidadPollo, x + 10, y + 20);
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

    public int getCantidadPollo() {
        return cantidadPollo;
    }

    public int getCapacidad() {
        return capacidad;
    }
    
    
}
