/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package data;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class Cliente {

    public static void main(String[] args) {
        String serverAddress = "localhost"; // Dirección del servidor
        int serverPort = 50000; // Puerto del servidor
        int MAX_BYTES_POR_PAQUETE=1024;

        try (DatagramSocket socket = new DatagramSocket()) {
            // Crear mensaje
            String message = JOptionPane.showInputDialog("Escribe que palabra quieres en mayuscula");
            byte[] messageData = message.getBytes();

            // Enviar paquete al servidor
            InetAddress serverInetAddress = InetAddress.getByName(serverAddress);
            DatagramPacket packet = new DatagramPacket(
                    messageData, messageData.length, serverInetAddress, serverPort);
            socket.send(packet);
            System.out.println("Mensaje enviado al servidor.");

            // Recibir respuesta del servidor
            byte[] buffer = new byte[MAX_BYTES_POR_PAQUETE];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);

            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Respuesta del servidor: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
