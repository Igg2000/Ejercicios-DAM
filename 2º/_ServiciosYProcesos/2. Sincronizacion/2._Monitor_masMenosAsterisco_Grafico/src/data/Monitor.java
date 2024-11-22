/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */
class Monitor {
    
    private int contador=0; //numero de caracteres que se han pintado
    private boolean fin;
    private char caracterAPintar = '+';
    private final int MaxChars=60; //cuando escriba este numero de caracteres la app se para
    private String cad="";

    public synchronized void pintar(char c) {
        
        while(!fin){
            //si no eres el caracter que le toca pintar te bloqueo
            while (c != caracterAPintar){
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            cad+=(c+" ");
            contador++;

            switch(caracterAPintar){
                case '+': caracterAPintar='-'; break;
                case '-': caracterAPintar='*'; break;
                case '*': cad+="\n"; caracterAPintar='+'; break;
            }

            notifyAll();

            if(contador>MaxChars){
                fin=true;
            }
        }

    }

    public boolean isFin() {
        return fin;
    }

    public String getCad() {
        return cad;
    }

    
    
    
    
    
}
