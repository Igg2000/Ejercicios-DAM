/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.App;
import data.Coche;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class PanelAnimacion extends JPanel{

    private final App a;
    private Image img;
    private Image imagenFondo;
    private Graphics gg;
    private Timer t;
    private Coche coche;

    public PanelAnimacion(App a) {
        this.a=a;   
        
       
        try {
            imagenFondo = ImageIO.read(new File(".//res//fondo.png"));
        } catch (IOException e) {
             System.out.println("La imagen del coche no ha podido cargar");
        }

        coche = new Coche(100, 100, 50, 70, 7);
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
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char car = e.getKeyChar();
                switch(Character.toLowerCase(car)){
                    case 'w': coche.moverArriba(); break;
                    case 's': coche.moverAbajo(); break;
                    case 'd': coche.moverDerecha();break;
                    case 'a': coche.moverIzquierda();break;
                }
                repaint();
            }
        });
                
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocus();
        
        //doble buffer
        JFrame v= a.getV();
        img=v.createImage(v.getWidth(),v.getHeight());        
        gg=img.getGraphics();  

        gg.drawImage(imagenFondo, 0, 0, v.getWidth(), v.getHeight(), v);
        
        coche.pintar(gg);
        
        
        
        //doble buffer
        g.drawImage(img,0,0, this);
    }
    
    
}
