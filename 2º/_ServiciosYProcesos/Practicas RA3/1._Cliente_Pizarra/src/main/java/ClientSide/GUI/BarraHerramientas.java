package ClientSide.GUI;

import PanelesGUI.NBoton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

import static ClientSide.Cliente.TEMA;

public class BarraHerramientas extends JPanel {
    private JButton btnCirculo, btnCuadrado, btnAspa, btnColor, btnBorrar;
    private Lienzo lienzo;

    public BarraHerramientas(Lienzo lienzo) {
        this.lienzo = lienzo;
        setLayout(new FlowLayout());
        String circulo = "\u25CF";    // ●
        String cuadrado = "\u25A0";   // ■
        String aspa = "\u2716";       // ✖
        String color = ("\uD83C\uDFA8"); // 🎨
        String borrar = "\uD83E\uDDFD"; // 🧽

        setBackground(TEMA.getFondo());
        setBorder(BorderFactory.createLineBorder(TEMA.getComplementario()));

        btnCirculo = new NBoton(circulo, TEMA.getComplementario(), TEMA.getBoton());
        btnCuadrado = new NBoton(cuadrado, TEMA.getComplementario(), TEMA.getBoton());
        btnAspa = new NBoton(aspa, TEMA.getComplementario(), TEMA.getBoton());
        btnColor = new NBoton(color, TEMA.getComplementario(), TEMA.getBoton());
        btnBorrar = new NBoton(borrar, TEMA.getComplementario(), TEMA.getBoton());

        btnCirculo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        btnCuadrado.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        btnAspa.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        btnColor.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        btnBorrar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));

        btnCirculo.setPreferredSize(new Dimension(50, 50));
        btnCuadrado.setPreferredSize(new Dimension(50, 50));
        btnAspa.setPreferredSize(new Dimension(50, 50));
        btnColor.setPreferredSize(new Dimension(50, 50));
        btnBorrar.setPreferredSize(new Dimension(50, 50));



        // Listeners para cambiar herramienta actual
        btnCirculo.addActionListener(e -> lienzo.setHerramientaActual("CIRCULO"));
        btnCuadrado.addActionListener(e -> lienzo.setHerramientaActual("CUADRADO"));
        btnAspa.addActionListener(e -> lienzo.setHerramientaActual("ASPA"));

        // Selección de color
        btnColor.addActionListener(e -> {
            Color nuevoColor = JColorChooser.showDialog(null, "Selecciona un color", Color.BLACK);
            if (nuevoColor != null) {
                lienzo.setColorActual(nuevoColor);
            }
        });

        add(btnCirculo);
        add(btnCuadrado);
        add(btnAspa);
        add(btnColor);
        add(btnBorrar);

    }


}
