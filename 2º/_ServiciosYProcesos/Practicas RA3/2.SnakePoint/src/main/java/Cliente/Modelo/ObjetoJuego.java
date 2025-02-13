package Cliente.Modelo;

import java.awt.*;

public abstract class ObjetoJuego extends Rectangle {


    public ObjetoJuego(int x, int y, int ancho, int alto) {
        super(x,y,ancho,alto);
    }

    public abstract void actualizar();
    public abstract void dibujar(Graphics g);
    // Podrías usar Graphics2D si quisieras
}
