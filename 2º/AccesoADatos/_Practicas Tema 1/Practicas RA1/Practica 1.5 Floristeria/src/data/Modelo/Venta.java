/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase que representa una venta en la floristería.
 * @author Nacho
 */
public class Venta {
    private Producto producto;
    private int cantidadVendida;
    private Calendar fechaVenta;

    /**
     * Constructor de la clase Venta.
     * 
     * @param producto El producto que se vendió.
     * @param cantidadVendida La cantidad del producto vendida.
     * @param fechaVenta La fecha en la que se realizó la venta.
     */
    public Venta(Producto producto, int cantidadVendida, Calendar fechaVenta) {
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
        this.fechaVenta = fechaVenta;
    }

    /**
     * Constructor alternativo que asume la fecha actual como la fecha de la venta.
     * 
     * @param producto El producto que se vendió.
     * @param cantidadVendida La cantidad del producto vendida.
     */
    public Venta(Producto producto, int cantidadVendida) {
        this(producto, cantidadVendida, Calendar.getInstance());
    }

    // Getters y Setters

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public Calendar getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Calendar fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    /**
     * Calcula el total de la venta basada en el precio del producto y la cantidad vendida.
     * 
     * @return El total de la venta.
     */
    public double calcularTotalVenta() {
        return producto.getPrecio() * cantidadVendida;
    }

    @Override
    public String toString() {
        // Formatear la fecha en un formato legible
        int dia = fechaVenta.get(Calendar.DAY_OF_MONTH);
        int mes = fechaVenta.get(Calendar.MONTH) + 1; // Los meses empiezan en 0
        int año = fechaVenta.get(Calendar.YEAR);

        return String.format("Venta [Producto: %s, Cantidad: %d, Fecha: %02d/%02d/%d, Total: %.2f]",
                producto.getNombre(), cantidadVendida, dia, mes, año, calcularTotalVenta());
    }
}
