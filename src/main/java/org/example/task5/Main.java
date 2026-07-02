package org.example.task5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();

        System.out.print("Enter Employee ID : ");
        int id = sc.nextInt();

        System.out.print("Enter New Salary : ");
        double salary = sc.nextDouble();

        dao.updateEmployeeSalary(id, salary);

        sc.close();

    }

}