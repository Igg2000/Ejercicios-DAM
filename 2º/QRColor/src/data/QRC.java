/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 * Representa un qr de colores
 * @author Nacho
 */
public class QRC {
    
    Color c[][];
    TamQRC tam;

    public QRC(TamQRC t) {
        tam=t;
        this.c = new Color[tam.tam][tam.tam];
        //rellenarQRCRandom();
    }
    
    public void rellenarQRCRandom(){
        Random r= new Random();
        
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j]= new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));      
            }
        }
    }

    void rellenar() {
        //metodo incompleto
        String[] ops={"Rojo","Azul","Verde","Amarillo","Blanco","Negro"};
        JOptionPane.showOptionDialog(null, "Elige un color", "Elige colores", 0, 0, null, ops, ops[0]);
        
    }
    
    public void visQRC(Graphics g){
        
        int x;
        int y;
        int tamCuadro=30;
        
        switch(this.tam){
            case tam.Pequeño: x=300; y=200; tamCuadro=40; break;
            case tam.Mediano: x=200; y=100; tamCuadro=40; break;
            case tam.Grande: x=180; y=80; tamCuadro=30; break;
            default: x=250; y=250; tamCuadro=30; break;
        }
        
        
 
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                    g.setColor(c[i][j]);
                    if(c[i][j]==null)
                        g.setColor(Color.gray);
                    g.fillRect(x+tamCuadro*j, y+tamCuadro*i, tamCuadro, tamCuadro);    
            }
            
        }
        
    }

    public void agregaColor(Color color) {
        
        if (c[c.length-1][c.length-1]!=null){
            JOptionPane.showMessageDialog(null, "El qrc está lleno, no puedes agregar mas colores");
            return;
        }
        
        for (int i = 0; i < c.length; i++) {
             for (int j = 0; j < c[i].length; j++) {
                if (c[i][j] == null) {
                    c[i][j] = color;  // Asignar color en el primer hueco null
                    return;  // Salir del método inmediatamente
                }
            }
        }
    }
    
    public void borrarUltimoColor() throws Exception{
        
        if (c[0][0]==null){
            JOptionPane.showMessageDialog(null, "El qrc ya está vacio");
            return;
        }
        
         
        if (c[c.length-1][c.length-1]!=null){
            c[c.length-1][c.length-1]= null;
            return;
        }
        
        
        
         for (int i = c.length-1; i >=0; i--) {
             for (int j = c.length-1; j >= 0; j--) {
                if (c[i][j] != null) {
                    if(c[i][j]==Color.white){
                        c[i][j] = null;
                        throw new Exception("Color Blanco");
                    }
                    c[i][j] = null;  // borrar el anterior color en el primer hueco null
                    return;  // Salir del método inmediatamente 
                }
            }
        }
    }
    
    public void borrarTodo(){
    
        for (int i = 0; i < c.length; i++) {
             for (int j = 0; j < c[i].length; j++) {
                c[i][j] = null;
            }
        }
    }
    
    
}
