/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package data;

import GUI.MenuPrincipal;
import GUI.Tema;
import PanelesGUI.PMenuV2;
import Ventana.Vppal;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */
public class App extends Thread {

    public static Tema TEMA = Tema.OSCURO_CYAN; //tema de la app
    private final Vppal v;
    private Connection con;
    
    
    public App(String name) {
        super(name);
        this.v =new Vppal();
    }
    
    public static void main(String[] args) {
        App a=new App("Agenda");
        a.start();
    }

    @Override
    public void run() {
        
        //si la BD no existe cierro el programa
        if(!GestorBD.existeLaBD(GestorBD.getRutaArchivoBD()))
            return;
        
        try {
            
            //Me conecto a la base de datos
            con = GestorBD.establecerConexionAccess(GestorBD.getRutaArchivoBD());
            GestorBD.setConexion(con);
            
            
            String opciones[]={"Agregar Amigo","Ver lista de Amigos","Salir"};
            PanelesGUI.PMenuV2 menupp = new MenuPrincipal(v,opciones, "Agenda");
            v.ponPanel(menupp);
            
            
            //esto es para hace pruebas
            GestorBD.imprimirConsulta(con, "select * from Contactos");
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al usar el driver de UCanAccess:\n"+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error con la Base de datos:\n"+ex.getMessage());
        }
        
    }
    
    
    
}
