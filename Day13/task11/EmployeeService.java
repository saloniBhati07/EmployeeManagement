package org.example.task11;

public class EmployeeService {

    EmployeeDAO dao = new EmployeeDAO();

    // Add Employee
    public void addEmployee(String name, String department, double salary) {

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }

        if (department == null || department.trim().isEmpty()) {
            System.out.println("Error: Department cannot be empty.");
            return;
        }

        if (salary <= 10000) {
            System.out.println("Error: Salary must be greater than 10000.");
            return;
        }

        Employee employee = new Employee(name, department, salary);
        dao.addEmployee(employee);
    }

    // View All Employees
    public void viewEmployees() {
        dao.getAllEmployees();
    }

    // Search Employee by ID
    public void searchEmployee(int id) {

        if (id <= 0) {
            System.out.println("Invalid Employee ID.");
            return;
        }

        dao.getEmployeeById(id);
    }

    // Update Employee Salary
    public void updateEmployeeSalary(int id, double salary) {

        if (id <= 0) {
            System.out.println("Invalid Employee ID.");
            return;
        }

        if (salary <= 10000) {
            System.out.println("Salary must be greater than 10000.");
            return;
        }

        dao.updateEmployeeSalary(id, salary);
    }

    // Delete Employee
    public void deleteEmployee(int id) {

        if (id <= 0) {
            System.out.println("Invalid Employee ID.");
            return;
        }

        dao.deleteEmployee(id);
    }
}