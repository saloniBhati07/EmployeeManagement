package com.example.Task9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {

    private static final Logger logger =
            LoggerFactory.getLogger(DBConnectionUtil.class);

    private static final String URL =
            "jdbc:postgresql://localhost:5432/employee_db";

    private static final String USER =
            "postgres";

    private static final String PASSWORD =
            "Saloni@2007.";


    public static Connection getConnection()
            throws SQLException {

        try {

            Connection connection =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            logger.info("Database connected successfully");

            return connection;

        } catch (SQLException e) {

            logger.error(
                    "Failed to connect to database",
                    e
            );

            throw e;
        }
    }
}