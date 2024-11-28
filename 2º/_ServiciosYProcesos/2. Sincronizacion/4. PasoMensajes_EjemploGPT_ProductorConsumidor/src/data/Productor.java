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

    // Clase Productor
    class Productor implements Runnable {
        private BlockingQueue<String> cola;

        public Productor(BlockingQueue<String> cola) {
            this.cola = cola;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= 5; i++) {
                    String mensaje = "Mensaje " + i;
                    System.out.println("Productor produce: " + mensaje);
                    cola.put(mensaje); // Agrega el mensaje a la cola (bloquea si está llena)
                    Thread.sleep(500); // Simula tiempo de producción
                }
                cola.put("FIN"); // Mensaje especial para indicar el final
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Productor interrumpido");
            }
        }
    }
