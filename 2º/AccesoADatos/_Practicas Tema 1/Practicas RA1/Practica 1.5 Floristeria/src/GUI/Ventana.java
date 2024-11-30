/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.Controlador.App;
import data.Modelo.Floristeria;
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
    
    public Color color2 = new Color(102, 153, 102); // Verde oliva suave
    public Color color1 = new Color(34, 85, 34);   // Verde bosque
    public Color colorFondo = new Color(218, 232, 202); // Verde pastel claro
    public Font fuenteTitulo = new Font("Segoe UI", 1, 36);
    public Color colorLetraTitulo = new Color(234, 254, 234); // Verde bosque para contrastar
    public Font fuenteBotones = new Font("Segoe UI", 0, 18);
    public Color colorLetraBotones = Color.WHITE; // Blanco para botones con fondo oscuro

    public Floristeria floristeria;
    

    public Ventana(Floristeria floristeria) throws HeadlessException {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.floristeria = floristeria;
        
        
        String opciones[]={"Agregar Productos","Listados","Vender Productos","Consultar Ganancias","Salir"};
        MenuPrincipal menupp = new MenuPrincipal(this,opciones, "Floristeria Nacho", color1, color2, colorFondo, fuenteTitulo, colorLetraTitulo, fuenteBotones, colorLetraBotones);
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

    public Floristeria getFloristeria() {
        return floristeria;
    }
    
    
    
}
