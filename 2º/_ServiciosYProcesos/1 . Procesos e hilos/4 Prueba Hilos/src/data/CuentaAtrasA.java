/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hago una cuenta atras implementando la interfaz runnable
 * con la que creare un objeto thread
 * @author Nacho
 */
public class CuentaAtrasA implements Runnable{

    int n;
    public CuentaAtrasA(int n) {
        this.n=n;
    }

    @Override
    public void run() {
        for (int i = n; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CuentaAtrasA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
