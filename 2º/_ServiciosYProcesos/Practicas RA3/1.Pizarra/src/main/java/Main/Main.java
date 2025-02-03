package Main;

import ServerSide.Servidor;
import ClientSide.Cliente;

/**
 * He hecho esta clase para iniciar un servidor y dos clientes para hacer pruebas mas rapido
 */
public class Main{
    public static void main(String[] args) {
        int p=54321;

        Thread serverThread = new Thread(() -> new Servidor(p));
        serverThread.start();

        // Esperar a que el servidor se inicie
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Iniciar clientes
        Thread client1 = new Thread(() -> {
            Cliente cliente1 = new Cliente("localhost", p);
            cliente1.conectar();
        });

        Thread client2 = new Thread(() -> {
            Cliente cliente2 = new Cliente("localhost", p);
            cliente2.conectar();
        });

        client1.start();
        client2.start();
    }
}
