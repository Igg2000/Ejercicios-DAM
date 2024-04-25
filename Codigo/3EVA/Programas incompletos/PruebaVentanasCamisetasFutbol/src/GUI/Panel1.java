/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class Panel1 extends JPanel{

    MiBoton boton= new MiBoton(50,50,150,100);
    
    public Panel1() {
    
        this.setLayout(null);
        this.add(boton);
        //pintarBoton(boton);
    }
    
    
    
}
