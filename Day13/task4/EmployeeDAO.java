package org.example.task4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {

    public void getEmployeeById(int id) {

        String sql = "SELECT * FROM employee WHERE id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {

                System.out.println("Employee Found");
                System.out.println("----------------------------");
                System.out.println("ID         : " + rs.getInt("id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Department : " + rs.getString("department"));
                System.out.println("Salary     : " + rs.getDouble("salary"));

            } else {

                System.out.println("Employee not found.");

            }

            rs.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}