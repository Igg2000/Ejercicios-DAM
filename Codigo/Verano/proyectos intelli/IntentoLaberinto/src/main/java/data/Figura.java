package data;

import java.awt.*;

/**
 * simboliza una figura que tiene x, y, ancho y alto y un color o imagen
 */
public class Figura {

    private int x;
    private int y;
    private int ancho;
    private int alto;
    private Image image;
    private Color color;


    public Figura(int x, int y, int ancho, int alto, Color color) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
    }
    public Figura(int x, int y, int ancho, int alto, Image imagen) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.image = imagen;
    }

    /**
     * Si hay imagen la pinta y si no la pinta de color
     * @param g es el componente grafico que lo va a pintar
     */
    public void pintar(Graphics g) {
        if (image != null) {
            g.drawImage(image, x, y, ancho, alto, null);
        } else {
            g.setColor(color);
            g.fill3DRect(x, y, ancho, alto, true);
        }
    }

    //de aqui hacia abajo getters y setters


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
