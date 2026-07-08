package com.company.ems.dao;

import com.company.ems.exception.EmployeeNotFoundException;
import com.company.ems.model.Employee;
import com.company.ems.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static final Logger logger =
            Logger.getLogger(EmployeeDAOImpl.class.getName());

    @Override
    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employee(name,email,department,salary,designation) VALUES(?,?,?,?,?)";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getDepartment());
            statement.setDouble(4, employee.getSalary());
            statement.setString(5, employee.getDesignation());

            statement.executeUpdate();

            logger.info("Employee added successfully.");

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error while adding employee.", e);
        }
    }

    @Override
    public Employee getEmployeeById(int id) {

        String sql = "SELECT * FROM employee WHERE id=?";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {

                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("department"),
                        rs.getDouble("salary"),
                        rs.getString("designation")
                );
            }

            throw new EmployeeNotFoundException("Employee not found with id " + id);

        } catch (SQLException e) {

            logger.log(Level.SEVERE, "Error while retrieving employee.", e);

        }

        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> employeeList = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                Employee employee = new Employee(

                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("department"),
                        rs.getDouble("salary"),
                        rs.getString("designation")

                );

                employeeList.add(employee);
            }

            logger.info("Employee list retrieved successfully.");

        } catch (SQLException e) {

            logger.log(Level.SEVERE, "Error while retrieving employee.", e);

        }

        return employeeList;
    }

    @Override
    public void updateEmployee(Employee employee) {

        String sql = "UPDATE employee SET name=?,email=?,department=?,salary=?,designation=? WHERE id=?";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getDepartment());
            statement.setDouble(4, employee.getSalary());
            statement.setString(5, employee.getDesignation());
            statement.setInt(6, employee.getId());

            int rows = statement.executeUpdate();

            if (rows > 0)
                logger.info("Employee updated successfully.");
            else
                logger.warning("Employee not found.");

        } catch (SQLException e) {

            logger.log(Level.SEVERE, "Error while updating employee.", e);

        }
    }

    @Override
    public void deleteEmployee(int id) {

        String sql = "DELETE FROM employee WHERE id=?";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0)
                logger.info("Employee deleted successfully.");
            else
                logger.warning("Employee not found.");

        } catch (SQLException e) {

            logger.log(Level.SEVERE, "Error while deleting employee.", e);

        }
    }
}