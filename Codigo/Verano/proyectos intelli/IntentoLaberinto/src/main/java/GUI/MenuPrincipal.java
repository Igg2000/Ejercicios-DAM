package GUI;

import data.Mapa;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Este es el menu principal de la aplicacion
 */
public class MenuPrincipal extends PMenuConNBotones{

    Vppal v;
    Color color1,color2,colorFondo,colorLetraTitulo;
    Font fuenteTitulo;
    public static String rutaCarpetaMapas="src\\main\\java\\res\\mapas";
    public MenuPrincipal(Vppal v,String[] opciones, String nombreTitulo, Color color1, Color color2, Color colorFondo, Font fuenteTitulo, Color colorLetraTitulo) {
        super(opciones, nombreTitulo, color1, color2, colorFondo, fuenteTitulo, colorLetraTitulo);
        this.v=v;
        this.color1=color1;
        this.color2=color2;
        this.colorFondo=colorFondo;
        this.fuenteTitulo=fuenteTitulo;
        this.colorLetraTitulo=colorLetraTitulo;
        inicializar();
    }

    private void inicializar() {
        //eventoBotonJugar();
        eventoBotonJugarConElegirNivel();
        elUltimoBotonCierraLaVentana(getOpciones());
    }

    private void eventoBotonJugarConElegirNivel() {

        getBotones()[0].addActionListener(e -> {
            String[] opsMenu = leerMapasDeCarpeta(rutaCarpetaMapas);
            PMenuConNBotones p = new PMenuConNBotones(opsMenu,"Menu de Dificultad", color1, color2, colorFondo,fuenteTitulo, colorLetraTitulo);
            MenuPrincipal.this.v.ponPanel(p);

            for (int i = 0; i < p.getBotones().length ; i++) {
                //no entiendo el sentido de esto
                int iQueFunciona = i;
                p.getBotones()[i].addActionListener(e1 -> {
                   JOptionPane.showMessageDialog(this, "Mapa elegido "+ p.getBotones()[iQueFunciona].getText());
                    ponerPanelDeJuego(leerMapasDeCarpeta(rutaCarpetaMapas)[iQueFunciona]+".txt");
                });
            }

        });
    }

    private void ponerPanelDeJuego(String nombreArchivo) {
        //este metodo es el que recoge todas las excepciones en caso de que el mapa no se pueda cargar
        try {
            MenuPrincipal.this.v.ponPanel(new PanelJuego(v,new Mapa(nombreArchivo)));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el mapa");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el mapa");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El formato del mapa no es correcto");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error desconocido");
        }
    }

    private String[] leerMapasDeCarpeta(String ruta) {
            // Especifica la ruta de la carpeta que deseas leer
            File carpeta = new File(ruta);
            String[] archivos=null;
            // Verifica si la ruta especificada es una carpeta
            if (carpeta.isDirectory()) {
                // Obtiene un array con los nombres de los archivos en la carpeta
                archivos = carpeta.list();

                //lee cada archivo, y le quita el .txt
                for (int i = 0; i < archivos.length; i++) {
                    String[] split = archivos[i].split(".txt");
                    archivos[i]=split[0];
                }
            } else {
                System.out.println("La ruta especificada no es una carpeta.");
            }
        return archivos;
    }

    private void eventoBotonJugar() {
        //es para hacer pruebas
        getBotones()[0].addActionListener(e -> {
            ponerPanelDeJuego(leerMapasDeCarpeta(rutaCarpetaMapas)[0]+".txt");
        });

    }



}
