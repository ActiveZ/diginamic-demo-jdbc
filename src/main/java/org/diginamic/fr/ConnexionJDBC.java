package org.diginamic.fr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnexionJDBC {

    public static void main(String[] args) {
        try {
            System.out.println(ConnexionJDBC.getConnection().getCatalog() + ": connexion réussie !");
        } catch (Exception ex) {
            System.err.println((ex.getMessage()));
        }
    }

    public static Connection getConnection() throws Exception {
        ResourceBundle databaseConf = ResourceBundle.getBundle("database");

        Class.forName(databaseConf.getString("database.driver"));

        return DriverManager.getConnection(
                databaseConf.getString("database.url"),
                databaseConf.getString("database.user"),
                databaseConf.getString("database.password"));
    }
}
