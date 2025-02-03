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

import java.awt.*;
import javax.swing.JButton;
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
        
        
        funcionalidadBotones(opciones);
        
        UtilTema.aplicarTema(this, App.TEMA);
        getTitulo().setFont(App.TEMA.getFuenteTitulo());
        
        agregarBotonCambiarTema();
    }

    private void funcionalidadBotones(String[] opciones) {
        JButton[] botones;
        botones = super.getBotones();
        
        //poner panel resultados de las rondas
        botones[0].addActionListener(e -> {
            JPanel p = new ResultadosPorRonda(v,this);
            v.ponPanel(p);
        });
        
        //poner panel tableros de las partidas
        botones[1].addActionListener(e -> {
            JPanel p = new TablerosDePartidas(v,this);
            v.ponPanel(p);
        });

        //poner panel tableros de las rondas
        botones[2].addActionListener(e -> {
            JPanel p = new TablerosDeRondas(v,this);
            v.ponPanel(p);
        });
        
        elUltimoBotonCierraLaVentana(opciones);
     
        
        

    }

    private void agregarBotonCambiarTema() {
        JPanel panelTema = new JPanel();
        panelTema.setOpaque(false);
        panelTema.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //hacer el boton transparente
        /*
        int red = App.TEMA.getBoton().getRed();
        int green = App.TEMA.getBoton().getGreen();
        int blue = App.TEMA.getBoton().getBlue();
        Color c= new Color(red,green,blue,150);
        NBoton botonTema = new NBoton("Cambiar Tema",c,c);
        */
        NBoton botonTema = new NBoton("Cambiar Tema",App.TEMA.getBoton(),App.TEMA.getBoton());


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
