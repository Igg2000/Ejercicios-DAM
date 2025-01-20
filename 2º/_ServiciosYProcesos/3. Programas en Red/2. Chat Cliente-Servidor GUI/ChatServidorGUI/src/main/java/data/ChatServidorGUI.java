/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package data;

import java.io.*;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatServidorGUI {
    private static JTextArea textArea;
    private static DefaultListModel<String> listaClientesModel;
    private static ServerSocket serverSocket;
    private static final int PUERTO = 12345;
    private static ConcurrentHashMap<String, PrintWriter> clientes = new ConcurrentHashMap<>();
    private static boolean servidorActivo = false;

    public static void main(String[] args) {
        // Configurar ventana
        JFrame frame = new JFrame("Servidor Chat");
        frame.setLayout(new BorderLayout());

        // Área de mensajes
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Lista de clientes conectados
        listaClientesModel = new DefaultListModel<>();
        JList<String> listaClientes = new JList<>(listaClientesModel);
        JScrollPane scrollClientes = new JScrollPane(listaClientes);
        scrollClientes.setPreferredSize(new Dimension(150, 0));
        scrollClientes.setBorder(BorderFactory.createTitledBorder("Clientes"));

        // Botones de control
        JButton btnIniciar = new JButton("Iniciar");
        JButton btnParar = new JButton("Parar");
        btnParar.setEnabled(false);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnIniciar);
        panelBotones.add(btnParar);

        // Agregar componentes a la ventana
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(scrollClientes, BorderLayout.EAST);
        frame.add(panelBotones, BorderLayout.SOUTH);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Acción del botón "Iniciar"
        btnIniciar.addActionListener(e -> {
            if (!servidorActivo) {
                iniciarServidor();
                btnIniciar.setEnabled(false);
                btnParar.setEnabled(true);
            }
        });

        // Acción del botón "Parar"
        btnParar.addActionListener(e -> {
            if (servidorActivo) {
                detenerServidor();
                btnIniciar.setEnabled(true);
                btnParar.setEnabled(false);
            }
        });
    }

    private static void iniciarServidor() {
        servidorActivo = true;
        textArea.append("Servidor iniciado en el puerto " + PUERTO + "\n");

        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(PUERTO);

                while (servidorActivo) {
                    Socket clienteSocket = serverSocket.accept();
                    new Thread(() -> manejarCliente(clienteSocket)).start();
                }
            } catch (IOException e) {
                if (servidorActivo) {
                    textArea.append("Error en el servidor: " + e.getMessage() + "\n");
                }
            }
        }).start();
    }

    private static void manejarCliente(Socket clienteSocket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
        ) {
            // Recibir nombre del cliente
            String nombre = in.readLine();
            if (nombre == null || nombre.trim().isEmpty()) {
                out.println("Error: Nombre inválido.");
                clienteSocket.close();
                return;
            }

            synchronized (clientes) {
                clientes.put(nombre, out);
                listaClientesModel.addElement(nombre);
                textArea.append(nombre + " se ha conectado.\n");
                broadcast("Servidor", nombre + " se ha unido al chat.");
            }

            // Manejar mensajes del cliente
            String mensaje;
            while ((mensaje = in.readLine()) != null) {
                textArea.append(nombre + ": " + mensaje + "\n");
                broadcast(nombre, mensaje);
            }
        } catch (IOException e) {
            textArea.append("Error con un cliente: " + e.getMessage() + "\n");
        } finally {
            desconectarCliente(clienteSocket);
        }
    }

    private static void detenerServidor() {
        servidorActivo = false;
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
            textArea.append("Servidor detenido.\n");
        } catch (IOException e) {
            textArea.append("Error al detener el servidor: " + e.getMessage() + "\n");
        }
        synchronized (clientes) {
            clientes.clear();
            listaClientesModel.clear();
        }
    }

    private static void desconectarCliente(Socket clienteSocket) {
        try {
            clienteSocket.close();
        } catch (IOException e) {
            textArea.append("Error al cerrar cliente: " + e.getMessage() + "\n");
        }

        synchronized (clientes) {
            String nombre = clientes.entrySet().stream()
                .filter(entry -> entry.getValue().equals(clienteSocket))
                .map(entry -> entry.getKey())
                .findFirst().orElse(null);
            if (nombre != null) {
                clientes.remove(nombre);
                listaClientesModel.removeElement(nombre);
                broadcast("Servidor", nombre + " se ha desconectado.");
            }
        }
    }

    private static void broadcast(String remitente, String mensaje) {
        synchronized (clientes) {
            for (PrintWriter clienteOut : clientes.values()) {
                clienteOut.println(remitente + ": " + mensaje);
            }
        }
    }
}
