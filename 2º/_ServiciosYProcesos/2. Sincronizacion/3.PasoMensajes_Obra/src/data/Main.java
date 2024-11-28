/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creando las colas para las tareas
        BlockingQueue<String> colaMensajesObrero = new LinkedBlockingQueue<>();
        BlockingQueue<String> colaMensajesPintor = new LinkedBlockingQueue<>();
        BlockingQueue<String> colaMensajesJefe = new LinkedBlockingQueue<>(); // Cola para el Jefe

        // Iniciar los hilos
        Thread jefe = new Thread(new Jefe(colaMensajesObrero, colaMensajesPintor, colaMensajesJefe));
        Thread obrero = new Thread(new Obrero(colaMensajesObrero, colaMensajesJefe));
        Thread pintor = new Thread(new Pintor(colaMensajesPintor, colaMensajesJefe));

        // Iniciar los hilos
        jefe.start();
        obrero.start();
        pintor.start();
    }
    
}
