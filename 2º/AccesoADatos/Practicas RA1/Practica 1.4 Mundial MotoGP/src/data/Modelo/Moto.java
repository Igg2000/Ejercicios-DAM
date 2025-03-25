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
public class Moto {
    private int numero;
    private String marca;
    private String modelo;

    public Moto(int numero, String marca, String modelo) {
        this.numero = numero;
        this.marca = marca;
        this.modelo = modelo;
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // hashCode y equals para evitar duplicados en HashSet
    @Override
    public int hashCode() {
        return Objects.hash(numero); // Clave única basada en el número de moto
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Moto moto = (Moto) obj;
        return numero == moto.numero;
    }

    @Override
    public String toString() {
        return "Nº "+numero + " Marca: " + marca + " Modelo: " + modelo;
    }
}