/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.PanelPaginaDeTextoHTML;
import GUI.Vppal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class Main {

    static public Boolean modoGrafico=true;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        pruebaRuntime();
        
    }

    private static void pruebaRuntime() {
        
        String ruta=JOptionPane.showInputDialog("Elige la ruta que quieres ver");
        String comando= "dir "+ ruta + " /b";
        
        try {
            
            Process p = Runtime.getRuntime().exec("cmd /c "+comando);
            
                    
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            String linea;
            String textoEntero="";
            
            //la linea guarda la linea y al mismo tiempo pregunta si la linea no es null, de esa forma pinto las lineas
            
            while((linea=r.readLine())!=null){
                if(!modoGrafico)
                    System.out.println(linea);
                else
                    textoEntero= textoEntero + "<p>" + linea + "</p>";
            }
            
            if(modoGrafico)
                pintaEnVentana(textoEntero);

            
            
            //esto enteoria no hace falta pero es para cerrar el reader y el proceso
            r.close();
            p.waitFor();
        
        } catch (IOException ex) {
            System.out.println("Error al introducir el comando");
        } catch (InterruptedException ex) {
            System.out.println("El processo no pudo terminar correctamente");;
        }

        
    }

    private static void pintaEnVentana(String textoEntero) {
        Vppal v = new Vppal();
        PanelPaginaDeTextoHTML panel = new PanelPaginaDeTextoHTML("Salida de consola", textoEntero);
        v.ponPanel(panel);
    }

    
}
