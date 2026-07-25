package org.example.task3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {

    public void getAllEmployees() {

        String sql = "SELECT * FROM employee";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            System.out.println("--------------------------------------------");
            System.out.println("ID\tNAME\tDEPARTMENT\tSALARY");
            System.out.println("--------------------------------------------");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + "\t" +
                                rs.getString("name") + "\t" +
                                rs.getString("department") + "\t\t" +
                                rs.getDouble("salary")
                );

            }

            rs.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}