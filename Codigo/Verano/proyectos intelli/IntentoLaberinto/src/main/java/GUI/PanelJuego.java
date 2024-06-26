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
    int anchoLaberinto = 1280;
    int altoLaberinto = 720;
    Figura jugador= new Figura(100, 50, 50 , 50 , Color.blue);

    public PanelJuego(Vppal v) {
        this.v = v;
        initComponents();
    }

    private void initComponents() {
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        // Escala el gráfico según el tamaño actual del panel
        double widthRatio = (double) getWidth() / anchoLaberinto;
        double heightRatio = (double) getHeight() / altoLaberinto;
        g2d.scale(widthRatio, heightRatio);
/*
        for (Figura figura : figuras) {
            figura.pintar(g2d);
        }*/
        jugador.pintar(g2d);
        g2d.dispose();

    }

}
