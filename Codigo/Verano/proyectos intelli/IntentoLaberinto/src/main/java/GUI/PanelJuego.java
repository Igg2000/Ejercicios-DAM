/*
 * Created by JFormDesigner on Tue Jun 18 17:59:13 CEST 2024
 */

package GUI;

import data.Figura;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Este es el panel en el que se juega cada partida
 * @author grovy
 */
public class PanelJuego extends JPanel {

    Vppal v;
    Figura jugador= new Figura(0, 0, 10 , 10 , Color.blue);

    public PanelJuego(Vppal v) {
        this.v = v;
        initComponents();
    }

    private void initComponents() {
        ajustarFiguraAlTamDeLaPantalla(jugador);
        habilitarMovimientoDelJugador();

    }

    private void habilitarMovimientoDelJugador() {
        v.requestFocus();

        v.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {

                int saltoPixeles=3;
                char tecla= Character.toLowerCase(e.getKeyChar());

                switch (tecla) {
                    case 'w':jugador.setY(jugador.getY() - saltoPixeles);break;
                    case 's':jugador.setY(jugador.getY() + saltoPixeles);break;
                    case 'a':jugador.setX(jugador.getX() - saltoPixeles);break;
                    case 'd':jugador.setX(jugador.getX() + saltoPixeles);break;
                }
                repaint();
                revalidate();

            }
        });
    }

    private void ajustarFiguraAlTamDeLaPantalla(Figura f) {
        int ancho= f.getAncho();
        int alto= f.getAlto();

        f.setAncho(f.getAncho()* v.getWidth() /100);
        f.setAlto(f.getAlto()* v.getHeight() /100);

        v.requestFocus();
        v.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                f.setAncho(ancho* v.getWidth() /100);
                f.setAlto(alto* v.getHeight() /100);
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        jugador.pintar(g);

    }

}
