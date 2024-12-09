/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class Semaforo extends Rectangle {
    
    List<Luz> luces;
    
    Color colorApagado1= Color.red.darker().darker().darker();
    Color colorEncendido1= Color.red.brighter().brighter();
    Color colorApagado2= Color.yellow.darker().darker().darker();
    Color colorEncendido2= Color.yellow.brighter().brighter();
    Color colorApagado3= Color.green.darker().darker().darker();
    Color colorEncendido3= Color.green.brighter().brighter();

    private int centroX; // Coordenada X centrada horizontalmente dentro del semáforo
    private int luzDiameter; // Diámetro de las luces, proporcional al menor lado
    private int espacioVertical; // Espacio entre luces y márgenes superior/inferior

    public Semaforo(int x, int y, int width, int height) {
        super(x, y, width, height);
        
        luzDiameter = Math.min(width, height / 4);
        centroX = x + (width - luzDiameter) / 2;
        espacioVertical = (height - 3 * luzDiameter) / 4;

        luces = new ArrayList<>();
        luces.add(new Luz(centroX, y + espacioVertical, luzDiameter, luzDiameter, colorApagado1 ));
        luces.add(new Luz(centroX, y + 2 * espacioVertical + luzDiameter, luzDiameter, luzDiameter, colorApagado2)); // Luz amarilla
        luces.add(new Luz(centroX, y + 3 * espacioVertical + 2 * luzDiameter, luzDiameter, luzDiameter, colorApagado3)); // Luz verde 
    }

    public void actualizarCentroLuces(){
        luzDiameter = Math.min(width, height / 4);
        centroX = x + (width - luzDiameter) / 2;
        espacioVertical = (height - 3 * luzDiameter) / 4;
        
        for (int i = 0; i < luces.size(); i++) {
            luces.get(i).setLocation(centroX, y + (i+1) * espacioVertical + i*luzDiameter);
        }
    }
    
    public void pintar(Graphics g){
        
        Graphics g2= (Graphics2D) g;
        
        g2.setColor(Color.black);
        g2.fillRect(x, y, width, height);
        
        for (Luz l : luces) {
            g2.setColor(l.color);
            g2.fillOval(l.x, l.y, l.width, l.height);
        }
        
        
    }
    
    public void ponerseEnVerde(){
        Luz l = luces.get(2);
        l.color = colorEncendido3;
    }
    
    public void ApagarVerde(){
        Luz l = luces.get(2);
        l.color = colorApagado3;
    }
    
    public void ponerseEnAmbar(){
        Luz l = luces.get(1);
        l.color = colorEncendido2;
    }
    
    public void ApagarAmbar(){
        Luz l = luces.get(1);
        l.color = colorApagado2;
    }
    
    public void ponerseEnRojo(){
        Luz l = luces.get(0);
        l.color = colorEncendido1;
    }
    
    public void ApagarRojo(){
        Luz l = luces.get(0);
        l.color = colorApagado1;
    }
    
    
    
    private static class Luz extends Rectangle{

        private Color color;

        public Luz(int x, int y, int width, int height, Color color) {
            super(x, y, width, height);
            this.color = color;
        }
                
    }
    
}
