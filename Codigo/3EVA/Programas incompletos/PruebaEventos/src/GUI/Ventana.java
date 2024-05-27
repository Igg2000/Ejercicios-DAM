/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Nacho
 */
public class Ventana extends JFrame{

    public Ventana() throws HeadlessException {
    
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JButton boton = new JButton("Boton");
        boton.setBounds(350,150,70,50);
        JLabel j = new JLabel();
        j.setBounds(320,250,70,50);
        JLabel j2 = new JLabel("Escribe tu nombre");
        j2.setBounds(100,80,120,10);
        JTextArea texto = new JTextArea(null,null,20,10);
        texto.setBounds(100,100,170,250);
        //texto.setSize(100, 300);
        
        panel.add(boton);
        panel.add(j);
        panel.add(j2);
        panel.add(texto);
        
        ActionListener l=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            j.setText("Hola "+ texto.getText());
            
            }
        };
        boton.addActionListener(l);
        
        
        
        setContentPane(panel);
        
        
        
        
    }
    
}
