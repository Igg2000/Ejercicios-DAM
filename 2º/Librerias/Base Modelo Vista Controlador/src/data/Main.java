/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.Vista;
import data.Controlador.Controlador;
import data.Modelo.Modelo;


/**
 *
 * @author Nacho
 */
public class Main {
    
    public static void main(String[] args) {
        // Crear el modelo y la vista
        Modelo modelo = new Modelo();
        Vista vista = new Vista();

        // Crear el controlador y pasarle el modelo y la vista
        new Controlador(modelo, vista);

    
    }
    
}
