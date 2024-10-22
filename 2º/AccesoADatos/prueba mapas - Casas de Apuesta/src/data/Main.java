/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import ListaObjetos.PanelElegirObjeto;
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
    
    static Map<Partido,Prediccion> prediccionesPartido= new HashMap();
    
    public static void main(String[] args) {
        
        datosprueba();
        System.out.println(getTodasLasPredicciones());
        
        
    }

    private static void datosprueba() {
        //CasaDeApuestas casa= new CasaDeApuestas("casa1");
        List<Partido> partidos = new ArrayList();
        partidos.add(new Partido("Real Madrid", "Valencia"));
        partidos.add(new Partido("Betis", "Rayo Vallecano"));
        partidos.add(new Partido("Barcelona", "Villareal"));
        
        List<Prediccion> prediccionesPartido1= new ArrayList();
        
        hacerPrediccion(partidos.get(0), new Prediccion(3, 2));
        hacerPrediccion(partidos.get(1), new Prediccion(2, 0));
        hacerPrediccion(partidos.get(2), new Prediccion(1, 2));

    }
    
    public static void hacerPrediccion(Partido par,Prediccion pre){
        prediccionesPartido.put(par,pre);
    }
    
    public static String getPrediccionPartido(Partido par){
        return prediccionesPartido.get(par).toString();
    }

    
    private static String getTodasLasPredicciones() {
        String cad="";
        
        Iterator it = prediccionesPartido.entrySet().iterator();

        while(it.hasNext()){
            cad +=it.next()+"\n";
        }
        
        return cad;
    }
    
}
