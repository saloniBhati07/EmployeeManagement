package com.example.Task9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // ==========================================
    // ADD EMPLOYEE
    // ==========================================

    public void addEmployee(Employee employee) throws SQLException {

        String sql = "INSERT INTO employees " +
                "(id, name, email, designation, salary, department) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection =
                     DBConnectionUtil.getConnection();

             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql)) {

            preparedStatement.setInt(
                    1,
                    employee.getId()
            );

            preparedStatement.setString(
                    2,
                    employee.getName()
            );

            preparedStatement.setString(
                    3,
                    employee.getEmail()
            );

            preparedStatement.setString(
                    4,
                    employee.getDesignation()
            );

            preparedStatement.setDouble(
                    5,
                    employee.getSalary()
            );

            preparedStatement.setString(
                    6,
                    employee.getDepartment()
            );

            preparedStatement.executeUpdate();
        }
    }


    // ==========================================
    // VIEW ALL EMPLOYEES
    // ==========================================

    public List<Employee> getAllEmployees()
            throws SQLException {

        List<Employee> employees =
                new ArrayList<>();

        String sql =
                "SELECT id, name, email, designation, " +
                        "salary, department FROM employees";

        try (Connection connection =
                     DBConnectionUtil.getConnection();

             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql);

             ResultSet resultSet =
                     preparedStatement.executeQuery()) {

            while (resultSet.next()) {

                Employee employee =
                        new Employee(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getString("designation"),
                                resultSet.getDouble("salary"),
                                resultSet.getString("department")
                        );

                employees.add(employee);
            }
        }

        return employees;
    }


    // ==========================================
    // SEARCH EMPLOYEE
    // ==========================================

    public Employee searchEmployee(int id)
            throws SQLException {

        String sql =
                "SELECT id, name, email, designation, " +
                        "salary, department " +
                        "FROM employees WHERE id = ?";

        try (Connection connection =
                     DBConnectionUtil.getConnection();

             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql)) {

            preparedStatement.setInt(
                    1,
                    id
            );

            try (ResultSet resultSet =
                         preparedStatement.executeQuery()) {

                if (resultSet.next()) {

                    return new Employee(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("designation"),
                            resultSet.getDouble("salary"),
                            resultSet.getString("department")
                    );
                }
            }
        }

        return null;
    }


    // ==========================================
    // UPDATE EMPLOYEE
    // ==========================================

    public void updateEmployee(Employee employee)
            throws SQLException {

        String sql =
                "UPDATE employees SET " +
                        "name = ?, " +
                        "email = ?, " +
                        "designation = ?, " +
                        "salary = ?, " +
                        "department = ? " +
                        "WHERE id = ?";

        try (Connection connection =
                     DBConnectionUtil.getConnection();

             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql)) {

            preparedStatement.setString(
                    1,
                    employee.getName()
            );

            preparedStatement.setString(
                    2,
                    employee.getEmail()
            );

            preparedStatement.setString(
                    3,
                    employee.getDesignation()
            );

            preparedStatement.setDouble(
                    4,
                    employee.getSalary()
            );

            preparedStatement.setString(
                    5,
                    employee.getDepartment()
            );

            preparedStatement.setInt(
                    6,
                    employee.getId()
            );

            preparedStatement.executeUpdate();
        }
    }


    // ==========================================
    // DELETE EMPLOYEE
    // ==========================================

    public void deleteEmployee(int id)
            throws SQLException {

        String sql =
                "DELETE FROM employees WHERE id = ?";

        try (Connection connection =
                     DBConnectionUtil.getConnection();

             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql)) {

            preparedStatement.setInt(
                    1,
                    id
            );

            preparedStatement.executeUpdate();
        }
    }
}