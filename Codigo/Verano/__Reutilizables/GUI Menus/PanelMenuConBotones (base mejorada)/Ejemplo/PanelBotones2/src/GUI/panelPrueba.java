/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class panelPrueba extends PMenuConBotones {
    
    public panelPrueba(String[] nombres) {
        super(nombres);
    }

    public panelPrueba(String[] nombres, String nombreTitulo) {
        super(nombres, nombreTitulo);
        
        getBotones()[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "has pulsado el primer boton");
            }
        });
    }
    
}
