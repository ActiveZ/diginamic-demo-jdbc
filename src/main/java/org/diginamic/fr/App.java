package org.diginamic.fr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection connection = DriverManager.
                    getConnection("jdbc:mariadb://localhost:3306/comptaM02", "root", "root");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}