package data.Modelo;

import java.util.Objects;

public abstract class Producto {
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.cantidad = 0;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    public void incrementarCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva.");
        }
        this.cantidad += cantidad;
    }

    public void reducirCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva.");
        }
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
        } else {
            throw new IllegalArgumentException("No hay suficiente stock para reducir.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + " | Cantidad: " + cantidad + " | Precio: " + precio + "€";
    }
}
