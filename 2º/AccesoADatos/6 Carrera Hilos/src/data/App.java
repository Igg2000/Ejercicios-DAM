/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import GUI.PanelCarrera;
import Ventana.Vppal;

/**
 *
 * @author Nacho
 */
class App {
    
    Vppal v = new Vppal();
    PanelCarrera p= new PanelCarrera(5);
    
    
    public App() {
        v.ponPanel(p);
    }
    
}
