package org.example.task8;

public class Main {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        // Add Employee
        service.addEmployee("Ajay", "IT", 50000);

        // View Employees
        service.viewEmployees();

        // Search Employee
        service.searchEmployee(1);

        // Update Salary
        service.updateEmployeeSalary(1, 65000);

        // Delete Employee
        service.deleteEmployee(2);

    }

}