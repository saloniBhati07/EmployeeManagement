package com.example.Task5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DepartmentDAO {

    private static final Logger logger =
            LoggerFactory.getLogger(DepartmentDAO.class);

    // Add Department
    public void addDepartment(Department department) {

        String sql =
                "INSERT INTO department " +
                        "(department_id, department_name) VALUES (?, ?)";

        try (Connection connection =
                     DBConnectionUtil.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, department.getId());
            statement.setString(2, department.getName());

            statement.executeUpdate();

            logger.info("Department added successfully.");

        } catch (SQLException e) {

            logger.error("Error adding department", e);
        }
    }


    // View All Departments
    public List<Department> getAllDepartments() {

        List<Department> departments =
                new ArrayList<>();

        String sql =
                "SELECT department_id, department_name " +
                        "FROM department";

        try (Connection connection =
                     DBConnectionUtil.getConnection();

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

            logger.info("Departments retrieved successfully.");

        } catch (SQLException e) {

            logger.error("Error retrieving departments", e);
        }

        return departments;
    }


    // Search Department
    public Department searchDepartment(int id) {

        String sql =
                "SELECT department_id, department_name " +
                        "FROM department " +
                        "WHERE department_id = ?";

        try (Connection connection =
                     DBConnectionUtil.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet =
                         statement.executeQuery()) {

                if (resultSet.next()) {

                    logger.info(
                            "Department found with ID: {}", id
                    );

                    return new Department(
                            resultSet.getInt("department_id"),
                            resultSet.getString("department_name")
                    );
                }
            }

            logger.warn(
                    "Department not found with ID: {}", id
            );

        } catch (SQLException e) {

            logger.error(
                    "Error searching department with ID: " + id, e
            );
        }

        return null;
    }
}