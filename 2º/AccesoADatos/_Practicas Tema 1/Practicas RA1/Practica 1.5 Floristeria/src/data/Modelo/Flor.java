/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Modelo;

/**
 *
 * @author Nacho
 */
public class Flor extends Producto {
    private String color;

    public Flor(String nombre, String color) {
        super(nombre);
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
        return "Flor: "+super.getNombre() + " | Color: " + color + " | Cantidad: "+super.getCantidad();
    }
}
