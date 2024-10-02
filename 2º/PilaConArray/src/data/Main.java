/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

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
        PilaConArray p= new PilaConArray();
        p.agregar(2);
        p.agregar(4);
        p.agregar(5);
        p.agregar(6);
        p.agregar(7);
        p.agregar(8);
        p.borrarUltimo();
        p.agregar(19);
        
        p.pintar();
    }
    
}
