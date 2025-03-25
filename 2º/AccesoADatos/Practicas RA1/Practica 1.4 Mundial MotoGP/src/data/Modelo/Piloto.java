/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Modelo;

/**
 *
 * @author Nacho
 */
public class Piloto {
    private String nombre;
    private String pais;
    private String escuderia;
    private int puntos;

    // Constructor
    public Piloto(String nombre, String pais, String escuderia) {
        this.nombre = nombre;
        this.pais = pais;
        this.escuderia = escuderia;
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

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return nombre + " (" + pais + ") , Escudería: " + escuderia;
    }
}
