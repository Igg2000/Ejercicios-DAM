package data;

import javax.swing.*;
import java.awt.*;

public class Manzana {
    private Image imagen;
    private int tamanio= 50;
    int x;
    int y;

    public Manzana(int x, int y) {
        this.x = x;
        this.y = y;
        cargarImagen();
    }

    private void cargarImagen() {
        this.imagen = new ImageIcon("src/main/java/resources/Snake_Manzana.png").getImage();
    }

    public void pintar(Graphics g){
        g.drawImage(imagen,x,y,tamanio,tamanio,null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTamanio() {
        return tamanio;
    }
}
