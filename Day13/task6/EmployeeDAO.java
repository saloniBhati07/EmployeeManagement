package org.example.task6;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeDAO {

    public void deleteEmployee(int id) {

        String sql = "DELETE FROM employee WHERE id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("Employee Deleted Successfully");
                System.out.println("Rows Affected : " + rows);

            } else {

                System.out.println("Employee Not Found");

            }

            statement.close();
            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}