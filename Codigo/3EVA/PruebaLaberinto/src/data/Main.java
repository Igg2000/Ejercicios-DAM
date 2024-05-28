/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.Figura;
import GUI.Keko;
import GUI.PLab;
import GUI.VP;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grovy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
        String lab;
        Keko f=new Keko(20,20,20,20,Color.blue);
        List<Figura> muros =new ArrayList();
        
        String fich2 = ".//res//muros.txt";
        leerMuros(fich2,muros);
        
        for (Figura m : muros) {
            System.out.println(""+m);
        }
        
        VP v= new VP(f,muros);
        String fich = ".//res//lvl1.txt";
        lab=leerDatosSinScanner(fich);
        v.ponPanel(new PLab(lab,f,muros));
        //System.out.println(""+lab);
        
        
    }
    
        private static String leerDatosSinScanner(String fich) {
         try {
            String nivel="";
            BufferedReader is = new BufferedReader(new FileReader(fich));
            String l;
            while ((l = is.readLine()) != null) {
                //System.out.println(l);
                nivel+=l+"\n";
            }
            return nivel;
        } catch (FileNotFoundException ex) {
            System.out.println("EL fichero "+fich+" no existe");
            return null;
        } catch (IOException ex) {
            System.out.println("Error de lectura en el fichero "+fich);
            return null;
        }   
        
         
    }

    private static void leerMuros(String fich, List<Figura> muros) {
       
        String nivel="";
        BufferedReader is;
        try {
            is = new BufferedReader(new FileReader(fich));
            
            String l;
            String[] s;
            while ((l = is.readLine()) != null) {
                s = l.split(",");
                muros.add(new Figura(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3])));
        }
            
        } catch (FileNotFoundException ex) {
            System.out.println("EL fichero "+fich+" no existe");
        } catch (IOException ex) {
            System.out.println("Error de lectura en el fichero "+fich);
        }
       


    }

    
    
}
