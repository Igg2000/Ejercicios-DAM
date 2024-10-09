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
public class Vppal extends JFrame{

    public Vppal() throws HeadlessException {
        
        this.setVisible(true);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    }

    public void ponPanel(JPanel p){
        
       this.setContentPane(p);
       this.revalidate();
    }
    
}
