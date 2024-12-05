package data.Modelo;

public class Planta extends Producto {
    private String tamaño;

    public Planta(String nombre, String tamaño, double precio) {
        super(nombre, precio);
        this.tamaño = tamaño;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "Planta: " + super.getNombre() + " | Tamaño: " + tamaño + " | Cantidad: " + super.getCantidad() + " | Precio: " + super.getPrecio() + "€";
    }
}
