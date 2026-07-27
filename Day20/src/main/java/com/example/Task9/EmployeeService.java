package com.example.Task9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeDAO employeeDAO;

    // Constructor
    public EmployeeService() {

        this.employeeDAO = new EmployeeDAO();

        logger.info(
                "EmployeeService initialized successfully"
        );
    }


    // ==========================================
    // ADD EMPLOYEE
    // ==========================================

    public void addEmployee(Employee employee) {

        // Validate employee
        validateEmployee(employee);

        try {

            employeeDAO.addEmployee(employee);

            logger.info(
                    "Employee created successfully. ID: {}",
                    employee.getId()
            );

        } catch (SQLException e) {

            logger.error(
                    "Database error while creating employee. ID: {}",
                    employee.getId(),
                    e
            );

            throw new DatabaseException(
                    "Unable to add employee. Database error occurred.",
                    e
            );
        }
    }


    // ==========================================
    // VIEW ALL EMPLOYEES
    // ==========================================

    public List<Employee> getAllEmployees() {

        try {

            List<Employee> employees =
                    employeeDAO.getAllEmployees();

            logger.info(
                    "Successfully retrieved {} employees",
                    employees.size()
            );

            return employees;

        } catch (SQLException e) {

            logger.error(
                    "Database error while retrieving employees",
                    e
            );

            throw new DatabaseException(
                    "Unable to retrieve employees from database.",
                    e
            );
        }
    }


    // ==========================================
    // SEARCH EMPLOYEE
    // ==========================================

    public Employee searchEmployee(int id) {

        if (id <= 0) {

            logger.warn(
                    "Invalid employee ID provided for search: {}",
                    id
            );

            throw new IllegalArgumentException(
                    "Employee ID must be greater than 0"
            );
        }

        try {

            Employee employee =
                    employeeDAO.searchEmployee(id);

            if (employee == null) {

                logger.warn(
                        "Employee not found. ID: {}",
                        id
                );

                throw new EmployeeNotFoundException(
                        "Employee not found with ID: " + id
                );
            }

            logger.info(
                    "Employee searched successfully. ID: {}",
                    id
            );

            return employee;

        } catch (SQLException e) {

            logger.error(
                    "Database error while searching employee. ID: {}",
                    id,
                    e
            );

            throw new DatabaseException(
                    "Unable to search employee. Database error occurred.",
                    e
            );
        }
    }


    // ==========================================
    // UPDATE EMPLOYEE
    // ==========================================

    public void updateEmployee(Employee employee) {

        // Validate updated employee
        validateEmployee(employee);

        try {

            // Check whether employee exists
            Employee existingEmployee =
                    employeeDAO.searchEmployee(
                            employee.getId()
                    );

            if (existingEmployee == null) {

                logger.warn(
                        "Cannot update. Employee not found. ID: {}",
                        employee.getId()
                );

                throw new EmployeeNotFoundException(
                        "Employee not found with ID: "
                                + employee.getId()
                );
            }

            // Update employee
            employeeDAO.updateEmployee(employee);

            logger.info(
                    "Employee updated successfully. ID: {}",
                    employee.getId()
            );

        } catch (SQLException e) {

            logger.error(
                    "Database error while updating employee. ID: {}",
                    employee.getId(),
                    e
            );

            throw new DatabaseException(
                    "Unable to update employee. Database error occurred.",
                    e
            );
        }
    }


    // ==========================================
    // DELETE EMPLOYEE
    // ==========================================

    public void deleteEmployee(int id) {

        if (id <= 0) {

            logger.warn(
                    "Invalid employee ID provided for deletion: {}",
                    id
            );

            throw new IllegalArgumentException(
                    "Employee ID must be greater than 0"
            );
        }

        try {

            // Check whether employee exists
            Employee existingEmployee =
                    employeeDAO.searchEmployee(id);

            if (existingEmployee == null) {

                logger.warn(
                        "Cannot delete. Employee not found. ID: {}",
                        id
                );

                throw new EmployeeNotFoundException(
                        "Employee not found with ID: " + id
                );
            }

            // Delete employee
            employeeDAO.deleteEmployee(id);

            logger.info(
                    "Employee deleted successfully. ID: {}",
                    id
            );

        } catch (SQLException e) {

            logger.error(
                    "Database error while deleting employee. ID: {}",
                    id,
                    e
            );

            throw new DatabaseException(
                    "Unable to delete employee. Database error occurred.",
                    e
            );
        }
    }


    // ==========================================
    // VALIDATION
    // ==========================================

    private void validateEmployee(Employee employee) {

        // Employee object validation
        if (employee == null) {

            logger.warn(
                    "Attempted to process a null employee"
            );

            throw new IllegalArgumentException(
                    "Employee cannot be null"
            );
        }


        // Employee ID validation
        if (employee.getId() <= 0) {

            logger.warn(
                    "Invalid employee ID: {}",
                    employee.getId()
            );

            throw new IllegalArgumentException(
                    "Employee ID must be greater than 0"
            );
        }


        // Employee Name validation
        if (employee.getName() == null ||
                employee.getName().trim().isEmpty()) {

            logger.warn(
                    "Employee name is missing. ID: {}",
                    employee.getId()
            );

            throw new IllegalArgumentException(
                    "Employee name is required"
            );
        }


        // Email validation
        if (employee.getEmail() == null ||
                employee.getEmail().trim().isEmpty()) {

            logger.warn(
                    "Employee email is missing. ID: {}",
                    employee.getId()
            );

            throw new IllegalArgumentException(
                    "Email is required"
            );
        }


        // Email format validation
        String emailRegex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!employee.getEmail().matches(emailRegex)) {

            logger.warn(
                    "Invalid email format. Employee ID: {}",
                    employee.getId()
            );

            throw new IllegalArgumentException(
                    "Please enter a valid email address"
            );
        }


        // Designation validation
        if (employee.getDesignation() == null ||
                employee.getDesignation()
                        .trim()
                        .isEmpty()) {

            logger.warn(
                    "Employee designation is missing. ID: {}",
                    employee.getId()
            );

            throw new IllegalArgumentException(
                    "Designation is required"
            );
        }


        // Salary validation
        if (employee.getSalary() <= 10000) {

            logger.warn(
                    "Invalid salary. Employee ID: {}. Salary: {}",
                    employee.getId(),
                    employee.getSalary()
            );

            throw new InvalidSalaryException(
                    "Salary must be greater than ₹10,000"
            );
        }


        // Department validation
        if (employee.getDepartment() == null ||
                employee.getDepartment()
                        .trim()
                        .isEmpty()) {

            logger.warn(
                    "Employee department is missing. ID: {}",
                    employee.getId()
            );

            throw new IllegalArgumentException(
                    "Department is required"
            );
        }
    }
}