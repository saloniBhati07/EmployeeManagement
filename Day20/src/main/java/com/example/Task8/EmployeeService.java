package com.example.Task8;

import com.example.Task7.Employee;
import com.example.Task7.EmployeeDAO;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeService() {
        this.employeeDAO = new EmployeeDAO();
    }

    // ==========================================
    // 1. ADD EMPLOYEE
    // ==========================================

    public void addEmployee(Employee employee) throws SQLException {

        // Validate employee before inserting into database
        validateEmployee(employee);

        // Call DAO only after successful validation
        employeeDAO.addEmployee(employee);
    }


    // ==========================================
    // 2. VIEW ALL EMPLOYEES
    // ==========================================

    public List<Employee> getAllEmployees() throws SQLException {

        return employeeDAO.getAllEmployees();
    }


    // ==========================================
    // 3. SEARCH EMPLOYEE
    // ==========================================

    public Employee searchEmployee(int id) throws SQLException {

        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Employee ID must be greater than 0"
            );
        }

        Employee employee = employeeDAO.searchEmployee(id);

        if (employee == null) {
            throw new RuntimeException(
                    "Employee not found with ID: " + id
            );
        }

        return employee;
    }


    // ==========================================
    // 4. UPDATE EMPLOYEE
    // ==========================================

    public void updateEmployee(Employee employee) throws SQLException {

        // Validate updated employee data
        validateEmployee(employee);

        // Call DAO only after successful validation
        employeeDAO.updateEmployee(employee);
    }


    // ==========================================
    // 5. DELETE EMPLOYEE
    // ==========================================

    public void deleteEmployee(int id) throws SQLException {

        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Employee ID must be greater than 0"
            );
        }

        employeeDAO.deleteEmployee(id);
    }


    // ==========================================
    // 6. VALIDATION
    // ==========================================

    private void validateEmployee(Employee employee) {

        // Check Employee Object
        if (employee == null) {
            throw new IllegalArgumentException(
                    "Employee cannot be null"
            );
        }


        // Check Employee ID
        if (employee.getId() <= 0) {
            throw new IllegalArgumentException(
                    "Employee ID must be greater than 0"
            );
        }


        // Check Employee Name
        if (employee.getName() == null ||
                employee.getName().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Employee name is required"
            );
        }


        // Check Email
        if (employee.getEmail() == null ||
                employee.getEmail().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Email is required"
            );
        }

        // Validate Email Format
        String emailRegex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!employee.getEmail().matches(emailRegex)) {

            throw new IllegalArgumentException(
                    "Please enter a valid email address"
            );
        }


        // Check Designation
        if (employee.getDesignation() == null ||
                employee.getDesignation().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Designation is required"
            );
        }


        // Check Salary
        if (employee.getSalary() <= 10000) {

            throw new IllegalArgumentException(
                    "Salary must be greater than ₹10,000"
            );
        }


        // Check Department
        if (employee.getDepartment() == null ||
                employee.getDepartment().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Department is required"
            );
        }
    }
}