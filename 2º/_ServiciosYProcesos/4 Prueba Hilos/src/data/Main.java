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
        
        //aqui implemento la interfaz Runnable
        Thread t = new Thread(new CuentaAtrasA(5));
        t.start();
        
        //aqui heredo de Thread
        new CuentaAtrasB(5).start();
    }
    
}
