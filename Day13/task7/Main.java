package org.example.task7;

public class Main {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();

        Employee employee = new Employee("Ajay", "IT", 50000);

        dao.addEmployee(employee);

        dao.getAllEmployees();

        dao.getEmployeeById(1);

        dao.updateEmployeeSalary(1, 65000);

        dao.deleteEmployee(2);

    }

}