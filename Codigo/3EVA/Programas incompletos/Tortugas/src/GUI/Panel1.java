/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class Panel1 extends JPanel{

    public Panel1() {
    
        //fondo azul claro
        this.setBackground(new Color(218,240,255));
        
        
        Tortuga t1= new TortugaNinja(0.5f,Color.red);
        Tortuga t2= new Tortuga(0.1f);
        Tortuga t3= new Tortuga(0.1f);
        Tortuga t4= new Tortuga(0.1f);
        Tortuga t5= new TortugaNinja(0.15f,Color.magenta);
        
        
        
        //Tortuga t1= new Tortuga();
        //this.setLayout(new GridLayout(2,2));
        this.setLayout(null);
         //this.setLayout(new BorderLayout());
         
         //this.setLayout(new FlowLayout());
         
         t1.setBounds(50, 50,200,200);
         t2.setBounds(100,200,200,200);
         t3.setBounds(140,200,200,200);
         t4.setBounds(180,200,200,200);
         t5.setBounds(220,190,200,200);
         this.add(t1);
         this.add(t2);
         this.add(t3);
         this.add(t4);
         this.add(t5);
         //this.setPreferredSize(new Dimension(400, 300));
         
        //this.setLayout(null);
        //this.add(t1);
        //this.add(t1, BorderLayout.CENTER);
    
    } 
}
