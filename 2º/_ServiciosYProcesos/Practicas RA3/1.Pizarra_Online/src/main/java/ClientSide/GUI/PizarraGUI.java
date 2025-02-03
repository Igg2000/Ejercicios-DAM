package ClientSide.GUI;

import ClientSide.Cliente;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PizarraGUI extends JFrame {
    private Lienzo lienzo;
    private BarraHerramientas herramientas;

    public PizarraGUI(Cliente cliente) {
        setTitle("Pizarra Colaborativa - "+cliente.getNombreUsuario());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        lienzo = new Lienzo();
        herramientas = new BarraHerramientas(lienzo);

        add(herramientas, BorderLayout.NORTH);
        add(lienzo, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actualizarListaUsuarios(List<String> usuarios) {
        herramientas.actualizarListaUsuarios(usuarios);
    }
    public void actualizarListaUsuarios(String usuario) {
        herramientas.actualizarListaUsuarios(usuario);
    }

    public Lienzo getLienzo() {
        return lienzo;
    }
}
