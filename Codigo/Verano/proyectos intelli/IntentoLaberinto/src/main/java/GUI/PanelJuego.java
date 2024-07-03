/*
 * Created by JFormDesigner on Tue Jun 18 17:59:13 CEST 2024
 */

package GUI;

import data.Figura;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

/**
 * Este es el panel en el que se juega cada partida
 * @author grovy
 */
public class PanelJuego extends JPanel {

    Vppal v;
    int anchoLaberinto = 1280;
    int altoLaberinto = 720;
    int xInicialJugador;
    int yInicialJugador;
    Color colorJugador = Color.blue;
    Color colorMeta = Color.green;
    Figura jugador;
    Figura meta;
    //Figura jugador= new Figura(xInicialJugador, yInicialJugador, 50 , 50 , Color.blue);
    List<Figura> muros = new ArrayList<>();
    Color colorMuros = Color.red;

    public PanelJuego(Vppal v) {
        this.v = v;
        initComponents();
    }

    private void initComponents() {
        habilitarMovimientoDelJugador();
        cargarMapa();

    }

    private void cargarMapa() {

        List<Figura> figurasMapa = new ArrayList<>();
        try {
            //lee el archivo
            BufferedReader br = new BufferedReader(new java.io.FileReader("src\\main\\java\\res\\facil1.txt"));
            String cad;
            String[] datosLinea;

            //si hay una nueva linea, la separa por comas y crea figuras en base al contenido del archivo
            while ((cad = br.readLine()) != null) {
                datosLinea = cad.split(",");
                Figura nuevaFigura = new Figura(Integer.parseInt(datosLinea[0]), Integer.parseInt(datosLinea[1]), Integer.parseInt(datosLinea[2]), Integer.parseInt(datosLinea[3]), colorMuros);
                figurasMapa.add(nuevaFigura);
            }
            br.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el mapa");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el mapa");
        }

        for (int i = 0; i < figurasMapa.size(); i++) {
            if (i==0) {
                jugador = figurasMapa.get(i);
                jugador.setColor(colorJugador);
                xInicialJugador = jugador.getX();
                yInicialJugador = jugador.getY();
            }else if (i==1){
                meta = figurasMapa.get(i);
                meta.setColor(colorMeta);
            }else
                muros.add(figurasMapa.get(i));
        }

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

                comprobarColisiones();

                repaint();
                revalidate();

            }
        });
    }

    private void comprobarColisiones() {

        //creo rectangulo del jugador y de los muros
        Rectangle RJugador = new Rectangle(jugador.getX(),jugador.getY(),jugador.getAncho(),jugador.getAlto());
        List<Rectangle> RMuros = new ArrayList<>();
        for (Figura muro : muros) {
            Rectangle RMuro = new Rectangle(muro.getX(),muro.getY(),muro.getAncho(),muro.getAlto());
            RMuros.add(RMuro);
        }

        //compruebo la colision de todos los rectangulos

        for (Rectangle RMuro : RMuros) {
            if(RJugador.intersects(RMuro)){
                JOptionPane.showMessageDialog(this, "Has perdido");
                jugador.setX(xInicialJugador);
                jugador.setY(yInicialJugador);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        // Escala el gráfico según el tamaño actual del panel
        double widthRatio = (double) getWidth() / anchoLaberinto;
        double heightRatio = (double) getHeight() / altoLaberinto;
        g2d.scale(widthRatio, heightRatio);


        //dibujar laberinto
        List<Figura> figuras = new ArrayList<>();
        figuras.add(jugador);
        figuras.addAll(muros);
        figuras.add(meta);

        for (Figura figura : figuras) {
            figura.pintar(g2d);
        }

        g2d.dispose();

    }

}
