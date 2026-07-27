package com.example.Task12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeDAO employeeDAO =
            new EmployeeDAO();


    // ADD

    public void addEmployee(Employee employee) {

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
                    "Unable to add employee",
                    e
            );
        }
    }


    // VIEW ALL

    public List<Employee> getAllEmployees() {

        try {

            List<Employee> employees =
                    employeeDAO.getAllEmployees();

            logger.info(
                    "Retrieved {} employees",
                    employees.size()
            );

            return employees;

        } catch (SQLException e) {

            logger.error(
                    "Database error while retrieving employees",
                    e
            );

            throw new DatabaseException(
                    "Unable to retrieve employees",
                    e
            );
        }
    }


    // SEARCH

    public Employee searchEmployee(int id) {

        if (id <= 0) {

            logger.warn(
                    "Invalid employee ID: {}",
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
                    "Database error while searching employee",
                    e
            );

            throw new DatabaseException(
                    "Unable to search employee",
                    e
            );
        }
    }


    // UPDATE

    public void updateEmployee(Employee employee) {

        validateEmployee(employee);

        try {

            Employee existing =
                    employeeDAO.searchEmployee(
                            employee.getId()
                    );

            if (existing == null) {

                logger.warn(
                        "Employee not found for update. ID: {}",
                        employee.getId()
                );

                throw new EmployeeNotFoundException(
                        "Employee not found with ID: "
                                + employee.getId()
                );
            }

            employeeDAO.updateEmployee(employee);

            logger.info(
                    "Employee updated successfully. ID: {}",
                    employee.getId()
            );

        } catch (SQLException e) {

            logger.error(
                    "Database error while updating employee",
                    e
            );

            throw new DatabaseException(
                    "Unable to update employee",
                    e
            );
        }
    }


    // DELETE

    public void deleteEmployee(int id) {

        if (id <= 0) {

            logger.warn(
                    "Invalid employee ID: {}",
                    id
            );

            throw new IllegalArgumentException(
                    "Employee ID must be greater than 0"
            );
        }

        try {

            Employee existing =
                    employeeDAO.searchEmployee(id);

            if (existing == null) {

                logger.warn(
                        "Employee not found for deletion. ID: {}",
                        id
                );

                throw new EmployeeNotFoundException(
                        "Employee not found with ID: " + id
                );
            }

            employeeDAO.deleteEmployee(id);

            logger.info(
                    "Employee deleted successfully. ID: {}",
                    id
            );

        } catch (SQLException e) {

            logger.error(
                    "Database error while deleting employee",
                    e
            );

            throw new DatabaseException(
                    "Unable to delete employee",
                    e
            );
        }
    }


    // VALIDATION

    private void validateEmployee(
            Employee employee) {

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

            logger.warn(
                    "Employee name is missing"
            );

            throw new IllegalArgumentException(
                    "Employee name is required"
            );
        }

        if (employee.getEmail() == null ||
                employee.getEmail().trim().isEmpty()) {

            logger.warn(
                    "Employee email is missing"
            );

            throw new IllegalArgumentException(
                    "Email is required"
            );
        }

        String emailRegex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!employee.getEmail()
                .matches(emailRegex)) {

            logger.warn(
                    "Invalid email format"
            );

            throw new IllegalArgumentException(
                    "Please enter a valid email"
            );
        }

        if (employee.getDesignation() == null ||
                employee.getDesignation()
                        .trim()
                        .isEmpty()) {

            throw new IllegalArgumentException(
                    "Designation is required"
            );
        }

        if (employee.getSalary() <= 10000) {

            logger.warn(
                    "Invalid salary: {}",
                    employee.getSalary()
            );

            throw new InvalidSalaryException(
                    "Salary must be greater than ₹10,000"
            );
        }

        if (employee.getDepartment() == null ||
                employee.getDepartment()
                        .trim()
                        .isEmpty()) {

            throw new IllegalArgumentException(
                    "Department is required"
            );
        }
    }
}