package ServerSide;


import Protocol.MensajeDibujo;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;

public class Servidor {
    private int puerto;
    private ServerSocket serverSocket;
    private List<GestionaCliente> clientes;
    private List<MensajeDibujo> dibujos;

    public static void main(String[] args) {
        new Servidor(5000).iniciar();
    }

    public Servidor(int puerto) {
        this.puerto = puerto;
        this.clientes = new ArrayList<>();
        this.dibujos = new ArrayList<>();
    }

    public void iniciar() {
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

    public synchronized void broadcast(MensajeDibujo mensaje) {
        dibujos.add(mensaje);
        for (GestionaCliente cliente : clientes) {
            cliente.enviarMensaje(mensaje);
        }
    }

    public synchronized void quitarCliente(GestionaCliente cliente) {
        clientes.remove(cliente);
    }


}
