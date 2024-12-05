/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.Semaforo;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */
public class TareaSemaforo extends TimerTask {

    private final Semaforo s;
    private final int TIEMPO_VERDE = 2000;
    private final int TIEMPO_AMBAR = 1000;
    private final int TIEMPO_ROJO = 3000;
    private final PP panel;

    public TareaSemaforo(Semaforo semaforo, PP panel) {
        this.s = semaforo;
        this.panel = panel;
    }

    @Override
    public void run() {
        
        s.ponerseEnRojo(); //actualizo
        panel.repaint(); //pinto
        
        try {
            Thread.sleep(TIEMPO_ROJO); //espero
        } catch (InterruptedException ex) {
            System.out.println("Se ha interrumpido mientras estaba en rojo");
        }
        
        s.ApagarRojo();
        s.ponerseEnAmbar(); //actualizo
        panel.repaint(); //pinto
        
        try {
            Thread.sleep(TIEMPO_AMBAR); //espero
        } catch (InterruptedException ex) {
            System.out.println("Se ha interrumpido mientras estaba en ambar");
        }
        
        s.ApagarAmbar();
        s.ponerseEnVerde();//actualizo
        
        panel.repaint(); //pinto
        
        try {
        Thread.sleep(TIEMPO_VERDE); //espero
        } catch (InterruptedException ex) {
            System.out.println("Se ha interrumpido mientras estaba en verde");
        }
        
        s.ApagarVerde();
    }
    
}
