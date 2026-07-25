package com.example.Task5;

public class Main {

    public static void main(String[] args) {

        DepartmentService departmentService =
                new DepartmentService();

        // 1. Add Department
        System.out.println("=== ADD DEPARTMENT ===");

        Department department =
                new Department(6, "Marketing");

        departmentService.addDepartment(department);


        // 2. View All Departments
        System.out.println("\n=== VIEW DEPARTMENTS ===");

        departmentService.viewDepartments();


        // 3. Search Department
        System.out.println("\n=== SEARCH DEPARTMENT ===");

        departmentService.searchDepartment(5);
    }
}