/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Modelo;

/**
 *
 * @author Nacho
 */
import java.util.Objects;

public abstract class Producto {
    private String nombre;
    private int cantidad;

    public Producto(String nombre) {
        this.nombre = nombre;
        this.cantidad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void incrementarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public void reducirCantidad(int cantidad) {
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
}
