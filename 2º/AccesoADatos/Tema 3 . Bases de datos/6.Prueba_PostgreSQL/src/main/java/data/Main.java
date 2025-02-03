package data;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String name= "postgres";
        String pass= "2505";


        Main.conectarConPostgreSQL(url,name,pass);
    }

    public static void conectarConPostgreSQL(String url, String name , String pass){

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url,name,pass);
            System.out.println("conectado con exito");

            /*
            PreparedStatement ps = con.prepareStatement("select * from postgres");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            */

        } catch (SQLException e) {
            System.out.println("Error de conexion:\n"+e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error de driver:\n"+e);
        }

    }
}