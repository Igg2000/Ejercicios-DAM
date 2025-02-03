package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            if (con != null) {
                System.out.println("Conectado a la base de datos");

                var statement = con.createStatement();
                var resultSet = statement.executeQuery("SELECT * FROM amigos");

                while (resultSet.next()) {

                    String nom = resultSet.getString("nom");
                    String ape = resultSet.getString("ape");
                    String dir = resultSet.getString("dir");
                    String tlf = resultSet.getString("tlf");
                    System.out.println(nom + " | " + ape+ " | " + dir+ " | " + tlf);
                }
            } else {
                System.out.println("Fallo al conectarse a la base de datos");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
