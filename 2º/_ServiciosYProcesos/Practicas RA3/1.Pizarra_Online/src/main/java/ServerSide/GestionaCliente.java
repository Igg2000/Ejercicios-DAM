package ServerSide;

import Protocol.MensajeDibujo;
import java.io.*;
import java.net.Socket;

public class GestionaCliente implements Runnable {
    private Socket cliente;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Servidor servidor;

    public GestionaCliente(Socket socket, Servidor servidor) {
        this.cliente = socket;
        this.servidor = servidor;
        try {
            output = new ObjectOutputStream(cliente.getOutputStream());
            input = new ObjectInputStream(cliente.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                MensajeDibujo mensaje = (MensajeDibujo) input.readObject();
                servidor.broadcast(mensaje);
            }
        } catch (IOException | ClassNotFoundException e) {
            servidor.quitarCliente(this);
        }
    }

    public void enviarMensaje(MensajeDibujo msg) {
        try {
            output.writeObject(msg);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
