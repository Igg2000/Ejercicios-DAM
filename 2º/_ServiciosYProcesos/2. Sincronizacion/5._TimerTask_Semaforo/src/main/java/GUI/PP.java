/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.Semaforo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class PP extends JPanel {
    
    Semaforo semaforo;
    Color colorFondo= Color.gray;
    //Doble Buffer
    Image img;
    Graphics gg;

    public PP(Ventana v) {
        this.img = v.createImage(v.getWidth(),v.getHeight());
        this.gg = img.getGraphics();
        
        semaforo = new Semaforo(v.getWidth()/2-100, v.getHeight()/2-300, 200, 600);
        
        TimerTask tt = new TareaSemaforo(semaforo,this);
        Timer t = new Timer();
        t.schedule(tt, 1, 30);
        
        //cierro el timer al cerrar la ventana
        v.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                t.cancel();
            }
            
        });
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        gg.setColor(colorFondo);
        gg.fillRect(getX(), getY(), getWidth(),getHeight());

        semaforo.pintar(gg);
        
        //Pinto la imagen aux sobre la ventana
        g.drawImage(img, 0,0, null);
    }
    
    
    
}
