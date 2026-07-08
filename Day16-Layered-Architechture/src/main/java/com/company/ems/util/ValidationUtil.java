package com.company.ems.util;

import com.company.ems.exception.InvalidDepartmentException;
import com.company.ems.exception.InvalidSalaryException;
import com.company.ems.model.Employee;

public class ValidationUtil {

    // Validate complete Employee object
    public static void validateEmployee(Employee employee) {

        validateName(employee.getName());
        validateEmail(employee.getEmail());
        validateDepartment(employee.getDepartment());
        validateSalary(employee.getSalary());

    }

    // Validate Name
    public static void validateName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

    }

    // Validate Email
    public static void validateEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty.");
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }

    }

    // Validate Department
    public static void validateDepartment(String department) {

        if (department == null || department.trim().isEmpty()) {
            throw new InvalidDepartmentException("Department cannot be empty.");
        }

    }

    // Validate Salary
    public static void validateSalary(double salary) {

        if (salary <= 10000) {
            throw new InvalidSalaryException("Salary should be greater than 10000.");
        }

    }
}