package com.example.Task12;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        EmployeeService service =
                new EmployeeService();

        while (true) {

            System.out.println(
                    "\n===== EMPLOYEE MANAGEMENT SYSTEM ====="
            );

            System.out.println(
                    "1. Add Employee"
            );

            System.out.println(
                    "2. View All Employees"
            );

            System.out.println(
                    "3. Search Employee"
            );

            System.out.println(
                    "4. Update Employee"
            );

            System.out.println(
                    "5. Delete Employee"
            );

            System.out.println(
                    "6. Exit"
            );

            System.out.print(
                    "Enter your choice: "
            );

            try {

                int choice =
                        scanner.nextInt();

                scanner.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print(
                                "Enter Employee ID: "
                        );

                        int id =
                                scanner.nextInt();

                        scanner.nextLine();

                        System.out.print(
                                "Enter Name: "
                        );

                        String name =
                                scanner.nextLine();

                        System.out.print(
                                "Enter Email: "
                        );

                        String email =
                                scanner.nextLine();

                        System.out.print(
                                "Enter Designation: "
                        );

                        String designation =
                                scanner.nextLine();

                        System.out.print(
                                "Enter Salary: "
                        );

                        double salary =
                                scanner.nextDouble();

                        scanner.nextLine();

                        System.out.print(
                                "Enter Department: "
                        );

                        String department =
                                scanner.nextLine();

                        Employee employee =
                                new Employee(
                                        id,
                                        name,
                                        email,
                                        designation,
                                        salary,
                                        department
                                );

                        service.addEmployee(
                                employee
                        );

                        System.out.println(
                                "Employee added successfully."
                        );

                        break;


                    case 2:

                        List<Employee> employees =
                                service.getAllEmployees();

                        if (employees.isEmpty()) {

                            System.out.println(
                                    "No employees found."
                            );

                        } else {

                            for (
                                    Employee emp :
                                    employees
                            ) {

                                System.out.println(emp);
                            }
                        }

                        break;


                    case 3:

                        System.out.print(
                                "Enter Employee ID: "
                        );

                        int searchId =
                                scanner.nextInt();

                        Employee found =
                                service.searchEmployee(
                                        searchId
                                );

                        System.out.println(
                                "Employee Found:"
                        );

                        System.out.println(found);

                        break;


                    case 4:

                        System.out.print(
                                "Enter Employee ID to update: "
                        );

                        int updateId =
                                scanner.nextInt();

                        scanner.nextLine();

                        System.out.print(
                                "Enter New Name: "
                        );

                        String updateName =
                                scanner.nextLine();

                        System.out.print(
                                "Enter New Email: "
                        );

                        String updateEmail =
                                scanner.nextLine();

                        System.out.print(
                                "Enter New Designation: "
                        );

                        String updateDesignation =
                                scanner.nextLine();

                        System.out.print(
                                "Enter New Salary: "
                        );

                        double updateSalary =
                                scanner.nextDouble();

                        scanner.nextLine();

                        System.out.print(
                                "Enter New Department: "
                        );

                        String updateDepartment =
                                scanner.nextLine();

                        Employee updatedEmployee =
                                new Employee(
                                        updateId,
                                        updateName,
                                        updateEmail,
                                        updateDesignation,
                                        updateSalary,
                                        updateDepartment
                                );

                        service.updateEmployee(
                                updatedEmployee
                        );

                        System.out.println(
                                "Employee updated successfully."
                        );

                        break;


                    case 5:

                        System.out.print(
                                "Enter Employee ID to delete: "
                        );

                        int deleteId =
                                scanner.nextInt();

                        service.deleteEmployee(
                                deleteId
                        );

                        System.out.println(
                                "Employee deleted successfully."
                        );

                        break;


                    case 6:

                        System.out.println(
                                "Application closed."
                        );

                        scanner.close();

                        return;


                    default:

                        System.out.println(
                                "Invalid choice."
                        );
                }

            } catch (
                    EmployeeNotFoundException e) {

                System.out.println(
                        "Error: "
                                + e.getMessage()
                );

            } catch (
                    InvalidSalaryException e) {

                System.out.println(
                        "Salary Error: "
                                + e.getMessage()
                );

            } catch (
                    DatabaseException e) {

                System.out.println(
                        "Database Error: "
                                + e.getMessage()
                );

            } catch (
                    IllegalArgumentException e) {

                System.out.println(
                        "Validation Error: "
                                + e.getMessage()
                );

            } catch (Exception e) {

                System.out.println(
                        "Unexpected Error: "
                                + e.getMessage()
                );
            }
        }
    }
}