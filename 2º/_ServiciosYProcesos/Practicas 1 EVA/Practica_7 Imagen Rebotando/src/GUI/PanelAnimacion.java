/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.App;
import Ventana.Vppal;
import data.Particula;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Color colorFondo= Color.white;
    private JFrame v;


    public PanelAnimacion(App a) {
        this.a=a;
        
        v= a.getV();
        
        
        //doble buffer
        img=v.createImage(v.getWidth(),v.getHeight());        
        gg=img.getGraphics();  
        
        
        animacion= new Animacion();
        hiloAnimacion = new Thread(animacion);
        
        
        this.setBackground(colorFondo);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        gg.setColor(colorFondo); 
        gg.fillRect(0, 0, img.getWidth(this), img.getHeight(this));
        
        
        List<Particula> particulas = a.getParticulas();
        
        for (Particula particula : particulas) {
            particula.pintar(gg);
        }
        
        
        
        //doble buffer
        g.drawImage(img,0,0, this);
    }
    
     public void actualizar() {
        //Actualizo

        Rectangle dimensionesPanel = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        List<Particula> particulas = a.getParticulas();

        //muevo dentro de la ventana
        particulas.getFirst().mover(dimensionesPanel);

        for (int i = 0; i < particulas.size(); i++) {
            for (int j = i + 1; j < particulas.size(); j++) {
                Particula p1 = particulas.get(i);
                Particula p2 = particulas.get(j);
                p1.verificarColision(p2);
            }
        }


        //Pinto
        repaint();
        
        //Espero
        try {
            Thread.sleep(16);
        } catch (InterruptedException ex) {
            System.out.println("Se ha interrumpido la animacion");
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
