/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Modelo;

/**
 *
 * @author Nacho
 */
public class Planta extends Producto {
    private String tamaño;

    public Planta(String nombre, String tamaño) {
        super(nombre);
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
        return "Planta: "+super.getNombre() + " | Tama\u00f1o: " + tamaño+ " | Cantidad: "+super.getCantidad();
    }
    
    
}
