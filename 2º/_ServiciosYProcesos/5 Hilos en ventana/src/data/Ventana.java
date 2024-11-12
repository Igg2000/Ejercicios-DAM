/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Nacho
 */
public class Ventana extends JFrame implements Runnable{

    public Ventana() throws HeadlessException {
        setVisible(true);
        setSize(1200, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
    

    @Override
    public void run() {
        
        Ppal panel = new Ppal(this);
        setContentPane(panel);
        revalidate();
        
    }
    
}
