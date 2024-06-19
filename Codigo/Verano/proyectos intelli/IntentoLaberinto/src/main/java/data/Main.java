package data;

import GUI.MenuPrincipal;
import GUI.Vppal;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        AbrirVentanaMenu();

    }

    /**
     * Esto lo que hace es crear y abrir la ventana del menu
     */
    private static void AbrirVentanaMenu() {
        Vppal v = new Vppal();
        String[] opsMenu = new String[]{"Jugar", "Cambiar dificultad", "Crear Mapas ", "Salir"};
        v.ponPanel(new MenuPrincipal(v,opsMenu, "Juego de laberinto", Color.red, Color.orange, new Color(255, 184, 51), new Font(Font.SANS_SERIF, Font.BOLD, 30), Color.red));

    }
}