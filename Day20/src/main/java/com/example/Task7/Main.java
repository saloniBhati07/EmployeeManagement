package com.example.Task7;


import com.example.Task7.Employee;
import com.example.Task7.EmployeeService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (choice) {

                    // 1. Add Employee
                    case 1:

                        System.out.print("Enter Employee ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();

                        System.out.print("Enter Designation: ");
                        String designation = scanner.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Enter Department: ");
                        String department = scanner.nextLine();

                        Employee employee = new Employee(
                                id,
                                name,
                                email,
                                designation,
                                salary,
                                department
                        );

                        employeeService.addEmployee(employee);

                        break;


                    // 2. View All Employees
                    case 2:

                        List<Employee> employees =
                                employeeService.getAllEmployees();

                        if (employees.isEmpty()) {
                            System.out.println("No employees found.");
                        } else {

                            for (Employee emp : employees) {
                                System.out.println(emp);
                            }
                        }

                        break;


                    // 3. Search Employee
                    case 3:

                        System.out.print("Enter Employee ID: ");
                        int searchId = scanner.nextInt();

                        Employee foundEmployee =
                                employeeService.searchEmployee(searchId);

                        System.out.println("Employee Found:");
                        System.out.println(foundEmployee);

                        break;


                    // 4. Update Employee
                    case 4:

                        System.out.print("Enter Employee ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter New Name: ");
                        String updateName = scanner.nextLine();

                        System.out.print("Enter New Email: ");
                        String updateEmail = scanner.nextLine();

                        System.out.print("Enter New Designation: ");
                        String updateDesignation = scanner.nextLine();

                        System.out.print("Enter New Salary: ");
                        double updateSalary = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Enter New Department: ");
                        String updateDepartment = scanner.nextLine();

                        Employee updatedEmployee = new Employee(
                                updateId,
                                updateName,
                                updateEmail,
                                updateDesignation,
                                updateSalary,
                                updateDepartment
                        );

                        employeeService.updateEmployee(updatedEmployee);

                        break;


                    // 5. Delete Employee
                    case 5:

                        System.out.print("Enter Employee ID to delete: ");
                        int deleteId = scanner.nextInt();

                        employeeService.deleteEmployee(deleteId);

                        break;


                    // 6. Exit
                    case 6:

                        System.out.println(
                                "Thank you for using Employee Management System."
                        );

                        scanner.close();
                        return;


                    default:

                        System.out.println(
                                "Invalid choice. Please try again."
                        );
                }

            }catch (IllegalArgumentException e){
                System.out.println("Validation Error:"+ e.getMessage());
            }
            catch (Exception e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );
            }
        }
    }
}
