package ServerSide;

import Protocol.MensajeDibujo;

import java.io.*;
import java.net.Socket;

public class GestionaCliente implements Runnable {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Servidor servidor;
    private String nombreUsuario;

    public GestionaCliente(Socket socket, Servidor servidor) {
        this.socket = socket;
        this.servidor = servidor;
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object obj = input.readObject();
                if (obj instanceof MensajeDibujo) {
                    MensajeDibujo mensaje = (MensajeDibujo) obj;

                    if (mensaje.getTipo().equals("NUEVO_USUARIO")) {
                        nombreUsuario = mensaje.getUsuario();
                        servidor.agregarUsuario(nombreUsuario);
                    } else {
                        servidor.broadcast(mensaje);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Usuario " + nombreUsuario + " desconectado.");
            servidor.quitarCliente(this);
        }
    }

    public void enviarMensaje(Object mensaje) {
        try {
            output.writeObject(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
}
