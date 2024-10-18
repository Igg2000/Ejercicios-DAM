/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
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
        
        List<String> comando= new ArrayList();

        //cosasQueNuncaFuncionaron();
        comando.add("java");
        comando.add("-jar");
        comando.add("C:\\Users\\Nacho\\OneDrive\\Escritorio\\1º DAM\\RepositorioGitHub\\2º\\_ServiciosYProcesos\\2 prueba args\\dist\\1_prueba_args.jar");
        comando.add("buenos");
        comando.add("dias");
        
        //java -jar C:\Users\Nacho\OneDrive\Escritorio\1º DAM\RepositorioGitHub\2º\_ServiciosYProcesos\2 prueba args\dist\1_prueba_args.jar hola buenos dias

        ProcessBuilder pb = new ProcessBuilder(comando);
        leerProceso(pb);
    }

    private static void leerProceso(ProcessBuilder pb) {
        try {
            Process proceso=pb.start();
            BufferedReader br= new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException ex) {
            System.out.println("Hay un error: "+ex.getMessage());
        }
    }

    private static void cosasQueNuncaFuncionaron() {
                
        /*
        * Esto me funciona en el cmd
        * java "C:\Users\Nacho\OneDrive\Escritorio\1º DAM\RepositorioGitHub\2º\_ServiciosYProcesos\2 prueba args\src\data\Main.java" hola
        */
        
        /*
        //ProcessBuilder pb = new ProcessBuilder("cmd","/c","dir");
        
        //comando.add("cmd");
        //comando.add("/c");
        comando.add("java");
        comando.add("-cp");
        //comando.add("\"C:\\Users\\Nacho\\OneDrive\\Escritorio\\10 DAM\\RepositorioGitHub\\20\\Librerias\\1 prueba args\\src\\data\\Main.java\"");
        comando.add("\"C:\\Users\\Nacho\\OneDrive\\Escritorio\\1º DAM\\RepositorioGitHub\\2º\\Librerias\\1 prueba args\\build\\classes\\data\"");
        comando.add("Main");
        comando.add("hola");
        */
    }
    
}
