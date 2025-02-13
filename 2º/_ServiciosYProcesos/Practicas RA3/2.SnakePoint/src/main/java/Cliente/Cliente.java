package Cliente;

import Cliente.GUI.Ventana;
import Cliente.Modelo.Jugador;
import Protocolo.Protocolo;
import Protocolo.ProtocoloUtiles;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente implements Protocolo {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private Jugador jugador;

    public Cliente(String host, int puerto) throws IOException {
        socket = new Socket(host, puerto);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /**
     * Envía un mensaje al servidor.
     */
    public synchronized void enviarMensaje(String mensaje) {
        out.println(mensaje);
    }

    /**
     * Escucha mensajes del servidor de forma bloqueante.
     */
    public synchronized String recibirMensaje() throws IOException {
        return in.readLine();
    }

    public void cerrar() throws IOException {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }

    // Ejemplo de método para notificar que un nuevo usuario se conecta
    public synchronized void enviarNuevoUsuario() {
        String mensaje = ProtocoloUtiles.crearMensajeNuevoUsuario(jugador.getNombre());
        enviarMensaje(mensaje);
    }

    public synchronized void enviarPreparado(int idAvatar) {
        String mensaje = ProtocoloUtiles.crearMensajePreparado(idAvatar);
        enviarMensaje(mensaje);
    }

    public Socket getSocket() {
        return socket;
    }

    public PrintWriter getOut() {
        return out;
    }

    public BufferedReader getIn() {
        return in;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public static void main(String[] args) {

        // Conexión al servidor (en un hilo aparte, por ejemplo)
        try {
            Cliente cliente = new Cliente("127.0.0.1", 50000);
            SwingUtilities.invokeLater(() -> {
                String nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
                cliente.setJugador(new Jugador(nombre,0,0,100,100));
                Ventana ventana = new Ventana(cliente);
                ventana.setVisible(true);
            });

        } catch (IOException e) {
            System.out.println("Error al conectar al servidor: " + e.getMessage());
        }

    }
}
