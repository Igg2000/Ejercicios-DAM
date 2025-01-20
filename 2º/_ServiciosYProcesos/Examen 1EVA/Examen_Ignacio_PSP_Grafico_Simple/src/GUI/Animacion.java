/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Nacho
 */
import java.util.TimerTask;
import GUI.PanelAnimacion;

class Animacion extends TimerTask {
    private PanelAnimacion panelAnimacion;

    public Animacion(PanelAnimacion panelAnimacion) {
        this.panelAnimacion = panelAnimacion;
    }

    @Override
    public void run() {
        panelAnimacion.repaint();
    }
}

