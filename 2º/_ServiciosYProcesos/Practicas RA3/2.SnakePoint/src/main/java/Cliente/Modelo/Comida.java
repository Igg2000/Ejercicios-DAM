package Cliente.Modelo;

import java.awt.*;

public class Comida extends ObjetoJuego {
    private int valor;
    private boolean activa;

    public Comida(int x, int y, int ancho, int alto, int valor) {
        super(x, y,ancho,alto);
        this.valor = valor;
        this.activa = true;
    }

    public int getValor() {
        return valor;
    }

    public boolean isActiva() {
        return activa;
    }

    public void consumir() {
        activa = false;
    }

    @Override
    public void actualizar() {
        // Lógica de actualización si la comida se mueve o desaparece
    }

    @Override
    public void dibujar(Graphics g) {
        // Dibujar la comida en la posición (x, y)
    }
}
