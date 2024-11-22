/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import PanelesTexto.PanelPaginaDeTexto;
import PanelesTexto.PanelPaginaDeTextoHTML;
import Ventana.Vppal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeSet<Equipo> equipos = new TreeSet<>();

        File archivo = new File(".//res//resultados.txt"); 

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Comprobamos si la línea es un nombre de equipo
                if (!line.matches("\\d+ - \\d+")) { // Ignorar líneas que son resultados
                    equipos.add(new Equipo(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar los equipos ordenados
        String cad="";
        for (Equipo equipo : equipos) {
            cad+=(equipo)+"\n";
        }
        
        Vppal v = new Vppal();
        PanelPaginaDeTextoHTML p = new PanelPaginaDeTextoHTML("Equipos de baloncesto", cad);
        v.ponPanel(p);
    }
    
}
