/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import GUI.MenuPrincipal;
import Ventana.Vppal;
import data.Animales.*;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class App {
    
    private final Zoo z;
    private final Vppal v; //es una ventana de mi libreria
    
    public App() {
       z = new Zoo();
       v = new Vppal();
       v.setSize(400,500);
       v.setLocationRelativeTo(null);
       
       v.ponPanel(crearMenuPrincipal());
       
       datosDePrueba();
       
    }
    
    private void datosDePrueba() {
        z.agregarAnimal(new Foca("Foca1", 6, 14.5f));
        z.agregarAnimal(new Foca("Foca2", 6, 14.5f));
        z.agregarAnimal(new Aguila("Aguila1", 6, 14.5f));
        //System.out.println(z.getAnimalesDelZoo());
        z.getJaulasComoCadena();
    }

    /**
     * Este metodo inicializa el menu y lo devuelve
     * @return 
     */
    private JPanel crearMenuPrincipal() {
        String titulo="El Zoo de Nacho";
        String[] opciones={"Agregar Animales","Eliminar Animales","Mostrar Jaulas","Mostrar Animales","Salir"}; 
        Color color1=Color.green.darker();
        Color color2=Color.ORANGE;
        Color colorFondo=Color.orange.darker();
       MenuPrincipal m = new MenuPrincipal(opciones, titulo, color1, color2, colorFondo,this);
       return m;
    }
    
    

    //getters y setters abajo
    public Zoo getZ() {
        return z;
    }

    public Vppal getV() {
        return v;
    }

    
}
