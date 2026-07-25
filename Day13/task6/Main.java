package org.example.task6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();

        System.out.print("Enter Employee ID to Delete : ");

        int id = sc.nextInt();

        dao.deleteEmployee(id);

        sc.close();

    }

}