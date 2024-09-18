/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class PMenuConBotones extends JPanel {
    
    
    private JButton []botones;   
    private JPanel panelOpciones= new JPanel();
    private JPanel panelTitulo= new JPanel();
    private JLabel titulo = new JLabel();

    public PMenuConBotones(String[] nombres){
        minitComponents(nombres);
    }

    public PMenuConBotones(String[] nombres, String nombreTitulo){
        minitComponents(nombres, nombreTitulo);
    }

    private void minitComponents(String[] nombres){
        botones=new JButton[nombres.length];
        
        //Esto pone un layout a todo el panel para poner el panel de opciones al centro y el del titulo arriba
        setLayout(new BorderLayout());
     
        //le ponemos layout a los botones y un borde
        panelOpciones.setLayout(new java.awt.GridLayout(botones.length, 1, 0, 80/botones.length));
        panelOpciones.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        
        //Esto coloca los botones de forma automatica segun el numero de opciones
        for (int i = 0; i < botones.length; i++) {            
            botones[i]=new JButton(nombres[i]);
            panelOpciones.add(botones[i]);
        }
        
        //añade el panel de opciones al centro
        add(panelOpciones,java.awt.BorderLayout.CENTER);
        
    }     

    private void minitComponents(String[] nombres, String nombreTitulo) {
        //añadimos el panel con opciones
        minitComponents(nombres);
        
        //añadimos el panel con el titulo encima del panel de opciones
        titulo.setText(nombreTitulo);
        panelTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 10, 1));
        panelTitulo.add(titulo, new java.awt.GridBagConstraints());
        add(panelTitulo,java.awt.BorderLayout.NORTH);
    }

    public JButton[] getBotones() {
        return botones;
    }
    
    
    
}
