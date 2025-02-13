package Cliente.GUI;

import Cliente.Cliente;

import javax.swing.JFrame;
import java.awt.CardLayout;

public class Ventana extends JFrame {
    private PanelLobby panelLobby;
    private PanelJuego panelJuego;
    private CardLayout layout;

    public Ventana(Cliente cliente) {
        super("Mi Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

       layout = new CardLayout();


        // Usamos un CardLayout para cambiar de panel fácilmente
        setLayout(layout);

        panelLobby = new PanelLobby(this,cliente);
        panelJuego = new PanelJuego(this);

        // Añadimos los paneles con un nombre identificador
        add(panelLobby, "LOBBY");
        add(panelJuego, "JUEGO");
    }


    /**
     * Cambia al panel de juego.
     */
    public void mostrarJuego() {
        layout.show(getContentPane(), "JUEGO");
    }

    /**
     * Cambia al panel de lobby.
     */
    public void mostrarLobby() {
        layout.show(getContentPane(), "LOBBY");
    }
}
