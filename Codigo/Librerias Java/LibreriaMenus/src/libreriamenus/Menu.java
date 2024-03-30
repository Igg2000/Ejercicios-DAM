/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreriamenus;

/**
 *
 * @author Nacho
 */
public class Menu {
         
    public static void VisualizarMenu(String titulo, String []opciones){
       
        int cont=0;   
          
        System.out.println("____________________");
        System.out.println(""+titulo);
        System.out.println("____________________");
        
        for (String i : opciones) {
            cont++;
            System.out.println(cont+". "+i);
        }   
    }
}
