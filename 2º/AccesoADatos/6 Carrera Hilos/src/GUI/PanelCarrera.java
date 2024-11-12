/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PanelesGUI.BasePintar;
import data.Corredor;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class PanelCarrera extends BasePintar{

    private final int numCorredores;
    private final int Meta=800;
    private final int TamCorredores=50;
    private final int SeparacionCorredores=100;
    
    List<Corredor> corredores;
    private boolean carreraTerminada=false;
    
    
        
    public PanelCarrera(int numCorredores) {
        this.numCorredores = numCorredores;
        
        corredores = new ArrayList();
        
        for (int i = 1; i <= numCorredores; i++) {
            corredores.add(new Corredor(i,0, SeparacionCorredores*i, TamCorredores, TamCorredores));
        }
        
        for (Corredor c : corredores) {
            Thread t = new Thread(c);
            t.setPriority(10);
            t.start();
        }
        
        // Este hilo repinta y verifica si la carrera ha acabado cada 20 milisegundos
        new Thread(() -> {
            while (!carreraTerminada) {
                repaint(); 
                verificarFinCarrera();
                try {
                    Thread.sleep(20); // Redibujar cada 20 milisegundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
    
    }
    
    

    @Override
    protected void pintar(Graphics g) {
        for (Corredor c : corredores) {
            c.pintar(g);
        }
        g.setColor(Color.green);
        g.fillRect(Meta+TamCorredores,0, 10, 1000);
        
    }
    
    public void detenerCorredores() {
        for (Corredor c : corredores) {
            c.detener(); // Detener cada corredor
        }
    }
    
    // Método que verifica si un corredor ha llegado a la meta
    public synchronized void verificarFinCarrera() {
        for (Corredor c : corredores) {
            if (c.getX() >= Meta) {  // Si algún corredor ha llegado a la meta (por ejemplo, 800px)
                if (!carreraTerminada) {
                    carreraTerminada = true;  // Marcar que la carrera ha terminado
                    detenerCorredores();  // Detener todos los corredores
                    JOptionPane.showMessageDialog(null,"El corredor " + c + " ha ganado la carrera!");
                }
                break; // Solo necesitamos que un corredor termine, así que salimos del bucle
            }
        }
    }


}
