/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import GUI.MiVentana;
import GUI.PP;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class Laberinto {
    
    private List<String> cadLab = new ArrayList();
    
    public void leerLab() throws FileNotFoundException, IOException{
        
        BufferedReader in = new BufferedReader(new FileReader(".//rsc//lab.txt"));
        
        String cad=in.readLine();    
        
        while (cad!=null){
            cadLab.add(cad);
            cad=in.readLine();
        }
        
        in.close();
    }

    void pintarLabConsola() {
                
        for (String s : cadLab) {
            System.out.println(""+s);
        }
    
    }

    void pintarLabVentana() {
       MiVentana v= new MiVentana();
       PP p1= new PP(cadLab);
       v.ponPanel(p1);
    
    }
    
    
    
}
