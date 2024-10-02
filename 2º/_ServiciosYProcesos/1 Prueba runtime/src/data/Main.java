/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import java.io.IOException;
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
        
        pruebaRuntime();
        
    }

    private static void pruebaRuntime() {
        String comando= "dir";
        
        try {
            Process p = Runtime.getRuntime().exec("cmd"+"\\c"+comando);
        } catch (IOException ex) {
            System.out.println("error");
        }
    }
    
}
