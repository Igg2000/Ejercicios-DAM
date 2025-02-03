package ClientSide.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class BarraHerramientas extends JPanel {
    private JButton btnCirculo, btnCuadrado, btnAspa, btnColor;
    private JList<String> listaUsuarios;
    private DefaultListModel<String> modeloUsuarios;
    private Lienzo lienzo;

    public BarraHerramientas(Lienzo lienzo) {
        this.lienzo = lienzo;
        setLayout(new FlowLayout());

        btnCirculo = new JButton("Círculo");
        btnCuadrado = new JButton("Cuadrado");
        btnAspa = new JButton("Aspa");
        btnColor = new JButton("Color");

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

        modeloUsuarios = new DefaultListModel<>();
        listaUsuarios = new JList<>(modeloUsuarios);
        add(new JScrollPane(listaUsuarios));
    }

    public void actualizarListaUsuarios(List<String> usuarios) {
        modeloUsuarios.clear();
        for (String usuario : usuarios) {
            modeloUsuarios.addElement(usuario);
        }
    }
    public void actualizarListaUsuarios(String usuario) {
        modeloUsuarios.addElement(usuario);

    }

}
