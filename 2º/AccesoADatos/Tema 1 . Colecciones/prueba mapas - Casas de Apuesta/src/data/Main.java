/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import ListaObjetos.PanelElegirObjeto;
import PanelesTexto.PanelPaginaDeTexto;
import Ventana.Vppal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nacho
 */
public class Main {
    
   
    
    public static void main(String[] args) {
        List<CasaDeApuestas> casas = new ArrayList<>();
        List<Partido> partidos = new ArrayList();
        
        hacerCasasYPartidos(casas,partidos);
        
        
        for (CasaDeApuestas casa : casas) {
            hacerPredicciones(casa,partidos);
        }
        
        pintarPorVentana(casas);
        
        
        
        
    }

    private static void hacerPredicciones(CasaDeApuestas c, List<Partido> partidos) {
        //CasaDeApuestas casa= new CasaDeApuestas("casa1");

        List<Prediccion> prediccionesPartido1= new ArrayList();
        
        
        for (Partido pa : partidos) {
            c.hacerPrediccion(pa, c.generarPrediccionRandom());
        }


    }

    private static void pintarPorVentana(List<CasaDeApuestas> casas) {
    
        String cad="";
        
        for (CasaDeApuestas casa : casas) {
            cad+=casa+"\n";
        }
        
        Vppal v = new Vppal();
        PanelesTexto.PanelPaginaDeTexto pan = new PanelPaginaDeTexto("Predicciones Jornada 1", cad);
        v.ponPanel(pan);
    }

    private static void hacerCasasYPartidos(List<CasaDeApuestas> casas, List<Partido> partidos) {
            
        casas.add(new CasaDeApuestas("Casa Nacho"));
        casas.add(new CasaDeApuestas("Casa Paco"));
        casas.add(new CasaDeApuestas("Casa Pepe"));
        casas.add(new CasaDeApuestas("Casa Luis"));

        partidos.add(new Partido("Real Betis", "Elche"));
        partidos.add(new Partido("Cádiz", "Real Madrid"));
        partidos.add(new Partido("Celta", "Atlético de Madrid"));
        partidos.add(new Partido("Mallorca", "Osasuna"));
        partidos.add(new Partido("Espanyol", "Valencia"));
        partidos.add(new Partido("Athletic", "Girona"));
        partidos.add(new Partido("Sevilla", "Villarreal"));
        partidos.add(new Partido("Getafe", "Granada"));
        partidos.add(new Partido("Barcelona", "Rayo Vallecano"));
        partidos.add(new Partido("Real Sociedad", "Almería"));}

}
