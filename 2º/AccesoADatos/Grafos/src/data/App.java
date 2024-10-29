/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Menus.PMenuConNBotones;
import PanelesTexto.PanelPaginaDeTexto;
import Ventana.Vppal;
import static data.App.ModoVisualizado.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Nacho
 */
public class App {

    Grafo grafo;
    Vppal v;
    
    public void run(){
        grafo = new Grafo();

        // Crear nodos
        Nodo sol = new Nodo("Sol", 50, 50); 
        Nodo barajas = new Nodo("Barajas", 100, 550);
        Nodo moncloa = new Nodo("Moncloa", 1150, 50);
        Nodo vallecas = new Nodo("Vallecas", 1000, 300);
        Nodo aluche = new Nodo("Aluche", 800, 450);
        Nodo cuatroCaminos = new Nodo("Cuatro Caminos", 400, 600);
        Nodo hortaleza = new Nodo("Hortaleza", 350, 300);

        // Añadir nodos adyacentes
        sol.agregarNodoAdyacente(barajas, 12.1);        // Sol -> Barajas
        sol.agregarNodoAdyacente(moncloa, 5.3);         // Sol -> Moncloa
        sol.agregarNodoAdyacente(vallecas, 8.0);        // Sol -> Vallecas
        barajas.agregarNodoAdyacente(hortaleza, 6.5);   // Barajas -> Hortaleza
        barajas.agregarNodoAdyacente(sol, 12.3);        // Barajas -> Sol
        moncloa.agregarNodoAdyacente(cuatroCaminos, 3.0); // Moncloa -> Cuatro Caminos
        moncloa.agregarNodoAdyacente(sol, 5.5);         // Moncloa -> Sol
        vallecas.agregarNodoAdyacente(sol, 8.4);        // Vallecas -> Sol
        vallecas.agregarNodoAdyacente(aluche, 10.0);    // Vallecas -> Aluche
        aluche.agregarNodoAdyacente(vallecas, 13.0);    // Aluche -> Vallecas
        aluche.agregarNodoAdyacente(cuatroCaminos, 7.0); // Aluche -> Cuatro Caminos
        cuatroCaminos.agregarNodoAdyacente(hortaleza, 6.5); // Cuatro Caminos -> Hortaleza
        cuatroCaminos.agregarNodoAdyacente(moncloa, 4.0); // Cuatro Caminos -> Moncloa
        hortaleza.agregarNodoAdyacente(barajas, 5.0);   // Hortaleza -> Barajas
        

        // Añadir nodos al Grafo
        grafo.agregarNodo(sol);
        grafo.agregarNodo(barajas);
        grafo.agregarNodo(moncloa);
        grafo.agregarNodo(vallecas);
        grafo.agregarNodo(aluche);
        grafo.agregarNodo(cuatroCaminos);
        grafo.agregarNodo(hortaleza);

        // Mostrar el grafo segun quiera el usuario

        elegirModoDeVisualizacionMedianteMenuPrincipal();
       
    }
    
    private void mostrarGrafo(ModoVisualizado modo) {
        
        switch(modo){
            case Consola:
                grafo.mostrarEnConsola();
                break;
            case TextoVentana: 
                grafo.MostrarEnVentana(v);
                break;
            case DibujoVentana:     
                grafo.DibujarEnVentana(v);
                break;
        }
        
    } 

    private void elegirModoDeVisualizacionMedianteMenuPrincipal() {
        v= new Vppal();
        String[] ops={"Modo Consola","Modo Grafico (Texto)", "Modo Grafico (Dibujo)", "Salir"};
        Menus.PMenuConNBotones menu = new PMenuConNBotones(ops,"Como quieres visualizar el Grafo",
                Color.decode("#6EACDA"), Color.decode("#E2E2B6"),Color.decode("#03346E"),new Font("Segoe UI",1,36),Color.white);
        JButton[]b=menu.getBotones();
        
        b[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 mostrarGrafo(Consola);
            }
        });
        b[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               mostrarGrafo(TextoVentana);
            }
        });
        b[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarGrafo(DibujoVentana);
            }
        });
        menu.elUltimoBotonCierraLaVentana(ops);
        v.ponPanel(menu);
    }
    
    /**
     * Esto es para poder elegir como se quiere mostrar el grafo
     * @author Nacho
     */
    enum ModoVisualizado{
        Consola,TextoVentana,DibujoVentana
    }

}


