/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class Ventana extends JFrame{  

    public Ventana() throws HeadlessException {
        this.setVisible(true);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);                  
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
