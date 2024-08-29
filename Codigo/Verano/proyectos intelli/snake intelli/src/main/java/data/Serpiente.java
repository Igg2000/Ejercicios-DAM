package data;

import javax.swing.*;
import java.awt.*;

public class Serpiente {

    private int longitud;
    private int tamanio= 50;
    private Direccion direccionSerpiente= Direccion.IZQUIERDA;

    private Cabeza cabeza;
    private Cuerpo cuerpo;

    private boolean serpienteConImagenes= false;

    public Serpiente(int longitud) {
        this.longitud = longitud;

        cabeza = new Cabeza(300, 250);
        cuerpo = new Cuerpo();
        if (serpienteConImagenes)
            cargarImagenes();
    }

    private void cargarImagenes() {
        cabeza.imagen = new ImageIcon("src/main/java/resources/Snake_Cabeza.png").getImage();
        cuerpo.imagen = new ImageIcon("src/main/java/resources/Snake_Cuerpo.png").getImage();
    }

    public void pintar(Graphics g) {

        if (serpienteConImagenes)
            dibujarSerpienteConImagenes(g);
        else
            dibujarSerpienteConFormas(g);
}

    private void dibujarSerpienteConFormas(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(cabeza.x, cabeza.y, tamanio, tamanio);
        g.setColor(Color.GREEN);
        for (int i = 0; i < cuerpo.x.length; i++) {
            g.fillOval(cuerpo.x[i], cuerpo.y[i], tamanio, tamanio);
        }
    }

    private void dibujarSerpienteConImagenes(Graphics g) {
        g.drawImage(cabeza.imagen, cabeza.x, cabeza.y, tamanio, tamanio, null);
        for (int i = 0; i < cuerpo.x.length; i++) {
            g.drawImage(cuerpo.imagen, cuerpo.x[i], cuerpo.y[i], tamanio, tamanio, null);
        }
    }

    public void mover(Direccion d) {

        // Verificar la dirección de la cabeza
        if (d == Direccion.ARRIBA && direccionSerpiente == Direccion.ABAJO) {
            return;
        } else if (d == Direccion.ABAJO && direccionSerpiente == Direccion.ARRIBA) {
            return;
        } else if (d == Direccion.IZQUIERDA && direccionSerpiente == Direccion.DERECHA) {
            return;
        } else if (d == Direccion.DERECHA && direccionSerpiente == Direccion.IZQUIERDA) {
            return;
        }


        // guarda las posiciones anteriores al movimiento
        Point posCabezaAnterior= new Point(cabeza.x, cabeza.y);
        Point []posCuerpoAnterior= new Point[cuerpo.x.length];
        for (int i = 0; i < cuerpo.x.length; i++) {
            posCuerpoAnterior[i]= new Point(cuerpo.x[i], cuerpo.y[i]);
        }

        direccionSerpiente = d;

        //mueve la cabeza
        switch (direccionSerpiente) {
            case ARRIBA:
                cabeza.y -= tamanio;
                break;
            case ABAJO:
                cabeza.y += tamanio;
                break;
            case IZQUIERDA:
                cabeza.x -= tamanio;
                break;
            case DERECHA:
                cabeza.x += tamanio;
                break;
        }

        //mueve el resto del cuerpo
        for (int i = longitud-2; i>0; i--) {
            cuerpo.x[i] = posCuerpoAnterior[i-1].x;
            cuerpo.y[i] = posCuerpoAnterior[i-1].y;
        }
        cuerpo.x[0] = posCabezaAnterior.x;
        cuerpo.y[0] = posCabezaAnterior.y;
    }

    public void crecer() {
        longitud++;
    }

    //De aqui hacia abajo son las clases internas de la serpiente o getters y setters

    /**
     * La cabeza de la serpiente guarda su posicion, su imagen y la direccion a la que mira
     */
    public class Cabeza {
        int x;
        int y;
        Image imagen;

        public Cabeza(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    /**
     * El cuerpo guarda la imagen y todas las posiciones de los trozos del cuerpo
     */
    public class Cuerpo {
        int []x= new int[longitud-1];
        int []y= new int[longitud-1];
        Image imagen;

        public Cuerpo() {
            for (int i = 0; i < x.length; i++) {
                x[i] = cabeza.x+(i+1)*tamanio;
                y[i] = cabeza.y;
            }
        }

        public int[] getX() {
            return x;
        }

        public int[] getY() {
            return y;
        }

        public Image getImagen() {
            return imagen;
        }
    }

    public enum Direccion {
        ARRIBA,
        ABAJO,
        IZQUIERDA,
        DERECHA
    }

    public Direccion getDireccionSerpiente() {
        return direccionSerpiente;
    }

    public Cabeza getCabeza() {
        return cabeza;
    }

    public Cuerpo getCuerpo() {
        return cuerpo;
    }

    public int getLongitud() {
        return longitud;
    }

    public int getTamanio() {
        return tamanio;
    }
}
