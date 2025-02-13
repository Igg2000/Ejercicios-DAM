package Servidor;

import Protocolo.Protocolo;
import Protocolo.ProtocoloUtiles;
import Servidor.Modelo.Juego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

// Clase principal que gestiona las conexiones entrantes
public class Servidor implements Protocolo{
    private ServerSocket serverSocket;
    private Juego juego;

    public Servidor(int puerto) {
        try {
            serverSocket = new ServerSocket(puerto);
            juego = new Juego();
            System.out.println("Servidor escuchando en el puerto " + puerto);
        } catch (IOException e) {
            System.out.println("Error al crear el servidor: " + e.getMessage());
        }
    }

    public void iniciar() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado: " + socket.getInetAddress());
                // Hilo para manejar cada conexión por separado
                new Thread(() -> manejarCliente(socket)).start();

            } catch (IOException e) {
                System.out.println("Error al aceptar conexión: " + e.getMessage());
            }
        }
    }

    private void manejarCliente(Socket socket) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String mensaje;
            while ((mensaje = in.readLine()) != null) {
                procesarMensaje(mensaje, out);
            }
        } catch (IOException e) {
            System.out.println("Error al manejar el cliente: " + e.getMessage());
        }
    }

    private void procesarMensaje(String mensaje, PrintWriter out) {
        String[] tokens = ProtocoloUtiles.parsearMensaje(mensaje);
        int codigo = ProtocoloUtiles.obtenerCodigo(tokens);


        System.out.println("He recibido el siguiente mensaje: "+mensaje);

        switch (codigo) {
            case Protocolo.NUEVO_JUGADOR:
                // tokens[1] -> id, tokens[2] -> nombre
                int id = Integer.parseInt(tokens[1]);
                String nombre = tokens[2];
                System.out.println("Nuevo usuario: "+ id +" : "+ nombre);
                // Aquí podrías añadir el jugador al juego
                break;
            case Protocolo.MOVER:
                // tokens[1] -> id, tokens[2] -> x, tokens[3] -> y
                // Actualizar posición en el juego
                break;
            // Manejar otros casos
            default:
                System.out.println("Mensaje no reconocido: " + mensaje);
                break;
        }
    }


    public static void main(String[] args) {
        Servidor servidor = new Servidor(50000);
        servidor.iniciar();
    }


}
