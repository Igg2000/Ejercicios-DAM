package ClientSide;


import ClientSide.GUI.PizarraGUI;
import Protocol.MensajeDibujo;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.List;

public class Cliente implements Runnable {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private List<String> usuariosConectados;
    private PizarraGUI ventana;
    private String nombreUsuario;
    private String serverIP;
    private int serverPort;

    public Cliente(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void conectar() {
        try {
            socket = new Socket(serverIP, serverPort);
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());

            // Pedir el nombre del usuario
            nombreUsuario = JOptionPane.showInputDialog(null, "Ingrese su nombre:", "Conectar", JOptionPane.PLAIN_MESSAGE);

            if (nombreUsuario == null || nombreUsuario.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nombre inválido. Cerrando aplicación.");
                System.exit(0);
            }

            // Notificar conexión exitosa
            JOptionPane.showMessageDialog(null, "Conectado al servidor como " + nombreUsuario);

            // Enviar mensaje de nuevo usuario al servidor
            output.writeObject(new MensajeDibujo("NUEVO_USUARIO", "", 0, 0, nombreUsuario, ""));

            ventana = new PizarraGUI(this);
            recibirMensajes();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con el servidor.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void enviarMensaje(MensajeDibujo msg) {
        try {
            output.writeObject(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void recibirMensajes() {
        new Thread(() -> {
            try {
                while (true) {
                    Object obj = input.readObject();
                    if (obj instanceof MensajeDibujo) {
                        MensajeDibujo mensaje = (MensajeDibujo) obj;

                        if (mensaje.getTipo().equals("NUEVO_USUARIO")) {
                            ventana.actualizarListaUsuarios(mensaje.getUsuario());
                        } else {
                            ventana.getLienzo().agregarForma(mensaje);
                        }
                    } else if (obj instanceof List) {
                        ventana.actualizarListaUsuarios((List<String>) obj);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    @Override
    public void run() {
        conectar();
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente("localhost", 54321);
        cliente.conectar();
    }
}
