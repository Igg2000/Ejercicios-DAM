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
        BlockingQueue<String> cola = new LinkedBlockingQueue<>(3); // Cola con capacidad de 3 mensajes

        Thread productor = new Thread(new Productor(cola));
        Thread consumidor = new Thread(new Consumidor(cola));

        productor.start();
        consumidor.start();
    }
    

    
    


}
