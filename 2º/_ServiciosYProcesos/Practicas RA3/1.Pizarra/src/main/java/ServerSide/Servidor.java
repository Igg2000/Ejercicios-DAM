package ServerSide;


import Protocol.MensajeDibujo;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    private int puerto;
    private ServerSocket serverSocket;
    private List<GestionaCliente> clientes;
    private List<String> nombresUsuarios;

    public Servidor(int puerto) {
        this.puerto = puerto;
        clientes = new ArrayList<>();
        nombresUsuarios = new ArrayList<>();

        try {
            serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en el puerto " + puerto);

            while (true) {
                Socket socket = serverSocket.accept();
                GestionaCliente nuevoCliente = new GestionaCliente(socket, this);
                clientes.add(nuevoCliente);
                new Thread(nuevoCliente).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void broadcast(Object mensaje) {
        for (GestionaCliente cliente : clientes) {
            cliente.enviarMensaje(mensaje);
        }
    }

    public synchronized void actualizarListaUsuarios() {
        broadcast(new ArrayList<>(nombresUsuarios));
    }

    public synchronized void agregarUsuario(String nombre) {
        if (!nombresUsuarios.contains(nombre)) {
            nombresUsuarios.add(nombre);
            actualizarListaUsuarios();
        }
    }

    public synchronized void quitarCliente(GestionaCliente cliente) {
        clientes.remove(cliente);
        nombresUsuarios.remove(cliente.getNombreUsuario());
        actualizarListaUsuarios();
    }

    public static void main(String[] args) {
        new Servidor(54321);
    }
}
