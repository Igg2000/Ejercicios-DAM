/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import GUI.PanelCalcularElegirOrigen;
import ListaObjetos.PanelElegirObjeto;
import Menus.PMenuConNBotones;
import PanelesTexto.PanelPaginaDeTexto;
import Ventana.Vppal;
import static data.App.ModoVisualizado.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class App {

    Grafo grafo;
    Vppal v;
    JPanel MenuPrincipal;
    
    public void run(){
        Boolean esBidirecional = true;
        grafo = new Grafo(esBidirecional);

        // Crear nodos y agregarlos directamente al grafo
        Nodo zonaPesas = new Nodo("Zona de pesas");
        Nodo pistaAtletismo = new Nodo("Pista de atletismo");
        Nodo piscinaOlimpica = new Nodo("Piscina olímpica");
        Nodo salaYoga = new Nodo("Sala de yoga");
        Nodo campoTiroArco = new Nodo("Campo de tiro con arco");
        Nodo duchas = new Nodo("Duchas");
        Nodo cafeteria = new Nodo("Cafetería");

        // Agregar nodos al grafo
        grafo.agregarNodo(zonaPesas);
        grafo.agregarNodo(pistaAtletismo);
        grafo.agregarNodo(piscinaOlimpica);
        grafo.agregarNodo(salaYoga);
        grafo.agregarNodo(campoTiroArco);
        grafo.agregarNodo(duchas);
        grafo.agregarNodo(cafeteria);

        // Conectar nodos
        grafo.conectarNodos(zonaPesas, pistaAtletismo, 10.0);
        grafo.conectarNodos(zonaPesas, campoTiroArco,3.0);
        grafo.conectarNodos(zonaPesas, cafeteria, 15.0);
        
        grafo.conectarNodos(pistaAtletismo, piscinaOlimpica, 2.0);
        grafo.conectarNodos(pistaAtletismo, campoTiroArco, 4.0);
        
        
        grafo.conectarNodos(piscinaOlimpica, salaYoga, 9.0);
        grafo.conectarNodos(piscinaOlimpica, duchas, 5.0);
        
        grafo.conectarNodos(salaYoga, cafeteria, 8.0);
        
        grafo.conectarNodos(campoTiroArco, duchas, 7.0);
        
        grafo.conectarNodos(duchas, cafeteria, 2.0);
        

        // Mostrar el grafo según la elección del usuario
        crearMenuPrincipal();
    }
    
    private void mostrarGrafo(ModoVisualizado modo, JPanel panelAnterior) {
        
        switch(modo){
            case Consola:
                grafo.mostrarEnConsola();
                break;
            case TextoVentana: 
                grafo.MostrarEnVentana(v,panelAnterior);
                break;
            case DibujoVentana:     
                grafo.DibujarEnVentana(v,panelAnterior);
                break;
        }
        
    } 

    private void crearMenuPrincipal() {
        v= new Vppal();
        String[] ops={"Calcular distancia entre nodos","Visualizar Modo Consola","Visualizar Modo Grafico (Texto)", " Visualizar Modo Grafico (Dibujo)", "Salir"};
        Menus.PMenuConNBotones menu = new PMenuConNBotones(ops,"Grafo Polideportivo",
                Color.decode("#6EACDA"), Color.decode("#E2E2B6"),Color.decode("#03346E"),new Font("Segoe UI",1,36),Color.white);
        JButton[]b=menu.getBotones();
     
        //boton calcular distancia entre nodos
        b[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Object> nodos = new ArrayList<>(App.this.grafo.getNodos());
                
                ListaObjetos.PanelElegirObjeto p = new PanelCalcularElegirOrigen(App.this,nodos,"¿Donde se encuentra usted?",
                        Color.decode("#6EACDA"), Color.decode("#03346E"),new Font("Segoe UI",1,36),new Font("Segoe UI",1,36),Color.decode("#03346E"),Color.decode("#E2E2B6"));
                App.this.v.ponPanel(p);
            }
        });
        
        //boton Visualizar Modo Consola
        b[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarGrafo(Consola,null);
            }
        });
        
        //boton Visualizar Modo Grafico (Texto)
        b[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               mostrarGrafo(TextoVentana,menu);
            }
        });
        
        //boton Visualizar Modo Grafico (Dibujo)
        b[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarGrafo(DibujoVentana,menu);
            }
        });
        //boton Salir
        menu.elUltimoBotonCierraLaVentana(ops);
        
        this.MenuPrincipal=menu;
        v.ponPanel(menu);
    }
    
    /**
     * Esto es para poder elegir como se quiere mostrar el grafo
     * @author Nacho
     */
    enum ModoVisualizado{
        Consola,TextoVentana,DibujoVentana
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public Vppal getV() {
        return v;
    }

    public JPanel getMenuPrincipal() {
        return MenuPrincipal;
    }

    
    
}


