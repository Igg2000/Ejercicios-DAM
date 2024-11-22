/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hago una cuenta atras heredando de Thread
 * @author Nacho
 */
public class CuentaAtrasB extends Thread{

    int n;
    public CuentaAtrasB(int n) {
        this.n=n;
    }

    @Override
    public void run() {
        for (int i = n; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CuentaAtrasB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
