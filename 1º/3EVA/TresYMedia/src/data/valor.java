/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
public enum valor {
    
    
    
    AS(1f),DOS(2f),TRES(3f),SOTA(0.5f),CABALLO(0.5f),REY(0.5f);
    
    float puntos;

    private valor(float puntuacion) {
        this.puntos = puntuacion;
    }

    public float getPuntos() {
        return puntos;
    }
    
    
}
