package ClientSide.GUI;


import javax.swing.*;
import java.awt.*;

public class PizarraGUI extends JFrame {
    private Lienzo lienzo;
    private BarraHerramientas herramientas;

    public PizarraGUI() {
        setTitle("Pizarra Colaborativa");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        lienzo = new Lienzo();
        herramientas = new BarraHerramientas(lienzo);

        add(herramientas, BorderLayout.NORTH);
        add(lienzo, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new PizarraGUI();
    }
}
