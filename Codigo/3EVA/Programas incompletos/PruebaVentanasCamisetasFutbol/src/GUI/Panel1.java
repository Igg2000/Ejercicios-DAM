/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Nacho
 */
public class Panel1 extends JPanel{

    MiBoton boton= new MiBoton("MESSI");
    
    public Panel1() {
    
        //boton.setBounds(10,10, 200, 150);
        //this.setLayout(null);
        
        this.setBorder(new EmptyBorder(100,100,100,100));
        this.setLayout(new GridLayout());
        
        this.add(boton);
        //pintarBoton(boton);
    }
    
    
    
}
