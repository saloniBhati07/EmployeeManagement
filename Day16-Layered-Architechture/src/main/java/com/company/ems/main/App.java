package com.company.ems.main;

import com.company.ems.model.Employee;
import com.company.ems.service.EmployeeService;

import java.util.List;

public class App {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        // Add Employee
        Employee employee = new Employee(
                "Saloni",
                "saloni@gmail.com",
                "IT",
                35000,
                "Software Engineer"
        );

        service.addEmployee(employee);

        // Get Employee by ID
        Employee emp = service.getEmployeeById(1);
        System.out.println(emp);

        // Get All Employees
        List<Employee> employees = service.getAllEmployees();

        for (Employee e : employees) {
            System.out.println(e);
        }

        // Update Employee
        Employee updatedEmployee = new Employee(
                1,
                "Saloni Bhati",
                "saloni@gmail.com",
                "IT",
                45000,
                "Senior Software Engineer"
        );

        service.updateEmployee(updatedEmployee);

        // Delete Employee
        // service.deleteEmployee(1);
    }
}