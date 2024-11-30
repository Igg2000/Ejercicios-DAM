/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.Robot;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JPanel;


/**
 *
 * @author Nacho
 */

public class PanelAnimacion extends JPanel implements Runnable {
    private Ventana v;
    private Robot robot;
    private boolean running;
    
    
    //doble buffer
    private Image img;
    private Graphics gg;

    public PanelAnimacion(Ventana v) {
        this.v=v;
        robot = new Robot(0, 400, 100); // Posición inicial
        //doble buffer
        img=v.createImage(v.getWidth(),v.getHeight());        
        gg=img.getGraphics();  
        
        // Añadir KeyListener para escuchar eventos de teclado
        v.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Cuando se presiona "d", mueve el robot a la derecha
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    robot.moveRight();
                    repaint();
                }
                // Cuando se presiona "a", mueve el robot a la izquierda
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    robot.moveLeft();
                    repaint();
                }
                // Cuando se presiona "s", agacha el robot
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    robot.agacharse();
                    repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Cuando se presiona "s", agacha el robot
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    robot.levantarse();
                    repaint();
                }
            }
            
            
        });
        
        v.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Llamar al método finalizarAnimacion cuando se cierre la ventana
                stop();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(gg);
        dibujarFondo(gg);
        dibujarInstrucciones(gg);
        robot.draw(gg);
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.scale(WIDTH, WIDTH);
        
        //doble buffer
        g.drawImage(img,0,0, this);
    }
    
     // Método para dibujar el fondo 2D
    private void dibujarFondo(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        setBackground(Color.decode("#2ea85f"));
        
        // **Cielo** (Parte superior de la pantalla)
        g2d.setColor(new Color(135, 206, 235)); // Color cielo (azul claro)
        g2d.fillRect(0, 0, getWidth(), getHeight() / 2); // Rellenar la mitad superior con el cielo

        // **Colinas** (Montañas oscuras)
        g2d.setColor(new Color(0, 50, 0)); // Color verde muy oscuro para las colinas
        g2d.fillArc(0, getHeight() / 2 - 100, getWidth() / 3, 200, 0, 180); // Colina izquierda
        g2d.fillArc(getWidth() / 2, getHeight() / 2 - 100, getWidth() / 3, 200, 0, 180); // Colina derecha

        // **Camino** (Sendero más pequeño)
        g2d.setColor(new Color(169, 169, 169)); // Color gris para el camino
        int caminoAltura = getHeight() / 4; // Altura del camino
        g2d.fillRoundRect(0, getHeight() / 2 + caminoAltura / 2, getWidth(), caminoAltura, 50, 50); // Camino más pequeño

        // **Árboles** (Añadimos más árboles a los lados del camino y los hacemos más grandes)
        // Árbol 1
        g2d.setColor(new Color(139, 69, 19)); // Color marrón para los troncos
        g2d.fillRect(100, getHeight() / 2 - 100, 30, 100); // Tronco árbol 1
        g2d.setColor(new Color(34, 139, 34)); // Color verde para las hojas
        g2d.fillOval(80, getHeight() / 2 - 150, 70, 70); // Hojas árbol 1

        
        // Árbol 2
        g2d.setColor(new Color(139, 69, 19)); // Color marrón para los troncos
        g2d.fillRect(300, getHeight() / 2 - 100, 30, 100); // Tronco árbol 2
        g2d.setColor(new Color(34, 139, 34)); // Color verde para las hojas
        g2d.fillOval(280, getHeight() / 2 - 150, 70, 70); // Hojas árbol 2

        // Árbol 3
        g2d.setColor(new Color(139, 69, 19)); // Color marrón para los troncos
        g2d.fillRect(500, getHeight() / 2 - 100, 30, 100); // Tronco árbol 3
        g2d.setColor(new Color(34, 139, 34)); // Color verde para las hojas
        g2d.fillOval(480, getHeight() / 2 - 150, 70, 70); // Hojas árbol 3

        // Árbol 4
        g2d.setColor(new Color(139, 69, 19)); // Color marrón para los troncos
        g2d.fillRect(700, getHeight() / 2 - 100, 30, 100); // Tronco árbol 4
        g2d.setColor(new Color(34, 139, 34)); // Color verde para las hojas
        g2d.fillOval(680, getHeight() / 2 - 150, 70, 70); // Hojas árbol 4

        // Árbol 5
        g2d.setColor(new Color(139, 69, 19)); // Color marrón para los troncos
        g2d.fillRect(900, getHeight() / 2 - 100, 30, 100); // Tronco árbol 5
        g2d.setColor(new Color(34, 139, 34)); // Color verde para las hojas
        g2d.fillOval(880, getHeight() / 2 - 150, 70, 70); // Hojas árbol 5

        // **Montañas al fondo** (Montañas lejanas con tonos más oscuros)
        g2d.setColor(new Color(50, 50, 50)); // Color de las montañas lejanas (más oscuro)
        g2d.fillPolygon(new int[]{0, getWidth() / 4, 0}, new int[]{getHeight() / 2, getHeight() / 3, getHeight() / 2}, 3); // Montaña izquierda
        g2d.fillPolygon(new int[]{getWidth(), getWidth() - getWidth() / 4, getWidth()}, new int[]{getHeight() / 2, getHeight() / 3, getHeight() / 2}, 3); // Montaña derecha
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            
            //robot.moveRight();
            
            if (robot.isOutOfBounds(v.getWidth())) {
                robot.resetPosition();
            }
            repaint();
            try {
                Thread.sleep(50); // Velocidad de la animación
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
    }

    private void dibujarInstrucciones(Graphics g) {
        List<String> cads = new ArrayList();
        cads.add("Moverse a la derecha: D");
        cads.add("Moverse a la izquierda: A");
        cads.add("Agacharse: S");
        
        g.setColor(Color.red);
        g.setFont(new Font("Segoe UI",1,16));
        
        for (int i = 1; i <= cads.size(); i++) {
            g.drawString(cads.get(i-1), v.getWidth()-300, 30*i);
            
        }
        
    }
}
