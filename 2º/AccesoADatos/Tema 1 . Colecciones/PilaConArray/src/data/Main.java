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
        Pila p= new PilaConStack();
        pruebaPila(p);
    }

    private static void pruebaPila(Pila p) {
       
        
        p.apilar(2);
        p.apilar(4);
        p.apilar(5);
        p.apilar(6);
        p.apilar(7);
        p.apilar(8);
        p.desapilar();
        p.apilar(19);
        
        p.pintar();
    }
    
}
