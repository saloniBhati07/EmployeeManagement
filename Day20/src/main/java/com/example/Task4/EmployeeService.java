package com.example.Task4;

import com.example.Task4.EmployeeDAO;
import com.example.Task4.Employee;

import java.util.List;

public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeService() {
        this.employeeDAO = new EmployeeDAO();
    }

    // 1. Add Employee
    public void addEmployee(Employee employee) {

        validateEmployee(employee);

        employeeDAO.addEmployee(employee);
    }

    // 2. View All Employees
    public List<Employee> getAllEmployees() {

        return employeeDAO.getAllEmployees();
    }

    // 3. Search Employee
    public Employee searchEmployee(int id) {

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

    // 4. Update Employee
    public void updateEmployee(Employee employee) {

        validateEmployee(employee);

        employeeDAO.updateEmployee(employee);
    }

    // 5. Delete Employee
    public void deleteEmployee(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Employee ID must be greater than 0"
            );
        }

        employeeDAO.deleteEmployee(id);
    }

    // Validation
    private void validateEmployee(Employee employee) {

        if (employee == null) {
            throw new IllegalArgumentException(
                    "Employee cannot be null"
            );
        }

        if (employee.getId() <= 0) {
            throw new IllegalArgumentException(
                    "Employee ID must be greater than 0"
            );
        }

        if (employee.getName() == null ||
                employee.getName().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Employee name is required"
            );
        }

        if (employee.getEmail() == null ||
                employee.getEmail().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Email is required"
            );
        }

        if (employee.getDesignation() == null ||
                employee.getDesignation().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Designation is required"
            );
        }

        if (employee.getSalary() <= 10000) {
            throw new IllegalArgumentException(
                    "Salary must be greater than ₹10,000"
            );
        }

        if (employee.getDepartment() == null ||
                employee.getDepartment().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Department is required"
            );
        }
    }
}