package GUI;

import PanelesGUI.NBoton;
import PanelesGUI.PanelPaginaDeTextoHTML;
import Ventana.Vppal;
import conexionBD.LectorDePartida;
import data.Partida;
import data.App;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ResultadosPorRonda extends JPanel {
    private final Vppal v;
    private final JPanel panelAnterior;
    private JComboBox<String> comboRondas;
    private PanelPaginaDeTextoHTML panelHTML;

    public ResultadosPorRonda(Vppal v, JPanel panelAnterior) {
        this.v = v;
        this.panelAnterior = panelAnterior;
        initComponents();
        cargarRondas();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel superior con el ComboBox
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelSuperior.add(new JLabel("Seleccione ronda:"));

        comboRondas = new JComboBox<>();
        comboRondas.setPreferredSize(new Dimension(200, 25));
        comboRondas.addActionListener(e -> actualizarPartidas());

        panelSuperior.add(comboRondas);

        add(panelSuperior, BorderLayout.NORTH);

        // Panel HTML
        panelHTML = new PanelPaginaDeTextoHTML("Partidas por Ronda","");
        panelHTML.getCuadroTexto().setBackground(App.TEMA.getFondo());
        add(panelHTML, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton botonVolver = new NBoton("Volver");
        botonVolver.setPreferredSize(new Dimension(100, 40));

        botonVolver.addActionListener(e -> {
            v.ponPanel(panelAnterior);
        });

        panelBotones.add(botonVolver);
        add(panelBotones, BorderLayout.SOUTH);

        Temas.UtilTema.aplicarTema(this, App.TEMA);
    }

    private void cargarRondas() {
        try {
            List<String> rondas = LectorDePartida.obtenerRondasDisponibles();
            rondas.forEach(ronda -> comboRondas.addItem(ronda));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar rondas: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarPartidas() {
        String rondaSeleccionada = (String) comboRondas.getSelectedItem();
        if (rondaSeleccionada != null) {
            try {

                List<Partida> partidas = LectorDePartida.obtenerPartidasPorRonda(rondaSeleccionada);

                String html = generarHTMLPartidas(partidas);
                panelHTML.getCuadroTexto().setText(html);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al cargar partidas: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método para pasar de rgb a hexadecimal
    private String toHex(Color c) {
        return String.format("#%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
    }

    private String generarHTMLPartidas(List<Partida> partidas) {
        StringBuilder html = new StringBuilder();
        html.append("""
        <html>
        <head>
        <style>
        """);

        // .contenedor: se usa la fuente del tema y se asigna el fondo y el color de texto
        html.append(".contenedor { \n")
                .append("    padding: 20px;\n")
                .append("    font-family: '")
                .append(App.TEMA.getFuenteTexto().getFamily())
                .append("', sans-serif;\n")
                .append("    background-color: ")
                .append(toHex(App.TEMA.getFondo()))
                .append(";\n")
                .append("    color: ")
                .append(toHex(App.TEMA.getTexto()))
                .append(";\n")
                .append("}\n");

        // .partida: para cada tarjeta se usa el color complementario para el borde;
        // en este ejemplo se mantiene el mismo fondo que el contenedor, pero podrías
        // elegir otra opción (por ejemplo, una variante más clara u oscura)
        html.append(".partida {\n")
                .append("    border: 1px solid ")
                .append(toHex(App.TEMA.getComplementario()))
                .append(";\n")
                .append("    border-radius: 8px;\n")
                .append("    padding: 15px;\n")
                .append("    margin-bottom: 15px;\n")
                .append("    background-color: ")
                .append(toHex(App.TEMA.getFondo()))
                .append(";\n")
                .append("    box-shadow: 0 2px 4px rgba(0,0,0,0.1);\n")
                .append("}\n");

        html.append(".titulo {\n")
                .append("    color: ")
                .append(toHex(App.TEMA.getBoton()))
                .append(";\n")
                .append("    font-size: 1.2em;\n")
                .append("    margin-bottom: 10px;\n")
                .append("}\n");


        html.append(".detalle {\n")
                .append("    display: grid;\n")
                .append("    grid-template-columns: repeat(2, 1fr);\n")
                .append("    gap: 10px;\n")
                .append("    margin-bottom: 8px;\n")
                .append("}\n");

        html.append(".etiqueta {\n")
                .append("    font-weight: bold;\n")
                .append("    color: ")
                .append(toHex(App.TEMA.getTexto()))
                .append(";\n")
                .append("}\n");

        html.append(".valor {\n")
                .append("    color: ")
                .append(toHex(App.TEMA.getTexto()))
                .append(";\n")
                .append("}\n");

        html.append("""
        </style>
        </head>
        <body>
        <div class='contenedor'>
        """);

        if (partidas.isEmpty()) {
            html.append("<p>No hay partidas en esta ronda</p>");
        } else {
            for (Partida partida : partidas) {
                html.append(String.format("""
                    <div class='partida'>
                        <div class='titulo'>Partida #%d</div>
                        <div class='detalle'>
                            <div class='etiqueta'>Blancas:</div>
                            <div class='valor'>%s</div>
                            <div class='etiqueta'>Negras:</div>
                            <div class='valor'>%s</div>
                            <div class='etiqueta'>Ganador:</div>
                            <div class='valor'>%s</div>
                            <div class='etiqueta'>Duración:</div>
                            <div class='valor'>%s</div>
                            <div class='etiqueta'>Inicio:</div>
                            <div class='valor'>%s</div>
                            <div class='etiqueta'>Fin:</div>
                            <div class='valor'>%s</div>
                        </div>
                        <div class='ronda'>Ronda: %s</div>
                    </div>
                    """,
                        partida.getIdPartida(),
                        partida.getJugadorBlancas(),
                        partida.getJugadorNegras(),
                        partida.getGanador(),
                        partida.getDuracion(),
                        partida.getFechaInicio(),
                        partida.getFechaFin(),
                        partida.getRonda()));
            }
        }

        html.append("</div></body></html>");
        return html.toString();
    }
}