/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class Nodo {
    private String nombre;  // Nombre o identificador del nodo
    private List<NodoAdyacente> adyacentes;  // Lista de nodos adyacentes
    private Point coordenadas;  // Para guardar las coordenadas del nodo

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.adyacentes = new ArrayList<>();
    }

    // Método para verificar si un nodo ya es adyacente
    public boolean yaEsAdyacente(Nodo nodoDestino) {
        for (NodoAdyacente adyacente : adyacentes) {
            if (adyacente.getNodo().equals(nodoDestino)) {
                return true;
            }
        }
    return false;
}


    // Añadir nodo adyacente con la distancia
    public void agregarNodoAdyacente(Nodo nodo, double distancia) {
        adyacentes.add(new NodoAdyacente(nodo, distancia));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<NodoAdyacente> getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(List<NodoAdyacente> adyacentes) {
        this.adyacentes = adyacentes;
    }

    public Point getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Point coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    
    

    @Override
    public String toString() {
        return nombre;
    }
}
