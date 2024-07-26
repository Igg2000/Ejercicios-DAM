/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.*;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class Vppal extends JFrame{



    public Vppal() throws HeadlessException {
        
        this.setVisible(true);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    }

    public void ponPanel(JPanel p){;
        this.getContentPane().removeAll();
        this.setContentPane(p);
        this.revalidate();
    }


    public void ponerPanelPrincipal() {
        String[] opsMenu = new String[]{"Jugar", "Crear Mapas ","Opciones", "Salir"};
        MenuPrincipal mp = new MenuPrincipal(this,opsMenu, "Juego de laberinto", Color.red, Color.orange, new Color(255, 184, 51), new Font(Font.SANS_SERIF, Font.BOLD, 30), Color.red);
        ponPanel(mp);
    }
}
