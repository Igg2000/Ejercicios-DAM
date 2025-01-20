/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package data;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatClienteGUI {
    private static JTextArea textArea;
    private static JTextField inputField;
    private static DefaultListModel<String> listaClientesModel;
    private static PrintWriter out;
    private static String nombre;

    public static void main(String[] args) {
        // Pedir nombre del cliente
        nombre = JOptionPane.showInputDialog(null, "Ingresa tu nombre:", "Cliente Chat", JOptionPane.PLAIN_MESSAGE);
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre para entrar al chat.");
            return;
        }

        // Configurar ventana de chat
        JFrame frame = new JFrame("Cliente Chat - " + nombre);
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

        // Campo de entrada
        inputField = new JTextField();
        inputField.addActionListener(e -> enviarMensaje());

        // Agregar componentes a la ventana
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(scrollClientes, BorderLayout.EAST);
        frame.add(inputField, BorderLayout.SOUTH);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        conectarAlServidor();
    }

    private static void conectarAlServidor() {
        String host = "127.0.0.1"; // Dirección del servidor
        int puerto = 12345;

        try {
            Socket socket = new Socket(host, puerto);
            textArea.append("Conectado al servidor\n");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Enviar el nombre al servidor
            out.println(nombre);

            // Hilo para escuchar mensajes del servidor
            new Thread(() -> {
                try {
                    String mensaje;
                    while ((mensaje = in.readLine()) != null) {
                        if (mensaje.startsWith("Servidor:")) {
                            actualizarListaClientes(mensaje);
                        } else {
                            textArea.append(mensaje + "\n");
                        }
                    }
                } catch (IOException e) {
                    textArea.append("Conexión cerrada: " + e.getMessage() + "\n");
                }
            }).start();
        } catch (IOException e) {
            textArea.append("Error al conectar al servidor: " + e.getMessage() + "\n");
        }
    }

    private static void enviarMensaje() {
        String mensaje = inputField.getText().trim();
        if (!mensaje.isEmpty() && out != null) {
            out.println(mensaje);
            inputField.setText("");
        }
    }

    private static void actualizarListaClientes(String mensaje) {
        String[] partes = mensaje.replace("Servidor:", "").split(",");
        SwingUtilities.invokeLater(() -> {
            listaClientesModel.clear();
            for (String cliente : partes) {
                listaClientesModel.addElement(cliente.trim());
            }
        });
    }
}
