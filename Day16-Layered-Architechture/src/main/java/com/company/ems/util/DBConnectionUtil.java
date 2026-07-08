package com.company.ems.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnectionUtil {
    private static final String URL="jdbc:postgresql://localhost:5432/employee_db";;
    private static final String USERNAME="postgres";
    private static final String PASSWORD="Saloni@2007.";
    private static final Logger logger= Logger.getLogger(DBConnectionUtil.class.getName());
    public static Connection getConnection(){
         Connection connection=null;
         try{
             connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
             logger.info("Database Connected created Successfully.");

         }catch(SQLException e){
             logger.log(Level.SEVERE,"Failed to connect to the database",e);

        }
         return connection;
    }
}
