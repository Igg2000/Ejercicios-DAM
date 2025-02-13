package ClientSide.GUI;

import ClientSide.Cliente;
import Protocol.MensajeDibujo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class PizarraGUI extends JFrame {
    private Cliente cliente;
    private Lienzo lienzo;
    private BarraHerramientas herramientas;
    private ListaUsuarios listaUsuarios;

    public PizarraGUI(Cliente cliente) {
        this.cliente = cliente;
        setTitle("Pizarra Colaborativa - "+cliente.getNombreUsuario());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //se me estaba complicando
        setLayout(new BorderLayout());


        lienzo = new Lienzo(this);
        herramientas = new BarraHerramientas(lienzo);
        listaUsuarios = new ListaUsuarios(this);

        add(listaUsuarios, BorderLayout.EAST);
        add(herramientas, BorderLayout.NORTH);
        add(lienzo, BorderLayout.CENTER);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cliente.conectado=false;
                super.windowClosing(e);
            }
        });
    }

    public synchronized void agregarForma(MensajeDibujo forma) {
        cliente.enviarMensaje(forma);
    }

    public void actualizarListaUsuarios(List<String> usuarios) {
        listaUsuarios.actualizarListaUsuarios(usuarios);
    }
    public void actualizarListaUsuarios(String usuario) {
        listaUsuarios.actualizarListaUsuarios(usuario);
    }

    public Lienzo getLienzo() {
        return lienzo;
    }
}
