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
// Clase Jefe
class Jefe implements Runnable {
    private final BlockingQueue<String> colaMensajesObrero;
    private final BlockingQueue<String> colaMensajesPintor;
    private final BlockingQueue<String> colaMensajesJefe;  // Cola de mensajes exclusiva para el jefe

    public Jefe(BlockingQueue<String> colaMensajesObrero, BlockingQueue<String> colaMensajesPintor, BlockingQueue<String> colaMensajesJefe) {
        this.colaMensajesObrero = colaMensajesObrero;
        this.colaMensajesPintor = colaMensajesPintor;
        this.colaMensajesJefe = colaMensajesJefe;
    }

    @Override
    public void run() {
        try {
            // Ordenar al obrero que arregle la pared
            System.out.println("Jefe: Obrero, arregla la pared.");
            colaMensajesObrero.put("Arreglar pared");

            // El jefe espera hasta recibir la respuesta del obrero en su cola
            String respuestaObrero = colaMensajesJefe.take();
            System.out.println("Jefe recibe del Obrero: " + respuestaObrero);

            // Ordenar al pintor que pinte la pared
            System.out.println("Jefe: Pintor, pinta la pared.");
            colaMensajesPintor.put("Pintar pared");

            // El jefe espera hasta recibir la respuesta del pintor en su cola
            String respuestaPintor = colaMensajesJefe.take();
            System.out.println("Jefe recibe del Pintor: " + respuestaPintor);

            // Declarar que la obra está terminada
            System.out.println("Jefe: La obra está terminada.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Jefe interrumpido.");
        }
    }
}


