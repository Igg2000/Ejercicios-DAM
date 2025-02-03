package ClientSide.GUI;

import ClientSide.Cliente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

import static ClientSide.Cliente.TEMA;

public class ListaUsuarios extends JPanel {

    private final PizarraGUI ventana;
    private DefaultListModel<Object> modeloUsuarios;
    private JList<Object> listaUsuarios;

    public ListaUsuarios(PizarraGUI pizarraGUI) {
        this.ventana = pizarraGUI;
        minicomponents();
    }

    private void minicomponents() {



        modeloUsuarios = new DefaultListModel<>();
        listaUsuarios = new JList<>(modeloUsuarios);
        listaUsuarios.setBorder(new EmptyBorder(0, 2, 0, 2));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JScrollPane(listaUsuarios));


        setBackground(TEMA.getFondo());
        setBorder(BorderFactory.createLineBorder(TEMA.getComplementario()));
        listaUsuarios.setFont(TEMA.getFuenteTexto());
        listaUsuarios.setForeground(TEMA.getTexto());
        listaUsuarios.setBackground(TEMA.getFondo());

        revalidate();
        repaint();


    }


    public void actualizarListaUsuarios(List<String> usuarios) {
        modeloUsuarios.clear();
        for (String usuario : usuarios) {
            modeloUsuarios.addElement(usuario);
        }

        revalidate();
        repaint();
    }
    public void actualizarListaUsuarios(String usuario) {
        modeloUsuarios.addElement(usuario);

        revalidate();
        repaint();
    }
}
