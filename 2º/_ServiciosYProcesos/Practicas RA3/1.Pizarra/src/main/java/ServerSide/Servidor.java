package ServerSide;


import Protocol.MensajeDibujo;

import javax.swing.*;
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
    private boolean encendido= true;
    public Servidor(int puerto) {
        this.puerto = puerto;
        clientes = new ArrayList<>();
        nombresUsuarios = new ArrayList<>();

        crearVentana();

        try {
            serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en el puerto " + puerto);

            while (encendido) {
                Socket socket = serverSocket.accept();
                GestionaCliente nuevoCliente = new GestionaCliente(socket, this);
                clientes.add(nuevoCliente);
                new Thread(nuevoCliente).start();
            }
        } catch (IOException e) {
            System.out.println("Se ha dejado de escuchar en el puerto " + puerto);
        }
    }

    private void crearVentana() {
        JFrame ventana = new JFrame("Servidor");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel etiqueta = new JLabel("Servidor iniciado en el puerto " + puerto);
        panel.add(etiqueta);
        JButton boton = new JButton("Desconectar");
        panel.add(boton);

        boton.addActionListener(e -> {
            encendido = false;

            try {
                serverSocket.close();
            } catch (IOException ex) {
                System.out.println("No se pudo cerrar el servidor");
            }
            ventana.dispose();
        });

        ventana.setContentPane(panel);
        ventana.revalidate();

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
