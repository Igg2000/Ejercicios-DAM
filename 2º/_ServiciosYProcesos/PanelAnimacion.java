/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.App;
import Ventana.Vppal;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author grovy
 */
public class PanelAnimacion extends JPanel{

    private final App a;
    private Image img;
    private Graphics gg;

    public PanelAnimacion(App a) {
        this.a=a;
        
        JFrame v= a.getV();
        
        
        //doble buffer
        img=v.createImage(v.getWidth(),v.getHeight());        
        gg=img.getGraphics();  
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        a.getTarro().pintar(gg);
        
        //doble buffer
        g.drawImage(img,0,0, this);
    }
    
    
}
