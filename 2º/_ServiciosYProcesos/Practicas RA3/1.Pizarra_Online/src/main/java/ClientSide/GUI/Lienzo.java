package ClientSide.GUI;

import Protocol.MensajeDibujo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

public class Lienzo extends JPanel {
    private final PizarraGUI pizarraGUI;
    private List<MensajeDibujo> formas;
    private String herramientaActual = "CIRCULO";
    private Color colorActual = Color.BLACK; // Color por defecto negro
    private int mouseX = -1, mouseY = -1;
    private boolean mostrarPrevisualizacion = false;

    public Lienzo(PizarraGUI pizarraGUI) {
        this.pizarraGUI = pizarraGUI;
        this.formas = new ArrayList<>();
        setBackground(Color.WHITE);

        // Detectar clics en el lienzo
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String colorHex = String.format("#%02x%02x%02x", colorActual.getRed(), colorActual.getGreen(), colorActual.getBlue());
                MensajeDibujo forma = new MensajeDibujo("DIBUJAR", herramientaActual, e.getX(), e.getY(), "Usuario", colorHex);
                agregarForma(forma);
                //Esto hace que la pizarra llame al cliente para que le mande la forma al servidor
                pizarraGUI.agregarForma(forma);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mostrarPrevisualizacion = false;
                repaint();
            }
        });

        // Detectar movimiento del mouse para la previsualización
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                mostrarPrevisualizacion = true;
                repaint();
            }
        });
    }

    public synchronized void agregarForma(MensajeDibujo forma) {
        formas.add(forma);

        repaint();
    }

    public void setHerramientaActual(String herramienta) {
        this.herramientaActual = herramienta;
    }

    public void setColorActual(Color color) {
        this.colorActual = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Dibujar todas las formas con su color
        for (MensajeDibujo forma : formas) {
            Color colorForma = Color.decode(forma.getColor());
            dibujarForma(g2, forma.getForma(), forma.getX(), forma.getY(), colorForma, 255);
        }

        // Dibujar la previsualización con el color actual
        if (mostrarPrevisualizacion) {
            dibujarForma(g2, herramientaActual, mouseX, mouseY, colorActual, 100);
        }
    }

    private void dibujarForma(Graphics2D g2, String forma, int x, int y, Color color, int alpha) {
        Color colorTransparente = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
        g2.setColor(colorTransparente);

        switch (forma) {
            case "CIRCULO":
                g2.fillOval(x - 25, y - 25, 50, 50);
                break;
            case "CUADRADO":
                g2.fillRect(x - 25, y - 25, 50, 50);
                break;
            case "ASPA":
                g2.drawLine(x - 25, y - 25, x + 25, y + 25);
                g2.drawLine(x + 25, y - 25, x - 25, y + 25);
                break;
        }
    }
}
