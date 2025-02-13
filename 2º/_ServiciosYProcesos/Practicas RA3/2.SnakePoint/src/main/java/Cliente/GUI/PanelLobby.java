package Cliente.GUI;

import Cliente.Cliente;
import Cliente.Modelo.Avatar;
import Protocolo.Protocolo;
import Protocolo.ProtocoloUtiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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

    // Número de avatares disponibles
    private final int NUM_AVATARES = 4;

    // Variables para el estado de jugadores (simulación; en la práctica se actualizarían con datos del servidor)
    private int totalJugadores = 0;
    private int jugadoresPreparados = 0;

    public PanelLobby(Ventana ventana, Cliente cliente) {
        this.ventana = ventana;
        this.cliente = cliente;

        mandarMensaje(Protocolo.NUEVO_JUGADOR);
        inicializarComponentes();
        // Simulación: agregar usuarios conectados
        simularUsuariosConectados();
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

    private void mandarMensaje(int i) {
        switch (i) {
            case Protocolo.NUEVO_JUGADOR:
                String cad = ProtocoloUtiles.crearMensajeNuevoUsuario(cliente.getJugador().getId(), cliente.getJugador().getNombre());
                cliente.getOut().println(cad);
        }
    }

    /**
     * Método para simular la carga de usuarios conectados.
     * En un entorno real, estos datos vendrían del servidor.
     */
    private void simularUsuariosConectados() {
        // Agregamos algunos usuarios de ejemplo
        modeloUsuarios.addElement("Usuario1");
        modeloUsuarios.addElement("Usuario2");
        modeloUsuarios.addElement("Usuario3");
        totalJugadores = modeloUsuarios.getSize();
        actualizarEstadoPreparado(); // Actualiza el texto del botón con el estado actual
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

        // Aquí podrías enviar al servidor el mensaje indicando que el usuario está preparado,
        // por ejemplo: Cliente.enviarPreparado(nombre, avatarSeleccionado.getId());
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
