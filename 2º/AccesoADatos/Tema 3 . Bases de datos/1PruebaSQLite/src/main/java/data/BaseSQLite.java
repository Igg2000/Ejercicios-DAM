/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package data;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */
public class BaseSQLite {

    public static void main(String[] args) {
        
        Connection con=null;
        String rutaDB = ".//pruebaDB.db";
        
        try {
            con = getConexionConSQLite(rutaDB); //establezco conexion
            PreparedStatement ps = con.prepareStatement("Select * from usuarios;"); //preparo la sentencia
            System.out.println(sacarResultadosDeUnaQuery(ps)); //pinto los resultados
            
            ps.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        //forma2();
       
    }
    
    /**
     * Este metodo recibe un PreparedStatement con una query, y te devuelve
     * una cadena con los resultados de la query
     * @param preparedStatement 
     * @return Cadena con los resultados
     * @throws SQLException 
     */
    public static String sacarResultadosDeUnaQuery(PreparedStatement preparedStatement) throws SQLException{
        String cad="";
        
        ResultSet res = preparedStatement.executeQuery();
        
        
        // Recorre el ResultSet y muestra los resultados
        
        // Bucle para las filas
        while (res.next()) {
           StringBuilder resultString = new StringBuilder();
           int columnCount = res.getMetaData().getColumnCount(); // Obtiene el número de columnas

           // Bucle para las columnas
           for (int i = 1; i <= columnCount; i++) {
               // Obtiene el valor de la columna según el tipo de dato y lo convierte a cadena
               resultString.append(res.getString(i)); 

               // Si no es la última columna, añade un separador (por ejemplo, una coma)
               if (i < columnCount) {
                   resultString.append(", ");
               }
           }
            cad+= resultString.toString()+"\n";
       }
        return cad;

    }
    
    /**
     * Este metodo establece y devuelve una conexion con una base de datos SQLite
     * @param rutaDB ruta del archivo de base de datos
     * @return Conexion con la base de datos
     * @throws SQLException Error al establecer la conexion
     */
    public static Connection getConexionConSQLite(String rutaDB) throws SQLException {
        try {
            // Carga el driver JDBC de SQLite
            Class.forName("org.sqlite.JDBC");
            // Establece la conexión a la base de datos SQLite
            return DriverManager.getConnection("jdbc:sqlite:" + rutaDB);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Se ha producido un error al establecer la conexion: ", e.getMessage());
        }
    }

    private static void forma2() {
        Connection con=null;
        String rutaDB = ".//pruebaDB.db";
        
         try {
            // Carga el driver JDBC de SQLite
            Class.forName("org.sqlite.JDBC");
            // Establece la conexión a la base de datos SQLite
            con = DriverManager.getConnection("jdbc:sqlite:"+rutaDB);
            if (con != null) {
                System.out.println("Conexión exitosa!");
            }
            
            PreparedStatement ps = con.prepareStatement("Select * from usuarios;");
            
         
            //System.out.println(sacarResultadosDeUnaQuery(ps));
            
            ResultSet resUsuarios = ps.executeQuery();            
            // Recorre el ResultSet y muestra los resultados
            while (resUsuarios.next()) {
                int id = resUsuarios.getInt("id"); // Asumiendo que la tabla tiene una columna 'id'
                String nombre = resUsuarios.getString("nombre"); // Asumiendo que la tabla tiene una columna 'nombre'
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }

            resUsuarios.close();
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Error en la conexión");
        }
    }
    
    
}
