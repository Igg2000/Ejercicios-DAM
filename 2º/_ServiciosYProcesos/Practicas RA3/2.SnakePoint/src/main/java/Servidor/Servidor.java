package Servidor;

import Servidor.Net.ManejaCliente;
import Servidor.Net.GestorClientes;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private ServerSocket serverSocket;
    private GestorClientes gestorClientes;

    public Servidor(int puerto) {
        try {
            serverSocket = new ServerSocket(puerto);
            gestorClientes = new GestorClientes();
            System.out.println("Servidor escuchando en el puerto " + puerto);
        } catch (IOException e) {
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }

    public void iniciar() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado: " + socket.getInetAddress());
                ManejaCliente cliente = new ManejaCliente(socket, gestorClientes);
                gestorClientes.agregarCliente(cliente);
                new Thread(cliente).start();
            } catch (IOException e) {
                System.out.println("Error al aceptar conexiones: " + e.getMessage());
            }
        }
    }

    // Método para procesar mensajes, si es necesario delegarlos desde el ClienteHandler
    // public void procesarMensaje(ClienteHandler cliente, String mensaje) { ... }

    public static void main(String[] args) {
        Servidor servidor = new Servidor(50000);
        servidor.iniciar();
    }
}
