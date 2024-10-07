/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.PanelPaginaDeTextoHTML;
import GUI.Vppal;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
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

        mostrarDirectorio(modoGrafico,2);
        
    }
    /**
     * Te pide una ruta y te muestra sus ficheros y directorios por ventana o consola
     * @param modoGrafico Si quieres modo grafico o modo texto
     * @param modo 1 introducir la ruta por JOptionPane y 2 introducir por JfileChooser
     */
    private static void mostrarDirectorio(boolean modoGrafico,int modo) {
        
        if(modo<1 || modo>2){
            JOptionPane.showMessageDialog(null, "El metodo debe ser 1 o 2");
            return;
        }
        
        String ruta= introducirRuta(modo);
        
        ruta = "\""+ ruta +"\""; //lo mete entre comillas para que no haya problemas con los espacios
        String comando= "dir "+ruta+ " /b /o:n"; // /b lo saca simplificado /o:n te lo saca en orden alfabetico
        
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
                    //textoEntero= textoEntero + linea + "<br>";
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

    private static String introducirRuta(int modo) {
        
        if(modo==1)
            return JOptionPane.showInputDialog("Elige la ruta que quieres ver");
        else
            return introducirRutaPorFileChooser();
    }

    private static String introducirRutaPorFileChooser() {
       
        // Crear una instancia de JFileChooser
        JFileChooser selectorDeCarpeta = new JFileChooser();
        
        // Configurar el JFileChooser para seleccionar directorios
        selectorDeCarpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        // Mostrar el diálogo para seleccionar un archivo
        int returnValue = selectorDeCarpeta.showOpenDialog(null);
        
        // Comprobar si se seleccionó un archivo
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = selectorDeCarpeta.getSelectedFile();
            return selectedFile.getAbsolutePath();
        } else {
            return null;
        }
    }

    
}
