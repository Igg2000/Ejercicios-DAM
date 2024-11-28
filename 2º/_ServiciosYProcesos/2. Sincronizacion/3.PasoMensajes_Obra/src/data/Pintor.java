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
// Clase Pintor
class Pintor implements Runnable {
    private final BlockingQueue<String> colaMensajesPintor;
    private final BlockingQueue<String> colaMensajesJefe; // Cola de mensajes exclusiva para el Jefe

    public Pintor(BlockingQueue<String> colaMensajesPintor, BlockingQueue<String> colaMensajesJefe) {
        this.colaMensajesPintor = colaMensajesPintor;
        this.colaMensajesJefe = colaMensajesJefe;
    }

    @Override
    public void run() {
        try {
            // Esperar tarea del jefe
            String tarea = colaMensajesPintor.take();
            System.out.println("Pintor recibe del Jefe: " + tarea);

            // Simular trabajo pintando la pared
            System.out.println("Pintor: Pintando la pared...");
            Thread.sleep(3000); // Simula tiempo de trabajo

            // Notificar al jefe que la pared está pintada
            colaMensajesJefe.put("Pared pintada");
            System.out.println("Pintor: Pared pintada. Avisando al jefe...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Pintor interrumpido.");
        }
    }
}

