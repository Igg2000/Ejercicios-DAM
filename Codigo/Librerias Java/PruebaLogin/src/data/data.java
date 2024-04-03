/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.VentanaLogin;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class data {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        VentanaLogin v = new VentanaLogin();
        
        datosPrueba(VentanaLogin.getU());
        
        v.setVisible(true);
        v.setLocationRelativeTo(null);
        
        
    }
    
    public static void datosPrueba(List <Usuarios> u) {
    
        u.add(new Usuarios("Admin","123"));
        u.add(new Usuarios("nacho","1245"));
        u.add(new Usuarios("miguel","12456"));
    
    }
}
