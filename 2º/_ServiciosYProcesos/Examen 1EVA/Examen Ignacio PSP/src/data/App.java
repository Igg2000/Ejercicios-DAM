/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.PanelAnimacion;
import GUI.Ventana;
import java.util.Random;
import javax.swing.SwingUtilities;

/**
 *
 * @author Nacho
 */
public class App extends Thread{

    public static void main(String[] args) {
        App a = new App();
        a.start();
    }

    @Override
    public void run() {
        Ventana ventana = new Ventana();
        PanelAnimacion panelAnimacion = new PanelAnimacion(ventana);
        ventana.ponPanel(panelAnimacion);
    }
}









