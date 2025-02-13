package Cliente.GUI;

import Cliente.Cliente;
import Cliente.Modelo.Avatar;
import Protocolo.Protocolo;
import Protocolo.ProtocoloUtiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PanelLobby extends JPanel {
    private Ventana ventana;
    private final Cliente cliente;
    private JPanel panelAvatares;
    private JButton btnPreparado;
    private JButton[] botonesAvatar;
    private Avatar avatarSeleccionado;
    private boolean preparado= false;

    // Lista de usuarios conectados (por ejemplo, "Usuario1", "Usuario2", etc.)
    private DefaultListModel<String> modeloUsuarios;
    private JList<String> listaUsuarios;
    private List<String> listaNombres;

    // Número de avatares disponibles
    private final int NUM_AVATARES = 4;


    private int totalJugadores = 0;
    private int jugadoresPreparados = 0;
    private boolean listoParaJugar=false;

    public PanelLobby(Ventana ventana, Cliente cliente) {
        this.ventana = ventana;
        this.cliente = cliente;
        listaNombres = new ArrayList<>();


        cliente.enviarNuevoUsuario();
        inicializarComponentes();

        recibirUsuarios();
    }

    private void inicializarComponentes() {

        setLayout(new BorderLayout(10, 10));

        // Panel superior: ingreso del nombre
        JPanel panelNombre = new JPanel();
        JLabel etiquetaNombre = new JLabel(cliente.getJugador().getNombre());
        panelNombre.add(etiquetaNombre);
        add(panelNombre, BorderLayout.NORTH);

        // Panel central: selección de avatar mediante botones con iconos
        panelAvatares = new JPanel(new GridLayout(2, 3, 10, 10));
        botonesAvatar = new JButton[NUM_AVATARES];

        for (int i = 0; i < NUM_AVATARES; i++) {
            int avatarId = i + 1; // IDs de 1 a NUM_AVATARES
            String rutaImagen = "imagenes/avatar" + avatarId + ".png";
            // Se carga la imagen
            ImageIcon icon = new ImageIcon(rutaImagen);
            JButton btnAvatar = new JButton(icon);
            btnAvatar.setActionCommand(String.valueOf(avatarId));
            btnAvatar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    seleccionarAvatar(Integer.parseInt(e.getActionCommand()), rutaImagen);
                }
            });
            botonesAvatar[i] = btnAvatar;
            panelAvatares.add(btnAvatar);
        }
        add(panelAvatares, BorderLayout.CENTER);

        // Panel derecho: lista de usuarios conectados
        modeloUsuarios = new DefaultListModel<>();
        listaUsuarios = new JList<>(modeloUsuarios);
        JScrollPane scrollUsuarios = new JScrollPane(listaUsuarios);
        scrollUsuarios.setPreferredSize(new Dimension(150, 0));
        add(scrollUsuarios, BorderLayout.EAST);

        // Panel inferior: botón "Preparado"
        JPanel panelInferior = new JPanel();
        btnPreparado = new JButton("Preparado");
        btnPreparado.setBackground(Color.LIGHT_GRAY);
        btnPreparado.setFont(new Font("Arial", Font.BOLD, 20));
        btnPreparado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!preparado)
                    prepararse();
            }
        });
        panelInferior.add(btnPreparado);
        add(panelInferior, BorderLayout.SOUTH);
    }



    private void recibirUsuarios() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!listoParaJugar) {
                    cliente.enviarMensaje(String.valueOf(Protocolo.DAME_LISTA_DE_JUGADORES));
                    cliente.enviarMensaje(String.valueOf(Protocolo.DAME_JUGADORES_PREPARADOS));
                    try {
                        Thread.sleep(500); // espera 1 segundo
                        String cad = cliente.recibirMensaje();
                        String[] tokens = ProtocoloUtiles.parsearMensaje(cad);

                        System.out.println("El cliente ha recibido el mensaje: " + cad);

                        // Si el mensaje es de agregar jugadores
                        if (tokens[0].equals(String.valueOf(Protocolo.AGREGA_JUGADORES_A_LA_LISTA))) {
                            // Crear lista temporal con los nombres recibidos
                            List<String> nuevosNombres = new ArrayList<>();
                            for (int i = 1; i < tokens.length; i++) {
                                nuevosNombres.add(tokens[i]);
                            }

                            // Si la lista de nombres actual es diferente a la recibida, se actualiza
                            if (!nuevosNombres.equals(listaNombres)) {
                                // Actualizar la lista de nombres y el modelo del JList
                                listaNombres.clear();
                                modeloUsuarios.clear();

                                for (String nombre : nuevosNombres) {
                                    listaNombres.add(nombre);
                                    modeloUsuarios.addElement(nombre);
                                }
                                totalJugadores = modeloUsuarios.getSize();
                                actualizarEstadoPreparado(); // Actualiza el texto del botón con el estado actual

                                // Actualizar la interfaz
                                PanelLobby.this.revalidate();
                            }
                        } else if (tokens[0].equals(String.valueOf(Protocolo.TOMA_JUGADORES_PREPARADOS))) {
                            //aqui tengo un problema de sincronizacion
                            System.out.println("Estos son los jugadores preparados antes: " +jugadoresPreparados);
                            jugadoresPreparados = Integer.parseInt(tokens[1]);
                            System.out.println("Estos son los jugadores preparados despues: " +jugadoresPreparados);
                            actualizarEstadoPreparado();
                        }
                    } catch (InterruptedException | IOException e) {
                        System.out.println("Error al recibir usuarios: " + e.getMessage());
                    }
                }
            }
        });
        t.start();
    }


    private void seleccionarAvatar(int id, String rutaImagen) {
        // Resalta el botón seleccionado (quita el borde de los demás)
        for (JButton btn : botonesAvatar) {
            btn.setBorder(UIManager.getBorder("Button.border"));
        }
        for (JButton btn : botonesAvatar) {
            if (btn.getActionCommand().equals(String.valueOf(id))) {
                btn.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
                break;
            }
        }
        // Se crea el objeto Avatar seleccionado
        avatarSeleccionado = new Avatar(id, rutaImagen);
    }

    private void prepararse() {

        if (avatarSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un avatar.");
            return;
        }

        // Cambiar el botón a verde para indicar que está preparado
        btnPreparado.setBackground(Color.GREEN);

        // Deshabilitar los botones de avatar para evitar cambios posteriores
        for (JButton btn : botonesAvatar) {
            btn.setEnabled(false);
        }

        preparado = true;

        // Simulación: incrementar el contador de jugadores preparados
        jugadoresPreparados++;
        actualizarEstadoPreparado();
        cliente.enviarPreparado(avatarSeleccionado.getId());
    }

    /**
     * Actualiza el texto del botón "Preparado" con el formato "Preparado X/Y"
     * donde X es el número de jugadores preparados y Y el total de jugadores conectados.
     */
    private void actualizarEstadoPreparado() {
        btnPreparado.setText("Preparado " + jugadoresPreparados + "/" + totalJugadores);
    }

    /**
     * Método para actualizar la lista de usuarios conectados (por ejemplo, cuando llega información del servidor).
     */
    public void actualizarUsuariosConectados(List<String> usuarios) {
        modeloUsuarios.clear();
        for (String usuario : usuarios) {
            modeloUsuarios.addElement(usuario);
        }
        totalJugadores = modeloUsuarios.getSize();
        actualizarEstadoPreparado();
    }
}
