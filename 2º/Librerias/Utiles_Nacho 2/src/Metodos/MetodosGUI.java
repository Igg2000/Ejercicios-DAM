/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import Ventana.Vppal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
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
     * @param boton El boton que quieres añadir
     */
    public static void agregarBotonDeVolverAUnPanel(JFrame v, JPanel panelEnUso, JPanel panelAnterior, JButton boton) {

        // Crear el botón de "volver"
        JButton botonVolver = boton;
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para volver a la vista anterior, por ejemplo:
                v.setContentPane(panelAnterior);
                v.revalidate();
            }
        });

        // Crear un panel para el botón con FlowLayout y añadir el botón
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(botonVolver);

        // Añadir el panel del botón a la parte inferior del panel HTML
        panelEnUso.add(panelBoton, BorderLayout.SOUTH);
    }
    
    /**
     * Este constructor te añade un boton basico en el que pone Volver
     * @param v La ventana, debe ser la Vppal de mi libreria
     * @param panelEnUso El panel al que le quieres añadir el boton
     * @param panelAnterior El panel al que quieres volver
     */
    public static void agregarBotonDeVolverAUnPanel(JFrame v, JPanel panelEnUso, JPanel panelAnterior){
        agregarBotonDeVolverAUnPanel(v, panelEnUso, panelAnterior,new JButton("Volver"));
    }
    
     /**
     * Esta funcion recibe la ruta de una imagen, la lee, y te devuelve la imagen
     * @param rutaImagen ruta que tiene la imagen
     * @return la propia imagen
     * @throws IOException Excepcion que devuelve en caso
     * de que no pueda cargar la imagen
     */
    public static Image leerImagen(String rutaImagen) throws IOException {      
        File archivoImagen = new File(rutaImagen);
        BufferedImage imagen = null;
        imagen = ImageIO.read(archivoImagen);
        return imagen;
    }
}
