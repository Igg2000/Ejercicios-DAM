package data;

public class Pieza {
    private int x;
    private int y;
    private String color;
    private String nombre;
    private PiezasAjedrez tipo;

    public Pieza(int x, int y, String color, String name) {
        this.x = x;
        this.y = y;
        this.color = color.toLowerCase();
        this.nombre = name.toUpperCase().trim();
        this.tipo = PiezasAjedrez.parseFromName(this.nombre);
    }

    public String getSymbol() {
        return color.equalsIgnoreCase("blanco") ? tipo.getCaracterBlanco() : tipo.getCaracterNegro();
    }

    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public String getColor() { return color; }
    public String getNombre() { return nombre; }


}