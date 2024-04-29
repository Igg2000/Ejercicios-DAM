/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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

    public CuadroTablero(String text) {
        super(text);
        
        this.estado = 0;
        this.setSize(50,50);
        this.setOpaque(true);
        this.setBackground(Color.LIGHT_GRAY);
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody   

        
         if (estado==0)
            super.paintComponent(g);
         else if (estado==1)
            pintaCirculo(g);
         else if (estado==2)
            pintaX(g);
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    private void pintaCirculo(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        
            //esto dibuja el circulo rojo
            g.setColor(Color.red);
            g2d.setStroke(new BasicStroke(5));
            g2d.drawOval(10, 10, this.getWidth()-20, this.getHeight()-20);}

    private void pintaX(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
            //esto dibuja la x azul
            g.setColor(Color.blue);
            g2d.setStroke(new BasicStroke(5));
            g2d.drawLine(10, 10, this.getWidth()-20, this.getHeight()-20);
            g2d.drawLine(10, this.getHeight()-20, this.getWidth()-20, 10);    }
    
   
    
}
