package com.company.ems.dao;

import com.company.ems.model.Employee;
import java.util.List;

public interface EmployeeDAO {

    // Add a new employee
    void addEmployee(Employee employee);

    // Get employee by ID
    Employee getEmployeeById(int id);

    // Get all employees
    List<Employee> getAllEmployees();

    // Update employee details
    void updateEmployee(Employee employee);

    // Delete employee by ID
    void deleteEmployee(int id);
}