package org.example.task1;

import org.example.task1.DBConnection;
import java.sql.Connection;

public class ConnectionTest {

    public static void main(String[] args) {

        Connection connection = DBConnection.getConnection();

        if(connection != null){

            System.out.println("Connection Established!");

        }else{

            System.out.println("Connection Failed");

        }

    }

}