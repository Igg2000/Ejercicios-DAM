/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
class Productor extends Thread {
    private final Mesa mesa;
    private final int cantidadProduccion;
    private volatile boolean fin = false;

    public Productor(Mesa mesa, int cantidadProduccion) {
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
            System.out.println("Productor ha finalizado."); // Mensaje para asegurar que se está finalizando
        } finally {
            System.out.println("Productor ha finalizado."); // Mensaje para asegurar que se está finalizando
        }
    }

    public void finalizarHilo() {
        fin = true;
        //this.interrupt(); // He hecho esto porque estaba teniendo problemas
    }

    public boolean isFin() {
        return fin;
    }
    
    
}

