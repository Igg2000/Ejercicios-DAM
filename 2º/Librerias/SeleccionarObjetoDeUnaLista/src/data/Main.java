/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.pruebaPanel;
import Menus.NBoton;
import Ventana.Vppal;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        List<Object> perros = new ArrayList<>();
        perros.add(new Perro("Toby"));
        perros.add(new Perro("Firulais"));
        perros.add(new Perro("Rayo"));
        perros.add(new Perro("Coco"));
        perros.add(new Perro("Nevado"));
        
        Vppal v = new Vppal();
        v.setSize(300, 500);
        v.setLocationRelativeTo(null);
        
        pruebaPanel p = new pruebaPanel(perros);
        pruebaPanel p2 = new pruebaPanel(perros,"Mi lista de perros");
        pruebaPanel p3 = new pruebaPanel(perros,"Mi lista de perros",Color.cyan);
        pruebaPanel p4 = new pruebaPanel(perros,"Mi lista de perros",Color.CYAN,Color.orange);
        pruebaPanel p5 = new pruebaPanel(perros,"Mi lista de perros",Color.CYAN,Color.orange, new Font("Arial",1,40));
        pruebaPanel p6 = new pruebaPanel(perros,"Mi lista de perros",Color.CYAN,Color.orange, 
                new Font("Segoe UI",1,30),new Font("Arial",1,20), Color.white, Color.blue);
        
        p6.setBotonConfirmar(new NBoton("Eliminar", Color.black, Color.green));
        //p6.setBotonConfirmar(new JButton("Eliminar"));
        //p6.getBotonConfirmar().setBackground(Color.red);
        //p6.add(new NBoton("Eliminar", Color.black, Color.green));
        //p6.vaciarPanelBotones();
        
        //p6.addBoton(new NBoton("Volver", Color.black, Color.green));
        //p6.addBoton(new NBoton("Eliminar", Color.black, Color.green));

        
        v.ponPanel(p6);
    }
    
}
