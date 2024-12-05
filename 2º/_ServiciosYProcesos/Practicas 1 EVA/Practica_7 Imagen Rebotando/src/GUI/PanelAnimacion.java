/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.App;
import Ventana.Vppal;
import data.ImagenObstaculo;
import data.ImagenRebote;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author grovy
 */
public class PanelAnimacion extends JPanel{

    private final App a;
    private Image img;
    private Graphics gg;
    private Animacion animacion;
    private Thread hiloAnimacion;
    private Color colorFondo= Color.green.darker().darker();
    private BufferedImage imgFondo;
    private JFrame v;
    private ImagenRebote imagenRebote;
    private ImagenObstaculo imagenObstaculo;
        

    public PanelAnimacion(App a) {
        this.a=a;
        
        v= a.getV();
        
        crearDobleBuffer();
        
        imagenRebote = a.getImagenRebote();
        imagenObstaculo = a.getImagenObstaculo();
        
        try {
            // Cargar la imagen desde el archivo
            imgFondo = ImageIO.read(new File(".//src//res//cesped.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la imagen obstaculo.png");
        }
        
        //doble buffer
        img=v.createImage(v.getWidth(),v.getHeight());        
        gg=img.getGraphics();  
        
        
        animacion= new Animacion();
        hiloAnimacion = new Thread(animacion);
        
        // Agregar ComponentListener para manejar cambios de tamaño
        v.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Volver a crear el doble buffer cuando el tamaño cambie
                crearDobleBuffer();
                moverObstaculo();
            }
        });
        
        v.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                finalizarAnimacion();
                super.windowClosing(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
            
        });
        
        this.setBackground(colorFondo);
    }
    private void moverObstaculo() {
        imagenObstaculo.setLocation(v.getWidth()/2-imagenObstaculo.width/2, getHeight()/2-imagenObstaculo.height/2);
    }
            
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imgFondo != null) {
            // Dibujar la imagen escalada al tamaño del rectángulo
            gg.drawImage(imgFondo, 0, 0, v.getWidth(), v.getHeight(), null);
        } else {
            gg.setColor(colorFondo); 
            gg.fillRect(0, 0, img.getWidth(v), img.getHeight(v));
        }
        
        imagenRebote.pintar(gg);
        imagenObstaculo.pintar(gg);
      
        
        //doble buffer
        g.drawImage(img,0,0, v);
    }
    
    public void actualizar() {
        //Actualizo

        Rectangle dimensionesPanel = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        imagenRebote.mover(dimensionesPanel);
        moverObstaculo();
        
        imagenRebote.verificarColision(imagenObstaculo);

        //Pinto
        repaint();
        
        //Espero
        try {
            Thread.sleep(16);
        } catch (InterruptedException ex) {
            System.out.println("Se ha interrumpido la animacion");
        }
    }
     
    
    private void crearDobleBuffer() {
        img = v.createImage(v.getWidth(), v.getHeight());
        if (img != null) {
            gg = img.getGraphics();
        }
    }
        
    public void finalizarAnimacion(){
        if(hiloAnimacion.isAlive())
            animacion.finalizar();
    }
    
    public void iniciarAnimacion(){
        if(!hiloAnimacion.isAlive())
            hiloAnimacion.start();
    }

    private class Animacion implements Runnable {

        private boolean fin=false;

        @Override
        public void run() {
            while(!fin){
                PanelAnimacion.this.actualizar();
            }
        }

        public boolean isFin() {
            return fin;
        }

        public void setFin(boolean fin) {
            this.fin = fin;
        }
        
        public void finalizar(){
            fin=true;
        }
        
        
    }

    public Color getColorFondo() {
        return colorFondo;
    }
    
    
    
    
}
