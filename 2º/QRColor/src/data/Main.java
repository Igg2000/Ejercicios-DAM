/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.PInstis;
import java.awt.Color;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App a= new App();

        agregarDatosDePrueba(a);
        
        //a.visInstisEnVentana();
        //a.visQRC(TamQRC.peque);
        //a.sacarMenuQRC(false);
        a.sacarMenuPrincipal();
        
    }

    private static void agregarDatosDePrueba(App a) {
        
        Instituto ipv = new Instituto("IES Palomeras");        
        a.addInstis(ipv);
        a.addInstis(new Instituto("IES Pacifico"));
        a.addInstis(new Instituto("IES Juan de la Cierva"));
        a.addInstis(new Instituto("IES Moratalaz"));
    }
    
}
