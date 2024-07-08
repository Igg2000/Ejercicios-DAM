package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPausa extends JFrame {

    private final Vppal v;
    private final MenuPrincipal mp;

    JPanel panel = new JPanel();
    NBoton b1= new NBoton("Continuar", Color.BLUE, Color.cyan);
    NBoton b2= new NBoton("Volver al Menu", Color.BLUE, Color.cyan);
    NBoton b3= new NBoton("Salir del juego", Color.BLUE, Color.cyan);

    public MenuPausa(Vppal v, MenuPrincipal mp) {
        super();
        this.v=v;
        this.mp=mp;
        inicializar();
    }

    private void inicializar() {
        crearLayout();
        agregarBotones();
        quitarBarraDeTitulo();
        quitarFondo();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(100, 100, 100,100));
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
    }

    private void quitarFondo() {
        setBackground(new Color(0, 0, 0, 0));
        panel.setBackground(new Color(0, 0, 0, 0));

    }

    private void quitarBarraDeTitulo() {
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    }

    private void crearLayout() {

        GridLayout layout = new GridLayout(3, 1);
        layout.setVgap( layout.getRows()*2);
        setLayout(new BorderLayout());
        panel.setLayout(layout);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panel, BorderLayout.CENTER);
    }

    private void agregarBotones() {

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                //v.ponPanel(new MenuPrincipal(v, mp.getOpciones(), mp.getNombreTitulo(), mp.getColor1(), mp.getColor2(), mp.getColorFondo(), mp.getFuenteTitulo(), mp.getColorLetraTitulo()));
                v.ponerPanelPrincipal();
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                v.dispose();
            }
        });
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);

    }

}
