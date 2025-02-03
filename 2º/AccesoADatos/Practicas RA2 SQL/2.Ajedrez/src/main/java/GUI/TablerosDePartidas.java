package GUI;


import PanelesGUI.NBoton;
import Ventana.Vppal;
import conexionBD.GestorBD;
import data.Pieza;
import conexionBD.LectorDePartida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TablerosDePartidas extends JPanel {
    private final Vppal v;
    private final JPanel panelAnterior;
    private TableroAjedrez tablero;
    private JTextField txtIdPartida;

    public TablerosDePartidas(Vppal v, JPanel panelAnterior) {
        this.v = v;
        this.panelAnterior = panelAnterior;
        minitComponents();
    }

    private void minitComponents() {
        setLayout(new BorderLayout());


        // Panel superior de búsqueda
        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBusqueda.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblIdPartida = new JLabel("ID de Partida:");
        txtIdPartida = new JTextField(15);
        JButton btnBuscar = new JButton("Buscar");

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarPartida();
                if(tablero.getPiezas().isEmpty()){
                    JOptionPane.showMessageDialog(null, "No se ha encontrado la partida", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });

        panelBusqueda.add(lblIdPartida);
        panelBusqueda.add(txtIdPartida);
        panelBusqueda.add(btnBuscar);

        add(panelBusqueda, BorderLayout.NORTH);

        // Panel del tablero

        JPanel contenedorTablero = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        tablero = new TableroAjedrez();
        //tablero.setBorder(BorderFactory.createLineBorder(Color.black,2));
        tablero.setPreferredSize(new Dimension(v.getWidth()-(v.getWidth()/3),v.getHeight()-(v.getHeight()/3)));
        contenedorTablero.add(tablero);
        add(contenedorTablero, BorderLayout.CENTER);


        JButton btnVolver = new NBoton("Volver");
        btnVolver.setPreferredSize(new Dimension(100, 40));
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.ponPanel(panelAnterior);
            }
        });
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        panelBotones.add(btnVolver);
        add(panelBotones, BorderLayout.SOUTH);

        Temas.UtilTema.aplicarTema(this, data.App.TEMA);

        //adaptar el tamaño del tablero
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                tablero.setPreferredSize(new Dimension(v.getWidth()-(v.getWidth()/2),v.getHeight()-(v.getHeight()/3)));
                TablerosDePartidas.this.revalidate();
                TablerosDePartidas.this.repaint();
            }
        });

    }

    private void cargarPartida() {
        String idText = txtIdPartida.getText().trim();

        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor introduce un ID de partida", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int idPartida = Integer.parseInt(idText);
            List<Pieza> piezas = LectorDePartida.cargarPartida(idPartida);
            tablero.actualizarPiezas(piezas);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar la partida: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    //Este Main es para probar el panel
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba partidas ajedrez");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(new TablerosDePartidas((Vppal) frame,null));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            try {

                Connection con = GestorBD.establecerConexionMYSQL("jdbc:mysql://localhost:3306/bddajedrez", "root", "");
                GestorBD.setConexion(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
}