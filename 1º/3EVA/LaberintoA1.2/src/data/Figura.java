/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import GUI.VJuego;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author DAI
 */
public class Figura {

    private Point pos;  //Posición de la figura dentro de la ventana
    private Dimension tam;  //Tamaño de la figura dentro de la ventana
    private ImageIcon img;        
    
    
    public Figura(ImageIcon img,Point p,Dimension tamaño) {
        pos=p;
        tam=tamaño;
        this.img=img;        
    }
    
    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public Dimension getTam() {
        return tam;
    }

    public void setTam(Dimension tam) {
        this.tam = tam;
    }
    

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public int getX() {
        return pos.x;
    }

    public void setX(int x) {
        this.pos.x = x;
    }

    public int getY() {
        return pos.y;
    }

    public void setY(int y) {
        this.pos.y = y;
    }   

    public void dibujar(Graphics g){                
        g.drawImage(img.getImage(), pos.x, pos.y, tam.width,tam.height,null);
    }   
    
    //Nos dice si la figura está dentro de la ventana
    //Lo averiguamos xq el rectángulo formado por la figura está dentro del formado por la ventana
    public boolean estaDentroVentana(VJuego v){
        
        Rectangle r1=new Rectangle(new Point(1,25),v.getSize());//El 25 es xq la barra de título forma parte del tamaño de la ventana
        Rectangle r2=new Rectangle(this.getPos(),this.getTam());
        if(r1.contains(r2))
                return true;
    
        return false;
        
    }  
    
    //Si una fig esta dentro de otra es q hay colision
    public boolean estaDentroFigura(Figura f){   
        //MEJOR Y + SENCILLO:USO EL MÉTODO INTERSECTS DE RECTANGLE
        //Si hay intersección entre ambos es q se tocan
        Rectangle r1=new Rectangle(f.getPos(),f.getTam());
        Rectangle r2=new Rectangle(this.getPos(),this.getTam());
        if(r1.intersects(r2))
            return true;
        return false;
    }

    

    
}