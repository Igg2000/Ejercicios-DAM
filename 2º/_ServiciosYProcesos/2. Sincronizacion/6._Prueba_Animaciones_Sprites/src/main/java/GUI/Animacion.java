/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.Personaje;
import data.Sprite;
import data.SpriteSheet;
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
    private final Personaje p;
    private boolean derecha= true;

    public Animacion(PanelAnimacion panel, Personaje p) {
        this.panel = panel;      
        this.p = p;
    }

    @Override
    public void run() {
        //Actualizo
        if(derecha){
            p.moverDerecha();
            if(p.getX()>=400)
                derecha=false;
        } else{
            p.moverIzquierda();
        }
        
        
        //Pinto
        panel.repaint();

        //Espero (si no se usa el fixedRate en el timer)

    }
    
}
