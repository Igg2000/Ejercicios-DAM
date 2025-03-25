/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class VentanaP extends JFrame {

    public VentanaP(String title) {
        super(title);
        iniciarComponentes();
        
    }

    private void iniciarComponentes() {
        
    
        this.setVisible(true);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                  // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                  
                  
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                VentanaP.this.dispose();
            
            }

            @Override
            public void windowClosing(WindowEvent e) {
          
            }

            @Override
            public void windowClosed(WindowEvent e) {
                
                JOptionPane j= new JOptionPane();
                j.showMessageDialog(null, "Adios");
                
                    try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                
            }

            @Override
            public void windowIconified(WindowEvent e) {
                  // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                  // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void windowActivated(WindowEvent e) {
                  // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                               

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                  // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        
    }
    
    
    
}
