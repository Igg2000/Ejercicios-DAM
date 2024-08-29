/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.Manzana;
import data.Serpiente;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Nacho
 */
public class PanelJuego extends JPanel{

    Serpiente s=new Serpiente(5);
    Manzana m=new Manzana(650,500);

    public PanelJuego() {
        this.setBackground(Color.darkGray);
       // JOptionPane.showMessageDialog(this, "Pulsa para empezar");
        iniciarPartida();
    }

    private void iniciarPartida() {
        //movimientoAutomaticoDeLaSerpienteEnMilisegundos(2000);
        detectarTeclas();

    }


    private void detectarTeclas() {

        this.setFocusable(true);
        //this.requestFocusInWindow();
        //por algun motivo requestFocusInWindow no funciona sin invokeLater
        SwingUtilities.invokeLater(() -> this.requestFocusInWindow());

        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyChar() == Character.toLowerCase('w')) {
                    s.mover(Serpiente.Direccion.ARRIBA);
                } else if (evt.getKeyChar() == Character.toLowerCase('s')) {
                    s.mover(Serpiente.Direccion.ABAJO);
                } else if (evt.getKeyChar() == Character.toLowerCase('a')) {
                    s.mover(Serpiente.Direccion.IZQUIERDA);
                } else if (evt.getKeyChar() == Character.toLowerCase('d')){
                    s.mover(Serpiente.Direccion.DERECHA);
                } else if (evt.getKeyChar() == Character.toLowerCase('c')){
                    s.crecer();
                }

                if(verificarColisiones())
                    System.out.println("has chocado con algo");

                repaint();
            }
        });


    }

    private boolean verificarColisiones() {

        Rectangle rectCabeza = new Rectangle(s.getCabeza().getX(), s.getCabeza().getY(), s.getTamanio(), s.getTamanio());
        Rectangle []rectCuerpo = new Rectangle[s.getCuerpo().getX().length];
        for (int i = 0; i < rectCuerpo.length; i++) {
            rectCuerpo[i] = new Rectangle(s.getCuerpo().getX()[i], s.getCuerpo().getY()[i], s.getTamanio(), s.getTamanio());
        }


        //verificar si la serpiente choca consigo misma
        for (int i = 1; i < rectCuerpo.length; i++) {
            if(rectCabeza.intersects(rectCuerpo[i]))
                return true;
        }

        //verificar si la serpiente choca con el borde del mapa
        if(s.getCabeza().getX() <= 0 || s.getCabeza().getX() >= this.getWidth() || s.getCabeza().getY() <= 0 || s.getCabeza().getY() >= this.getHeight())
            return true;

        return false;
    }

    private void movimientoAutomaticoDeLaSerpienteEnMilisegundos(int ms) {
        Timer t = new Timer(ms, e -> {
            s.mover(s.getDireccionSerpiente());
            repaint();
        });
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        s.pintar(g);
        m.pintar(g);
    }
}
