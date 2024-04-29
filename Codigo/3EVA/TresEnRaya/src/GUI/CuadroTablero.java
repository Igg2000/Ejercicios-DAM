/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author Nacho
 */
public class CuadroTablero extends JLabel{

    
    /*
    0 es que el cuadro va en blanco
    1 es que hay que pintar un circulo
    2 es que hay que pintar una x
    */
    int estado;

    public CuadroTablero() {
        //esto llama al constructor de abajo y le pone el estado 0
        this(0);
    }

    public CuadroTablero(int estado) {
        this.estado = estado;
        this.setSize(50,50);
        this.setOpaque(true);
        this.setBackground(Color.red);
    }
    
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        if (estado==1){
            this.setBackground(Color.blue);
        }
        
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
   
    
}
