/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class Vista extends JFrame{
    
    
    Color color1=Color.black;
    Color color2=Color.orange;
    Color colorFondo=Color.LIGHT_GRAY; 
    Font fuenteTitulo=new Font("Segoe UI",1,36);
    Color colorLetraTitulo=Color.BLACK;
    Font fuenteBotones=new Font("Segoe UI",0,18); 
    Color colorLetraBotones=Color.BLACK;

    public Vista() throws HeadlessException {
        this.setVisible(true);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        String opciones[]={"Opcion 1","Opcion 2","Opcion 3","Salir"};
        MenuPrincipal menupp = new MenuPrincipal(opciones, "Nombre de la App", color1, color2, colorFondo, fuenteTitulo, colorLetraTitulo, fuenteBotones, colorLetraBotones);
        ponPanel(menupp);
        
    }

    /**
     * Cambia el panel de contenido y actualiza la ventana
     * @param panel panel que va a poner en la ventana
     */
    public void ponPanel(JPanel panel){
       this.setContentPane(panel);
       this.revalidate();
    }
    
}
