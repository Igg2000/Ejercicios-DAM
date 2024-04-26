/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class MiVentana extends JFrame{

    public MiVentana() throws HeadlessException {
        
        this.setVisible(true);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    }

    public void ponPanel(JPanel p){
        
       this.setContentPane(p);
       this.revalidate();
    }
    
    
    @Override
    public void dispose() {
       // JOptionPane.showMessageDialog(null,"bye");
        super.dispose(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
