/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package data;

/**
 *
 * @author Nacho
 */
import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 56789; // Puerto donde escuchará el servidor
        try (ServerSocket servidorSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);

            while (true) {
                // Espera a un cliente
                Socket clienteSocket = servidorSocket.accept();
                System.out.println("Cliente conectado desde: " + clienteSocket.getInetAddress());

                // Flujos para comunicación
                InputStreamReader isr = new InputStreamReader(clienteSocket.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);

                // Recibir mensaje del cliente
                String mensaje = br.readLine();
                System.out.println("Mensaje del cliente: " + mensaje);

                // Responder al cliente
                out.println("Mensaje recibido: " + mensaje);

                // Cerrar conexión con el cliente
                clienteSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


