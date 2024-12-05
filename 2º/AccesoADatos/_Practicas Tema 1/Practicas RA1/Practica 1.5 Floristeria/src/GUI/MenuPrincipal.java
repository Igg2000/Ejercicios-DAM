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
import java.util.ArrayList;
import java.util.List;
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
        
        //el boton de ventas lleva al PanelVender
        botones[2].addActionListener(e -> {
            //hago esto porque que es una lista de productos abstractos, no es una List<Object>
            List<Object> listaObjetos = new ArrayList<>(v.floristeria.getInventario());
            PanelesGUI.PanelElegirObjeto p= new PanelVender(v,this,listaObjetos,"Elige el producto a vender");
            v.ponPanel(p);
        });
       
        //el boton de ver ganancias muestra las ganancias
        botones[3].addActionListener(e -> {
            PanelesGUI.PanelPaginaDeTextoHTML p = new PanelPaginaDeTextoHTML
                ("Ganancias de la floristeria", v.floristeria.generarHtmlVentas(), v.fuenteTitulo);
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
