package data.Modelo;

public class Flor extends Producto {
    private String color;

    public Flor(String nombre, String color, double precio) {
        super(nombre, precio);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Flor: " + super.getNombre() + " | Color: " + color + " | Cantidad: " + super.getCantidad() + " | Precio: " + super.getPrecio() + "€";
    }
}
