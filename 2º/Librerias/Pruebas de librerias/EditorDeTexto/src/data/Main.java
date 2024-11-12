/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import PanelesTexto.PanelPaginaDeTextoHTML;
import Ventana.Vppal;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Vppal v = new Vppal();
        PanelEditorDeTextoHTML p = new PanelEditorDeTextoHTML("", true);
        v.ponPanel(p);
        
    }
    
}
