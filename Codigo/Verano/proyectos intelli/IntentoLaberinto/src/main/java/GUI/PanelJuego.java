/*
 * Created by JFormDesigner on Tue Jun 18 17:59:13 CEST 2024
 */

package GUI;

import data.Figura;
import data.Mapa;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.awt.event.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

import static GUI.MenuPrincipal.rutaCarpetaMapas;

/**
 * Este es el panel en el que se juega cada partida
 * @author grovy
 */
public class PanelJuego extends JPanel {

    private final Mapa mapa;
    Vppal v;
    int anchoLaberinto = 1280;
    int altoLaberinto = 720;
    int xInicialJugador;
    int yInicialJugador;
    int saltoJugador=5;
    Color colorJugador = Color.blue;
    Image imagenJugador= leerImagenJugador("src\\main\\java\\res\\jugador.png");
    Color colorMeta = Color.green;
    Figura jugador;
    Figura meta;
    List<Figura> muros = new ArrayList<>();
    Color colorMuros = Color.red;

    public PanelJuego(Vppal v, Mapa mapa) throws Exception {
        this.v = v;
        this.mapa = mapa;
        initComponents();

    }

    private void initComponents() throws Exception {
        habilitarMovimientoDelJugador();
        cargarMapa();

    }

    private void cargarMapa() throws Exception {

        List<Figura> figurasMapa = new ArrayList<>();

        //lee el archivo
        System.out.println(mapa.getNombreArchivo());
        BufferedReader br = new BufferedReader(new java.io.FileReader(rutaCarpetaMapas+"\\"+mapa.getNombreArchivo()));
        String cad;
        String[] datosLinea;

        //si hay una nueva linea, la separa por comas y crea figuras en base al contenido del archivo
        while ((cad = br.readLine()) != null) {
            datosLinea = cad.split(",");
            Figura nuevaFigura = new Figura(Integer.parseInt(datosLinea[0]), Integer.parseInt(datosLinea[1]), Integer.parseInt(datosLinea[2]), Integer.parseInt(datosLinea[3]), colorMuros);
            figurasMapa.add(nuevaFigura);
        }
        br.close();


        for (int i = 0; i < figurasMapa.size(); i++) {
            if (i==0) {
                jugador = figurasMapa.get(i);

                //si hay un fallo al cargar la imagen, la pinta del color elegido

                if (imagenJugador!=null)
                    jugador.setImage(imagenJugador);
                else
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

                int saltoPixeles=saltoJugador;
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
        Rectangle rJugador = new Rectangle(jugador.getX(),jugador.getY(),jugador.getAncho(),jugador.getAlto());
        Rectangle rMeta = new Rectangle(meta.getX(),meta.getY(),meta.getAncho(),meta.getAlto());
        List<Rectangle> rMuros = new ArrayList<>();
        for (Figura muro : muros) {
            Rectangle RMuro = new Rectangle(muro.getX(),muro.getY(),muro.getAncho(),muro.getAlto());
            rMuros.add(RMuro);
        }

        //compruebo la colision de todos los rectangulos

        for (Rectangle RMuro : rMuros) {
            if(rJugador.intersects(RMuro)){
                JOptionPane.showMessageDialog(this, "Has perdido");
                jugador.setX(xInicialJugador);
                jugador.setY(yInicialJugador);
            }
        }

        if(rJugador.intersects(rMeta)){
            JOptionPane.showMessageDialog(this, "Has ganado");
        }


    }

    private Image leerImagenJugador(String rutaImagen) {

        // Lee la imagen
        File archivoImagen = new File(rutaImagen);
        BufferedImage imagen = null;
        try {
            imagen = ImageIO.read(archivoImagen);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la imagen");
        }

        return imagen;
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
