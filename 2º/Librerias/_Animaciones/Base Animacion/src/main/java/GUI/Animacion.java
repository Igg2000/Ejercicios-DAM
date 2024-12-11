/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Rectangle;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */
class Animacion extends TimerTask{

    private final PanelAnimacion panel;


    Animacion(PanelAnimacion panel) {
        this.panel = panel;
    }

    @Override
    public void run() {
        //Actualizo
        
        //Pinto
        panel.repaint();

        //Espero (si no se usa el fixedRate en el timer)

    }
    
}
