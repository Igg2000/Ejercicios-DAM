/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class App {

    int TamTablero=3;
    int[][] tablero;

    public App() {
        this.tablero= new int[][]{{0,0,0},{0,0,0},{0,0,0}};
    }
    
    void jugar() {
        
       pintarTablero();
        
    }
    
    void pintarTablero(){
        
        String cad="";
        
        cad+="  1 2 3\n";
        for (int i = 0; i < TamTablero; i++) {
            cad+=i+1+" ";
            for (int j = 0; j < TamTablero; j++) {
                cad+=(tablero[i][j]+" ");
                
            }
            cad+="\n";
        }
        
        JOptionPane.showMessageDialog(null, cad);
        
    }
    
}
