package ServerSide;


import Protocol.MensajeDibujo;

import javax.swing.*;
import java.awt.*;
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
            System.out.println("Se ha dejado de buscar clientes");
        }
    }

    private void crearVentana() {
        JFrame ventana = new JFrame("Servidor");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel etiqueta = new JLabel("Servidor iniciado en el puerto " + puerto, SwingConstants.CENTER);
        JButton boton = new JButton("Desconectar");

        // Configuración para que los componentes se expandan en ambas direcciones
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; // Ocupa todo el ancho disponible
        gbc.weighty = 0.5; // Distribuye el espacio verticalmente

        // Agregar etiqueta
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(etiqueta, gbc);

        // Agregar botón
        gbc.gridy = 1;
        panel.add(boton, gbc);

        boton.addActionListener(e -> {
            encendido = false;
            try {
                serverSocket.close();
            } catch (IOException ex) {
                System.out.println("No se pudo cerrar el servidor");
            }
            System.out.println("El servidor se ha cerrado");
            ventana.dispose();
        });

        ventana.setContentPane(panel);
        ventana.setVisible(true); // Mejor práctica: Hacer visible al final
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
