package data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Serpiente {

    private int longitud;
    private int tamanio= 50;
    private Direccion direccionCabeza = Direccion.DERECHA;

    private Cabeza cabeza;
    private List <Cuerpo> cuerpos;

    private Image imagenCabeza,imagenCuerpo;

    private boolean serpienteConImagenes= false;

    public Serpiente(int longitud) {
        this.longitud = longitud;

        cabeza = new Cabeza(300, 250);
        cuerpos = new ArrayList<>();
        for (int i = 0; i < this.longitud-1; i++) {
            cuerpos.add(new Cuerpo(cabeza.x -(i+1)*tamanio, cabeza.y));
        }

        if (serpienteConImagenes)
            cargarImagenes();
    }

    private void cargarImagenes() {
        imagenCabeza = new ImageIcon("src/main/java/resources/Snake_Cabeza.png").getImage();
        imagenCuerpo = new ImageIcon("src/main/java/resources/Snake_Cuerpo.png").getImage();
    }

    public void pintar(Graphics g) {
/*
        if (serpienteConImagenes)
            dibujarSerpienteConImagenes(g);
        else
*/           dibujarSerpienteConFormas(g);

    }

    private void dibujarSerpienteConFormas(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(cabeza.x, cabeza.y, tamanio, tamanio);
        g.setColor(Color.GREEN);

        for (Cuerpo cs : cuerpos) {
            g.fillOval(cs.x, cs.y, tamanio, tamanio);
        }
    }
/*
    private void dibujarSerpienteConImagenes(Graphics g) {
        g.drawImage(imagenCabeza, cabeza.x, cabeza.y, tamanio, tamanio, null);
        for (int i = 0; i < cuerpos.x.length; i++) {
            g.drawImage(imagenCuerpo, cuerpos.x[i], cuerpos.y[i], tamanio, tamanio, null);
        }
    }
*/
    public void mover(Direccion d) {

        // Verificar la dirección de la cabeza
        if (d == Direccion.ARRIBA && direccionCabeza == Direccion.ABAJO) {
            return;
        } else if (d == Direccion.ABAJO && direccionCabeza == Direccion.ARRIBA) {
            return;
        } else if (d == Direccion.IZQUIERDA && direccionCabeza == Direccion.DERECHA) {
            return;
        } else if (d == Direccion.DERECHA && direccionCabeza == Direccion.IZQUIERDA) {
            return;
        }


        // guarda las posiciones anteriores al movimiento
        Point posCabezaAnterior= new Point(cabeza.x, cabeza.y);

        List<Point> posCuerpoAnterior= new ArrayList<>();
        for (Cuerpo cs : cuerpos) {
            posCuerpoAnterior.add(new Point(cs.x, cs.y));
        }
        List<Direccion> dirCuerpoAnterior= new ArrayList<>();
        for (Cuerpo cs : cuerpos) {
            dirCuerpoAnterior.add(cs.direccion);
        }

        direccionCabeza = d;

        //mueve la cabeza
        switch (direccionCabeza) {
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
            cuerpos.get(i).x = posCuerpoAnterior.get(i-1).x;
            cuerpos.get(i).y = posCuerpoAnterior.get(i-1).y;
            cuerpos.get(i).direccion = dirCuerpoAnterior.get(i-1);
        }

        cuerpos.get(0).x = posCabezaAnterior.x;
        cuerpos.get(0).y = posCabezaAnterior.y;
    }

    public void crecer() {
        Cuerpo cn;

        switch (cuerpos.getLast().direccion) {
            case ARRIBA:
                  cn =new Cuerpo(cuerpos.getLast().x, cuerpos.getLast().y - tamanio);
                break;
            case ABAJO:
                  cn =new Cuerpo(cuerpos.getLast().x, cuerpos.getLast().y + tamanio);
                break;
            case IZQUIERDA:
                  cn =new Cuerpo(cuerpos.getLast().x - tamanio, cuerpos.getLast().y);
                break;
            case DERECHA:
                  cn =new Cuerpo(cuerpos.getLast().x + tamanio, cuerpos.getLast().y);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error creciendo la serpiente");
                return;
        }

        cn.direccion = cuerpos.getLast().direccion;
        cuerpos.add(cn);
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
        int x;
        int y;
        Direccion direccion= Direccion.DERECHA;


        public Cuerpo(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Direccion getDireccion() {
            return direccion;
        }

        public void setDireccion(Direccion direccion) {
            this.direccion = direccion;
        }
    }

    public enum Direccion {
        ARRIBA,
        ABAJO,
        IZQUIERDA,
        DERECHA
    }

    public Direccion getDireccionCabeza() {
        return direccionCabeza;
    }

    public Cabeza getCabeza() {
        return cabeza;
    }

    public List<Cuerpo> getCuerpos() {
        return cuerpos;
    }

    public int getLongitud() {
        return longitud;
    }

    public int getTamanio() {
        return tamanio;
    }
}
