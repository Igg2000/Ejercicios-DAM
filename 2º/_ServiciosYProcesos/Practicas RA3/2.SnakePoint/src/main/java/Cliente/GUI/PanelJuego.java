package Cliente.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class PanelJuego extends JPanel {
    private Ventana ventana;

    public PanelJuego(Ventana ventana) {
        this.ventana = ventana;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Aquí dibujas el escenario, los avatares, la comida, etc.
        g.setColor(Color.BLUE);
        g.drawString("Aquí va el juego en marcha...", 50, 50);
    }
}
