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
public class Ventana extends JFrame{
    
    public Color color2=new Color(156, 156, 156);
    public Color color1=new Color(49, 19, 20);
    public Color colorFondo=Color.LIGHT_GRAY; 
    public Font fuenteTitulo=new Font("Segoe UI",1,36);
    public Color colorLetraTitulo=Color.white;
    public Font fuenteBotones=new Font("Segoe UI",0,18); 
    public Color colorLetraBotones=Color.BLACK;
    

    public Ventana() throws HeadlessException {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        String opciones[]={"Altas","Listados","Clasificaciones","Salir"};
        MenuPrincipal menupp = new MenuPrincipal(this,opciones, "Mundial MotoGP", color1, color2, colorFondo, fuenteTitulo, colorLetraTitulo, fuenteBotones, colorLetraBotones);
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
