/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int n1=0,n2=0,n3=0;
        boolean todoOk=true;
        
        do{
            try{
                n1= Integer.parseInt(JOptionPane.showInputDialog("Introduce 1 numero (1/3)"));
                n2= Integer.parseInt(JOptionPane.showInputDialog("Introduce 1 numero (2/3)"));
                n3= Integer.parseInt(JOptionPane.showInputDialog("Introduce 1 numero (3/3)"));
                todoOk=true;
            }catch (NumberFormatException e){
                todoOk=false;
                JOptionPane.showMessageDialog(null, "No te pases de listo");
            }
        }while(todoOk==false);
        
        int[] n={n1,n2,n3};
        
        int mayor=n[0];
        
        for (int i = 1; i < n.length; i++) {
            if (n[i]>mayor)
                mayor=n[i];
        }
        
        System.out.println("El mayor es " + mayor);
        
    }
    
}
