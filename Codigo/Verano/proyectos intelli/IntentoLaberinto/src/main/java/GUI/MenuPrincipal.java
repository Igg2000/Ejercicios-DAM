package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Este es el menu principal de la aplicacion
 */
public class MenuPrincipal extends PMenuConNBotones{

    Vppal v;
    public MenuPrincipal(Vppal v,String[] opciones, String nombreTitulo, Color color1, Color color2, Color colorFondo, Font fuenteTitulo, Color colorLetraTitulo) {
        super(opciones, nombreTitulo, color1, color2, colorFondo, fuenteTitulo, colorLetraTitulo);
        this.v=v;
        inicializar();
    }

    private void inicializar() {
        eventoBotonJugar();
        elUltimoBotonCierraLaVentana(getOpciones());
    }

    private void eventoBotonJugar() {
        getBotones()[0].addActionListener(e -> {
            MenuPrincipal.this.v.ponPanel(new PanelJuego(v));
        });

    }


}
