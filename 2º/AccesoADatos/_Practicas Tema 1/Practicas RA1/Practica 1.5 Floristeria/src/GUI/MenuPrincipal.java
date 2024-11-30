/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import PanelesGUI.PMenuV2;
import java.awt.Color;
import java.awt.Font;
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
        ponerImagenDeFondo("src//res//fondoFloristeria.jpg");
        
        
        funcionalidadBotones(opciones);
        
        
    }

    private void funcionalidadBotones(String[] opciones) {
    
        JButton[] botones;
        botones = super.getBotones();
        
        //el boton altas te lleva al Menu de altas
        botones[0].addActionListener(e -> {
            
            String opcionesSiguienteMenu[]={"Agregar Flores","Agregar Plantas","Reponer Productos","Volver"};
            PMenuV2 menu = new MenuAltas(v,this,opcionesSiguienteMenu, "Floristería Nacho", v.color1, v.color2, v.colorFondo, v.fuenteTitulo, v.colorLetraTitulo, v.fuenteBotones, v.colorLetraBotones);
            v.ponPanel(menu);
            
        });
        
        //el boton de Listados lleva al Menu de Listados
        botones[1].addActionListener(e -> {
            String opcionesSiguienteMenu[]={"Mostrar Flores","Mostrar Plantas","Mostrar Todo","Volver"};
            PMenuV2 menu = new MenuListados(v,this,opcionesSiguienteMenu, "Floristeria Nacho", v.color1, v.color2, v.colorFondo, v.fuenteTitulo, v.colorLetraTitulo, v.fuenteBotones, v.colorLetraBotones);
            v.ponPanel(menu);
        });
        
        //el boton de clasificacion lleva al Menu de Clasificacion
        botones[2].addActionListener(e -> {
            //String opcionesSiguienteMenu[]={"Clasificacion por Pilotos","Clasificacion por Escudería","Volver"};
            //PMenuV2 menu = new MenuClasificacion(v,this,opcionesSiguienteMenu, "Mundial MotoGP", v.color1, v.color2, v.colorFondo, v.fuenteTitulo, v.colorLetraTitulo, v.fuenteBotones, v.colorLetraBotones);
            //v.ponPanel(menu);
        });
       
        
        
        elUltimoBotonCierraLaVentana(opciones);
    }
    
}
