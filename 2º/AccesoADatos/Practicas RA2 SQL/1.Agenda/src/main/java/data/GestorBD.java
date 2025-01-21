/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class GestorBD {
      

    
    public static Connection establecerConexionAccess(String rutaArchivoBD) throws ClassNotFoundException, SQLException {
        Connection conn;
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        conn = DriverManager.getConnection("jdbc:ucanaccess://"+rutaArchivoBD);
        return conn;
    }

    public static ResultSet hacerConsulta(Connection con, String consulta) throws SQLException {
        PreparedStatement ps = null;
        ps = con.prepareStatement(consulta);
        ResultSet res = ps.executeQuery();
        return res;

    }

    public static String convertirResultSetEnCadena(ResultSet resConsulta) throws SQLException {
        String cad="";
        
        // Recorre el ResultSet y muestra los resultados
        
        // Bucle para las filas
        while (resConsulta.next()) {
           StringBuilder resultString = new StringBuilder();
           int columnCount = resConsulta.getMetaData().getColumnCount(); // Obtiene el número de columnas

           // Bucle para las columnas
           for (int i = 1; i <= columnCount; i++) {
               // Obtiene el valor de la columna según el tipo de dato y lo convierte a cadena
               resultString.append(resConsulta.getString(i)); 

               // Si no es la última columna, añade un separador (por ejemplo, una coma)
               if (i < columnCount) {
                   resultString.append(", ");
               }
           }
            cad+= resultString.toString()+"\n";
       }
        return cad;
    }
    
    public static void imprimirConsulta(Connection con, String consulta) throws SQLException {
        ResultSet resConsulta = hacerConsulta(con, consulta);
        
        String cad = convertirResultSetEnCadena(resConsulta);
        System.out.println(cad);    
    }

    public static boolean existeLaBD(String cad) {
        
        //por algun motivo para la conexion sobra el '.' pero para verificar el archivo no
        File bd = new File(cad); 
        if (!bd.exists()) {
            System.err.println("El archivo de base de datos no existe: " + cad);
            return false;
        }
        return true;
    }
    
    public static void insertarDatos(Connection con, String tabla, Object[] valores, String[] campos) throws SQLException {
        // Construir la parte de columnas de la consulta
        StringBuilder columnas = new StringBuilder();
        for (int i = 0; i < campos.length; i++) {
            columnas.append(campos[i]);
            if (i < campos.length - 1) {
                columnas.append(", ");
            }
        }

        // Construir la parte de valores de la consulta
        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < valores.length; i++) {
            placeholders.append("?");
            if (i < valores.length - 1) {
                placeholders.append(", ");
            }
        }

        // Construir la consulta SQL
        String query = "INSERT INTO " + tabla + " (" + columnas + ") VALUES (" + placeholders + ")";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            for (int i = 0; i < valores.length; i++) {
                ps.setObject(i + 1, valores[i]);
            }
            ps.executeUpdate();
            System.out.println("Datos insertados correctamente en la tabla: " + tabla);
        }
    }

    public static void borrarDatos(Connection con, String tabla, String campoCondicion, Object valorCondicion) throws SQLException {
        // Construir la consulta DELETE
        String query = "DELETE FROM " + tabla + " WHERE " + campoCondicion + " = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            // Establecer el valor de la condición (ej. DNI o ID)
            ps.setObject(1, valorCondicion);
            // Ejecutar la eliminación
            ps.executeUpdate();
            System.out.println("Datos eliminados correctamente de la tabla: " + tabla);
        }
    }

    public static void modificarDatos(Connection con, String tabla, String[] campos, Object[] nuevosValores, String campoCondicion, Object valorCondicion) throws SQLException {
        // Construir la parte de SET de la consulta UPDATE
        StringBuilder setClause = new StringBuilder();
        for (int i = 0; i < campos.length; i++) {
            setClause.append(campos[i]).append(" = ?");
            if (i < campos.length - 1) {
                setClause.append(", ");
            }
        }

        // Construir la consulta UPDATE con la condición WHERE
        String query = "UPDATE " + tabla + " SET " + setClause + " WHERE " + campoCondicion + " = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            // Establecer los valores de los campos a modificar
            for (int i = 0; i < nuevosValores.length; i++) {
                ps.setObject(i + 1, nuevosValores[i]);
            }
            // Establecer el valor de la condición (ej. DNI o ID)
            ps.setObject(nuevosValores.length + 1, valorCondicion);

            // Ejecutar la actualización
            ps.executeUpdate();
            System.out.println("Datos actualizados correctamente en la tabla: " + tabla);
        }
        
        //Ejemplo de uso
        /*
            String camposPaciente[] = {"Nombre", "Apellido1", "Apellido2", "edad"};
            Object nuevosValoresPaciente[] = {"María", "López", "Martínez", 31}; // Actualizar la edad a 31

            // Modificar el paciente con DNI 6
            modificarDatos(con, "Pacientes", camposPaciente, nuevosValoresPaciente, "DNI", 6);

            String camposMedico[] = {"nombre", "apellidos", "especialidad"};
            Object nuevosValoresMedico[] = {"Luis", "Fernández Gómez", "cardiología avanzada"}; // Actualizar especialidad

            // Modificar el médico con ID 6
            modificarDatos(con, "Médicos", camposMedico, nuevosValoresMedico, "ID", 6);

        */
    }

    public static List<String> sacarValoresDeColumna(ResultSet resConsulta, int i) throws SQLException {
        List<String> valores = new ArrayList();
        while (resConsulta.next()) {
            valores.add(resConsulta.getString(i));
        }
        
        return valores;
    }

    
}
