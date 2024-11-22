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
public class App implements Runnable{

    Modelo modelo;
    Vista vista;
    
    public App(Modelo modelo, Vista vista) {
        this.modelo=modelo;
        this.vista=vista;
    }

    @Override
    public void run() {
        vista.setVisible(true);
    }
    
}
