package com.example.Task5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/employee_db";

    private static final String USER = "postgres";

    private static final String PASSWORD = "Saloni@2007.";


    // Add Department
    public void addDepartment(Department department) {

        String sql =
                "INSERT INTO department"
        +" (department_id,department_name) VALUES (?, ?)";

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, department.getId());
            statement.setString(2, department.getName());

            statement.executeUpdate();

            System.out.println(
                    "Department added successfully."
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error adding department."
            );

            e.printStackTrace();
        }
    }


    // View All Departments
    public List<Department> getAllDepartments() {

        List<Department> departments =
                new ArrayList<>();

        String sql =
                "SELECT department_id, department_name FROM department";

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);

             PreparedStatement statement =
                     connection.prepareStatement(sql);

             ResultSet resultSet =
                     statement.executeQuery()) {

            while (resultSet.next()) {

                int id =
                        resultSet.getInt("department_id");

                String name =
                        resultSet.getString("department_name");

                Department department =
                        new Department(id, name);

                departments.add(department);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error retrieving departments."
            );

            e.printStackTrace();
        }

        return departments;
    }


    // Search Department
    public Department searchDepartment(int id) {

        String sql =
                "SELECT department_id, department_name"+" FROM department"+" WHERE department_id = ?";

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet =
                         statement.executeQuery()) {

                if (resultSet.next()) {

                    return new Department(
                            resultSet.getInt("department_id"),
                            resultSet.getString("department_name")
                    );
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error searching department."
            );

            e.printStackTrace();
        }

        return null;
    }
}