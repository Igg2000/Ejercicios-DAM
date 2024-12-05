/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import GUI.PanelAnimacion;
import GUI.PanelPrincipal;
import Ventana.Vppal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grovy
 */
public class App implements Runnable{

    Vppal v;
    List<Particula> particulas;

    
    
    @Override
    public void run() {
        v = new Vppal();

        
        particulas = new ArrayList<>();
        generarParticulas();
        
        PanelPrincipal p = new PanelPrincipal(this);
        PanelAnimacion pan = new PanelAnimacion(this);
        v.ponPanel(pan);
        
        pan.iniciarAnimacion();
        
    }

    private void generarParticulas() {
        int tam = 100;
        int anchoVentana = v.getWidth();
        int altoVentana = v.getHeight();
        int xVentana = v.getX();
        int yVentana = v.getY();
        
       
        // Crear la imagen que va a rebotar dentro de los límites de la pantalla
        int x1 = xVentana + (int) (Math.random() * (anchoVentana - tam));
        int y1 = yVentana + (int) (Math.random() * (altoVentana - tam));
        particulas.add(new Particula(x1, y1, tam, tam));
        
        
        //Crea la particula estatica en el medio de la pantalla
        int x2 = xVentana + (int) (anchoVentana /2 - tam);
        int y2 = yVentana + (int) (altoVentana /2 - tam);
        particulas.add(new Particula(x2, y2, tam, tam));
    }
    
    //abajo solo hay getters
    public Vppal getV() {
        return v;
    }

    public List<Particula> getParticulas() {
        return particulas;
    }

    
    
    
}
