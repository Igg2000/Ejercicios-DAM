/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Nacho
 */
// Clase Obrero
class Obrero implements Runnable {
    private final BlockingQueue<String> colaMensajesObrero;
    private final BlockingQueue<String> colaMensajesJefe; // Cola de mensajes exclusiva para el Jefe

    public Obrero(BlockingQueue<String> colaMensajesObrero, BlockingQueue<String> colaMensajesJefe) {
        this.colaMensajesObrero = colaMensajesObrero;
        this.colaMensajesJefe = colaMensajesJefe;
    }

    @Override
    public void run() {
        try {
            // Esperar tarea del jefe
            String tarea = colaMensajesObrero.take();
            System.out.println("Obrero recibe del Jefe: " + tarea);

            // Simular trabajo arreglando la pared
            System.out.println("Obrero: Arreglando la pared...");
            Thread.sleep(2000); // Simula tiempo de trabajo

            // Notificar al jefe que la pared está arreglada
            colaMensajesJefe.put("Pared arreglada");
            System.out.println("Obrero: Pared arreglada. Avisando al jefe...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Obrero interrumpido.");
        }
    }
}
