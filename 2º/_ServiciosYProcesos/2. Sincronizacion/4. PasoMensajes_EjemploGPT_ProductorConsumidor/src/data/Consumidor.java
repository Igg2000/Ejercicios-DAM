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

    // Clase Consumidor
    class Consumidor implements Runnable {
        private BlockingQueue<String> cola;

        public Consumidor(BlockingQueue<String> cola) {
            this.cola = cola;
        }

        @Override
        public void run() {
            try {
                String mensaje;
                while (!(mensaje = cola.take()).equals("FIN")) { // Toma un mensaje de la cola (bloquea si está vacía)
                    System.out.println("Consumidor consume: " + mensaje);
                    Thread.sleep(1000); // Simula tiempo de procesamiento
                }
                System.out.println("Consumidor recibe señal de FIN. Terminando...");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumidor interrumpido");
            }
        }
    }