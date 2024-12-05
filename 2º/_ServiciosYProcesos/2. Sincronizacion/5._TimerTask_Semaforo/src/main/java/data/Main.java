/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package data;

import GUI.PP;
import GUI.Ventana;



/**
 *
 * @author Nacho
 */
public class Main {

    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
        PP p = new PP(v);
        v.ponPanel(p);
    }
}
