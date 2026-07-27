package com.example.Task12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // ADD EMPLOYEE

    public void addEmployee(Employee employee)
            throws SQLException {

        String sql =
                "INSERT INTO employees " +
                        "(id, name, email, designation, salary, department) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection connection =
                        DBConnectionUtil.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    employee.getId()
            );

            statement.setString(
                    2,
                    employee.getName()
            );

            statement.setString(
                    3,
                    employee.getEmail()
            );

            statement.setString(
                    4,
                    employee.getDesignation()
            );

            statement.setDouble(
                    5,
                    employee.getSalary()
            );

            statement.setString(
                    6,
                    employee.getDepartment()
            );

            statement.executeUpdate();
        }
    }


    // VIEW ALL EMPLOYEES

    public List<Employee> getAllEmployees()
            throws SQLException {

        List<Employee> employees =
                new ArrayList<>();

        String sql =
                "SELECT id, name, email, designation, " +
                        "salary, department " +
                        "FROM employees";

        try (
                Connection connection =
                        DBConnectionUtil.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

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


    // SEARCH EMPLOYEE

    public Employee searchEmployee(int id)
            throws SQLException {

        String sql =
                "SELECT id, name, email, designation, " +
                        "salary, department " +
                        "FROM employees " +
                        "WHERE id = ?";

        try (
                Connection connection =
                        DBConnectionUtil.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    id
            );

            try (
                    ResultSet resultSet =
                            statement.executeQuery()
            ) {

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


    // UPDATE EMPLOYEE

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

        try (
                Connection connection =
                        DBConnectionUtil.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    employee.getName()
            );

            statement.setString(
                    2,
                    employee.getEmail()
            );

            statement.setString(
                    3,
                    employee.getDesignation()
            );

            statement.setDouble(
                    4,
                    employee.getSalary()
            );

            statement.setString(
                    5,
                    employee.getDepartment()
            );

            statement.setInt(
                    6,
                    employee.getId()
            );

            statement.executeUpdate();
        }
    }


    // DELETE EMPLOYEE

    public void deleteEmployee(int id)
            throws SQLException {

        String sql =
                "DELETE FROM employees WHERE id = ?";

        try (
                Connection connection =
                        DBConnectionUtil.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    id
            );

            statement.executeUpdate();
        }
    }
}