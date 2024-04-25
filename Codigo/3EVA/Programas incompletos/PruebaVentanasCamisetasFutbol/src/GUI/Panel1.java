/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class Panel1 extends JPanel{

    MiBoton boton= new MiBoton("Pepe");
    
    public Panel1() {
    
        //this.setLayout(new GridLayout());
        this.add(boton);
        //pintarBoton(boton);
    }
    
    
    
}
