package org.example.task11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    // Add Employee
    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employee(name, department, salary) VALUES (?, ?, ?)";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDepartment());
            statement.setDouble(3, employee.getSalary());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Added Successfully");
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }

    // View All Employees
    public void getAllEmployees() {

        String sql = "SELECT * FROM employee";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery()
        ) {

            System.out.println("-----------------------------------------------");
            System.out.printf("%-5s %-15s %-15s %-10s%n",
                    "ID", "NAME", "DEPARTMENT", "SALARY");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {

                System.out.printf("%-5d %-15s %-15s %-10.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary"));
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }

    // Search Employee by ID
    public void getEmployeeById(int id) {

        String sql = "SELECT * FROM employee WHERE id = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {

                System.out.println("Employee Found");
                System.out.println("---------------------------");
                System.out.println("ID         : " + rs.getInt("id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Department : " + rs.getString("department"));
                System.out.println("Salary     : " + rs.getDouble("salary"));

            } else {

                System.out.println("Employee Not Found");

            }

            rs.close();

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }

    // Update Salary
    public void updateEmployeeSalary(int id, double salary) {

        String sql = "UPDATE employee SET salary=? WHERE id=?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setDouble(1, salary);
            statement.setInt(2, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("Salary Updated Successfully");
                System.out.println("Rows Affected : " + rows);

            } else {

                System.out.println("Employee Not Found");

            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {

        String sql = "DELETE FROM employee WHERE id=?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("Employee Deleted Successfully");
                System.out.println("Rows Affected : " + rows);

            } else {

                System.out.println("Employee Not Found");

            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}