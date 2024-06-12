/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Nacho
 */
public class PMenuConNBotones extends JPanel {
    
    private NBoton []botones;   
    private JPanel panelOpciones= new JPanel();
    private JPanel panelTitulo= new JPanel();
    private JLabel titulo = new JLabel();

    public PMenuConNBotones(String[] opciones, Color color1, Color color2){
        minitComponents(opciones,color1,color2);
    }
    public PMenuConNBotones(String[] opciones){
        this(opciones,Color.white,Color.white);
    }
    public PMenuConNBotones(String[] opciones, String nombreTitulo){
        this(opciones, nombreTitulo,Color.white,Color.white);
    }
    public PMenuConNBotones(String[] opciones, String nombreTitulo, Color color1, Color color2){
        minitComponents(opciones, nombreTitulo, color1,color2);
    }

    private void minitComponents(String[] opciones, Color color1, Color color2){
        botones=new NBoton[opciones.length];
        
        
        //Esto pone un layout a todo el panel para poner el panel de opciones al centro y el del titulo arriba
        setLayout(new BorderLayout());
     
        //le ponemos layout a los botones y un borde
        panelOpciones.setLayout(new java.awt.GridLayout(botones.length, 1, 0, 80/botones.length));
        
        int anchuraBorde = 40;
        panelOpciones.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, anchuraBorde, 10, anchuraBorde));
        
        
        //Esto coloca los botones de forma automatica segun el numero de opciones
        colocarBotones(opciones,color1,color2);

        //añade el panel de opciones al centro
        add(panelOpciones,java.awt.BorderLayout.CENTER);
                
        panelOpciones.setOpaque(false);
        //le ponemos color al fondo
        setBackground(color2.brighter().brighter());
    }     

    private void minitComponents(String[] opciones, String nombreTitulo, Color color1, Color color2) {
        //añadimos el panel con opciones
        minitComponents(opciones,color1,color2);
        
        //añadimos el panel con el titulo encima del panel de opciones
        titulo.setText(nombreTitulo);
        titulo.setFont(new java.awt.Font("SansSerif", 1, 16));
        panelTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 10, 1));
        panelTitulo.add(titulo, new java.awt.GridBagConstraints());
        panelTitulo.setOpaque(false);
        add(panelTitulo,java.awt.BorderLayout.NORTH);

    }

    public JButton[] getBotones() {
        return botones;
    }

    private void colocarBotones(String[] opciones, Color color1, Color color2) {
        for (int i = 0; i < botones.length; i++) {    
            botones[i]=new NBoton(opciones[i], color1, color2);
            panelOpciones.add(botones[i]);
        }   
    }

    protected void elUltimoBotonCierraLaVentana(String[] opciones) {
        //Esto es para que el boton de salir cierre la app
        botones[opciones.length-1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(PMenuConNBotones.this);
                ventana.dispose();
            }
        });
    }
    
}
