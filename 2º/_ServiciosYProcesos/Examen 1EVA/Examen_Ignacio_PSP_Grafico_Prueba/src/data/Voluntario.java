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
import java.util.Random;


public class Voluntario extends Thread {
    private int x, y, ancho, alto;
    private final Mesa mesa;
    private final Casa casa;
    private final Escalera escalera;
    private final Random random = new Random();
    public String nombre;
    private boolean moviendose = false;
    private boolean llevaPollo = false;
    private boolean volando = false;
    private int cantidadConsumo;

    public Voluntario(int x, int y, int ancho, int alto, Mesa mesa, Casa casa, Escalera escalera, String nombre) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.mesa = mesa;
        this.casa = casa;
        this.escalera = escalera;
        this.nombre = nombre;
    }

    public void run() {
        try {
            cantidadConsumo = random.nextInt(5) + 1; // Genera un número aleatorio entre 1 y 5
            moverHaciaMesa();
            mesa.tomarPollo(cantidadConsumo, nombre);
            llevaPollo = true;
            moverHaciaCasa();
            casa.entregarPollo(cantidadConsumo, nombre);
            llevaPollo = false;
            moverHaciaEscalera();
            subirEscalera();
            convertirseEnPajaro();
            volar();
            String mensaje = nombre + " ha finalizado.";
            System.out.println(mensaje);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void moverHaciaMesa() throws InterruptedException {
        moviendose = true;
        int mesaX = mesa.getX();
        int mesaY = mesa.getY();
        int velocidad = 5;

        while (x != mesaX || y != mesaY) {
            if (x < mesaX) x += velocidad;
            if (x > mesaX) x -= velocidad;
            if (y < mesaY) y += velocidad;
            if (y > mesaY) y -= velocidad;

            Thread.sleep(50); // Ajusta la velocidad del movimiento
        }
        moviendose = false;
    }

    private void moverHaciaCasa() throws InterruptedException {
        moviendose = true;
        int casaX = casa.getX();
        int casaY = casa.getY();
        int velocidad = 5;

        while (x != casaX || y != casaY) {
            if (x < casaX) x += velocidad;
            if (x > casaX) x -= velocidad;
            if (y < casaY) y += velocidad;
            if (y > casaY) y -= velocidad;

            Thread.sleep(50); // Ajusta la velocidad del movimiento
        }
        moviendose = false;
    }

    private void moverHaciaEscalera() throws InterruptedException {
        moviendose = true;
        int escaleraX = escalera.getX();
        int escaleraY = escalera.getY() + escalera.getAlto();
        int velocidad = 5;

        while (x != escaleraX || y != escaleraY) {
            if (x < escaleraX) x += velocidad;
            if (x > escaleraX) x -= velocidad;
            if (y < escaleraY) y += velocidad;
            if (y > escaleraY) y -= velocidad;

            Thread.sleep(50); // Ajusta la velocidad del movimiento
        }
        moviendose = false;
    }

    private void subirEscalera() throws InterruptedException {
        String mensaje = nombre + " está subiendo una escalera.";
        System.out.println(mensaje);
        int velocidad = 5;
        int topY = escalera.getY();

        while (y > topY) {
            y -= velocidad;
            Thread.sleep(50); // Ajusta la velocidad del movimiento
        }
    }

    private void convertirseEnPajaro() throws InterruptedException {
        String mensaje = nombre + " se ha convertido en un pájaro y se ha ido volando.";
        System.out.println(mensaje);
        volando = true;
    }

    private void volar() throws InterruptedException {
        int velocidad = 5;
        while (x < 1280) { // Suponiendo que el ancho de la ventana es 1280 píxeles
            x += velocidad;
            Thread.sleep(50); // Ajusta la velocidad del vuelo
        }
        volando = false;
    }

    public void pintar(Graphics g) {
        if (moviendose || isAlive() || volando) {
            g.setColor(Color.RED);
            if (volando) {
                g.setColor(Color.LIGHT_GRAY); // Color del pájaro
                ancho = 20;
                alto = 20;
            }
            g.fillRect(x, y, ancho, alto);
            g.setColor(Color.BLACK);
            if (!volando) {
                g.drawString(nombre, x + 10, y + 20);
                if (llevaPollo) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(x + ancho / 2, y - 10, 10, 10); // Dibuja el pollo en la mano
                }
            }
        }
    }
}
