package org.example.task11;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeService service = new EmployeeService();

        try {

            System.out.print("Enter Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Department : ");
            String department = sc.nextLine();

            System.out.print("Enter Salary : ");
            double salary = sc.nextDouble();

            service.addEmployee(name, department, salary);

        } catch (Exception e) {

            System.out.println("Invalid Input. Please enter correct values.");

        } finally {

            sc.close();

        }

    }

}