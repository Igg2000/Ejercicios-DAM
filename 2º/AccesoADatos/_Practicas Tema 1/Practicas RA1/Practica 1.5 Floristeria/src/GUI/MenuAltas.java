/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PanelesGUI.PMenuV2;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
class MenuAltas extends PMenuV2{
    
    private final Ventana v;
    private final JPanel panelAnterior;
    
    public MenuAltas(Ventana v, JPanel panelAnterior, String[] opciones, String nombreTitulo, Color color1, Color color2, Color colorFondo, Font fuenteTitulo, Color colorLetraTitulo, Font fuenteBotones, Color colorLetraBotones) {
        super(opciones, nombreTitulo, color1, color2, colorFondo, fuenteTitulo, colorLetraTitulo, fuenteBotones, colorLetraBotones);
        this.v = v;
        ponerImagenDeFondo("src//res//fondoFloristeria.jpg");
        
        
        funcionalidadBotones(opciones);
        this.panelAnterior = panelAnterior;
        
        
    }

    private void funcionalidadBotones(String[] opciones) {
    
        JButton[] botones;
        botones = super.getBotones();
        
        //alta flor
        botones[0].addActionListener(e -> {
           PanelesGUI.PanelAltas p= new PanelAltaFlor(v,this,"Introduce una nueva Flor",List.of("Nombre","Color","Cantidad"));
           v.ponPanel(p);
        });
        
        //alta planta
        botones[1].addActionListener(e -> {
           PanelesGUI.PanelAltas p= new PanelAltaPlanta(v,this,"Introduce una nueva Planta",List.of("Nombre","Tamaño","Cantidad"));
           v.ponPanel(p);
        });
        //reponer
        botones[2].addActionListener(e -> {
            //hago esto porque que es una lista de productos abstractos, no es una List<Object>
            List<Object> listaObjetos = new ArrayList<>(v.floristeria.getInventario());
            PanelesGUI.PanelElegirObjeto p= new PanelReponer(v,this,listaObjetos,"Elige el producto a reponer");
            v.ponPanel(p);
        });     
        
        //volver
        botones[3].addActionListener(e -> {
            v.ponPanel(panelAnterior);
        });
        
        
        
    }
    
    
}
