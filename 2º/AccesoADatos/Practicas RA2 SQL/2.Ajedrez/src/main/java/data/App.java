/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package data;

import GUI.MenuPrincipal;
import Temas.Temas;
import Ventana.Vppal;
import conexionBD.GestorBD;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class App extends Thread {

    public static Temas TEMA = Temas.AMANECER; //tema de la app
    private final Vppal v;
    private Connection con;
    public static String url = "jdbc:mysql://localhost:3306/bddajedrez";
    public static String user = "root";
    public static String password = "";



    public App(String name) {
        super(name);
        this.v =new Vppal();
        v.setVisible(false);
        v.setName(name);
    }
    
    public static void main(String[] args) {
        App a=new App("Ajedrez");
        a.start();
    }

    @Override
    public void run() {




        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Cargar el driver
            Connection con = GestorBD.establecerConexionMYSQL(url, user, password);
            GestorBD.setConexion(con);
            v.setVisible(true);
            String opciones[]={"Resultados por Rondas","Tableros de partidas","Tableros de rondas","Salir"};
            PanelesGUI.PMenuV2 menupp = new MenuPrincipal(v,opciones, this.getName());
            v.ponPanel(menupp);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n"+e.getMessage());
            v.dispose();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el driver de la base de datos:\n"+e.getMessage());
            v.dispose();
        }

    }
    
    
    
}
