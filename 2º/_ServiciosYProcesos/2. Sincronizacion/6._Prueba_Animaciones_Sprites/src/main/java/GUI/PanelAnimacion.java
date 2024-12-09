/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.App;
import data.Personaje;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
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
    private Personaje p;
    private int fps;

    public PanelAnimacion(App a) {
        this.a=a;   
        this.p=new Personaje(100, 100, 3);
        
        t = new Timer("Temporizador Animacion");
        Animacion anim = new Animacion(this,p);
        fps = 20;
        t.scheduleAtFixedRate(anim,0,1000/fps);
        
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
    
    //pintar muñeco
    p.pintar(gg);
    
    
    
    
    // Escalar la imagen
    int anchoEscala = (int) (v.getWidth() * 2); // Escala el ancho a 2 veces
    int altoEscala = (int) (v.getHeight() * 2); // Escala el alto a 2 veces
    
    // Crea una nueva imagen escalada
    BufferedImage imgEscala = new BufferedImage(anchoEscala, altoEscala, BufferedImage.TYPE_INT_ARGB);
    
    // Dibuja la imagen original en la imagen escalada
    Graphics2D g2d = imgEscala.createGraphics();
    g2d.drawImage(img, 0, 0, anchoEscala, altoEscala, null);
    g2d.dispose();
    
    // Dibuja la imagen escalada en el panel
    g.drawImage(imgEscala, 0, 0, this);
}
    
}
