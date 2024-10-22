/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author grovy
 */
public class CasaDeApuestas {
    
    String nombre;
    Map<Partido,Prediccion> prediccionesPartido= new HashMap();

    //constructor
    public CasaDeApuestas(String nombre) {
        this.nombre = nombre;
    }
    
    
    public void hacerPrediccion(Partido par,Prediccion pre){
        prediccionesPartido.put(par,pre);
    }
    
    public String getPrediccionPartido(Partido par){
        return prediccionesPartido.get(par).toString();
    }

    
    public String getTodasLasPredicciones() {
        String cad="";
        
         Iterator<Map.Entry<Partido, Prediccion>> it = prediccionesPartido.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<Partido, Prediccion> entry = it.next();
            // Formatear la salida clave -> valor
            cad+=("Partido"+entry.getKey().num+ ": "+entry.getKey().toString())
           +" -> Predicción: "+entry.getValue().toString()
           +"\n";
            //cad +=it.next()+"\n";
        }
        
        return cad;
    }
    
    public Prediccion generarPrediccionRandom(){
        Random r = new Random();
        
        int r1=r.nextInt(4);
        int r2=r.nextInt(4);
        
        //evitar que sean iguales
        while (r1 == r2) {
            r2 = r.nextInt(4);
        }
        
        int[] numerosOrdenados= ordenarNumeros(r1,r2); //ordena el mayor y el menor
        
        r1=numerosOrdenados[0]; //mayor
        r2=numerosOrdenados[1]; //menor

        
        double probabilidad=Math.random(); //de 0 a 1
       
        if(probabilidad<0.50)
            return new Prediccion(r1, r2); //50% ganar el local
        else if(probabilidad<0.90)
            return new Prediccion(r2, r1); //40% ganar el visitante
        else
            return new Prediccion(r2, r2); //10% empatar
    }


    public int[] ordenarNumeros(int r1, int r2) {
        // Crear un array para almacenar los dos números
        int[] resultado = new int[2];

        if (r1 > r2) {
            // Si r1 es mayor, el array será [r1, r2]
            resultado[0] = r1;
            resultado[1] = r2;
        } else {
            // Si r2 es mayor o son iguales, el array será [r2, r1]
            resultado[0] = r2;
            resultado[1] = r1;
        }

        return resultado;
    }
    
    

    @Override
    public String toString() {
        return "Casa de apuestas: " + nombre + "\n________________________\n"+getTodasLasPredicciones();
    }

    
    
}
