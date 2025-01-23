/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Temas.UtilTema;
import PanelesGUI.NBoton;
import PanelesGUI.PMenuV2;
import Temas.Temas;
import Ventana.Vppal;
import data.App;
import data.Contacto;
import data.GestorBD;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Menu principal de la aplicacion heredado de mi libreria personal
 * @author Nacho
 */
public class MenuPrincipal extends PMenuV2{

    private final Vppal v;
    
    public MenuPrincipal(Vppal v, String[] opciones, String nombreTitulo) {
        super(opciones, nombreTitulo);
        this.v = v;
        //ponerImagenDeFondo(".//res//agenda.png");
        
        
        funcionalidadBotones(opciones);
        
        UtilTema.aplicarTema(this, App.TEMA);
        getTitulo().setFont(App.TEMA.getFuenteTitulo());
        
        agregarBotonCambiarTema();
    }

    private void funcionalidadBotones(String[] opciones) {
        JButton[] botones;
        botones = super.getBotones();
        
        //poner panel altas
        botones[0].addActionListener(e -> {
           PanelesGUI.PanelAltas p= new AgregarAmigo(v,this,"Introduce los datos de tu amigo",List.of("Nombre", "Telefono","Direccion", "Aficiones", "Pandilla","Sitio de Veraneo"));
           v.ponPanel(p);
        });
        
        //poner panel de listas
        botones[1].addActionListener(e -> {
            List<Contacto> contactos = GestorBD.recibirListaDeContactos();
            JPanel p = new ListasContactos(v,this,contactos);
            
            //esto lo que hace es añadirle el boton de volver de forma personalizada
            JButton btn = new JButton("Volver");
            btn.setPreferredSize(new Dimension(120, 35)); // Tamaño uniforme
            UtilTema.aplicarTema(btn, App.TEMA);
            Metodos.MetodosGUI.agregarBotonDeVolverAUnPanel(v, p, this,btn);
            v.ponPanel(p);
        });
        
        elUltimoBotonCierraLaVentana(opciones);
     
        
        

    }

    private void agregarBotonCambiarTema() {
        JPanel panelTema = new JPanel();
        panelTema.setOpaque(false);
        panelTema.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        NBoton botonTema = new NBoton("Cambiar Tema");
        botonTema.setPreferredSize(new Dimension(100, 40));
        
        //Cambia al siguiente tema disponible
        botonTema.addActionListener(e -> {  

            for (int i = 0; i < Temas.values().length; i++) {
                if (App.TEMA == Temas.values()[i]){
                    App.TEMA = Temas.values()[(i + 1) % Temas.values().length];
                    break;
                }
            }
            MenuPrincipal nuevoMenu = new MenuPrincipal(v, MenuPrincipal.this.getOpciones(),MenuPrincipal.this.getNombreTitulo());
            v.ponPanel(nuevoMenu);
        });
        
        
        panelTema.add(botonTema);
        this.add(panelTema,BorderLayout.SOUTH);
    }
}
