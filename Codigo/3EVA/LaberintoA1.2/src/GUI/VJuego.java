package GUI;

import data.*;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Guille
 */

public class VJuego extends JFrame implements KeyListener{

        private final int avance_x = 5;
        private final int avance_y = 5;
        
        private final int ancho_ventana = 800;
        private final int alto_ventana = 600;

        private final PJuego pj;
        private final Juego j;
        

    //Contructor de la clase VJuego
    public VJuego(Juego j) {
        //initComponents();
        setTitle("Juego del laberinto");
        
        
        this.j=j;                
        pj=new PJuego(j);        
        
        setSize(ancho_ventana, alto_ventana);//x, y, ancho, alto
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
        this.addKeyListener(this);//Gestiono los eventos de teclado en esta misma clase
        
        this.setLocationRelativeTo(null);
        
        this.setContentPane(pj);
        
    } 
    
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        JOptionPane.showMessageDialog(null, "Has presionado una tecla: "+e.getKeyChar());

        if(e.getKeyChar()=='k'){
            JOptionPane.showMessageDialog(null, "Has presionado la tecla: k");
        }
    }
    
    
    
    @Override
    public void keyPressed(KeyEvent e) {
     
        int i,auxX=j.getMuñeco().getX();
        int   auxY=j.getMuñeco().getY();

        //controlo que el objeto haga tope si sobrepasa el margen izquierdo
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT -> auxX-=avance_x;
            case KeyEvent.VK_RIGHT -> auxX+=avance_x;
            case KeyEvent.VK_UP -> auxY-=avance_y;
            case KeyEvent.VK_DOWN -> auxY+=avance_y;        
        }

        //Creo una figura fantasma(ficiticia) q simula una figura desplazada como quiere el user
        Figura fAux=new Figura(j.getMuñeco().getImg(),new Point(auxX,auxY),j.getMuñeco().getTam());
        
        if(fAux.estaDentroVentana(this))
        {
            //Miro si choca con algún obstaculo
            for(i=0;i<j.getObstaculos().size();i++)
                if(fAux.estaDentroFigura(j.getObstaculos().get(i)))
                   break;
            
            //O con la meta
            if(j.llegaAlaMeta())
                   j.gameOver();
            
            //Si no ha chocado entonces paso el mov de ficiticio a real
            if(i>=j.getObstaculos().size()){
                j.getMuñeco().setX(auxX);
                j.getMuñeco().setY(auxY);
                repaint();
            }
        }else{        
            JOptionPane.showMessageDialog(null,"No te vayas de la Ventana");
        }
        
    }
    
        @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }


}//:~)



