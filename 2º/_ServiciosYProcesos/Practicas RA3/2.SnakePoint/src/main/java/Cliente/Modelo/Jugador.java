package Cliente.Modelo;

import java.awt.*;

public class Jugador extends ObjetoJuego {
    private String nombre;
    private int avatar;
    private int puntuacion;

    public Jugador(String nombre, int x, int y, int ancho, int alto) {
        super(x, y, ancho, alto);
        this.nombre = nombre;
        this.puntuacion = 0;
    }


    public String getNombre() {
        return nombre;
    }

    public int getAvatar() {
        return avatar;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }


    @Override
    public void actualizar() {
        // Lógica de actualización del jugador (ej: movimiento)
    }

    @Override
    public void dibujar(Graphics g) {
        // Dibujar el jugador en la posición (x, y)
    }
}
