/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package data;

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

    private final String rutaArchivoBD;
    private final Vppal v;
    
    public Color color2=new Color(156, 156, 156);
    public Color color1=new Color(49, 19, 20);
    public Color colorFondo=new Color(13,16,35); 
    public Font fuenteTitulo=new Font("Segoe UI",1,36);
    public Color colorLetraTitulo=Color.white;
    public Font fuenteBotones=new Font("Segoe UI",0,18); 
    public Color colorLetraBotones=Color.BLACK;
    
    
    
    public App(String name, String rutaArchivo) {
        super(name);
        rutaArchivoBD = rutaArchivo;
        this.v =new Vppal();
    }
    
    public static void main(String[] args) {
        App a=new App("Agenda",".//res//Agenda.accdb");
        a.start();
    }

    @Override
    public void run() {
        
        //si la BD no existe cierro el programa
        if(!GestorBD.existeLaBD(rutaArchivoBD))
            return;
        
        try {
            
            //Me conecto a la base de datos
            Connection con = GestorBD.establecerConexionAccess(rutaArchivoBD);
            
            
            String opciones[]={"Agregar Amigo","Ver lista de Amigos","Editar Amigos","Borrar Amigos","Salir"};
            PanelesGUI.PMenuV2 menupp = new PMenuV2(opciones, "Agenda", color1, color2, colorFondo, fuenteTitulo, colorLetraTitulo, fuenteBotones, colorLetraBotones);
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
