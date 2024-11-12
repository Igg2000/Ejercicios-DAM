/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Controlador;

import GUI.Vista;
import data.Modelo.Modelo;

/**
 *
 * @author Nacho
 */
public class Controlador {

    Modelo modelo;
    Vista vista;
    
    public Controlador(Modelo modelo, Vista vista) {
        this.modelo=modelo;
        this.vista=vista;
    }
    
}
