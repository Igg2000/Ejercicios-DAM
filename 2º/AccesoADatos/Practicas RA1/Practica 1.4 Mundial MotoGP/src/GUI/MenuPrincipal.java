/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Metodos.MetodosGUI;
import PanelesGUI.NBoton;
import PanelesGUI.PMenuV2;
import PanelesGUI.PanelPaginaDeTextoHTML;
import data.Controlador.App;
import data.Controlador.GestorFicherosXML;
import data.Modelo.Mundial;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Nacho
 */
class MenuPrincipal extends PMenuV2{

    private final Ventana v;
    
    public MenuPrincipal(Ventana v, String[] opciones, String nombreTitulo, Color color1, Color color2, Color colorFondo, Font fuenteTitulo, Color colorLetraTitulo, Font fuenteBotones, Color colorLetraBotones) {
        super(opciones, nombreTitulo, color1, color2, colorFondo, fuenteTitulo, colorLetraTitulo, fuenteBotones, colorLetraBotones);
        this.v = v;
        ponerImagenDeFondo("src//res//fondoMotoGP.png");
        
        
        funcionalidadBotones(opciones);
        
        
    }

    private void funcionalidadBotones(String[] opciones) {
    
        JButton[] botones;
        botones = super.getBotones();
        
        //el boton altas te lleva al Menu de altas
        botones[0].addActionListener(e -> {
            
            String opcionesSiguienteMenu[]={"Circuitos","Motos","Pilotos","Asignar motos a pilotos","Volver"};
            PMenuV2 menu = new MenuAltas(v,this,opcionesSiguienteMenu, "Mundial MotoGP", v.color1, v.color2, v.colorFondo, v.fuenteTitulo, v.colorLetraTitulo, v.fuenteBotones, v.colorLetraBotones);
            v.ponPanel(menu);
            
        });
        
        //el boton de Listados lleva al Menu de Listados
        botones[1].addActionListener(e -> {
            String opcionesSiguienteMenu[]={"Circuitos","Escuderias","Pilotos","Volver"};
            PMenuV2 menu = new MenuListados(v,this,opcionesSiguienteMenu, "Mundial MotoGP", v.color1, v.color2, v.colorFondo, v.fuenteTitulo, v.colorLetraTitulo, v.fuenteBotones, v.colorLetraBotones);
            v.ponPanel(menu);
        });
        
        //el boton de clasificacion lleva al Menu de Clasificacion
        botones[2].addActionListener(e -> {
            String opcionesSiguienteMenu[]={"Clasificacion por Pilotos","Clasificacion por Escudería","Volver"};
            PMenuV2 menu = new MenuClasificacion(v,this,opcionesSiguienteMenu, "Mundial MotoGP", v.color1, v.color2, v.colorFondo, v.fuenteTitulo, v.colorLetraTitulo, v.fuenteBotones, v.colorLetraBotones);
            v.ponPanel(menu);
        });
        
        //el boton de importar XML
        botones[3].addActionListener(e -> {
            GestorFicherosXML g = new GestorFicherosXML(v.mundial);
           v.mundial = g.importarXML();
        });
        
        //el boton de exportar XML
        botones[4].addActionListener(e -> {
            GestorFicherosXML g = new GestorFicherosXML(v.mundial);
            g.exportarXML();
        });

        //el boton de hacer consultas XPATH
        botones[5].addActionListener(e -> {
            GestorFicherosXML g = new GestorFicherosXML(v.mundial);
            String consultas = g.recibirConsultasXPath();
            
            PanelesGUI.PanelPaginaDeTextoHTML p = new PanelPaginaDeTextoHTML
                ("Consultas XPath de ridersMotoGP.xml", consultas, v.fuenteTitulo);
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
        
        
        elUltimoBotonCierraLaVentana(opciones);
    }
    
}
