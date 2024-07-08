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
        v.ponerPanelPrincipal();
    }


}