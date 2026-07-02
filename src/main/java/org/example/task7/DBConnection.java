package org.example.task7;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL= "jdbc:postgresql://localhost:5432/employee_db";
    private static final String USER="postgres";
    private static final String PASSWORD="Saloni@2007.";
    public static Connection getConnection(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Database Connected Successfully");
            return connection;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
