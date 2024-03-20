/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._ejerciciofacilloteria;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class App {

    static final int  CantidadNumAleatorios=20;
    
    public static void main(String[] args) {
        
        int numJugador;
        do{
           numJugador=Integer.parseInt(JOptionPane.showInputDialog(null, " Elige un numero del 1 al 100")); 
        }while(numJugador<1 || numJugador>100 );
        JOptionPane.showMessageDialog(null, "Generando un numero aleatorio");
        
        Random r1 = new Random();
        
        int []numRandom = new int[CantidadNumAleatorios];
        boolean hasAcertado=false;
        
            //Esto es para inicializar el array
            for (int i = 0; i < CantidadNumAleatorios ; i++) {
            numRandom[i]=r1.nextInt(1,101); 
        }
            //Esto es para comprobar si has acertado el numero
            for (int i = 0; i < CantidadNumAleatorios ; i++) {
             if (numJugador==numRandom[i]){
                 hasAcertado=true;
             }   
        }
            
             String resultados="";
             
             //Esto es para concatenar una String que contenga todos los resultados 
             for (int i = 0; i < numRandom.length; i++) {
                 resultados+=(numRandom[i]+" ");
            
        }
             
            // JOptionPane.showMessageDialog(null, resultados);
             
             
        if (hasAcertado==true){
            JOptionPane.showMessageDialog(null,"Felicidades, has acertado, tu numero era el "+ numJugador+" "
                    + "y los numeros que han salido eran "+ resultados);
        } else {
            JOptionPane.showMessageDialog(null," Has fallado, tu numero era el "+ numJugador +
                    " y los numeros que han salido eran "+ resultados);
        }
        
    }
}
