package com.company.ems.service;

import com.company.ems.dao.EmployeeDAO;
import com.company.ems.dao.EmployeeDAOImpl;
import com.company.ems.model.Employee;
import com.company.ems.util.ValidationUtil;

import java.util.List;

public class EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeService() {
        employeeDAO = new EmployeeDAOImpl();
    }

    // Add Employee
    public void addEmployee(Employee employee) {

        ValidationUtil.validateEmployee(employee);

        employeeDAO.addEmployee(employee);
    }

    // Get Employee By ID
    public Employee getEmployeeById(int id) {

        return employeeDAO.getEmployeeById(id);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {

        return employeeDAO.getAllEmployees();
    }

    // Update Employee
    public void updateEmployee(Employee employee) {

        ValidationUtil.validateEmployee(employee);

        employeeDAO.updateEmployee(employee);
    }

    // Delete Employee
    public void deleteEmployee(int id) {

        employeeDAO.deleteEmployee(id);
    }
}