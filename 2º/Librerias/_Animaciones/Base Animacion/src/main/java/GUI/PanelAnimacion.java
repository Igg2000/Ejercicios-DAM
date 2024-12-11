/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.App;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class PanelAnimacion extends JPanel{

    private final App a;
    private Image img;
    private Graphics gg;
    private Timer t;

    public PanelAnimacion(App a) {
        this.a=a;   
        
        t = new Timer("Temporizador Animacion");
        Animacion anim = new Animacion(this);
        t.schedule(anim, 0,1);
        
        JFrame v= a.getV();
        v.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                t.cancel();
                super.windowClosing(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
        });
                
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //doble buffer
        JFrame v= a.getV();
        img=v.createImage(v.getWidth(),v.getHeight());        
        gg=img.getGraphics();  
        

        
        //doble buffer
        g.drawImage(img,0,0, this);
    }
    
    
}
