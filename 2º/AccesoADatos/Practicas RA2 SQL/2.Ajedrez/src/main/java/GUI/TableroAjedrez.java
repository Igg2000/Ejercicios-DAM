package GUI;

import data.App;
import data.Pieza;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TableroAjedrez extends JPanel {
    private static final int TAM_TABLERO = 8;
    private static final int MARGEN_COORDENADAS = 30; // Nuevo margen fijo para coordenadas
    private List<Pieza> piezas;

    public TableroAjedrez() {
        int tamañoBase = TAM_TABLERO * 80; // 80px por casilla base
        setPreferredSize(new Dimension(
                tamañoBase + MARGEN_COORDENADAS * 2,
                tamañoBase + MARGEN_COORDENADAS * 2
        ));
        cargarPiezas();
    }

    private void cargarPiezas() {
        piezas = new ArrayList<>();

        // Piezas blancas
        piezas.add(new Pieza(0, 0, "blanco", "TORRE"));
        piezas.add(new Pieza(7, 0, "blanco", "TORRE"));
        piezas.add(new Pieza(1, 0, "blanco", "CABALLO"));
        piezas.add(new Pieza(6, 0, "blanco", "CABALLO"));
        piezas.add(new Pieza(2, 0, "blanco", "ALFIL"));
        piezas.add(new Pieza(5, 0, "blanco", "ALFIL"));
        piezas.add(new Pieza(3, 0, "blanco", "REINA"));
        piezas.add(new Pieza(4, 0, "blanco", "REY"));

        // Peones blancos
        for (int x = 0; x < TAM_TABLERO; x++) {
            piezas.add(new Pieza(x, 1, "blanco", "PEON"));
        }

        // Piezas negras
        piezas.add(new Pieza(0, 7, "negro", "TORRE"));
        piezas.add(new Pieza(7, 7, "negro", "TORRE"));
        piezas.add(new Pieza(1, 7, "negro", "CABALLO"));
        piezas.add(new Pieza(6, 7, "negro", "CABALLO"));
        piezas.add(new Pieza(2, 7, "negro", "ALFIL"));
        piezas.add(new Pieza(5, 7, "negro", "ALFIL"));
        piezas.add(new Pieza(3, 7, "negro", "REINA"));
        piezas.add(new Pieza(4, 7, "negro", "REY"));

        // Peones negros
        for (int x = 0; x < TAM_TABLERO; x++) {
            piezas.add(new Pieza(x, 6, "negro", "PEON"));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Calcular tamaño disponible restando los márgenes
        int anchoDisponible = getWidth() - MARGEN_COORDENADAS * 2;
        int altoDisponible = getHeight() - MARGEN_COORDENADAS * 2;

        // Calcular tamaño de casilla asegurando que quepa en el espacio disponible
        int tamCuadrado = Math.min(anchoDisponible, altoDisponible) / TAM_TABLERO;

        // Calcular posición inicial con márgenes
        int offsetX = MARGEN_COORDENADAS + (anchoDisponible - tamCuadrado * TAM_TABLERO) / 2;
        int offsetY = MARGEN_COORDENADAS + (altoDisponible - tamCuadrado * TAM_TABLERO) / 2;

        // Dibujar el tablero
        for (int y = 0; y < TAM_TABLERO; y++) {
            for (int x = 0; x < TAM_TABLERO; x++) {
                // Alternar colores
                if ((x + y) % 2 == 0) {
                    g.setColor(new Color(240, 217, 181));
                } else {
                    g.setColor(new Color(181, 136, 99));
                }
                g.fillRect(
                        offsetX + x * tamCuadrado,
                        offsetY + y * tamCuadrado,
                        tamCuadrado,
                        tamCuadrado
                );
            }
        }

        // Dibujar coordenadas
        dibujarCoordenadas(g, tamCuadrado, offsetX, offsetY);

        // Dibujar piezas
        for (Pieza pieza : piezas) {
            dibujarPieza(g, pieza, tamCuadrado, offsetX, offsetY);
        }

    }
    private void dibujarCoordenadas(Graphics g, int tamCuadrado, int offsetX, int offsetY) {
        g.setColor(App.TEMA.getTexto());
        Font font = new Font("Arial", Font.PLAIN, tamCuadrado / 4);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();

        // Coordenadas verticales (1-8)
        for (int y = 0; y < TAM_TABLERO; y++) {
            String numero = String.valueOf(8 - y);
            int xPos = offsetX - MARGEN_COORDENADAS / 2;
            int yPos = offsetY + y * tamCuadrado + tamCuadrado / 2 + fm.getAscent() / 2;
            g.drawString(numero, xPos, yPos);

            xPos = offsetX + TAM_TABLERO * tamCuadrado + MARGEN_COORDENADAS / 2;
            g.drawString(numero, xPos, yPos);
        }

        // Coordenadas horizontales (A-H)
        for (int x = 0; x < TAM_TABLERO; x++) {
            String letra = String.valueOf((char) ('A' + x));
            int xPos = offsetX + x * tamCuadrado + tamCuadrado / 2 - fm.stringWidth(letra) / 2;
            int yPos = offsetY - MARGEN_COORDENADAS / 2;
            g.drawString(letra, xPos, yPos);

            yPos = offsetY + TAM_TABLERO * tamCuadrado + MARGEN_COORDENADAS / 2 + fm.getAscent();
            g.drawString(letra, xPos, yPos);
        }
    }


    private void dibujarPieza(Graphics g, Pieza pieza, int tamCuadrado, int offsetX, int offsetY) {
        g.setColor(pieza.getColor().equals("blanco") ? Color.WHITE : Color.BLACK);
        g.setFont(new Font("Arial Unicode MS", Font.PLAIN, (int)(tamCuadrado * 0.75)));

        // Calcular posición centrada
        int x = offsetX + pieza.getX() * tamCuadrado;
        int y = offsetY + pieza.getY() * tamCuadrado;

        // Centrar el símbolo
        FontMetrics fm = g.getFontMetrics();
        String simbolo = pieza.getSymbol();
        int textX = x + (tamCuadrado - fm.stringWidth(simbolo)) / 2;
        int textY = y + ((tamCuadrado - fm.getHeight()) / 2) + fm.getAscent();

        g.drawString(simbolo, textX, textY);
    }

    public void actualizarPiezas(List<Pieza> nuevasPiezas) {
        this.piezas = nuevasPiezas;
        repaint();
    }

    public List<Pieza> getPiezas() {
        return piezas;
    }

    //Main que he hecho para probar el panel
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TableroAjedrez());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}