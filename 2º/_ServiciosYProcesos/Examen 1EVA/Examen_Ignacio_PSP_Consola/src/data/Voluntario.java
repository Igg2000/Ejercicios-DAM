/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
import java.util.Random;

class Voluntario extends Thread {
    private final Mesa mesa;
    private final Casa casa;
    private final Random random = new Random();
    private final String nombre;

    public Voluntario(Mesa mesa, Casa casa, String nombre) {
        this.mesa = mesa;
        this.casa = casa;
        this.nombre = nombre;
    }

    public void run() {
        try {
            int cantidadConsumo = random.nextInt(5) + 1; // Genera un número aleatorio entre 1 y 5
            mesa.tomarPollo(cantidadConsumo, nombre);
            casa.entregarPollo(cantidadConsumo, nombre);
            subirEscalera();
            convertirseEnPajaro();
            System.out.println(nombre + " ha finalizado.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void subirEscalera() throws InterruptedException {
        System.out.println(nombre + " está subiendo una escalera.");
        Thread.sleep(1000); // Simula el tiempo para subir la escalera
    }

    private void convertirseEnPajaro() throws InterruptedException {
        System.out.println(nombre + " se ha convertido en un pájaro y se ha ido volando.");
        Thread.sleep(500); // Simula el tiempo para convertirse en pájaro y volar
    }
}


