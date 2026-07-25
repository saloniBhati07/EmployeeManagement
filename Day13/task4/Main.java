package org.example.task4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();

        System.out.print("Enter Employee ID: ");

        int id = sc.nextInt();

        dao.getEmployeeById(id);

        sc.close();
    }
}