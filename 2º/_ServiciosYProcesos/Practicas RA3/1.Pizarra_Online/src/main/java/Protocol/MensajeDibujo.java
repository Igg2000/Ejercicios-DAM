package Protocol;

import java.io.Serializable;

public class MensajeDibujo implements Serializable {
    private String tipo;
    private String forma;
    private int x;
    private int y;
    private String usuario;
    private String color; // Color en formato hexadecimal

    public MensajeDibujo(String tipo, String forma, int x, int y, String usuario, String color) {
        this.tipo = tipo;
        this.forma = forma;
        this.x = x;
        this.y = y;
        this.usuario = usuario;
        this.color = color;
    }

    // Getters
    public String getTipo() { return tipo; }
    public String getForma() { return forma; }
    public int getX() { return x; }
    public int getY() { return y; }
    public String getUsuario() { return usuario; }
    public String getColor() { return color; }
}
