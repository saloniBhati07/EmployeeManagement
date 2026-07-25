package org.example.task9;

public class EmployeeService {

    EmployeeDAO dao = new EmployeeDAO();

    // Add Employee
    public void addEmployee(String name, String department, double salary) {

        Employee employee = new Employee(name, department, salary);

        dao.addEmployee(employee);

    }

    // View All Employees
    public void viewEmployees() {

        dao.getAllEmployees();

    }

    // Search Employee
    public void searchEmployee(int id) {

        dao.getEmployeeById(id);

    }

    // Update Employee Salary
    public void updateEmployeeSalary(int id, double salary) {

        dao.updateEmployeeSalary(id, salary);

    }

    // Delete Employee
    public void deleteEmployee(int id) {

        dao.deleteEmployee(id);

    }

}