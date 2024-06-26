package GUI;

import data.Main;

import javax.swing.*;
import java.awt.*;

import static data.Dificultades.*;

/**
 * Este es el menu principal de la aplicacion
 */
public class MenuPrincipal extends PMenuConNBotones{

    Vppal v;
    Color color1,color2,colorFondo,colorLetraTitulo;
    Font fuenteTitulo;
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
        eventoBotonJugar();
        eventoBotonCambiarDificultad();
        elUltimoBotonCierraLaVentana(getOpciones());
    }

    private void eventoBotonCambiarDificultad() {

        getBotones()[1].addActionListener(e -> {
            String[] opsMenu = new String[]{"Facil", "Normal", "Dificil"};
            PMenuConNBotones p = new PMenuConNBotones(opsMenu,"Menu de Dificultad", color1, color2, colorFondo,fuenteTitulo, colorLetraTitulo);

            p.getBotones()[0].addActionListener(e1 -> {
                Main.dificultad =Facil;
                JOptionPane.showMessageDialog(this, "Dificultad cambiada a "+ Main.dificultad.toString());
                MenuPrincipal.this.v.ponPanel(MenuPrincipal.this);
            });
            p.getBotones()[1].addActionListener(e1 -> {
                Main.dificultad =Medio;
                JOptionPane.showMessageDialog(this, "Dificultad cambiada a "+ Main.dificultad.toString());
                MenuPrincipal.this.v.ponPanel(MenuPrincipal.this);
            });
            p.getBotones()[2].addActionListener(e1 -> {
                Main.dificultad =Dificil;
                JOptionPane.showMessageDialog(this, "Dificultad cambiada a "+ Main.dificultad.toString());
                MenuPrincipal.this.v.ponPanel(MenuPrincipal.this);
            });
            MenuPrincipal.this.v.ponPanel(p);
        });
    }

    private void eventoBotonJugar() {
        getBotones()[0].addActionListener(e -> {
            MenuPrincipal.this.v.ponPanel(new PanelJuego(v));
        });

    }


}
