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
    Tarro tarro;
    List<Particula> particulas;

    
    
    @Override
    public void run() {
        v = new Vppal();

        int anchoTarro= 300;
        int altoTarro= 450;
        
        tarro = new Tarro(v.getWidth()/2-anchoTarro/2,v.getHeight()/2-altoTarro/2-50,anchoTarro,altoTarro);
        particulas = new ArrayList<>();
        generarParticulas(40,20);
        
        PanelPrincipal p = new PanelPrincipal(this);
        v.ponPanel(p);
        
    }

    private void generarParticulas(int n,int tam) {
        int anchoTarro = getTarro().width;
        int altoTarro = getTarro().height;
        int xTarro = getTarro().x;
        int yTarro = getTarro().y;
        
        for (int i = 0; i < n; i++) {
            // Crear partículas dentro de los límites del tarro
            int x = xTarro + (int) (Math.random() * (anchoTarro - tam));
            int y = yTarro + (int) (Math.random() * (altoTarro - tam));
            particulas.add(new Particula(x, y, tam, tam));
        }

    }
    
    //abajo solo hay getters
    public Vppal getV() {
        return v;
    }

    public Tarro getTarro() {
        return tarro;
    }

    public List<Particula> getParticulas() {
        return particulas;
    }

    
    
    
}
