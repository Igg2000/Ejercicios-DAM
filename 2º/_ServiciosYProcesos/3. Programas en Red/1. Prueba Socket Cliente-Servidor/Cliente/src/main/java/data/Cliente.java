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

public class Cliente {
    public static void main(String[] args) {
        String host = "127.0.0.1"; // Dirección del servidor (localhost)
        int puerto = 56789; // Puerto donde el servidor está escuchando

        try (Socket socket = new Socket(host, puerto)) {
            System.out.println("Conectado al servidor");

            // Flujos para comunicación
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Enviar mensaje al servidor
            String mensaje = "Hola, servidor!";
            out.println(mensaje);

            // Recibir respuesta del servidor
            String respuesta = in.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

