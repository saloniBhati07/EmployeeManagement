package com.example.Task9;
//import com.example.Task8.Main;
//import com.example.Task7.Employee;
//import com.example.Task7.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;
import com.example.Task9.EmployeeService;
import com.example.Task9.Employee;

public class Main {

    private static final Logger logger =
            LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        EmployeeService employeeService =
                new EmployeeService();

        logger.info(
                "Employee Management System started"
        );

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


                    // ==========================================
                    // ADD EMPLOYEE
                    // ==========================================

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


                        employeeService
                                .addEmployee(employee);


                        System.out.println(
                                "Employee added successfully."
                        );

                        break;


                    // ==========================================
                    // VIEW ALL EMPLOYEES
                    // ==========================================

                    case 2:

                        List<Employee> employees =
                                employeeService
                                        .getAllEmployees();


                        if (employees.isEmpty()) {

                            System.out.println(
                                    "No employees found."
                            );

                        } else {

                            for (Employee emp :
                                    employees) {

                                System.out.println(emp);
                            }
                        }

                        break;


                    // ==========================================
                    // SEARCH EMPLOYEE
                    // ==========================================

                    case 3:

                        System.out.print(
                                "Enter Employee ID: "
                        );

                        int searchId =
                                scanner.nextInt();


                        Employee foundEmployee =
                                employeeService
                                        .searchEmployee(
                                                searchId
                                        );


                        System.out.println(
                                "Employee Found:"
                        );

                        System.out.println(
                                foundEmployee
                        );

                        break;


                    // ==========================================
                    // UPDATE EMPLOYEE
                    // ==========================================

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


                        employeeService
                                .updateEmployee(
                                        updatedEmployee
                                );


                        System.out.println(
                                "Employee updated successfully."
                        );

                        break;


                    // ==========================================
                    // DELETE EMPLOYEE
                    // ==========================================

                    case 5:

                        System.out.print(
                                "Enter Employee ID to delete: "
                        );

                        int deleteId =
                                scanner.nextInt();


                        employeeService
                                .deleteEmployee(
                                        deleteId
                                );


                        System.out.println(
                                "Employee deleted successfully."
                        );

                        break;


                    // ==========================================
                    // EXIT
                    // ==========================================

                    case 6:

                        logger.info(
                                "Employee Management System stopped"
                        );

                        System.out.println(
                                "Thank you for using Employee Management System."
                        );

                        scanner.close();

                        return;


                    default:

                        logger.warn(
                                "Invalid menu choice: {}",
                                choice
                        );

                        System.out.println(
                                "Invalid choice. Please try again."
                        );
                }


            } catch (
                    EmployeeNotFoundException e) {

                logger.warn(
                        "Employee not found: {}",
                        e.getMessage()
                );

                System.out.println(
                        "Employee Error: "
                                + e.getMessage()
                );


            } catch (
                    InvalidSalaryException e) {

                logger.warn(
                        "Invalid salary: {}",
                        e.getMessage()
                );

                System.out.println(
                        "Salary Error: "
                                + e.getMessage()
                );


            } catch (
                    DatabaseException e) {

                logger.error(
                        "Database operation failed",
                        e
                );

                System.out.println(
                        "Database Error: "
                                + e.getMessage()
                );


            } catch (
                    IllegalArgumentException e) {

                logger.warn(
                        "Validation error: {}",
                        e.getMessage()
                );

                System.out.println(
                        "Validation Error: "
                                + e.getMessage()
                );


            } catch (Exception e) {

                logger.error(
                        "Unexpected application error",
                        e
                );

                System.out.println(
                        "Error: "
                                + e.getMessage()
                );
            }
        }
    }
}