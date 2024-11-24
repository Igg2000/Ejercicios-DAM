/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.Ventana;
import data.Controlador.App;
import data.Modelo.Mundial;

/**
 *
 * @author Nacho
 */
public class Main {

      public static void main(String[] args) {
          
        // Crear el modelo y la vista
        Mundial modelo = new Mundial();
        Ventana vista = new Ventana(modelo);

        // Crear el controlador y pasarle el modelo y la vista
        App controlador=new App(modelo, vista);
        new Thread(controlador).start();
    }
    
}
