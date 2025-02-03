package ClientSide.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

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


        btnCirculo = new JButton(circulo);
        btnCuadrado = new JButton(cuadrado);
        btnAspa = new JButton(aspa);
        btnColor = new JButton(color);
        btnBorrar = new JButton(borrar);

        btnCirculo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        btnCuadrado.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        btnAspa.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        btnColor.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        btnBorrar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));


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
