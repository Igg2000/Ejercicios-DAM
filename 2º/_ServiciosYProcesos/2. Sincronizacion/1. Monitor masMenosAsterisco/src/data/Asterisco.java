/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
public class Asterisco extends Thread {

    private final Monitor m;
    private boolean fin;

    public Asterisco(Monitor m) {
        this.m = m;
    }
    
    
    
    @Override
    public void run() {
        while(!fin && !m.isFin())
            m.pintar('*');
    }
    
    public void finalizar(){
        fin=true;
    } 
    
    
}
