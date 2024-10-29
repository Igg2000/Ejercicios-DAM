/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Ventana.Vppal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author grovy
 */
public class MetodosGUI {

    /**
     * Añade abajo un boton de volver
     * @param v La ventana, debe ser la Vppal de mi libreria
     * @param panelEnUso El panel al que le quieres añadir el boton
     * @param panelAnterior El panel al que quieres volver
     */
    public static void agregarBotonDeVolverAUnPanel(Vppal v, JPanel panelEnUso, JPanel panelAnterior) {

        // Crear el botón de "volver"
        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para volver a la vista anterior, por ejemplo:
                v.ponPanel(panelAnterior);
            }
        });

        // Crear un panel para el botón con FlowLayout y añadir el botón
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(botonVolver);

        // Añadir el panel del botón a la parte inferior del panel HTML
        panelEnUso.add(panelBoton, BorderLayout.SOUTH);
    }
}
