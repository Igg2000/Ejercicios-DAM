package GUI;

import PanelesGUI.NBoton;
import Ventana.Vppal;
import conexionBD.GestorBD;
import conexionBD.LectorDePartida;
import data.App;
import data.Partida;
import data.Pieza;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TablerosDeRondas extends JPanel {
    private final Vppal v;
    private final JPanel panelAnterior;
    private JComboBox<String> comboRondas;
    private JPanel panelTableros;

    public TablerosDeRondas(Vppal v, JPanel panelAnterior) {
        this.v = v;
        this.panelAnterior = panelAnterior;
        minitComponents();
        cargarRondas();
    }

    private void minitComponents() {
        setLayout(new BorderLayout());

        // Panel superior con ComboBox
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelSuperior.add(new JLabel("Seleccionar Ronda:"));

        comboRondas = new JComboBox<>();
        comboRondas.setPreferredSize(new Dimension(200, 30));
        comboRondas.addActionListener(e -> cargarTablerosRonda());
        panelSuperior.add(comboRondas);

        add(panelSuperior, BorderLayout.NORTH);

        // Panel central con scroll para los tableros
        panelTableros = new JPanel();
        panelTableros.setLayout(new GridLayout(0, 2, 10, 10)); // 2 columnas, espacio entre elementos
        JScrollPane scrollPane = new JScrollPane(panelTableros);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        // Botón Volver
        JButton btnVolver = new NBoton("Volver");
        btnVolver.setPreferredSize(new Dimension(100, 40));
        btnVolver.addActionListener(e -> v.ponPanel(panelAnterior));
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.add(btnVolver);
        add(panelInferior, BorderLayout.SOUTH);

        Temas.UtilTema.aplicarTema(this, data.App.TEMA);
    }

    private void cargarRondas() {
        new SwingWorker<List<String>, Void>() {
            @Override
            protected List<String> doInBackground() throws Exception {
                return LectorDePartida.obtenerRondasDisponibles();
            }

            @Override
            protected void done() {
                try {
                    comboRondas.removeAllItems();
                    List<String> rondas = get();
                    if (rondas.isEmpty()) {
                        comboRondas.addItem("No hay rondas disponibles");
                    } else {
                        rondas.forEach(comboRondas::addItem);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(TablerosDeRondas.this,
                            "Error al cargar rondas: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }

    private void cargarTablerosRonda() {
        String ronda = (String) comboRondas.getSelectedItem();
        if (ronda == null || ronda.isEmpty()) return;

        //Esta parte es para que se actualice el panel en segundo plano
        //Y una vez obtiene las partidas las pone
        new SwingWorker<List<Partida>, Void>() {
            @Override
            protected List<Partida> doInBackground() throws Exception {
                return LectorDePartida.obtenerPartidasPorRonda(ronda);
            }

            @Override
            protected void done() {
                try {
                    panelTableros.removeAll();
                    List<Partida> partidas = get();

                    if (partidas.isEmpty()) {
                        panelTableros.add(new JLabel("No hay partidas en esta ronda"));
                    } else {
                        for (Partida partida : partidas) {
                            JPanel contenedorTablero = crearPanelTablero(partida);
                            panelTableros.add(contenedorTablero);
                        }
                    }

                    panelTableros.revalidate();
                    panelTableros.repaint();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(TablerosDeRondas.this,
                            "Error al cargar partidas: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }

    /**
     * Este metodo crea un panel con el numero de partida y los jugadores y debajo
     * el tablero de ajedrez de la partida
     * @param partida
     * @return
     */
    private JPanel crearPanelTablero(Partida partida) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(App.TEMA.getFondo());
        panel.setBorder(BorderFactory.createLineBorder(App.TEMA.getBoton(), 1));

        // Cabecera con información de la partida
        JLabel lblInfo = new JLabel(
                String.format("Partida #%d - %s vs %s",
                        partida.getIdPartida(),
                        partida.getJugadorBlancas(),
                        partida.getJugadorNegras())
        );
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setForeground(App.TEMA.getTexto());
        panel.add(lblInfo, BorderLayout.NORTH);

        // Panel del tablero
        TableroAjedrez tablero = new TableroAjedrez();
        tablero.setBackground(App.TEMA.getFondo());
        tablero.setPreferredSize(new Dimension(300, 300));

        try {
            List<Pieza> piezas = LectorDePartida.cargarPartida(partida.getIdPartida());
            tablero.actualizarPiezas(piezas);
        } catch (SQLException ex) {
            tablero.actualizarPiezas(List.of());
            lblInfo.setText(lblInfo.getText() + " (Error al cargar)");
        }

        panel.add(tablero, BorderLayout.CENTER);
        return panel;
    }

    // Este Main es para probar el panel
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Visualizador de Rondas");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            try {
                Connection con = GestorBD.establecerConexionMYSQL(
                        "jdbc:mysql://localhost:3306/bddajedrez",
                        "root",
                        "");
                GestorBD.setConexion(con);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
            }

            frame.add(new TablerosDeRondas(new Vppal(), null));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}