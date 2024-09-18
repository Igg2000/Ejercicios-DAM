/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.Panel1;

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

        
        a.addInstis(new Instituto("Palomeras"));
        a.addInstis(new Instituto("Pacifico"));
        a.addInstis(new Instituto("Juan de la Cierva"));
        
        Panel1 p= new Panel1(a);
        a.v.ponPanel(p);
        
        
    }
    
}
