package com.example.Task7;

import com.example.Task7.DBConnectionUtil;
import com.example.Task7.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // 1. Add Employee
    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employee " +
                "(id, name, email, designation, salary, department) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getDesignation());
            ps.setDouble(5, employee.getSalary());
            ps.setString(6, employee.getDepartment());

            ps.executeUpdate();

            System.out.println("Employee added successfully.");

        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }


    // 2. View All Employees
    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Employee employee = new Employee();

                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setDesignation(rs.getString("designation"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDepartment(rs.getString("department"));

                employees.add(employee);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving employees: " + e.getMessage());
        }

        return employees;
    }


    // 3. Search Employee
    public Employee searchEmployee(int id) {

        String sql = "SELECT * FROM employee WHERE id = ?";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Employee employee = new Employee();

                    employee.setId(rs.getInt("id"));
                    employee.setName(rs.getString("name"));
                    employee.setEmail(rs.getString("email"));
                    employee.setDesignation(rs.getString("designation"));
                    employee.setSalary(rs.getDouble("salary"));
                    employee.setDepartment(rs.getString("department"));

                    return employee;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error searching employee: " + e.getMessage());
        }

        return null;
    }


    // 4. Update Employee
    public void updateEmployee(Employee employee) {

        String sql = "UPDATE employee SET " +
                "name = ?, email = ?, designation = ?, " +
                "salary = ?, department = ? " +
                "WHERE id = ?";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getDesignation());
            ps.setDouble(4, employee.getSalary());
            ps.setString(5, employee.getDepartment());
            ps.setInt(6, employee.getId());

            ps.executeUpdate();

            System.out.println("Employee updated successfully.");

        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }


    // 5. Delete Employee
    public void deleteEmployee(int id) {

        String sql = "DELETE FROM employee WHERE id = ?";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Employee deleted successfully.");

        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }
}