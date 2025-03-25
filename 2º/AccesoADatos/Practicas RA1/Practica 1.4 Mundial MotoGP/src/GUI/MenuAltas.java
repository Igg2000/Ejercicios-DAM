/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PanelesGUI.PMenuV2;
import PanelesGUI.PanelAltas;
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
        ponerImagenDeFondo("src//res//fondoMotoGP.png");
        
        
        funcionalidadBotones(opciones);
        this.panelAnterior = panelAnterior;
        
        
    }

    private void funcionalidadBotones(String[] opciones) {
    
        JButton[] botones;
        botones = super.getBotones();
        
        //alta circuito
        botones[0].addActionListener(e -> {
           PanelesGUI.PanelAltas p= new PanelAltaCircuito(v,this,"Introduce un nuevo circuito",List.of("Nombre", "País" ,"Longitud"));
           v.ponPanel(p);
        });
        
        //alta moto
        botones[1].addActionListener(e -> {
            PanelesGUI.PanelAltas p= new PanelAltaMoto(v,this,"Introduce una nueva Moto",List.of("Número", "Marca" ,"Modelo"));
            v.ponPanel(p);
        });
        
        //alta piloto
        botones[2].addActionListener(e -> {
            PanelesGUI.PanelElegirObjeto p = new PanelAltaPilotoElegirEscudería(v,this,new ArrayList<>(v.mundial.getEscuderias()), "Elige la escuderia");
            v.ponPanel(p);
        });
        
        //vincular moto a piloto
        botones[3].addActionListener(e -> {
            PanelesGUI.PanelElegirObjeto p = new PanelAsignarMotoAPiloto1(v,this,new ArrayList<>(v.mundial.getPilotos()), "Elige El Piloto al que quieres asignar la Moto");
            v.ponPanel(p);
        });
        
        //volver
        botones[4].addActionListener(e -> {
            v.ponPanel(panelAnterior);
        });
        
        
        
    }
    
    
}
