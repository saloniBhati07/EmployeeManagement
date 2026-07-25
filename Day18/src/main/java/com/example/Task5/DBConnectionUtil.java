package com.example.Task5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/employee_db";

    private static final String USER =
            "postgres";

    private static final String PASSWORD =
            "Saloni@2007.";

    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}