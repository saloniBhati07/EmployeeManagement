package org.example.task5;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeDAO {

    public void updateEmployeeSalary(int id, double salary) {

        String sql = "UPDATE employee SET salary = ? WHERE id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setDouble(1, salary);
            statement.setInt(2, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("Salary Updated Successfully");
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