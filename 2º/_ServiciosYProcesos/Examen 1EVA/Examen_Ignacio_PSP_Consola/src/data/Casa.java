/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
class Casa {
    public synchronized void entregarPollo(int cantidad, String voluntario) throws InterruptedException {
        System.out.println(voluntario + " está llevando " + cantidad + " piezas de pollo a la casa.");
        Thread.sleep(2000); // Simula el tiempo de viaje a la casa
        System.out.println(voluntario + " ha entregado " + cantidad + " piezas de pollo en la casa.");
    }
}

