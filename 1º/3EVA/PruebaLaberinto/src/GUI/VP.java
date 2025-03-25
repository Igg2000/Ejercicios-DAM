/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class VP extends JFrame{
    
    Keko f;
    List<Figura> muros;
    
    public VP(Keko f, List<Figura> muros) throws HeadlessException {
        this.muros=muros;
        this.f=f;
        this.setVisible(true);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addKeyListener(new KeyAdapter() {
            
                
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);               
           
                switch(e.getKeyChar()){
                    case 'w':VP.this.f.y-=1;break;
                    case 'a':VP.this.f.x-=1;break;
                    case 's':VP.this.f.y+=1;break;
                    case 'd':VP.this.f.x+=1;break; 
                }
                
                if (estaTocandoMuro()){
                    JOptionPane.showMessageDialog(null,"Has tocado un muro");
                    VP.this.dispose();
                }
                
            }

            private boolean estaTocandoMuro() {
                
                for (Figura m : muros) {
                    if(f.intersects(m))
                        return true;
                }
                return false;
            }
            
        });
    
    }

    public void ponPanel(JPanel p){
        
       this.setContentPane(p);
       this.revalidate();
    }
    
    
}
