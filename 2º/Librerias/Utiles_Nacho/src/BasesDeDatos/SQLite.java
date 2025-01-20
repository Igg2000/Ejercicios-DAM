/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BasesDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nacho
 */
public class SQLite {
    
      
    /**
     * Este metodo recibe un PreparedStatement con una query, y te devuelve
     * una cadena con los resultados de la query
     * @param preparedStatement La sentencia de la query
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
}
