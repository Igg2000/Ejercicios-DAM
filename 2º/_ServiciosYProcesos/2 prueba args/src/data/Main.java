/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<String> lista = new ArrayList();
        
        for (String arg : args) {
          lista.add(arg);
        }
        
        lista = lista.reversed();
        for (String palabra : lista) {
            StringBuilder s = new StringBuilder(palabra);
            s.reverse();
            System.out.print(s.toString()+" ");
        
        }

    }
    
}
