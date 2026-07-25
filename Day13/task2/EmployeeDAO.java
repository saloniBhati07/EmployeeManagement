package org.example.task2;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeDAO {

    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employee(name, department, salary) VALUES (?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDepartment());
            statement.setDouble(3, employee.getSalary());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Record Inserted Successfully");
            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}