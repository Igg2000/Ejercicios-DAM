/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File fichero = new File(".//src//data//fich2.txt");
        
        Perro p1 = new Perro("Toby",2,"Labrador");
        Perro p2 = new Perro("Manchitas",3,"Chucho");
        /*
        try {
            SerializadorDeObjetos.escribirBase64(p1, fichero);
            SerializadorDeObjetos.escribirBase64(p2, fichero);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ArrayList<Perro> lista = SerializadorDeObjetos.leerBase64(fichero, Perro.class);
            System.out.println(lista);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        */
        try {
            SerializadorDeObjetos.escribirBinario(p1, fichero);
            SerializadorDeObjetos.escribirBinario(p2, fichero);
            
            List<Perro> perros = SerializadorDeObjetos.leerBinario(fichero, Perro.class);
            System.out.println(perros);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
