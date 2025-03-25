/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Modelo;

import java.util.Objects;

/**
 *
 * @author Nacho
 */
public class Circuito {
    private String nombre;
    private String pais;
    private double longitud;

    public Circuito(String nombre, String pais, double longitud) {
        this.nombre = nombre;
        this.pais = pais;
        this.longitud = longitud;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    // hashCode y equals para evitar duplicados en HashSet
    @Override
    public int hashCode() {
        return Objects.hash(nombre, pais); // Clave única basada en nombre y país
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Circuito circuito = (Circuito) obj;
        return Objects.equals(nombre, circuito.nombre) && Objects.equals(pais, circuito.pais);
    }

    @Override
    public String toString() {
        return "Circuito [Nombre=" + nombre + ", País=" + pais + ", Longitud=" + longitud + " km]";
    }
}