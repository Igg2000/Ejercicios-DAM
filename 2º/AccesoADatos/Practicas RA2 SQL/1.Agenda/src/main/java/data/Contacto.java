/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
public class Contacto {
    private int id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String aficiones;
    private String pandilla;
    private String sitioVeraneo;

    // Constructor
    public Contacto(String nombre, String telefono, String direccion, String aficiones, String pandilla, String sitioVeraneo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.aficiones = aficiones;
        this.pandilla = pandilla;
        this.sitioVeraneo = sitioVeraneo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAficiones() {
        return aficiones;
    }

    public void setAficiones(String aficiones) {
        this.aficiones = aficiones;
    }

    public String getPandilla() {
        return pandilla;
    }

    public void setPandilla(String pandilla) {
        this.pandilla = pandilla;
    }

    public String getSitioVeraneo() {
        return sitioVeraneo;
    }

    public void setSitioVeraneo(String sitioVeraneo) {
        this.sitioVeraneo = sitioVeraneo;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", aficiones='" + aficiones + '\'' +
                ", pandilla='" + pandilla + '\'' +
                ", sitioVeraneo='" + sitioVeraneo + '\'' +
                '}';
    }
}
