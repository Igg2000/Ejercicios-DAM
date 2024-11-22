/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame v = new JFrame();
        v.setVisible(true);
        v.setSize(1080, 720);
        v.setLocationRelativeTo(null);
        v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        PanelAltas p = new PanelPruebaAltas(List.of("Nombre", "Apellido", "Correo Electrónico"));
        v.setContentPane(p);
        v.validate();
        
        
        //ya que estoy tambien voy a probar el menu con imagenes
        
    }
    
}
