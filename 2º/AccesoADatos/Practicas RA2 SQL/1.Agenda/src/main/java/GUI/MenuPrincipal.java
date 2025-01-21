/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PanelesGUI.PMenuV2;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Nacho
 */
class MenuPrincipal extends PMenuV2{

    private final JFrame v;
    
    public MenuPrincipal(JFrame v, String[] opciones, String nombreTitulo, Color color1, Color color2, Color colorFondo, Font fuenteTitulo, Color colorLetraTitulo, Font fuenteBotones, Color colorLetraBotones) {
        super(opciones, nombreTitulo, color1, color2, colorFondo, fuenteTitulo, colorLetraTitulo, fuenteBotones, colorLetraBotones);
        this.v = v;
        //ponerImagenDeFondo(".//res//agenda.png");
        
        
        funcionalidadBotones(opciones);
    }

    private void funcionalidadBotones(String[] opciones) {
        JButton[] botones;
        botones = super.getBotones();
        
        
    }
}
