/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import GUI.PanelAnimacion;
import Ventana.Vppal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grovy
 */
public class App implements Runnable{

    Vppal v;
    ImagenRebote imagenRebote;
    ImagenObstaculo imagenObstaculo;

    
    @Override
    public void run() {
        v = new Vppal();

        generarImagenRebote();
        generarImagenObstaculo();
        
        PanelAnimacion pan = new PanelAnimacion(this);
        v.ponPanel(pan);

        
        pan.iniciarAnimacion();
        
    }

    private void generarImagenRebote() {
        int tam = 100;
        int anchoVentana = v.getWidth();
        int altoVentana = v.getHeight();
        int xVentana = v.getX();
        int yVentana = v.getY();
        
       
        // Crear la imagen que va a rebotar dentro de los límites de la pantalla
        int x = xVentana + (int) (Math.random() * (anchoVentana - tam));
        int y = yVentana + (int) (Math.random() * (altoVentana - tam));
        imagenRebote = new ImagenRebote(x, y, tam, tam);
 
    }
    
    //abajo solo hay getters
    public Vppal getV() {
        return v;
    }

    public ImagenRebote getImagenRebote() {
        return imagenRebote;
    }

    private void generarImagenObstaculo() {
        int tam = 100;
        int anchoVentana = v.getWidth();
        int altoVentana = v.getHeight();
        int xVentana = v.getX();
        int yVentana = v.getY();
        
       
        // Crear la imagen
        int x = xVentana + (int) ((anchoVentana/2 - tam/2));
        int y = yVentana + (int) ((altoVentana/2 - tam/2));
        imagenObstaculo = new ImagenObstaculo(x, y, tam, tam);
    }

    public ImagenObstaculo getImagenObstaculo() {
        return imagenObstaculo;
    }

    

}
