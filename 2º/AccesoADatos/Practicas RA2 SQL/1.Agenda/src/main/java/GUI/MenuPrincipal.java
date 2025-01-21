/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PanelesGUI.PMenuV2;
import Ventana.Vppal;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Nacho
 */
public class MenuPrincipal extends PMenuV2{

    private final Vppal v;
    
    public MenuPrincipal(Vppal v, String[] opciones, String nombreTitulo, Color color1, Color color2, Color colorFondo, Font fuenteTitulo, Color colorLetraTitulo, Font fuenteBotones, Color colorLetraBotones) {
        super(opciones, nombreTitulo, color1, color2, colorFondo, fuenteTitulo, colorLetraTitulo, fuenteBotones, colorLetraBotones);
        this.v = v;
        //ponerImagenDeFondo(".//res//agenda.png");
        
        
        funcionalidadBotones(opciones);
    }

    private void funcionalidadBotones(String[] opciones) {
        JButton[] botones;
        botones = super.getBotones();
        
        //poner panel altas
        botones[0].addActionListener(e -> {
           PanelesGUI.PanelAltas p= new AgregarAmigo(v,this,"Introduce los datos de tu amigo",List.of("Nombre", "Telefono","Direccion", "Aficiones", "Pandilla","Sitio de Veraneo"));
           v.ponPanel(p);
        });
        
    }
}
