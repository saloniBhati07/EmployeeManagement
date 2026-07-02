package org.example.task12;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        int choice;

        do {

            System.out.println("\n========== Employee Management System ==========");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    service.addEmployee(name, department, salary);

                    break;

                case 2:

                    service.viewEmployees();

                    break;

                case 3:

                    System.out.print("Enter Employee ID: ");
                    int searchId = sc.nextInt();

                    service.searchEmployee(searchId);

                    break;

                case 4:

                    System.out.print("Enter Employee ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();

                    service.updateEmployeeSalary(updateId, newSalary);

                    break;

                case 5:

                    System.out.print("Enter Employee ID: ");
                    int deleteId = sc.nextInt();

                    service.deleteEmployee(deleteId);

                    break;

                case 6:

                    System.out.println("Thank You! Exiting Application...");
                    break;

                default:

                    System.out.println("Invalid Choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}