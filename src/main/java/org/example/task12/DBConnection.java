package org.example.task12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/employee_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "YOUR_PASSWORD";

    public static Connection getConnection() {

        try {

            Class.forName("org.postgresql.Driver");

            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully");

            return connection;

        } catch (ClassNotFoundException e) {

            System.out.println("PostgreSQL JDBC Driver Not Found.");

        } catch (SQLException e) {

            System.out.println("Unable to connect to the database.");
            System.out.println("Reason : " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Unexpected Error : " + e.getMessage());

        }

        return null;
    }
}