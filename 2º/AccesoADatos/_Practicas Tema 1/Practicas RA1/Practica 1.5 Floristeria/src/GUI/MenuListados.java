/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Metodos.MetodosGUI;
import PanelesGUI.NBoton;
import PanelesGUI.PMenuV2;
import PanelesGUI.PanelPaginaDeTextoHTML;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
class MenuListados extends PMenuV2{
    
    private final Ventana v;
    private final JPanel panelAnterior;
    
    public MenuListados(Ventana v, JPanel panelAnterior, String[] opciones, String nombreTitulo, Color color1, Color color2, Color colorFondo, Font fuenteTitulo, Color colorLetraTitulo, Font fuenteBotones, Color colorLetraBotones) {
        super(opciones, nombreTitulo, color1, color2, colorFondo, fuenteTitulo, colorLetraTitulo, fuenteBotones, colorLetraBotones);
        this.v = v;
        ponerImagenDeFondo("src//res//fondoFloristeria.jpg");
        
        
        funcionalidadBotones(opciones);
        this.panelAnterior = panelAnterior;
        
        
    }

    private void funcionalidadBotones(String[] opciones) {
    
        JButton[] botones;
        botones = super.getBotones();
        
        //Listado Flores
        botones[0].addActionListener(e -> {
            
           PanelesGUI.PanelPaginaDeTextoHTML p = new PanelPaginaDeTextoHTML
                ("Listado de Flores", v.floristeria.generarHtmlFlores(), v.fuenteTitulo);
           //añadir boton volver
           NBoton bVolver = new NBoton("Volver", v.color1, v.color2);
           bVolver.setFont(v.fuenteBotones);
           bVolver.setForeground(v.colorLetraBotones);
            MetodosGUI.agregarBotonDeVolverAUnPanel(v, p, this, bVolver);
            //decorar panel
            p.setBackground(v.colorFondo);
            p.getjPanel1().setBackground(v.color1);
            p.getjPanel2().setBackground(v.colorFondo);
           v.ponPanel(p);
           
        });
        
        //Listado Plantas
        botones[1].addActionListener(e -> {
            PanelesGUI.PanelPaginaDeTextoHTML p = new PanelPaginaDeTextoHTML
                ("Listado de Plantas", v.floristeria.generarHtmlPlantas(), v.fuenteTitulo);
           //añadir boton volver
           NBoton bVolver = new NBoton("Volver", v.color1, v.color2);
           bVolver.setFont(v.fuenteBotones);
           bVolver.setForeground(v.colorLetraBotones);
            MetodosGUI.agregarBotonDeVolverAUnPanel(v, p, this, bVolver);
            //decorar panel
            p.setBackground(v.colorFondo);
            p.getjPanel1().setBackground(v.color1);
            p.getjPanel2().setBackground(v.colorFondo);
           v.ponPanel(p);
        });
        
        //Listado Inventario
        botones[2].addActionListener(e -> {
            PanelesGUI.PanelPaginaDeTextoHTML p = new PanelPaginaDeTextoHTML
                ("Listado de Inventario", v.floristeria.generarHtmlInventario(), v.fuenteTitulo);
           //añadir boton volver
           NBoton bVolver = new NBoton("Volver", v.color1, v.color2);
           bVolver.setFont(v.fuenteBotones);
           bVolver.setForeground(v.colorLetraBotones);
            MetodosGUI.agregarBotonDeVolverAUnPanel(v, p, this, bVolver);
            //decorar panel
            p.setBackground(v.colorFondo);
            p.getjPanel1().setBackground(v.color1);
            p.getjPanel2().setBackground(v.colorFondo);
           v.ponPanel(p);
        });
        
        //volver
        botones[3].addActionListener(e -> {
            v.ponPanel(panelAnterior);
        });
        
        
        
    }
    
    
}
